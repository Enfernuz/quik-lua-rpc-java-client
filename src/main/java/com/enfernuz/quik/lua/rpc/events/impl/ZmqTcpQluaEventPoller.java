package com.enfernuz.quik.lua.rpc.events.impl;

import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.events.api.TcpQluaEventPoller;
import com.google.common.collect.ImmutableSet;
import qlua.events.QluaEvents;

import java.io.IOException;

final class ZmqTcpQluaEventPoller implements TcpQluaEventPoller {

    @Override
    public QluaEvent poll() throws PollingException {
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
