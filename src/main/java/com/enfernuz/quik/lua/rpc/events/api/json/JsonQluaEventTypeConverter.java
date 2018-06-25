package com.enfernuz.quik.lua.rpc.events.api.json;

import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.events.api.QluaEventTypeConverter;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public enum JsonQluaEventTypeConverter implements QluaEventTypeConverter {

    INSTANCE;

    private static final BiMap<String, QluaEvent.EventType> PB_EVENT_TYPE_TO_EVENT_TYPE_MAP =
            createPbEventTypeToEventTypeMap();

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


    private static BiMap<String, QluaEvent.EventType> createPbEventTypeToEventTypeMap() {

        final BiMap<String, QluaEvent.EventType> result = HashBiMap.create(QluaEvent.EventType.values().length);

        result.put("OnClose", QluaEvent.EventType.ON_CLOSE);
        result.put("OnStop", QluaEvent.EventType.ON_STOP);
        result.put("OnFirm", QluaEvent.EventType.ON_FIRM);
        result.put("OnAllTrade", QluaEvent.EventType.ON_ALL_TRADE);
        result.put("OnTrade", QluaEvent.EventType.ON_TRADE);
        result.put("OnOrder", QluaEvent.EventType.ON_ORDER);
        result.put("OnAccountBalance", QluaEvent.EventType.ON_ACCOUNT_BALANCE);
        result.put("OnFuturesLimitChange", QluaEvent.EventType.ON_FUTURES_LIMIT_CHANGE);
        result.put("OnFuturesLimitDelete", QluaEvent.EventType.ON_FUTURES_LIMIT_DELETE);
        result.put("OnFuturesClientHolding", QluaEvent.EventType.ON_FUTURES_CLIENT_HOLDING);
        result.put("OnMoneyLimit", QluaEvent.EventType.ON_MONEY_LIMIT);
        result.put("OnMoneyLimitDelete", QluaEvent.EventType.ON_MONEY_LIMIT_DELETE);
        result.put("OnDepoLimit", QluaEvent.EventType.ON_DEPO_LIMIT);
        result.put("OnDepoLimitDelete", QluaEvent.EventType.ON_DEPO_LIMIT_DELETE);
        result.put("OnAccountPosition", QluaEvent.EventType.ON_ACCOUNT_POSITION);
        result.put("OnNegDeal", QluaEvent.EventType.ON_NEG_DEAL);
        result.put("OnNegTrade", QluaEvent.EventType.ON_NEG_TRADE);
        result.put("OnStopOrder", QluaEvent.EventType.ON_STOP_ORDER);
        result.put("OnTransReply", QluaEvent.EventType.ON_TRANS_REPLY);
        result.put("OnParam", QluaEvent.EventType.ON_PARAM);
        result.put("OnQuote", QluaEvent.EventType.ON_QUOTE);
        result.put("OnDisconnected", QluaEvent.EventType.ON_DISCONNECTED);
        result.put("OnConnected", QluaEvent.EventType.ON_CONNECTED);
        result.put("OnCleanUp", QluaEvent.EventType.ON_CLEAN_UP);

        return result;
    }
}
