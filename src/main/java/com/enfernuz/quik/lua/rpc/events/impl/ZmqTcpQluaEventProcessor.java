package com.enfernuz.quik.lua.rpc.events.impl;

import com.enfernuz.quik.lua.rpc.events.api.QluaEventHandler;
import com.enfernuz.quik.lua.rpc.events.api.TcpQluaEventProcessor;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import qlua.events.QluaEvents;

import java.io.IOException;

public final class ZmqTcpQluaEventProcessor implements TcpQluaEventProcessor {

    @Override
    public void process() {

    }

    @Override
    public void process(final int maxEvents) {

    }

    @Override
    public void register(final QluaEventHandler eventHandler) {

    }

    @Override
    public void register(final Iterable<? extends QluaEvents.EventType> eventHandlers) {

    }

    @Override
    public void deregister(final QluaEventHandler eventHandler) {

    }

    @Override
    public void deregister(final Iterable<? extends QluaEvents.EventType> eventHandlers) {

    }

    @Override
    public ImmutableList<QluaEventHandler> getRegisteredEventHandlers() {
        return null;
    }

    @Override
    public void subscribe(final QluaEvents.EventType eventType) {

    }

    @Override
    public void subscribe(final Iterable<? extends QluaEvents.EventType> eventTypes) {

    }

    @Override
    public void unsubscribe(final QluaEvents.EventType eventType) {

    }

    @Override
    public void unsubscribe(final Iterable<? extends QluaEvents.EventType> eventTypes) {

    }

    @Override
    public ImmutableSet<QluaEvents.EventType> getCurrentSubscription() {
        return null;
    }

    @Override
    public String getHost() {
        return null;
    }

    @Override
    public int getPort() {
        return 0;
    }

    @Override
    public void open() throws IOException {

    }

    @Override
    public boolean isOpened() {
        return false;
    }

    @Override
    public void close() throws Exception {

    }
}
