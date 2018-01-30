package com.enfernuz.quik.lua.rpc.events.api;

import com.google.common.collect.ImmutableList;
import qlua.events.QluaEvents;

public interface QluaEventHandlerRegistry {

    void register(QluaEventHandler eventHandler);

    void register(Iterable<? extends QluaEventHandler> eventHandlers);

    void unregister(QluaEventHandler eventHandler);

    void unregister(Iterable<? extends QluaEventHandler> eventHandlers);

    ImmutableList<QluaEventHandler> getRegisteredEventHandlers();
}
