package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.serde.Serde;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Сериализатор / десериализатор типов событий API QLua терминала QUIK в рамках удалённого RPC-сервиса
 * <b>quik-lua-rpc</b>, использующего формат JSON.
 * <br/>
 * @see <a href="https://github.com/Enfernuz/quik-lua-rpc">quik-lua-rpc</a>
 * @see <a href="https://json.org">JSON</a>
 */
enum JsonQluaEventTypeSerde implements Serde<QluaEvent.EventType> {

    INSTANCE;

    private static final Map<Integer, QluaEvent.EventType> EVENT_TYPE_NAME_HASH_TO_EVENT_TYPE_MAP =
            createPbEventTypeNameHashToEventTypeMap();

    private static final EnumMap<QluaEvent.EventType, byte[]> EVENT_TYPE_TO_EVENT_TYPE_BYTES_MAP =
            createEventTypeToEventTypeBytesMap();

    /**
     * Сериализует в бинарное представление тип события API QLua терминала QUIK в рамках удалённого RPC-сервиса
     * <b>quik-lua-rpc</b>, использующего формат JSON.
     *
     * @param eventType  тип события API QLua терминала QUIK
     * @return  бинарное представление, отвечающее данному типу события;
     * null в случае отсутствия соответствия, а также в случае, когда аргумент {@code eventType} является null
     */
    @Override
    public byte[] serialize(final QluaEvent.EventType eventType) {
        return EVENT_TYPE_TO_EVENT_TYPE_BYTES_MAP.get(eventType);
    }

    /**
     * Десериализует бинарное представление типа события API QLua терминала QUIK в рамках удалённого RPC-сервиса
     * <b>quik-lua-rpc</b>, использующего формат JSON.
     *
     * @param data  бинарное представление типа события
     * @return  экземпляр {@link QluaEvent.EventType}, отвечающий данному бинарному представлению;
     * null в случае отсутствия соответствия, а также в случае когда аргумент {@code data} является null
     */
    @Override
    public QluaEvent.EventType deserialize(final byte[] data) {

        if (data == null) {
            return null;
        }

        return EVENT_TYPE_NAME_HASH_TO_EVENT_TYPE_MAP.get( Integer.valueOf(Arrays.hashCode(data)) );
    }

    private static Map<Integer, QluaEvent.EventType> createPbEventTypeNameHashToEventTypeMap() {

        final Map<Integer, QluaEvent.EventType> result = new HashMap<>(QluaEvent.EventType.values().length);

        result.put(hash("OnClose"), QluaEvent.EventType.ON_CLOSE);
        result.put(hash("OnStop"), QluaEvent.EventType.ON_STOP);
        result.put(hash("OnFirm"), QluaEvent.EventType.ON_FIRM);
        result.put(hash("OnAllTrade"), QluaEvent.EventType.ON_ALL_TRADE);
        result.put(hash("OnTrade"), QluaEvent.EventType.ON_TRADE);
        result.put(hash("OnOrder"), QluaEvent.EventType.ON_ORDER);
        result.put(hash("OnAccountBalance"), QluaEvent.EventType.ON_ACCOUNT_BALANCE);
        result.put(hash("OnFuturesLimitChange"), QluaEvent.EventType.ON_FUTURES_LIMIT_CHANGE);
        result.put(hash("OnFuturesLimitDelete"), QluaEvent.EventType.ON_FUTURES_LIMIT_DELETE);
        result.put(hash("OnFuturesClientHolding"), QluaEvent.EventType.ON_FUTURES_CLIENT_HOLDING);
        result.put(hash("OnMoneyLimit"), QluaEvent.EventType.ON_MONEY_LIMIT);
        result.put(hash("OnMoneyLimitDelete"), QluaEvent.EventType.ON_MONEY_LIMIT_DELETE);
        result.put(hash("OnDepoLimit"), QluaEvent.EventType.ON_DEPO_LIMIT);
        result.put(hash("OnDepoLimitDelete"), QluaEvent.EventType.ON_DEPO_LIMIT_DELETE);
        result.put(hash("OnAccountPosition"), QluaEvent.EventType.ON_ACCOUNT_POSITION);
        result.put(hash("OnNegDeal"), QluaEvent.EventType.ON_NEG_DEAL);
        result.put(hash("OnNegTrade"), QluaEvent.EventType.ON_NEG_TRADE);
        result.put(hash("OnStopOrder"), QluaEvent.EventType.ON_STOP_ORDER);
        result.put(hash("OnTransReply"), QluaEvent.EventType.ON_TRANS_REPLY);
        result.put(hash("OnParam"), QluaEvent.EventType.ON_PARAM);
        result.put(hash("OnQuote"), QluaEvent.EventType.ON_QUOTE);
        result.put(hash("OnDisconnected"), QluaEvent.EventType.ON_DISCONNECTED);
        result.put(hash("OnConnected"), QluaEvent.EventType.ON_CONNECTED);
        result.put(hash("OnCleanUp"), QluaEvent.EventType.ON_CLEAN_UP);
        result.put(hash("OnDataSourceUpdate"), QluaEvent.EventType.ON_DATA_SOURCE_UPDATE);

        assert QluaEvent.EventType.values().length == result.size();

        return result;
    }

    private static EnumMap<QluaEvent.EventType, byte[]> createEventTypeToEventTypeBytesMap() {

        final EnumMap<QluaEvent.EventType, byte[]> result = new EnumMap<>(QluaEvent.EventType.class);

        result.put(QluaEvent.EventType.ON_CLOSE, asBytes("OnClose"));
        result.put(QluaEvent.EventType.ON_STOP, asBytes("OnStop"));
        result.put(QluaEvent.EventType.ON_FIRM, asBytes("OnFirm"));
        result.put(QluaEvent.EventType.ON_ALL_TRADE, asBytes("OnAllTrade"));
        result.put(QluaEvent.EventType.ON_TRADE, asBytes("OnTrade"));
        result.put(QluaEvent.EventType.ON_ORDER, asBytes("OnOrder"));
        result.put(QluaEvent.EventType.ON_ACCOUNT_BALANCE, asBytes("OnAccountBalance"));
        result.put(QluaEvent.EventType.ON_FUTURES_LIMIT_CHANGE, asBytes("OnFuturesLimitChange"));
        result.put(QluaEvent.EventType.ON_FUTURES_LIMIT_DELETE, asBytes("OnFuturesLimitDelete"));
        result.put(QluaEvent.EventType.ON_FUTURES_CLIENT_HOLDING, asBytes("OnFuturesClientHolding"));
        result.put(QluaEvent.EventType.ON_MONEY_LIMIT, asBytes("OnMoneyLimit"));
        result.put(QluaEvent.EventType.ON_MONEY_LIMIT_DELETE, asBytes("OnMoneyLimitDelete"));
        result.put(QluaEvent.EventType.ON_DEPO_LIMIT, asBytes("OnDepoLimit"));
        result.put(QluaEvent.EventType.ON_DEPO_LIMIT_DELETE, asBytes("OnDepoLimitDelete"));
        result.put(QluaEvent.EventType.ON_ACCOUNT_POSITION, asBytes("OnAccountPosition"));
        result.put(QluaEvent.EventType.ON_NEG_DEAL, asBytes("OnNegDeal"));
        result.put(QluaEvent.EventType.ON_NEG_TRADE, asBytes("OnNegTrade"));
        result.put(QluaEvent.EventType.ON_STOP_ORDER, asBytes("OnStopOrder"));
        result.put(QluaEvent.EventType.ON_TRANS_REPLY, asBytes("OnTransReply"));
        result.put(QluaEvent.EventType.ON_PARAM, asBytes("OnParam"));
        result.put(QluaEvent.EventType.ON_QUOTE, asBytes("OnQuote"));
        result.put(QluaEvent.EventType.ON_DISCONNECTED, asBytes("OnDisconnected"));
        result.put(QluaEvent.EventType.ON_CONNECTED, asBytes("OnConnected"));
        result.put(QluaEvent.EventType.ON_CLEAN_UP, asBytes("OnCleanUp"));
        result.put(QluaEvent.EventType.ON_DATA_SOURCE_UPDATE, asBytes("OnDataSourceUpdate"));

        assert QluaEvent.EventType.values().length == result.size();

        return result;
    }

    private static byte[] asBytes(final String str) {
        return str.getBytes(StandardCharsets.UTF_8);
    }

    private static int hash(final String str) {
        return Arrays.hashCode( asBytes(str) );
    }
}
