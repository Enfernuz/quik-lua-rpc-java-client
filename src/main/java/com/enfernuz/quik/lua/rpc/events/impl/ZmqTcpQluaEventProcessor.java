package com.enfernuz.quik.lua.rpc.events.impl;

import com.enfernuz.quik.lua.rpc.api.security.zmq.AuthContext;
import com.enfernuz.quik.lua.rpc.events.api.*;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.google.common.collect.*;
import qlua.events.QluaEvents;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static qlua.structs.QluaStructures.*;

public class ZmqTcpQluaEventProcessor implements TcpQluaEventProcessor {

    private ZmqTcpQluaEventPoller eventPoller;
    private final List<QluaEventHandler> eventHandlers;

    public static ZmqTcpQluaEventProcessor newInstance(
            final NetworkAddress networkAddress,
            final AuthContext authContext) {

        return new ZmqTcpQluaEventProcessor( ZmqTcpQluaEventPoller.newInstance(networkAddress, authContext) );
    }

    private ZmqTcpQluaEventProcessor(final ZmqTcpQluaEventPoller eventPoller) {

        this.eventPoller = eventPoller;
        this.eventHandlers = new ArrayList<>(1);
    }

    @Override
    public void process() throws QluaEventProcessingException {

        try {
            final QluaEvent event = eventPoller.poll();
            if (event != null) {
                for (final QluaEventHandler eventHandler : eventHandlers) {
                    switch (event.getType()) {
                        case PUBLISHER_ONLINE:
                            eventHandler.onInit();
                            break;
                        case PUBLISHER_OFFLINE:
                            eventHandler.onStop();
                            break;
                        case ON_CLOSE:
                            eventHandler.onClose();
                            break;
                        case ON_CONNECTED:
                            eventHandler.onConnected();
                            break;
                        case ON_DISCONNECTED:
                            eventHandler.onDisconnected();
                            break;
                        case ON_FIRM:
                            eventHandler.onFirm( Firm.parseFrom(event.getData()) );
                            break;
                        case ON_ALL_TRADE:
                            eventHandler.onAllTrade( AllTrade.parseFrom(event.getData()) );
                            break;
                        case ON_TRADE:
                            eventHandler.onTrade( Trade.parseFrom(event.getData()) );
                            break;
                        case ON_ORDER:
                            eventHandler.onOrder( Order.parseFrom(event.getData()) );
                            break;
                        case ON_ACCOUNT_BALANCE:
                            eventHandler.onAccountBalance( AccountBalance.parseFrom(event.getData()) );
                            break;
                        case ON_FUTURES_LIMIT_CHANGE:
                            eventHandler.onFuturesLimitChange( FuturesLimit.parseFrom(event.getData()) );
                            break;
                        case ON_FUTURES_LIMIT_DELETE:
                            eventHandler.onFuturesLimitDelete( FuturesLimitDelete.parseFrom(event.getData()) );
                            break;
                        case ON_FUTURES_CLIENT_HOLDING:
                            eventHandler.onFuturesClientHolding( FuturesClientHolding.parseFrom(event.getData()) );
                            break;
                        case ON_MONEY_LIMIT:
                            eventHandler.onMoneyLimit( MoneyLimit.parseFrom(event.getData()) );
                            break;
                        case ON_MONEY_LIMIT_DELETE:
                            eventHandler.onMoneyLimitDelete( MoneyLimitDelete.parseFrom(event.getData()) );
                            break;
                        case ON_DEPO_LIMIT:
                            eventHandler.onDepoLimit( DepoLimit.parseFrom(event.getData()) );
                            break;
                        case ON_DEPO_LIMIT_DELETE:
                            eventHandler.onDepoLimitDelete( DepoLimitDelete.parseFrom(event.getData()) );
                            break;
                        case ON_ACCOUNT_POSITION:
                            eventHandler.onAccountPosition( AccountPosition.parseFrom(event.getData()) );
                            break;
                        case ON_NEG_DEAL:
                            eventHandler.onNegDeal( NegDeal.parseFrom(event.getData()) );
                            break;
                        case ON_NEG_TRADE:
                            eventHandler.onNegTrade( NegTrade.parseFrom(event.getData()) );
                            break;
                        case ON_STOP_ORDER:
                            eventHandler.onStopOrder( StopOrder.parseFrom(event.getData()) );
                            break;
                        case ON_TRANS_REPLY:
                            eventHandler.onTransReply( Transaction.parseFrom(event.getData()) );
                            break;
                        case ON_PARAM:
                            eventHandler.onParam( ParamEventInfo.parseFrom(event.getData()) );
                            break;
                        case ON_QUOTE:
                            eventHandler.onQuote( QuoteEventInfo.parseFrom(event.getData()) );
                            break;
                        case ON_CLEAN_UP:
                            eventHandler.onCleanUp();
                            break;
                        default:
                            throw new QluaEventProcessingException(
                                    String.format("Unexpected event type \"%s\".", event.getType())
                            );
                    }
                }
            }
        } catch (final QluaEventProcessingException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new QluaEventProcessingException("An error has occurred while processing a QLua event.", ex);
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
    public void subscribe(final QluaEvents.EventType eventType) {
        eventPoller.subscribe(eventType);
    }

    @Override
    public void subscribe(final Iterable<? extends QluaEvents.EventType> eventTypes) {
        eventPoller.subscribe(eventTypes);
    }

    @Override
    public void subscribe(final QluaEvents.EventType... eventTypes) {
        eventPoller.subscribe(eventTypes);
    }

    @Override
    public void subscribeToEverything() {
        eventPoller.subscribeToEverything();
    }

    @Override
    public void unsubscribe(final QluaEvents.EventType eventType) {
        eventPoller.unsubscribe(eventType);
    }

    @Override
    public void unsubscribe(final Iterable<? extends QluaEvents.EventType> eventTypes) {
        eventPoller.unsubscribe(eventTypes);
    }

    @Override
    public void unsubscribe(final QluaEvents.EventType... eventTypes) {
        eventPoller.unsubscribe(eventTypes);
    }

    @Override
    public void unsubscribeFromEverything() {
        eventPoller.unsubscribeFromEverything();
    }

    @Override
    public ImmutableSet<QluaEvents.EventType> getCurrentSubscription() {
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
