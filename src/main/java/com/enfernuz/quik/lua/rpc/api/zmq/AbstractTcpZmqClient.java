package com.enfernuz.quik.lua.rpc.api.zmq;

import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.enfernuz.quik.lua.rpc.io.transport.TcpGateway;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.zeromq.ZMQ;

import java.io.IOException;

import static java.util.Objects.requireNonNull;

abstract class AbstractTcpZmqClient implements TcpGateway {

    private final NetworkAddress networkAddress;
    private final String uri;
    private boolean isOpened;

    AbstractTcpZmqClient(final @NotNull NetworkAddress networkAddress) {
        this.networkAddress = requireNonNull(networkAddress, "Аргумент 'networkAddress' не должен быть null.");
        this.uri = String.format("tcp://%s:%d", networkAddress.getHost(), networkAddress.getPort());
    }

    abstract ZMQ.Socket getSocket();

    abstract void initializeIO();

    abstract void deinitializeIO();

    @Contract(pure = true)
    @Override
    public final NetworkAddress getNetworkAddress() {
        return networkAddress;
    }

    @Override
    public final void open() throws IOException {

        if (!isOpened) {

            initializeIO();

            final ZMQ.Socket socket = getSocket();
            if ( socket.connect(uri) ) {
                isOpened = true;
            } else {

                final String errorMessage = String.format(
                        "Не удалось соединиться с %s. Номер ошибки сокета ZMQ (errno): %d.",
                        uri,
                        socket.errno()
                );

                deinitializeIO();

                throw new IOException(errorMessage);
            }
        }
    }

    @Contract(pure = true)
    @Override
    public final boolean isOpened() {
        return isOpened;
    }

    @Override
    public final void close() throws IOException {

        if (isOpened) {

            final ZMQ.Socket socket = getSocket();
            if ( socket.disconnect(uri) ) {
                isOpened = false;
                deinitializeIO();
            } else {
                throw new IOException(
                        String.format(
                                "Не удалось разъединиться с %s. Номер ошибки сокета ZMQ (errno): %d.",
                                uri,
                                socket.errno()
                        )
                );
            }
        }
    }
}
