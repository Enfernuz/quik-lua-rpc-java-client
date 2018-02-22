package com.enfernuz.quik.lua.rpc.events.api;

import com.google.common.collect.ImmutableSet;
import qlua.events.QluaEvents;

public interface QluaEventSubscription {

    void subscribe(QluaEvents.EventType eventType);

    void subscribe(Iterable<? extends QluaEvents.EventType> eventTypes);

    void subscribe(QluaEvents.EventType... eventTypes);

    void subscribeToEverything();

    void unsubscribe(QluaEvents.EventType eventType);

    void unsubscribe(Iterable<? extends QluaEvents.EventType> eventTypes);

    void unsubscribe(QluaEvents.EventType... eventTypes);

    void unsubscribeFromEverything();

    ImmutableSet<QluaEvents.EventType> getCurrentSubscription();

}
