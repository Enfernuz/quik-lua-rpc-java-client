package com.enfernuz.quik.lua.rpc.events.api;

import com.google.common.collect.ImmutableList;
import qlua.events.QluaEvents;

public interface QluaEventHandlerRegistry {

    void register(QluaEventHandler eventHandler);

    void register(Iterable<? extends QluaEvents.EventType> eventHandlers);

    void deregister(QluaEventHandler eventHandler);

    void deregister(Iterable<? extends QluaEvents.EventType> eventHandlers);

    ImmutableList<QluaEventHandler> getRegisteredEventHandlers();
}
