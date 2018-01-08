package com.enfernuz.quik.lua.rpc.api.events;

import com.google.common.collect.ImmutableSet;
import qlua.events.QluaEvents;

public interface QluaEventSubscription {

    void subscribe(QluaEvents.EventType eventType);

    void unsubscribe(QluaEvents.EventType eventType);

    ImmutableSet<QluaEvents.EventType> getCurrentSubscription();

}
