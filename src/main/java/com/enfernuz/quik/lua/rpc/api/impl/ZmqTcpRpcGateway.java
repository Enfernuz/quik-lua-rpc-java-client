package com.enfernuz.quik.lua.rpc.api.impl;

import com.enfernuz.quik.lua.rpc.api.TcpRpcGateway;
import com.google.protobuf.MessageLite;
import org.zeromq.ZFrame;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;
import qlua.rpc.RPC;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static java.util.Objects.requireNonNull;

public final class ZmqTcpRpcGateway implements TcpRpcGateway {

    private final String host;
    private final int port;
    private final ZMQ.Socket reqSocket;
    private boolean isOpened;

    public static ZmqTcpRpcGateway create(final ZMQ.Context zmqContext, final String host, final int port) {

        requireNonNull(zmqContext, "The argument 'zmqContext' must not be null.");
        if ( zmqContext.isTerminated() ) {
            throw new IllegalArgumentException("The argument 'zmqContext' must not be in the terminated state.");
        }

        // TO-DO: add URI validation
        //final String uri = String.format("tcp://%s:%d", host, port);

        return new ZmqTcpRpcGateway(zmqContext.socket(ZMQ.REQ), host, port);
    }

    private ZmqTcpRpcGateway(final ZMQ.Socket reqSocket, final String host, final int port) {

        this.reqSocket = reqSocket;
        this.host = host;
        this.port = port;
    }

    @Override
    public void open() throws IOException {

        if (!this.isOpened) {

            final boolean _isConnected  = this.reqSocket.connect(uri);
            if (_isConnected) {
                this.isOpened = true;
            } else {
                throw new IOException( String.format("Couldn't connect to '%s'.", uri) );
            }
        }
    }

    @Override
    public void close() throws Exception {

        if (this.isOpened) {

            final boolean isDisconnected = this.reqSocket.disconnect(uri);
            if (isDisconnected) {
                this.isOpened = false;
            } else {
                throw new IOException( String.format("Couldn't connect to '%s'.", uri) );
            }
        }
    }

    @Override
    public boolean isOpened() {
        return isOpened;
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public RPC.Response call(final RPC.ProcedureType procedureType) throws RpcException {

        requireNonNull(procedureType, "The argument 'procedureType' must not be null.");

        final RPC.Request request =
                RPC.Request.newBuilder()
                        .setType(procedureType)
                        .build();

        try {
            return makeRequest(request);
        } catch (final IOException ioe) {
            throw new RpcException("An error occured while making the remote procedure call.", ioe);
        }
    }

    @Override
    public RPC.Response callWithArguments(final RPC.ProcedureType procedureType, final MessageLite args) throws RpcException {

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
            throw new RpcException("An error occured while making the remote procedure call.", ioe);
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
