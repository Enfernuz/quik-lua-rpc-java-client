package com.enfernuz.quik.lua.rpc.events.impl;

import com.enfernuz.quik.lua.rpc.api.security.zmq.AuthContext;
import com.enfernuz.quik.lua.rpc.api.security.zmq.CurveCredentials;
import com.enfernuz.quik.lua.rpc.api.security.zmq.CurveKeyPair;
import com.enfernuz.quik.lua.rpc.api.security.zmq.PlainCredentials;
import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.events.api.TcpQluaEventPoller;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.google.common.collect.ImmutableSet;
import com.google.protobuf.ByteString;
import org.zeromq.ZFrame;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;
import qlua.events.QluaEvents;
import sun.reflect.CallerSensitive;

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
    private final EnumSet<QluaEvents.EventType> subscription;

    /**
     * Создаёт новый экземпляр компонента {@link ZmqTcpQluaEventPoller}, с точкой подключения RPC-сервиса на стороне
     * терминала QUIK по заданному сетевому адресу с заданным контекстом защиты передачи данных.
     *
     * @param networkAddress  сетевой адрес точки подключения RPC-сервиса на стороне терминала QUIK
     * @param authContext  контекст защиты передачи данных
     * @return новый экземпляр компонента {@link ZmqTcpQluaEventPoller}
     */
    static ZmqTcpQluaEventPoller newInstance(final NetworkAddress networkAddress, final AuthContext authContext) {
        return new ZmqTcpQluaEventPoller(requireNonNull(networkAddress), requireNonNull(authContext));
    }

    private ZmqTcpQluaEventPoller(final NetworkAddress networkAddress, final AuthContext authContext) {

        this.networkAddress = networkAddress;
        this.authContext = authContext;
        this.uri = String.format("tcp://%s:%d", networkAddress.getHost(), networkAddress.getPort());
        this.subscription = EnumSet.noneOf(QluaEvents.EventType.class);
    }

    @Override
    public QluaEvent poll() throws PollingException {

        try {

            final QluaEvent result;

            final byte[] subscriptionKeyAsBytes = subSocket.recv();
            if (subscriptionKeyAsBytes == null) {
                result = null;
            } else {

                final String subscriptionKeyAsString = new String(subscriptionKeyAsBytes, StandardCharsets.UTF_8);
                final int subscriptionKey = Integer.parseInt(subscriptionKeyAsString);
                final QluaEvents.EventType eventType = QluaEvents.EventType.forNumber(subscriptionKey);

                if (eventType == null) {
                    throw new PollingException( String.format("Unknown subscription key: %d.", subscriptionKey) );
                }

                final boolean hasReceiveMore = subSocket.hasReceiveMore();

                if (hasReceiveMore) {

                    final ZMsg eventDataAsMsg = ZMsg.recvMsg(subSocket);
                    if (eventDataAsMsg == null) {
                        throw new PollingException(
                                String.format("No event data has been received for the event \"%s\".", eventType)
                        );
                    }

                    final ByteString eventData = convertZMsgToByteString(eventDataAsMsg);
                    result = QluaEvent.create(eventType, eventData);
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
    public void subscribe(final QluaEvents.EventType eventType) {

        switch (eventType) {
            case UNRECOGNIZED:
            case EVENT_TYPE_UNKNOWN:
                return;
        }

        if (isOpened) {
            subSocket.subscribe( eventTypeToTopic(eventType) );
        }

        subscription.add(eventType);
    }

    @Override
    public void subscribe(final Iterable<? extends QluaEvents.EventType> eventTypes) {

        for (final QluaEvents.EventType eventType : eventTypes) {
            subscribe(eventType);
        }
    }

    @Override
    public void subscribe(final QluaEvents.EventType... eventTypes) {

        for (final QluaEvents.EventType eventType : eventTypes) {
            subscribe(eventType);
        }
    }

    @Override
    public void subscribeToEverything() {
        subscribe( QluaEvents.EventType.values() );
    }

    @Override
    public void unsubscribe(final QluaEvents.EventType eventType) {

        switch (eventType) {
            case UNRECOGNIZED:
            case EVENT_TYPE_UNKNOWN:
                return;
        }

        if (isOpened) {
            subSocket.unsubscribe( eventTypeToTopic(eventType) );
        }

        subscription.remove(eventType);
    }

    @Override
    public void unsubscribe(final Iterable<? extends QluaEvents.EventType> eventTypes) {

        for (final QluaEvents.EventType eventType : eventTypes) {
            unsubscribe(eventType);
        }
    }

    @Override
    public void unsubscribe(final QluaEvents.EventType... eventTypes) {

        for (final QluaEvents.EventType eventType : eventTypes) {
            unsubscribe(eventType);
        }
    }

    @Override
    public void unsubscribeFromEverything() {
        unsubscribe( QluaEvents.EventType.values() );
    }

    @Override
    public ImmutableSet<QluaEvents.EventType> getCurrentSubscription() {
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

            for (final QluaEvents.EventType eventType : subscription) {
                subSocket.subscribe( String.valueOf(eventType.getNumber()) );
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

    private static String eventTypeToTopic(final QluaEvents.EventType eventType) {
        return String.valueOf( eventType.getNumber() );
    }

    private static ByteString convertZMsgToByteString(final ZMsg message) throws IOException {

        // our event data is small (at the moment, at least), so it's safe to cast the content size to a long
        final ByteArrayOutputStream output = new ByteArrayOutputStream( (int) message.contentSize() );
        for (final ZFrame frame : message) {
            output.write( frame.getData() );
        }

        return ByteString.copyFrom( output.toByteArray() );
    }
}
