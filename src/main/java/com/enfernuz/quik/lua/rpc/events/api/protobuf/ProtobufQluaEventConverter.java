package com.enfernuz.quik.lua.rpc.events.api.protobuf;

import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.events.api.QluaEventTypeConverter;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import qlua.events.QluaEvents;

public enum ProtobufQluaEventConverter implements QluaEventTypeConverter {

    INSTANCE;

    private static final BiMap<String, QluaEvent.EventType> PB_EVENT_TYPE_TO_EVENT_TYPE_MAP =
            createPbEventTypeToEventTypeBiMap();

    @Override
    public QluaEvent.EventType convert(final String type) {

        if (type == null) {
            return null;
        }

        return PB_EVENT_TYPE_TO_EVENT_TYPE_MAP.get(type);
    }

    @Override
    public String convert(final QluaEvent.EventType eventType) {

        if (eventType == null) {
            return null;
        }

        return PB_EVENT_TYPE_TO_EVENT_TYPE_MAP.inverse().get(eventType);
    }

    private static BiMap<String, QluaEvent.EventType> createPbEventTypeToEventTypeBiMap() {

        final BiMap<String, QluaEvent.EventType> result = HashBiMap.create(QluaEvent.EventType.values().length);

        result.put(String.valueOf(QluaEvents.EventType.ON_CLOSE.getNumber()), QluaEvent.EventType.ON_CLOSE);
        result.put(String.valueOf(QluaEvents.EventType.ON_STOP.getNumber()), QluaEvent.EventType.ON_STOP);
        result.put(String.valueOf(QluaEvents.EventType.ON_FIRM.getNumber()), QluaEvent.EventType.ON_FIRM);
        result.put(String.valueOf(QluaEvents.EventType.ON_ALL_TRADE.getNumber()), QluaEvent.EventType.ON_ALL_TRADE);
        result.put(String.valueOf(QluaEvents.EventType.ON_TRADE.getNumber()), QluaEvent.EventType.ON_TRADE);
        result.put(String.valueOf(QluaEvents.EventType.ON_ORDER.getNumber()), QluaEvent.EventType.ON_ORDER);
        result.put(String.valueOf(QluaEvents.EventType.ON_ACCOUNT_BALANCE.getNumber()), QluaEvent.EventType.ON_ACCOUNT_BALANCE);
        result.put(String.valueOf(QluaEvents.EventType.ON_FUTURES_LIMIT_CHANGE.getNumber()), QluaEvent.EventType.ON_FUTURES_LIMIT_CHANGE);
        result.put(String.valueOf(QluaEvents.EventType.ON_FUTURES_LIMIT_DELETE.getNumber()), QluaEvent.EventType.ON_FUTURES_LIMIT_DELETE);
        result.put(String.valueOf(QluaEvents.EventType.ON_FUTURES_CLIENT_HOLDING.getNumber()), QluaEvent.EventType.ON_FUTURES_CLIENT_HOLDING);
        result.put(String.valueOf(QluaEvents.EventType.ON_MONEY_LIMIT.getNumber()), QluaEvent.EventType.ON_MONEY_LIMIT);
        result.put(String.valueOf(QluaEvents.EventType.ON_MONEY_LIMIT_DELETE.getNumber()), QluaEvent.EventType.ON_MONEY_LIMIT_DELETE);
        result.put(String.valueOf(QluaEvents.EventType.ON_DEPO_LIMIT.getNumber()), QluaEvent.EventType.ON_DEPO_LIMIT);
        result.put(String.valueOf(QluaEvents.EventType.ON_DEPO_LIMIT_DELETE.getNumber()), QluaEvent.EventType.ON_DEPO_LIMIT_DELETE);
        result.put(String.valueOf(QluaEvents.EventType.ON_ACCOUNT_POSITION.getNumber()), QluaEvent.EventType.ON_ACCOUNT_POSITION);
        result.put(String.valueOf(QluaEvents.EventType.ON_NEG_DEAL.getNumber()), QluaEvent.EventType.ON_NEG_DEAL);
        result.put(String.valueOf(QluaEvents.EventType.ON_NEG_TRADE.getNumber()), QluaEvent.EventType.ON_NEG_TRADE);
        result.put(String.valueOf(QluaEvents.EventType.ON_STOP_ORDER.getNumber()), QluaEvent.EventType.ON_STOP_ORDER);
        result.put(String.valueOf(QluaEvents.EventType.ON_TRANS_REPLY.getNumber()), QluaEvent.EventType.ON_TRANS_REPLY);
        result.put(String.valueOf(QluaEvents.EventType.ON_PARAM.getNumber()), QluaEvent.EventType.ON_PARAM);
        result.put(String.valueOf(QluaEvents.EventType.ON_QUOTE.getNumber()), QluaEvent.EventType.ON_QUOTE);
        result.put(String.valueOf(QluaEvents.EventType.ON_DISCONNECTED.getNumber()), QluaEvent.EventType.ON_DISCONNECTED);
        result.put(String.valueOf(QluaEvents.EventType.ON_CONNECTED.getNumber()), QluaEvent.EventType.ON_CONNECTED);
        result.put(String.valueOf(QluaEvents.EventType.ON_CLEAN_UP.getNumber()), QluaEvent.EventType.ON_CLEAN_UP);

        return result;
    }
}
