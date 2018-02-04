package com.enfernuz.quik.lua.rpc.events.impl;

import com.enfernuz.quik.lua.rpc.events.api.QluaEventHandler;
import com.enfernuz.quik.lua.rpc.events.api.TcpQluaEventProcessor;
import com.enfernuz.quik.lua.rpc.io.transport.NetworkAddress;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import qlua.events.QluaEvents;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

public final class ZmqTcpQluaEventProcessor implements TcpQluaEventProcessor {

    private ZmqTcpQluaEventPoller eventPoller;
    private final List<QluaEventHandler> eventHandlers;

    private ZmqTcpQluaEventProcessor() {
        this.eventHandlers = new ArrayList<>();
    }

    @Override
    public void process() {

    }

    @Override
    public void process(final int maxEvents) {

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
    public void unsubscribe(final QluaEvents.EventType eventType) {
        eventPoller.unsubscribe(eventType);
    }

    @Override
    public void unsubscribe(final Iterable<? extends QluaEvents.EventType> eventTypes) {
        eventPoller.unsubscribe(eventTypes);
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
    public void close() throws Exception {
        eventPoller.close();
    }
}
