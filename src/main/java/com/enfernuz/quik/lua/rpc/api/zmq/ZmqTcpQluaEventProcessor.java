package com.enfernuz.quik.lua.rpc.api.zmq;

import com.enfernuz.quik.lua.rpc.api.security.zmq.AuthContext;
import com.enfernuz.quik.lua.rpc.api.security.zmq.ZmqSecurable;
import com.enfernuz.quik.lua.rpc.api.structures.*;
import com.enfernuz.quik.lua.rpc.config.ClientConfiguration;
import com.enfernuz.quik.lua.rpc.events.api.*;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.enfernuz.quik.lua.rpc.serde.SerdeUtils;
import com.google.common.collect.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.util.Objects.requireNonNull;

/**
 * Обработчик очереди событий API QLua терминала QUIK, полученных из удалённого RPC-сервиса <b>quik-lua-rpc</b>.
 * <br/>
 * Связь с <b>quik-lua-rpc</b> происходит по протоколу TCP с помощью ZeroMQ.
 * <br/>
 * Экземпляры класса не потокобезопасны, за исключением методов {@link #register(QluaEventHandler eventHandler)},
 * {@link #unregister(QluaEventHandler eventHandler)}, {@link #register(Iterable eventHandlers)} и
 * {@link #unregister(Iterable eventHandlers)}.
 *
 * @see <a href="https://github.com/Enfernuz/quik-lua-rpc">quik-lua-rpc</a>
 * @see <a href="http://zeromq.org/">ZeroMQ - Distributed Messaging</a>
 */
public final class ZmqTcpQluaEventProcessor implements TcpQluaEventProcessor, ZmqSecurable {

    private ZmqTcpQluaEventPoller eventPoller;
    private final List<QluaEventHandler> eventHandlers;
    private final SerdeModule serdeModule;

    /**
     * Создаёт новый экземпляр компонента {@link ZmqTcpQluaEventProcessor}, с точкой подключения RPC-сервиса на стороне
     * терминала QUIK по заданному сетевому адресу с заданным контекстом защиты передачи данных.
     *
     * @param config  конфигурация клиента точки подключения к RPC-сервису QUIK
     * @return  новый экземпляр компонента {@link ZmqTcpQluaEventProcessor}
     */
    public static ZmqTcpQluaEventProcessor newInstance(final ClientConfiguration config, final PollingMode pollingMode) {

        final SerdeModule serdeModule = SerdeUtils.getSerdeModule( config.getSerdeProtocol() );
        final ZmqTcpQluaEventPoller eventPoller;
        switch ( requireNonNull(pollingMode, "Аргумент 'pollingMode' не должен быть null.") ) {
            case BLOCKING:
                eventPoller = new BlockingZmqTcpQluaEventPoller(config.getNetworkAddress(), config.getAuthContext(), serdeModule);
                break;
            case NO_BLOCKING:
                eventPoller = new NonBlockingZmqTcpQluaEventPoller(config.getNetworkAddress(), config.getAuthContext(), serdeModule);
                break;
            default:
                throw new IllegalArgumentException(String.format("Неподдерживаемый режим чтения очереди событий: '%s'.", pollingMode));
        }


        return new ZmqTcpQluaEventProcessor(eventPoller, serdeModule);
    }

    private ZmqTcpQluaEventProcessor(final ZmqTcpQluaEventPoller eventPoller, final SerdeModule serdeModule) {

        this.eventPoller = requireNonNull(eventPoller, "Аргумент 'eventPoller' не должен быть null.");
        this.serdeModule = requireNonNull(serdeModule, "Аргумент 'serdeModule' не должен быть null.");
        this.eventHandlers = new CopyOnWriteArrayList<>();
    }

    @Override
    public AuthContext getAuthContext() {
        return eventPoller.getAuthContext();
    }

    @Override
    public void process() throws QluaEventProcessingException {

        try {
            final QluaEvent event = eventPoller.poll();
            if (event != null) {
                final byte[] eventData = event.getData();
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
                            eventHandler.onAccountPosition( serdeModule.deserialize(AccountPosition.class, eventData) );
                            break;
                        case ON_NEG_DEAL:
                            eventHandler.onNegDeal( serdeModule.deserialize(NegDeal.class, eventData) );
                            break;
                        case ON_NEG_TRADE:
                            eventHandler.onNegTrade( serdeModule.deserialize(NegTrade.class, eventData) );
                            break;
                        case ON_STOP_ORDER:
                            eventHandler.onStopOrder( serdeModule.deserialize(StopOrder.class, eventData) );
                            break;
                        case ON_TRANS_REPLY:
                            eventHandler.onTransReply( serdeModule.deserialize(TransReply.class, eventData) );
                            break;
                        case ON_PARAM:
                            eventHandler.onParam( serdeModule.deserialize(ParamEventInfo.class, eventData) );
                            break;
                        case ON_QUOTE:
                            eventHandler.onQuote( serdeModule.deserialize(QuoteEventInfo.class, eventData) );
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
