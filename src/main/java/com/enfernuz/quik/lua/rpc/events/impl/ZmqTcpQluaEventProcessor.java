package com.enfernuz.quik.lua.rpc.events.impl;

import com.enfernuz.quik.lua.rpc.api.security.zmq.AuthContext;
import com.enfernuz.quik.lua.rpc.events.api.*;
import com.enfernuz.quik.lua.rpc.events.api.structures.*;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.google.common.collect.*;
import qlua.structs.QluaStructures;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * Обработчик очереди событий API QLua терминала QUIK, полученных из удалённого RPC-сервиса <b>quik-lua-rpc</b>.
 * <br/>
 * Связь с <b>quik-lua-rpc</b> происходит по протоколу TCP с помощью ZeroMQ.
 * <br/>
 * Экземпляры класса не потокобезопасны.
 *
 * @see <a href="https://github.com/Enfernuz/quik-lua-rpc">quik-lua-rpc</a>
 * @see <a href="http://zeromq.org/">ZeroMQ - Distributed Messaging</a>
 */
public class ZmqTcpQluaEventProcessor implements TcpQluaEventProcessor {

    private ZmqTcpQluaEventPoller eventPoller;
    private final List<QluaEventHandler> eventHandlers;
    private final SerdeModule serdeModule;

    /**
     * Создаёт новый экземпляр компонента {@link ZmqTcpQluaEventProcessor}, с точкой подключения RPC-сервиса на стороне
     * терминала QUIK по заданному сетевому адресу с заданным контекстом защиты передачи данных.
     *
     * @param networkAddress  сетевой адрес точки подключения RPC-сервиса на стороне терминала QUIK
     * @param authContext  контекст защиты передачи данных
     * @param serdeModule  модуль сериализации/десериализации доменных объектов QLua
     * @return  новый экземпляр компонента {@link ZmqTcpQluaEventProcessor}
     */
    public static ZmqTcpQluaEventProcessor newInstance(
            final NetworkAddress networkAddress,
            final AuthContext authContext,
            final SerdeModule serdeModule) {

        return new ZmqTcpQluaEventProcessor(
                ZmqTcpQluaEventPoller.newInstance(networkAddress, authContext, serdeModule),
                serdeModule
        );
    }

    private ZmqTcpQluaEventProcessor(final ZmqTcpQluaEventPoller eventPoller, final SerdeModule serdeModule) {

        this.eventPoller = requireNonNull(eventPoller, "Аргумент 'eventPoller' не должен быть null.");
        this.serdeModule = requireNonNull(serdeModule, "Аргумент 'serdeModule' не должен быть null.");
        this.eventHandlers = new ArrayList<>(1);
    }

    @Override
    public void process() throws QluaEventProcessingException {

        try {
            final QluaEvent event = eventPoller.poll(QluaEventPoller.PollingMode.BLOCKING);
            final byte[] eventData = event.getData();
            if (event != null) {
                for (final QluaEventHandler eventHandler : eventHandlers) {
                    switch (event.getType()) {
                        case ON_STOP:
                            eventHandler.onStop( serdeModule.deserialize(StopEventInfo.class, eventData) );
                            break;
                        case ON_CLOSE:
                            eventHandler.onClose();
                            break;
                        case ON_CONNECTED:
                            eventHandler.onConnected( serdeModule.deserialize(ConnectedEventInfo.class, eventData) );
                            break;
                        case ON_DISCONNECTED:
                            eventHandler.onDisconnected();
                            break;
                        case ON_FIRM:
                            eventHandler.onFirm( serdeModule.deserialize(Firm.class, eventData) );
                            break;
                        case ON_ALL_TRADE:
                            eventHandler.onAllTrade( serdeModule.deserialize(AllTrade.class, eventData) );
                            break;
                        case ON_TRADE:
                            eventHandler.onTrade( serdeModule.deserialize(Trade.class, eventData) );
                            break;
                        case ON_ORDER:
                            eventHandler.onOrder( serdeModule.deserialize(Order.class, eventData) );
                            break;
                        case ON_ACCOUNT_BALANCE:
                            eventHandler.onAccountBalance( serdeModule.deserialize(AccountBalance.class, eventData) );
                            break;
                        case ON_FUTURES_LIMIT_CHANGE:
                            eventHandler.onFuturesLimitChange( serdeModule.deserialize(FuturesLimit.class, eventData) );
                            break;
                        case ON_FUTURES_LIMIT_DELETE:
                            eventHandler.onFuturesLimitDelete( serdeModule.deserialize(FuturesLimitDelete.class, eventData) );
                            break;
                        case ON_FUTURES_CLIENT_HOLDING:
                            eventHandler.onFuturesClientHolding( serdeModule.deserialize(FuturesClientHolding.class, eventData) );
                            break;
                        case ON_MONEY_LIMIT:
                            eventHandler.onMoneyLimit( serdeModule.deserialize(MoneyLimit.class, eventData) );
                            break;
                        case ON_MONEY_LIMIT_DELETE:
                            eventHandler.onMoneyLimitDelete( serdeModule.deserialize(MoneyLimitDelete.class, eventData) );
                            break;
                        case ON_DEPO_LIMIT:
                            eventHandler.onDepoLimit( serdeModule.deserialize(DepoLimit.class, eventData) );
                            break;
                        case ON_DEPO_LIMIT_DELETE:
                            eventHandler.onDepoLimitDelete( serdeModule.deserialize(DepoLimitDelete.class, eventData) );
                            break;
                        case ON_ACCOUNT_POSITION:
                            eventHandler.onAccountPosition( QluaStructures.AccountPosition.parseFrom(event.getData()) );
                            break;
                        case ON_NEG_DEAL:
                            eventHandler.onNegDeal( QluaStructures.NegDeal.parseFrom(event.getData()) );
                            break;
                        case ON_NEG_TRADE:
                            eventHandler.onNegTrade( QluaStructures.NegTrade.parseFrom(event.getData()) );
                            break;
                        case ON_STOP_ORDER:
                            eventHandler.onStopOrder( QluaStructures.StopOrder.parseFrom(event.getData()) );
                            break;
                        case ON_TRANS_REPLY:
                            eventHandler.onTransReply( QluaStructures.Transaction.parseFrom(event.getData()) );
                            break;
                        case ON_PARAM:
                            eventHandler.onParam( QluaStructures.ParamEventInfo.parseFrom(event.getData()) );
                            break;
                        case ON_QUOTE:
                            eventHandler.onQuote( QluaStructures.QuoteEventInfo.parseFrom(event.getData()) );
                            break;
                        case ON_CLEAN_UP:
                            eventHandler.onCleanUp();
                            break;
                        default:
                            throw new QluaEventProcessingException(
                                    String.format("Неподдерживаемый тип QLua-события: \"%s\".", event.getType())
                            );
                    }
                }
            }
        } catch (final QluaEventProcessingException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new QluaEventProcessingException("Ошибка при обработке QLua-события.", ex);
        }
    }

    @Override
    public void process(int maxEvents) {

        do {
            process();
        } while (--maxEvents > 0);
    }

    @Override
    public void register(final QluaEventHandler eventHandler) {
        eventHandlers.add( requireNonNull(eventHandler) );
    }

    @Override
    public void register(final Iterable<? extends QluaEventHandler> eventHandlers) {

        for (final QluaEventHandler eventHandler : requireNonNull(eventHandlers)) {
            register(eventHandler);
        }
    }

    @Override
    public void unregister(final QluaEventHandler eventHandler) {
        eventHandlers.remove(eventHandler);
    }

    @Override
    public void unregister(final Iterable<? extends QluaEventHandler> eventHandlers) {

        for (final QluaEventHandler eventHandler : requireNonNull(eventHandlers)) {
            unregister(eventHandler);
        }
    }

    @Override
    public ImmutableList<QluaEventHandler> getRegisteredEventHandlers() {
        return ImmutableList.copyOf(eventHandlers);
    }

    @Override
    public void subscribe(final QluaEvent.EventType eventType) {
        eventPoller.subscribe(eventType);
    }

    @Override
    public void subscribe(final Iterable<? extends QluaEvent.EventType> eventTypes) {
        eventPoller.subscribe(eventTypes);
    }

    @Override
    public void subscribe(final QluaEvent.EventType... eventTypes) {
        eventPoller.subscribe(eventTypes);
    }

    @Override
    public void subscribeToEverything() {
        eventPoller.subscribeToEverything();
    }

    @Override
    public void unsubscribe(final QluaEvent.EventType eventType) {
        eventPoller.unsubscribe(eventType);
    }

    @Override
    public void unsubscribe(final Iterable<? extends QluaEvent.EventType> eventTypes) {
        eventPoller.unsubscribe(eventTypes);
    }

    @Override
    public void unsubscribe(final QluaEvent.EventType... eventTypes) {
        eventPoller.unsubscribe(eventTypes);
    }

    @Override
    public void unsubscribeFromEverything() {
        eventPoller.unsubscribeFromEverything();
    }

    @Override
    public ImmutableSet<QluaEvent.EventType> getCurrentSubscription() {
        return eventPoller.getCurrentSubscription();
    }

    @Override
    public NetworkAddress getNetworkAddress() {
        return eventPoller.getNetworkAddress();
    }

    @Override
    public void open() throws IOException {
        eventPoller.open();
    }

    @Override
    public boolean isOpened() {
        return eventPoller.isOpened();
    }

    @Override
    public void close() throws IOException {
        eventPoller.close();
    }
}
