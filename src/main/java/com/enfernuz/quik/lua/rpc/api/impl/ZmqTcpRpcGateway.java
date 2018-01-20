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
    private final String uri;
    private ZMQ.Context zmqContext;
    private ZMQ.Socket reqSocket;
    private boolean isOpened;

    public static ZmqTcpRpcGateway create(final String host, final int port) {

        // TO-DO: add URI validation
        //final String uri = String.format("tcp://%s:%d", host, port);

        return new ZmqTcpRpcGateway(host, port);
    }

    private ZmqTcpRpcGateway(final String host, final int port) {

        this.host = host;
        this.port = port;
        this.uri = String.format("tcp://%s:%d", host, port);
    }

    @Override
    public void open() throws IOException {

        if (!this.isOpened) {

            zmqContext = ZMQ.context(1);
            reqSocket = zmqContext.socket(ZMQ.REQ);

            final boolean _isConnected  = this.reqSocket.connect(uri);
            if (_isConnected) {
                this.isOpened = true;
            } else {

                final String errorMessage =
                        String.format("Couldn't connect to '%s'. ZMQ socket errno:", uri, reqSocket.errno());

                zmqContext.term();
                zmqContext = null;
                reqSocket = null;

                throw new IOException(errorMessage);
            }
        }
    }

    @Override
    public void close() throws Exception {

        if (this.isOpened) {

            final boolean isDisconnected = this.reqSocket.disconnect(uri);

            if (isDisconnected) {
                zmqContext.term();
                zmqContext = null;
                reqSocket = null;
                this.isOpened = false;
            } else {
                throw new IOException(
                        String.format(
                                "Couldn't disconnect from '%s'. ZMQ socket errno: %d",
                                uri,
                                reqSocket.errno()
                        )
                );
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

        zRequest.send(reqSocket);

        final ZMsg zResponse = ZMsg.recvMsg(reqSocket);

        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream( (int) zResponse.contentSize() );
        for (final ZFrame frame : zResponse) {
            byteArrayOutputStream.write( frame.getData() );
        }

        final byte[] responseData = byteArrayOutputStream.toByteArray();

        return RPC.Response.parseFrom(responseData);
    }

}
