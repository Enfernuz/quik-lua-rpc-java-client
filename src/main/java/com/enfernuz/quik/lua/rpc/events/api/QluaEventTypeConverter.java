package com.enfernuz.quik.lua.rpc.events.api;

public interface QluaEventTypeConverter {

    QluaEvent.EventType convert(String type);

    String convert(QluaEvent.EventType eventType);
}
