package com.enfernuz.quik.lua.rpc.events.impl;

import com.enfernuz.quik.lua.rpc.api.security.zmq.AuthContext;
import com.enfernuz.quik.lua.rpc.api.security.zmq.CurveCredentials;
import com.enfernuz.quik.lua.rpc.api.security.zmq.CurveKeyPair;
import com.enfernuz.quik.lua.rpc.api.security.zmq.PlainCredentials;
import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.events.api.TcpQluaEventPoller;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.common.collect.ImmutableSet;
import org.zeromq.ZFrame;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.EnumSet;

import static java.util.Objects.requireNonNull;

/**
 * Компонент, опрашивающий удалённый RPC-сервис <b>quik-lua-rpc</b> на предмет появления новых событий API QLua
 * терминала QUIK.
 * <br/>
 * Связь с <b>quik-lua-rpc</b> происходит по протоколу TCP с помощью ZeroMQ.
 * @see <a href="https://github.com/Enfernuz/quik-lua-rpc">quik-lua-rpc</a>
 * @see <a href="http://zeromq.org/">ZeroMQ - Distributed Messaging</a>
 */
class ZmqTcpQluaEventPoller implements TcpQluaEventPoller {

    private final NetworkAddress networkAddress;
    private final String uri;
    private ZMQ.Context zmqContext;
    private ZMQ.Socket subSocket;
    private final AuthContext authContext;
    private boolean isOpened;
    private final EnumSet<QluaEvent.EventType> subscription;
    private final SerdeModule serdeModule;

    /**
     * Создаёт новый экземпляр компонента {@link ZmqTcpQluaEventPoller}, с точкой подключения RPC-сервиса на стороне
     * терминала QUIK по заданному сетевому адресу с заданным контекстом защиты передачи данных.
     *
     * @param networkAddress  сетевой адрес точки подключения RPC-сервиса на стороне терминала QUIK
     * @param authContext  контекст защиты передачи данных
     * @param serdeModule  модуль сериализации/десериализации доменных объектов QLua
     * @return новый экземпляр компонента {@link ZmqTcpQluaEventPoller}
     */
    static ZmqTcpQluaEventPoller newInstance(
            final NetworkAddress networkAddress,
            final AuthContext authContext,
            final SerdeModule serdeModule) {

        return new ZmqTcpQluaEventPoller(
                requireNonNull(networkAddress),
                requireNonNull(authContext),
                requireNonNull(serdeModule)
        );
    }

    private ZmqTcpQluaEventPoller(
            final NetworkAddress networkAddress,
            final AuthContext authContext,
            final SerdeModule serdeModule) {

        this.networkAddress = networkAddress;
        this.authContext = authContext;
        this.serdeModule = serdeModule;
        this.uri = String.format("tcp://%s:%d", networkAddress.getHost(), networkAddress.getPort());
        this.subscription = EnumSet.noneOf(QluaEvent.EventType.class);
    }

    /**
     * Получает следующее событие в очереди событий терминала API QLua терминала QUIK.
     * <br/>
     *
     * @param mode  режим опроса удалённого RPC-сервиса <b>quik-lua-rpc</b> на предмет появления нового события API QLua терминала
     * QUIK
     * @return  следующее событие в очереди событий терминала API QLua терминала QUIK или null, если очередь пуста
     * @throws PollingException в случае ошибки при попытке получить следующее событие в очереди событий терминала API
     * QLua терминала QUIK
     */
    @Override
    public QluaEvent poll(final PollingMode mode) throws PollingException {

        try {

            final QluaEvent result;
            final byte[] subscriptionKeyAsBytes;
            switch (mode) {
                case BLOCKING:
                    subscriptionKeyAsBytes = subSocket.recv();
                    break;
                case NO_BLOCKING:
                    subscriptionKeyAsBytes = subSocket.recv(ZMQ.NOBLOCK);
                    break;
                default:
                    throw new IllegalArgumentException(
                            String.format("Неподдерживаемый режим опроса очереди событий: '%s'.", mode)
                    );
            }

            if (subscriptionKeyAsBytes == null) {
                result = null;
            } else {

                final QluaEvent.EventType eventType = serdeModule.deserialize(QluaEvent.EventType.class, subscriptionKeyAsBytes);
                if (eventType == null) {
                    throw new PollingException( String.format("Unknown subscription key: %s.", new String(subscriptionKeyAsBytes, StandardCharsets.UTF_8)) );
                }

                final boolean hasReceiveMore = subSocket.hasReceiveMore();

                if (hasReceiveMore) {

                    final ZMsg eventDataAsMsg = ZMsg.recvMsg(subSocket);
                    if (eventDataAsMsg == null) {
                        throw new PollingException(
                                String.format("No event data has been received for the event \"%s\".", eventType)
                        );
                    }

                    result = QluaEvent.create(eventType, convertZMsgToByteArray(eventDataAsMsg));
                } else {
                    result = QluaEvent.create(eventType);
                }
            }

            return result;
        } catch (final PollingException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new PollingException("Error while polling for events.", ex);
        }
    }

    @Override
    public void subscribe(final QluaEvent.EventType eventType) {

        if (isOpened) {
            subSocket.subscribe( serdeModule.serialize(eventType) );
        }

        subscription.add(eventType);
    }

    @Override
    public void subscribe(final Iterable<? extends QluaEvent.EventType> eventTypes) {

        for (final QluaEvent.EventType eventType : eventTypes) {
            subscribe(eventType);
        }
    }

    @Override
    public void subscribe(final QluaEvent.EventType... eventTypes) {

        for (final QluaEvent.EventType eventType : eventTypes) {
            subscribe(eventType);
        }
    }

    @Override
    public void subscribeToEverything() {
        subscribe( QluaEvent.EventType.values() );
    }

    @Override
    public void unsubscribe(final QluaEvent.EventType eventType) {

        if (isOpened) {
            subSocket.unsubscribe( serdeModule.serialize(eventType) );
        }

        subscription.remove(eventType);
    }

    @Override
    public void unsubscribe(final Iterable<? extends QluaEvent.EventType> eventTypes) {

        for (final QluaEvent.EventType eventType : eventTypes) {
            unsubscribe(eventType);
        }
    }

    @Override
    public void unsubscribe(final QluaEvent.EventType... eventTypes) {

        for (final QluaEvent.EventType eventType : eventTypes) {
            unsubscribe(eventType);
        }
    }

    @Override
    public void unsubscribeFromEverything() {
        unsubscribe( QluaEvent.EventType.values() );
    }

    @Override
    public ImmutableSet<QluaEvent.EventType> getCurrentSubscription() {
        return ImmutableSet.copyOf(subscription);
    }

    @Override
    public NetworkAddress getNetworkAddress() {
        return networkAddress;
    }

    @Override
    public void open() throws IOException {

        if (!this.isOpened) {

            zmqContext = ZMQ.context(1);
            zmqContext.setMaxSockets(1);
            subSocket = zmqContext.socket(ZMQ.SUB);
            subSocket.setLinger(0); // no waiting before closing the socket

            for (final QluaEvent.EventType eventType : subscription) {
                subSocket.subscribe( serdeModule.serialize(eventType) );
            }

            switch (authContext.getAuthMechanism()) {
                case PLAIN:
                    final PlainCredentials plainCredentials = authContext.getPlainCredentials();
                    subSocket.setPlainUsername( plainCredentials.getUsername() );
                    subSocket.setPlainPassword( plainCredentials.getPassword() );
                    break;
                case CURVE:
                    final CurveCredentials curveCredentials = authContext.getCurveCredentials();
                    final CurveKeyPair clientKeyPair = curveCredentials.getClientKeyPair();
                    subSocket.setCurveServerKey( curveCredentials.getServerPublicKey().asBinary() );
                    subSocket.setCurvePublicKey( clientKeyPair.getPublicKey().asBinary() );
                    subSocket.setCurveSecretKey( clientKeyPair.getSecretKey().asBinary() );
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

            final boolean _isConnected  = this.subSocket.connect(uri);
            if (_isConnected) {
                this.isOpened = true;
            } else {

                final String errorMessage =
                        String.format("Couldn't connect to '%s'. ZMQ socket errno:", uri, subSocket.errno());

                subSocket.close();
                zmqContext.term();
                zmqContext = null;
                subSocket = null;

                throw new IOException(errorMessage);
            }
        }
    }

    @Override
    public boolean isOpened() {
        return isOpened;
    }

    @Override
    public void close() throws IOException {

        if (this.isOpened) {

            final boolean isDisconnected = this.subSocket.disconnect(uri);

            if (isDisconnected) {
                subSocket.close();
                zmqContext.term();
                zmqContext = null;
                subSocket = null;
                this.isOpened = false;
            } else {
                throw new IOException(
                        String.format(
                                "Couldn't disconnect from '%s'. ZMQ socket errno: %d",
                                uri,
                                subSocket.errno()
                        )
                );
            }
        }
    }

    private static byte[] convertZMsgToByteArray(final ZMsg message) throws IOException {

        // our event data is small (at the moment, at least), so it's safe to cast the content size to a long
        final ByteArrayOutputStream output = new ByteArrayOutputStream( (int) message.contentSize() );
        for (final ZFrame frame : message) {
            output.write( frame.getData() );
        }

        return output.toByteArray();
    }
}
