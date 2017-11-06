package com.enfernuz.quik.lua.rpc.client.api.com.enfernuz.quik.lua.rpc.client.impl;

import com.enfernuz.quik.lua.rpc.client.api.RpcClient;
import org.zeromq.ZFrame;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Objects;

public class RpcClientImpl implements RpcClient {

    private final ZMQ.Context context;
    private final String uri;
    private final ZMQ.Socket socket;
    private boolean isConnected;

    private RpcClientImpl(final ZMQ.Context ctx, final String uri, final ZMQ.Socket socket) {

        this.context = ctx;
        this.uri = uri;
        this.socket = socket;
    }

    public static RpcClientImpl create(final String host, final int port) {

        // TO-DO: add validation for the host and port parameters

        final ZMQ.Context ctx = ZMQ.context(1);
        final String uri = String.format("tcp://%s:%d", host, port);
        final ZMQ.Socket socket = ctx.socket(ZMQ.REQ);

        return new RpcClientImpl(ctx, uri, socket);
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

    public qlua.rpc.Message.Result message(qlua.rpc.Message.Request request) {

        Objects.requireNonNull(request, "The 'request' parameter must not be null.");

        final qlua.rpc.RPC.Request qluaRequest =
                qlua.rpc.RPC.Request
                        .newBuilder()
                        .setType(qlua.rpc.RPC.ProcedureType.MESSAGE)
                        .setArgs( request.toByteString() )
                        .build();

        final ZMsg zRequest =  ZMsg.newStringMsg( qluaRequest.toByteString().toStringUtf8() );
        zRequest.send(socket);

        final ZMsg zResponse = ZMsg.recvMsg(socket);

        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream( (int) zResponse.contentSize() );
        for (final ZFrame frame : zResponse) {

            try {
                byteArrayOutputStream.write( frame.getData() );
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }

        final byte[] responseData = byteArrayOutputStream.toByteArray();

        try {
            final qlua.rpc.RPC.Response qluaResponse = qlua.rpc.RPC.Response.parseFrom(responseData);

            final qlua.rpc.Message.Result result =
                    qlua.rpc.Message.Result.parseFrom( qluaResponse.getResult() );

            System.out.println("Message result: " + result.getResult());

            return result;
        } catch (final Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
