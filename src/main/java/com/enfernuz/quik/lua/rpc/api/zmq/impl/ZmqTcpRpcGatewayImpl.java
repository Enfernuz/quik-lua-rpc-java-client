package com.enfernuz.quik.lua.rpc.api.zmq.impl;

import com.enfernuz.quik.lua.rpc.api.security.zmq.*;
import com.enfernuz.quik.lua.rpc.api.zmq.ZmqTcpRpcGateway;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.google.protobuf.MessageLite;
import org.zeromq.ZFrame;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;
import qlua.rpc.RPC;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static java.util.Objects.requireNonNull;

/**
 * Реализация компонента <b>TCP-шлюз удалённого вызова процедур на базе ZeroMQ</b>.
 */
class ZmqTcpRpcGatewayImpl implements ZmqTcpRpcGateway {

    private final NetworkAddress networkAddress;
    private final String uri;
    private ZMQ.Context zmqContext;
    private ZMQ.Socket reqSocket;
    private final AuthContext authContext;
    private boolean isOpened;

    /**
     * Возвращает новый экземпляр компонента {@link ZmqTcpRpcGatewayImpl} с точкой подключения RPC-сервиса на стороне
     * терминала QUIK по заданному сетевому адресу с заданным контекстом защиты передачи данных.
     *
     * @param networkAddress  сетевой адрес точки подключения RPC-сервиса на стороне терминала QUIK
     * @param authContext  контекст защиты передачи данных
     * @return новый экземпляр компонента {@link ZmqTcpRpcGatewayImpl}
     */
    static ZmqTcpRpcGatewayImpl newInstance(
            final NetworkAddress networkAddress,
            final AuthContext authContext) {

        return new ZmqTcpRpcGatewayImpl(
                requireNonNull(networkAddress, "The argument \"networkAddress\" must not be null."),
                requireNonNull(authContext, "The argument \"authContext\" must not be null.")
        );
    }

    private ZmqTcpRpcGatewayImpl(final NetworkAddress networkAddress, final AuthContext authContext) {

        this.networkAddress = networkAddress;
        this.authContext = authContext;
        this.uri = String.format("tcp://%s:%d", networkAddress.getHost(), networkAddress.getPort());
    }

    @Override
    public void open() throws IOException {

        if (!this.isOpened) {

            zmqContext = ZMQ.context(1);

            reqSocket = zmqContext.socket(ZMQ.REQ);
            reqSocket.setLinger(1000);

            switch (authContext.getAuthMechanism()) {
                case PLAIN:
                    final PlainCredentials plainCredentials = authContext.getPlainCredentials();
                    reqSocket.setPlainUsername( plainCredentials.getUsername() );
                    reqSocket.setPlainPassword( plainCredentials.getPassword() );
                    break;
                case CURVE:
                    final CurveCredentials curveCredentials = authContext.getCurveCredentials();
                    final CurveKeyPair clientKeyPair = curveCredentials.getClientKeyPair();
                    reqSocket.setCurveServerKey( curveCredentials.getServerPublicKey().asBinary() );
                    reqSocket.setCurvePublicKey( clientKeyPair.getPublicKey().asBinary() );
                    reqSocket.setCurveSecretKey( clientKeyPair.getSecretKey().asBinary() );
                    break;
                case NULL:
                    break;
                default:
                    throw new IllegalStateException(
                            String.format(
                                    "Unsupported authentication mechanism: \"s\".",
                                    authContext.getAuthMechanism()
                            )
                    );
            }

            final boolean _isConnected  = this.reqSocket.connect(uri);
            if (_isConnected) {
                this.isOpened = true;
            } else {

                final String errorMessage =
                        String.format("Couldn't connect to '%s'. ZMQ socket errno:", uri, reqSocket.errno());

                reqSocket.close();
                zmqContext.term();
                zmqContext = null;
                reqSocket = null;

                throw new IOException(errorMessage);
            }
        }
    }

    @Override
    public void close() throws IOException {

        if (this.isOpened) {

            final boolean isDisconnected = this.reqSocket.disconnect(uri);

            if (isDisconnected) {
                reqSocket.close();
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
    public NetworkAddress getNetworkAddress() {
        return networkAddress;
    }

    @Override
    public AuthContext getAuthContext() {
        return authContext;
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
    public RPC.Response call(final RPC.ProcedureType procedureType, final MessageLite args) throws RpcException {

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
