package com.enfernuz.quik.lua.rpc.api.zmq;

import com.enfernuz.quik.lua.rpc.api.security.zmq.AuthContext;
import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.common.collect.ImmutableSet;
import lombok.NonNull;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.zeromq.ZMQ;
import org.zeromq.ZMsg;

import java.nio.charset.StandardCharsets;
import java.util.EnumSet;

/**
 * Компонент, опрашивающий удалённый RPC-сервис <b>quik-lua-rpc</b> на предмет появления новых событий API QLua
 * терминала QUIK.
 * <br/>
 * Связь с <b>quik-lua-rpc</b> происходит по протоколу TCP с помощью ZeroMQ.
 * <br/>
 * Экземпляры класса не потокобезопасны.
 *
 * @see <a href="https://github.com/Enfernuz/quik-lua-rpc">quik-lua-rpc</a>
 * @see <a href="http://zeromq.org/">ZeroMQ - Distributed Messaging</a>
 */
abstract class AbstractZmqTcpQluaEventPoller extends AbstractTcpZmqClient implements ZmqTcpQluaEventPoller {

    private ZMQ.Context zmqContext;
    private ZMQ.Socket subSocket;
    private final AuthContext authContext;
    private final EnumSet<QluaEvent.EventType> subscription;
    private final SerdeModule serdeModule;

    /**
     * Создаёт новый экземпляр опрашивателя очереди событий, с точкой подключения RPC-сервиса на стороне
     * терминала QUIK по заданному сетевому адресу с заданным контекстом защиты передачи данных.
     *
     * @param networkAddress  сетевой адрес точки подключения RPC-сервиса на стороне терминала QUIK
     * @param authContext  контекст защиты передачи данных
     * @param serdeModule  модуль сериализации/десериализации доменных объектов QLua
     * @return новый экземпляр компонента {@link AbstractZmqTcpQluaEventPoller}
     */
    AbstractZmqTcpQluaEventPoller(
            final NetworkAddress networkAddress,
            final AuthContext authContext,
            final SerdeModule serdeModule) {

        super(networkAddress);

        this.authContext = authContext;
        this.serdeModule = serdeModule;
        this.subscription = EnumSet.noneOf(QluaEvent.EventType.class);
    }

    abstract byte[] receiveSubscriptionKeyAsBytes();

    /**
     * Получает следующее событие в очереди событий терминала API QLua терминала QUIK.
     *
     * @return  следующее событие в очереди событий терминала API QLua терминала QUIK или null, если очередь пуста
     * @throws PollingException в случае ошибки при попытке получить следующее событие в очереди событий терминала API
     * QLua терминала QUIK
     */
    @Override
    public QluaEvent poll() throws PollingException {

        try {

            final QluaEvent result;
            final byte[] subscriptionKeyAsBytes = receiveSubscriptionKeyAsBytes();
            if (subscriptionKeyAsBytes == null) {
                result = null;
            } else {
                final QluaEvent.EventType eventType = serdeModule.deserialize(QluaEvent.EventType.class, subscriptionKeyAsBytes);
                if (eventType == null) {
                    throw new PollingException(
                            String.format(
                                    "Неизвестный ключ подписки на QLua-события: \"%s\".",
                                    new String(subscriptionKeyAsBytes, StandardCharsets.UTF_8)
                            )
                    );
                }

                if ( subSocket.hasReceiveMore() ) {

                    final ZMsg eventDataAsMsg = ZMsg.recvMsg(subSocket);
                    if (eventDataAsMsg == null) {
                        throw new PollingException(
                                String.format("Для QLua-события \"%s\" не получено данных.", eventType)
                        );
                    }

                    result = QluaEvent.create(eventType, ZmqUtils.convertZMsgToByteArray(eventDataAsMsg));
                } else {
                    result = QluaEvent.create(eventType);
                }
            }

            return result;
        } catch (final PollingException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new PollingException("Ошибка при чтении очереди QLua-событий.", ex);
        }
    }

    @Override
    public void subscribe(@NotNull @NonNull final QluaEvent.EventType eventType) {

        if (isOpened()) {
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

        if (isOpened()) {
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

    @Contract(pure = true)
    @Override
    public final AuthContext getAuthContext() {
        return authContext;
    }

    @Override
    final void initializeIO() {

        zmqContext = ZMQ.context(1);
        zmqContext.setMaxSockets(1);
        subSocket = zmqContext.socket(ZMQ.SUB);
        subSocket.setLinger(0); // no waiting before closing the socket

        for (final QluaEvent.EventType eventType : subscription) {
            subSocket.subscribe( serdeModule.serialize(eventType) );
        }

        ZmqUtils.setSocketSecurity(subSocket, authContext);
    }

    @Override
    final void deinitializeIO() {

        subSocket.close();
        zmqContext.term();
        zmqContext = null;
        subSocket = null;
    }

    @Contract(pure = true)
    @Override
    final ZMQ.Socket getSocket() {
        return subSocket;
    }
}
