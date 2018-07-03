package com.enfernuz.quik.lua.rpc.serde.simple;

import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.nio.charset.StandardCharsets;

/**
 * Сериализатор / десериализатор типов событий API QLua терминала QUIK в рамках удалённого
 * RPC-сервиса <b>quik-lua-rpc</b>, использующего представление данных в виде символьных строк в кодировке UTF-8.
 * <br/>
 * @see <a href="https://github.com/Enfernuz/quik-lua-rpc">quik-lua-rpc</a>
 * @see <a href="https://ru.wikipedia.org/wiki/UTF-8">UTF-8</a>
 */
public enum Utf8ReadableStringQluaEventTypeSerde implements Serde<QluaEvent.EventType> {

    INSTANCE;

    private static final BiMap<byte[], QluaEvent.EventType> READABLE_STRING_BYTES_TO_EVENT_TYPE_MAP =
            createReadableStringBytesToEventTypeMap();

    /**
     * Десериализует бинарное представление типа события API QLua терминала QUIK в рамках удалённого RPC-сервиса
     * <b>quik-lua-rpc</b>, использующего представление данных в виде символьных строк в кодировке UTF-8.
     *
     * @param data  бинарное представление типа события
     * @return  тип события, отвечающий данному бинарному представлению;
     * null в случае отсутствия соответствия, а также в случае когда аргумент {@code data} является null
     */
    @Override
    public QluaEvent.EventType deserialize(final byte[] data) {

        if (data == null) {
            return null;
        }

        return READABLE_STRING_BYTES_TO_EVENT_TYPE_MAP.get(data);
    }

    /**
     * Сериализует в бинарное представление тип события API QLua терминала QUIK в рамках удалённого RPC-сервиса
     * <b>quik-lua-rpc</b>, использующего представление данных в виде символьных строк в кодировке UTF-8.
     *
     * @param eventType  тип события API QLua терминала QUIK
     * @return  бинарное представление, отвечающей данному типу события;
     * null в случае отсутствия соответствия, а также в случае, когда аргумент {@code eventType} является null
     */
    @Override
    public byte[] serialize(final QluaEvent.EventType eventType) {

        if (eventType == null) {
            return null;
        }

        return READABLE_STRING_BYTES_TO_EVENT_TYPE_MAP.inverse().get(eventType);
    }

    private static BiMap<byte[], QluaEvent.EventType> createReadableStringBytesToEventTypeMap() {

        final BiMap<byte[], QluaEvent.EventType> result = HashBiMap.create(QluaEvent.EventType.values().length);

        result.put(asByteArray("OnClose"), QluaEvent.EventType.ON_CLOSE);
        result.put(asByteArray("OnStop"), QluaEvent.EventType.ON_STOP);
        result.put(asByteArray("OnFirm"), QluaEvent.EventType.ON_FIRM);
        result.put(asByteArray("OnAllTrade"), QluaEvent.EventType.ON_ALL_TRADE);
        result.put(asByteArray("OnTrade"), QluaEvent.EventType.ON_TRADE);
        result.put(asByteArray("OnOrder"), QluaEvent.EventType.ON_ORDER);
        result.put(asByteArray("OnAccountBalance"), QluaEvent.EventType.ON_ACCOUNT_BALANCE);
        result.put(asByteArray("OnFuturesLimitChange"), QluaEvent.EventType.ON_FUTURES_LIMIT_CHANGE);
        result.put(asByteArray("OnFuturesLimitDelete"), QluaEvent.EventType.ON_FUTURES_LIMIT_DELETE);
        result.put(asByteArray("OnFuturesClientHolding"), QluaEvent.EventType.ON_FUTURES_CLIENT_HOLDING);
        result.put(asByteArray("OnMoneyLimit"), QluaEvent.EventType.ON_MONEY_LIMIT);
        result.put(asByteArray("OnMoneyLimitDelete"), QluaEvent.EventType.ON_MONEY_LIMIT_DELETE);
        result.put(asByteArray("OnDepoLimit"), QluaEvent.EventType.ON_DEPO_LIMIT);
        result.put(asByteArray("OnDepoLimitDelete"), QluaEvent.EventType.ON_DEPO_LIMIT_DELETE);
        result.put(asByteArray("OnAccountPosition"), QluaEvent.EventType.ON_ACCOUNT_POSITION);
        result.put(asByteArray("OnNegDeal"), QluaEvent.EventType.ON_NEG_DEAL);
        result.put(asByteArray("OnNegTrade"), QluaEvent.EventType.ON_NEG_TRADE);
        result.put(asByteArray("OnStopOrder"), QluaEvent.EventType.ON_STOP_ORDER);
        result.put(asByteArray("OnTransReply"), QluaEvent.EventType.ON_TRANS_REPLY);
        result.put(asByteArray("OnParam"), QluaEvent.EventType.ON_PARAM);
        result.put(asByteArray("OnQuote"), QluaEvent.EventType.ON_QUOTE);
        result.put(asByteArray("OnDisconnected"), QluaEvent.EventType.ON_DISCONNECTED);
        result.put(asByteArray("OnConnected"), QluaEvent.EventType.ON_CONNECTED);
        result.put(asByteArray("OnCleanUp"), QluaEvent.EventType.ON_CLEAN_UP);

        return result;
    }

    private static byte[] asByteArray(final String str) {
        return str.getBytes(StandardCharsets.UTF_8);
    }
}
