package com.enfernuz.quik.lua.rpc.api.zmq;

import com.enfernuz.quik.lua.rpc.api.security.zmq.AuthContext;
import com.enfernuz.quik.lua.rpc.api.security.zmq.ZmqSecurable;
import com.enfernuz.quik.lua.rpc.api.structures.*;
import com.enfernuz.quik.lua.rpc.config.ClientConfiguration;
import com.enfernuz.quik.lua.rpc.events.api.PollingMode;
import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.events.api.QluaEventHandler;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.enfernuz.quik.lua.rpc.serde.SerdeUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

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
     * @throws NullPointerException если какой-либо из аргументов является null
     */
    @NotNull
    public static ZmqTcpQluaEventProcessor newInstance(
            @NonNull @NotNull final ClientConfiguration config,
            @NonNull @NotNull final PollingMode pollingMode) {

        final SerdeModule serdeModule = SerdeUtils.getSerdeModule( config.getSerdeProtocol() );
        final ZmqTcpQluaEventPoller eventPoller;
        switch (pollingMode) {
            case BLOCKING:
                eventPoller = new BlockingZmqTcpQluaEventPoller(config.getNetworkAddress(), config.getAuthContext(), serdeModule);
                break;
            case NO_BLOCKING:
                eventPoller = new NonBlockingZmqTcpQluaEventPoller(config.getNetworkAddress(), config.getAuthContext(), serdeModule);
                break;
            default:
                throw new IllegalArgumentException(String.format("Неподдерживаемый режим чтения очереди событий: %s.", pollingMode));
        }


        return new ZmqTcpQluaEventProcessor(eventPoller, serdeModule);
    }

    private ZmqTcpQluaEventProcessor(
            @NotNull @NonNull final ZmqTcpQluaEventPoller eventPoller,
            @NotNull @NonNull final SerdeModule serdeModule) {

        this.eventPoller = eventPoller;
        this.serdeModule = serdeModule;
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
                            eventHandler.onStop( serdeModule.deserialize(StopEventInfo.class, requireNonNull(eventData)) );
                            break;
                        case ON_CLOSE:
                            eventHandler.onClose();
                            break;
                        case ON_CONNECTED:
                            eventHandler.onConnected( serdeModule.deserialize(ConnectedEventInfo.class, requireNonNull(eventData)) );
                            break;
                        case ON_DISCONNECTED:
                            eventHandler.onDisconnected();
                            break;
                        case ON_FIRM:
                            eventHandler.onFirm( serdeModule.deserialize(Firm.class, requireNonNull(eventData)) );
                            break;
                        case ON_ALL_TRADE:
                            eventHandler.onAllTrade( serdeModule.deserialize(AllTrade.class, requireNonNull(eventData)) );
                            break;
                        case ON_TRADE:
                            eventHandler.onTrade( serdeModule.deserialize(Trade.class, requireNonNull(eventData)) );
                            break;
                        case ON_ORDER:
                            eventHandler.onOrder( serdeModule.deserialize(Order.class, requireNonNull(eventData)) );
                            break;
                        case ON_ACCOUNT_BALANCE:
                            eventHandler.onAccountBalance( serdeModule.deserialize(AccountBalance.class, requireNonNull(eventData)) );
                            break;
                        case ON_FUTURES_LIMIT_CHANGE:
                            eventHandler.onFuturesLimitChange( serdeModule.deserialize(FuturesLimit.class, requireNonNull(eventData)) );
                            break;
                        case ON_FUTURES_LIMIT_DELETE:
                            eventHandler.onFuturesLimitDelete( serdeModule.deserialize(FuturesLimitDelete.class, requireNonNull(eventData)) );
                            break;
                        case ON_FUTURES_CLIENT_HOLDING:
                            eventHandler.onFuturesClientHolding( serdeModule.deserialize(FuturesClientHolding.class, requireNonNull(eventData)) );
                            break;
                        case ON_MONEY_LIMIT:
                            eventHandler.onMoneyLimit( serdeModule.deserialize(MoneyLimit.class, requireNonNull(eventData)) );
                            break;
                        case ON_MONEY_LIMIT_DELETE:
                            eventHandler.onMoneyLimitDelete( serdeModule.deserialize(MoneyLimitDelete.class, requireNonNull(eventData)) );
                            break;
                        case ON_DEPO_LIMIT:
                            eventHandler.onDepoLimit( serdeModule.deserialize(DepoLimit.class, requireNonNull(eventData)) );
                            break;
                        case ON_DEPO_LIMIT_DELETE:
                            eventHandler.onDepoLimitDelete( serdeModule.deserialize(DepoLimitDelete.class, requireNonNull(eventData)) );
                            break;
                        case ON_ACCOUNT_POSITION:
                            eventHandler.onAccountPosition( serdeModule.deserialize(AccountPosition.class, requireNonNull(eventData)) );
                            break;
                        case ON_NEG_DEAL:
                            eventHandler.onNegDeal( serdeModule.deserialize(NegDeal.class, requireNonNull(eventData)) );
                            break;
                        case ON_NEG_TRADE:
                            eventHandler.onNegTrade( serdeModule.deserialize(NegTrade.class, requireNonNull(eventData)) );
                            break;
                        case ON_STOP_ORDER:
                            eventHandler.onStopOrder( serdeModule.deserialize(StopOrder.class, requireNonNull(eventData)) );
                            break;
                        case ON_TRANS_REPLY:
                            eventHandler.onTransReply( serdeModule.deserialize(TransReply.class, requireNonNull(eventData)) );
                            break;
                        case ON_PARAM:
                            eventHandler.onParam( serdeModule.deserialize(ParamEventInfo.class, requireNonNull(eventData)) );
                            break;
                        case ON_QUOTE:
                            eventHandler.onQuote( serdeModule.deserialize(QuoteEventInfo.class, requireNonNull(eventData)) );
                            break;
                        case ON_CLEAN_UP:
                            eventHandler.onCleanUp();
                            break;
                        case ON_DATA_SOURCE_UPDATE:
                            eventHandler.onDataSourceUpdate( serdeModule.deserialize(DataSourceUpdateInfo.class, requireNonNull(eventData)) );
                            break;
                        default:
                            throw new QluaEventProcessingException(
                                    String.format("Неподдерживаемый тип QLua-события: %s.", event.getType())
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

    /**
     * {@inheritDoc}
     * @throws NullPointerException если аргумент {@code eventHandler} является null
     */
    @Override
    public void register(@NotNull @NonNull final QluaEventHandler eventHandler) {
        eventHandlers.add(eventHandler);
    }

    /**
     * {@inheritDoc}
     * @throws NullPointerException если аргумент {@code eventHandlers} является null или какой-либо из его элементов
     * является null
     */
    @Override
    public void register(@NotNull @NonNull final Iterable<? extends QluaEventHandler> eventHandlers) {

        for (final QluaEventHandler eventHandler : eventHandlers) {
            register(eventHandler);
        }
    }

    /**
     * {@inheritDoc}
     * @throws NullPointerException если аргумент {@code eventHandler} является null
     */
    @Override
    public void unregister(@NotNull @NonNull final QluaEventHandler eventHandler) {
        eventHandlers.remove(eventHandler);
    }

    /**
     * {@inheritDoc}
     * @throws NullPointerException если аргумент {@code eventHandlers} является null или какой-либо из его элементов
     * является null
     */
    @Override
    public void unregister(@NotNull @NonNull final Iterable<? extends QluaEventHandler> eventHandlers) {

        for (final QluaEventHandler eventHandler : eventHandlers) {
            unregister(eventHandler);
        }
    }

    @Override
    public ImmutableList<QluaEventHandler> getRegisteredEventHandlers() {
        return ImmutableList.copyOf(eventHandlers);
    }

    /**
     * {@inheritDoc}
     * @throws NullPointerException если аргумент {@code eventType} является null
     */
    @Override
    public void subscribe(@NotNull @NonNull final QluaEvent.EventType eventType) {
        eventPoller.subscribe(eventType);
    }

    /**
     * {@inheritDoc}
     * @throws NullPointerException если аргумент {@code eventTypes} является null или какой-либо из его элементов
     * является null
     */
    @Override
    public void subscribe(@NotNull @NonNull final Iterable<? extends QluaEvent.EventType> eventTypes) {
        eventPoller.subscribe(eventTypes);
    }

    /**
     * {@inheritDoc}
     * @throws NullPointerException если аргумент {@code eventTypes} является null или какой-либо из его элементов
     * является null
     */
    @Override
    public void subscribe(@NotNull @NonNull final QluaEvent.EventType... eventTypes) {
        eventPoller.subscribe(eventTypes);
    }

    @Override
    public void subscribeToEverything() {
        eventPoller.subscribeToEverything();
    }

    /**
     * {@inheritDoc}
     * @throws NullPointerException если аргумент {@code eventType} является null
     */
    @Override
    public void unsubscribe(@NotNull @NonNull final QluaEvent.EventType eventType) {
        eventPoller.unsubscribe(eventType);
    }

    /**
     * {@inheritDoc}
     * @throws NullPointerException если аргумент {@code eventTypes} является null или какой-либо из его элементов
     * является null
     */
    @Override
    public void unsubscribe(@NotNull @NonNull final Iterable<? extends QluaEvent.EventType> eventTypes) {
        eventPoller.unsubscribe(eventTypes);
    }

    /**
     * {@inheritDoc}
     * @throws NullPointerException если аргумент {@code eventTypes} является null или какой-либо из его элементов
     * является null
     */
    @Override
    public void unsubscribe(@NotNull @NonNull final QluaEvent.EventType... eventTypes) {
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
