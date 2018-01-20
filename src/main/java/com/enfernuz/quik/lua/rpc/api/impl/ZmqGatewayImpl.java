package com.enfernuz.quik.lua.rpc.api.impl;

import com.enfernuz.quik.lua.rpc.io.Gateway;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;

import java.io.IOException;

import static java.util.Objects.requireNonNull;

public final class ZmqGatewayImpl implements Gateway {

    private final String uri;
    private final ZMQ.Socket socket;
    private boolean isOpened;

    public static ZmqGatewayImpl create(
            final ZMQ.Context zmqContext,
            final int socketType,
            final String host,
            final int port) {

        requireNonNull(zmqContext, "The argument 'zmqContext' must not be null.");

        if ( zmqContext.isTerminated() ) {
            throw new IllegalArgumentException("The argument 'zmqContext' must not be in the terminated state.");
        }

        checkSocketType(socketType);

        // TO-DO: add URI validation
        final String uri = String.format("tcp://%s:%d", host, port);

        return new ZmqGatewayImpl(uri, zmqContext.socket(socketType));
    }

    private ZmqGatewayImpl(final String uri, final ZMQ.Socket socket) {

        this.uri = uri;
        this.socket = socket;
    }

    @Override
    public void open() throws IOException {

        if (!this.isOpened) {

            final boolean _isConnected  = this.socket.connect(uri);
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

            final boolean isDisconnected = this.socket.disconnect(uri);
            if (isDisconnected) {
                this.isOpened = false;
            } else {
                throw new IOException( String.format("Couldn't disconnect from '%s'.", uri) );
            }
        }
    }


    @Override
    public boolean isOpened() {
        return isOpened;
    }

    private static void checkSocketType(final int socketType) {

        switch (socketType) {
            case ZMQ.PAIR: break;
            case ZMQ.PUB: break;
            case ZMQ.SUB: break;
            case ZMQ.REQ: break;
            case ZMQ.REP: break;
            case ZMQ.DEALER: break;
            case ZMQ.ROUTER: break;
            case ZMQ.PULL: break;
            case ZMQ.PUSH: break;
            case ZMQ.XPUB: break;
            case ZMQ.XSUB: break;
            case ZMQ.STREAM: break;
            default:
                throw new IllegalArgumentException( String.format("Unsupported socket type: %d.", socketType) );
        }
    }

}
