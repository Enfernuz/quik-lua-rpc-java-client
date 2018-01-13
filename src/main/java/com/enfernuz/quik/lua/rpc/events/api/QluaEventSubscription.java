package com.enfernuz.quik.lua.rpc.events.api;

import com.google.common.collect.ImmutableSet;
import qlua.events.QluaEvents;

public interface QluaEventSubscription {

    void subscribe(QluaEvents.EventType eventType);

    void subscribe(ImmutableSet<QluaEvents.EventType> eventTypes);

    void unsubscribe(QluaEvents.EventType eventType);

    void unsubscribe(ImmutableSet<QluaEvents.EventType> eventTypes);

    ImmutableSet<QluaEvents.EventType> getCurrentSubscription();

}
