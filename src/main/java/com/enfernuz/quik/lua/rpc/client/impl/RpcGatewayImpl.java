package com.enfernuz.quik.lua.rpc.client.impl;

import com.enfernuz.quik.lua.rpc.client.api.RpcGateway;
import com.google.protobuf.MessageLite;
import org.zeromq.ZFrame;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;
import qlua.rpc.RPC;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static java.util.Objects.requireNonNull;

public final class RpcGatewayImpl implements RpcGateway {

    private final ZMQ.Context context;
    private final String uri;
    private final ZMQ.Socket socket;
    private boolean isConnected;

    public static RpcGatewayImpl create(final String host, final int port) {

        // TO-DO: add validation for the host and port parameters

        final ZMQ.Context ctx = ZMQ.context(1);
        final String uri = String.format("tcp://%s:%d", host, port);
        final ZMQ.Socket socket = ctx.socket(ZMQ.REQ);

        return new RpcGatewayImpl(ctx, uri, socket);
    }

    private RpcGatewayImpl(final ZMQ.Context ctx, final String uri, final ZMQ.Socket socket) {
        this.context = ctx;
        this.uri = uri;
        this.socket = socket;
    }

    @Override
    public void connect() throws IOException {

        this.isConnected = socket.connect(uri);
        if( !this.isConnected ) {
            throw new IOException( String.format("Couldn't connect to %s. Error number: %d.", uri, socket.errno()) );
        }
    }

    @Override
    public void disconnect() throws IOException {

        try {
            socket.close();
            this.isConnected = false;
        } catch (final Exception ex) {
            throw new IOException("Unable to close the ZMQ socket.", ex);
        }
    }

    @Override
    public void close() throws Exception {

        if ( !context.isTerminated() ) {
            try {
                context.term();
            } catch (final Exception ex) {
                throw new IOException("Unable to terminate the ZMQ Context.", ex);
            }
        }
    }

    public RPC.Response call(final RPC.ProcedureType procedureType) throws RpcGatewayException {

        requireNonNull(procedureType, "The argument 'procedureType' must not be null.");

        final RPC.Request request =
                RPC.Request.newBuilder()
                        .setType(procedureType)
                        .build();

        try {
            return makeRequest(request);
        } catch (final IOException ioe) {
            throw new RpcGatewayException("An error occured while making the remote procedure call.", ioe);
        }
    }

    public RPC.Response callWithArguments(final RPC.ProcedureType procedureType, final MessageLite args) throws RpcGatewayException {

        requireNonNull(procedureType, "The argument 'procedureType' must not be null.");
        requireNonNull(args, "The argument 'args' must not be null.");

        final RPC.Request request =
                RPC.Request.newBuilder()
                        .setType(procedureType)
                        .setArgs( args.toByteString() )
                        .build();
        try {
            return makeRequest(request);
        } catch (final IOException ioe) {
            throw new RpcGatewayException("An error occured while making the remote procedure call.", ioe);
        }
    }

    private RPC.Response makeRequest(final RPC.Request request) throws IOException {

        final ZMsg zRequest =  ZMsg.newStringMsg( request.toByteString().toStringUtf8() );

        zRequest.send(socket);

        final ZMsg zResponse = ZMsg.recvMsg(socket);

        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream( (int) zResponse.contentSize() );
        for (final ZFrame frame : zResponse) {
            byteArrayOutputStream.write( frame.getData() );
        }

        final byte[] responseData = byteArrayOutputStream.toByteArray();

        return RPC.Response.parseFrom(responseData);
    }

}
