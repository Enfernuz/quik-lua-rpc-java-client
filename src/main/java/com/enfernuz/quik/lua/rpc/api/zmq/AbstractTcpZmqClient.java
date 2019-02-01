package com.enfernuz.quik.lua.rpc.api.zmq;

import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.enfernuz.quik.lua.rpc.io.transport.TcpGateway;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.zeromq.ZMQ;

import java.io.IOException;

abstract class AbstractTcpZmqClient implements TcpGateway {

    private final NetworkAddress networkAddress;
    private final String uri;
    private boolean opened;

    AbstractTcpZmqClient(@NonNull @NotNull final NetworkAddress networkAddress) {
        this.networkAddress = networkAddress;
        this.uri = String.format("tcp://%s:%d", networkAddress.getHost(), networkAddress.getPort());
    }

    abstract ZMQ.Socket getSocket();

    abstract void initializeIO();

    abstract void deinitializeIO();

    @Override
    public final NetworkAddress getNetworkAddress() {
        return networkAddress;
    }

    @Override
    public final void open() throws IOException {

        if (!opened) {

            initializeIO();

            final ZMQ.Socket socket = getSocket();
            if ( socket.connect(uri) ) {
                opened = true;
            } else {

                final String errorMessage = String.format(
                        "Не удалось соединиться с %s. Номер ошибки сокета ZMQ (errno): %d.",
                        uri,
                        socket.errno()
                );

                Throwable suppressed = null;
                try {
                    deinitializeIO();
                } catch (final Throwable t) {
                    suppressed = t;
                } finally {
                    final IOException ex = new IOException(errorMessage);
                    if (suppressed != null) {
                        ex.addSuppressed(suppressed);
                    }
                    throw ex;
                }
            }
        }
    }

    @Override
    public final boolean isOpened() {
        return opened;
    }

    @Override
    public final void close() throws IOException {

        if (opened) {

            final ZMQ.Socket socket = getSocket();
            if ( socket.disconnect(uri) ) {
                opened = false;
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
