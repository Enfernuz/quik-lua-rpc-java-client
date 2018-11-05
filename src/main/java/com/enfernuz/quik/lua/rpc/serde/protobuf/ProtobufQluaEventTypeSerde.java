package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import qlua.events.QluaEvents;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Сериализатор / десериализатор типов событий API QLua терминала QUIK в рамках удалённого RPC-сервиса
 * <b>quik-lua-rpc</b>, использующего формат Protocol Buffers.
 * <br/>
 * @see <a href="https://github.com/Enfernuz/quik-lua-rpc">quik-lua-rpc</a>
 * @see <a href="https://developers.google.com/protocol-buffers">Protocol Buffers</a>
 */
enum ProtobufQluaEventTypeSerde implements Serde<QluaEvent.EventType> {

    INSTANCE;

    private static final Map<Integer, QluaEvent.EventType> PB_EVENT_TYPE_HASH_TO_EVENT_TYPE_MAP =
            createPbEventTypeHashToEventTypeMap();

    private static final EnumMap<QluaEvent.EventType, byte[]> EVENT_TYPE_TO_PB_EVENT_TYPE_BYTES_MAP =
            createEventTypeToPbEventTypeBytesMap();

    /**
     * Сериализует в бинарное представление тип события API QLua терминала QUIK в рамках удалённого RPC-сервиса
     * <b>quik-lua-rpc</b>, использующего формат Protocol Buffers.
     *
     * @param eventType  тип события API QLua терминала QUIK
     * @return  бинарное представление, отвечающее данному типу события;
     * null в случае отсутствия соответствия, а также в случае, когда аргумент {@code eventType} является null
     */
    @Override
    public byte[] serialize(final QluaEvent.EventType eventType) {
        return EVENT_TYPE_TO_PB_EVENT_TYPE_BYTES_MAP.get(eventType);
    }

    /**
     * Десериализует бинарное представление типа события API QLua терминала QUIK в рамках удалённого RPC-сервиса
     * <b>quik-lua-rpc</b>, использующего формат Protocol Buffers.
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

        return PB_EVENT_TYPE_HASH_TO_EVENT_TYPE_MAP.get( Integer.valueOf(Arrays.hashCode(data)) );
    }

    private static Map<Integer, QluaEvent.EventType> createPbEventTypeHashToEventTypeMap() {

        final Map<Integer, QluaEvent.EventType> result = new HashMap<>(QluaEvent.EventType.values().length);

        result.put(hash(QluaEvents.EventType.ON_CLOSE.getNumber()), QluaEvent.EventType.ON_CLOSE);
        result.put(hash(QluaEvents.EventType.ON_STOP.getNumber()), QluaEvent.EventType.ON_STOP);
        result.put(hash(QluaEvents.EventType.ON_FIRM.getNumber()), QluaEvent.EventType.ON_FIRM);
        result.put(hash(QluaEvents.EventType.ON_ALL_TRADE.getNumber()), QluaEvent.EventType.ON_ALL_TRADE);
        result.put(hash(QluaEvents.EventType.ON_TRADE.getNumber()), QluaEvent.EventType.ON_TRADE);
        result.put(hash(QluaEvents.EventType.ON_ORDER.getNumber()), QluaEvent.EventType.ON_ORDER);
        result.put(hash(QluaEvents.EventType.ON_ACCOUNT_BALANCE.getNumber()), QluaEvent.EventType.ON_ACCOUNT_BALANCE);
        result.put(hash(QluaEvents.EventType.ON_FUTURES_LIMIT_CHANGE.getNumber()), QluaEvent.EventType.ON_FUTURES_LIMIT_CHANGE);
        result.put(hash(QluaEvents.EventType.ON_FUTURES_LIMIT_DELETE.getNumber()), QluaEvent.EventType.ON_FUTURES_LIMIT_DELETE);
        result.put(hash(QluaEvents.EventType.ON_FUTURES_CLIENT_HOLDING.getNumber()), QluaEvent.EventType.ON_FUTURES_CLIENT_HOLDING);
        result.put(hash(QluaEvents.EventType.ON_MONEY_LIMIT.getNumber()), QluaEvent.EventType.ON_MONEY_LIMIT);
        result.put(hash(QluaEvents.EventType.ON_MONEY_LIMIT_DELETE.getNumber()), QluaEvent.EventType.ON_MONEY_LIMIT_DELETE);
        result.put(hash(QluaEvents.EventType.ON_DEPO_LIMIT.getNumber()), QluaEvent.EventType.ON_DEPO_LIMIT);
        result.put(hash(QluaEvents.EventType.ON_DEPO_LIMIT_DELETE.getNumber()), QluaEvent.EventType.ON_DEPO_LIMIT_DELETE);
        result.put(hash(QluaEvents.EventType.ON_ACCOUNT_POSITION.getNumber()), QluaEvent.EventType.ON_ACCOUNT_POSITION);
        result.put(hash(QluaEvents.EventType.ON_NEG_DEAL.getNumber()), QluaEvent.EventType.ON_NEG_DEAL);
        result.put(hash(QluaEvents.EventType.ON_NEG_TRADE.getNumber()), QluaEvent.EventType.ON_NEG_TRADE);
        result.put(hash(QluaEvents.EventType.ON_STOP_ORDER.getNumber()), QluaEvent.EventType.ON_STOP_ORDER);
        result.put(hash(QluaEvents.EventType.ON_TRANS_REPLY.getNumber()), QluaEvent.EventType.ON_TRANS_REPLY);
        result.put(hash(QluaEvents.EventType.ON_PARAM.getNumber()), QluaEvent.EventType.ON_PARAM);
        result.put(hash(QluaEvents.EventType.ON_QUOTE.getNumber()), QluaEvent.EventType.ON_QUOTE);
        result.put(hash(QluaEvents.EventType.ON_DISCONNECTED.getNumber()), QluaEvent.EventType.ON_DISCONNECTED);
        result.put(hash(QluaEvents.EventType.ON_CONNECTED.getNumber()), QluaEvent.EventType.ON_CONNECTED);
        result.put(hash(QluaEvents.EventType.ON_CLEAN_UP.getNumber()), QluaEvent.EventType.ON_CLEAN_UP);
        result.put(hash(QluaEvents.EventType.ON_DATA_SOURCE_UPDATE.getNumber()), QluaEvent.EventType.ON_DATA_SOURCE_UPDATE);

        assert (result.size() == QluaEvent.EventType.values().length);

        return result;
    }

    private static EnumMap<QluaEvent.EventType, byte[]> createEventTypeToPbEventTypeBytesMap() {

        final EnumMap<QluaEvent.EventType, byte[]> result = new EnumMap<>(QluaEvent.EventType.class);

        result.put(QluaEvent.EventType.ON_CLOSE, asStringBytes(QluaEvents.EventType.ON_CLOSE.getNumber()));
        result.put(QluaEvent.EventType.ON_STOP, asStringBytes(QluaEvents.EventType.ON_STOP.getNumber()));
        result.put(QluaEvent.EventType.ON_FIRM, asStringBytes(QluaEvents.EventType.ON_FIRM.getNumber()));
        result.put(QluaEvent.EventType.ON_ALL_TRADE, asStringBytes(QluaEvents.EventType.ON_ALL_TRADE.getNumber()));
        result.put(QluaEvent.EventType.ON_TRADE, asStringBytes(QluaEvents.EventType.ON_TRADE.getNumber()));
        result.put(QluaEvent.EventType.ON_ORDER, asStringBytes(QluaEvents.EventType.ON_ORDER.getNumber()));
        result.put(QluaEvent.EventType.ON_ACCOUNT_BALANCE, asStringBytes(QluaEvents.EventType.ON_ACCOUNT_BALANCE.getNumber()));
        result.put(QluaEvent.EventType.ON_FUTURES_LIMIT_CHANGE, asStringBytes(QluaEvents.EventType.ON_FUTURES_LIMIT_CHANGE.getNumber()));
        result.put(QluaEvent.EventType.ON_FUTURES_LIMIT_DELETE, asStringBytes(QluaEvents.EventType.ON_FUTURES_LIMIT_DELETE.getNumber()));
        result.put(QluaEvent.EventType.ON_FUTURES_CLIENT_HOLDING, asStringBytes(QluaEvents.EventType.ON_FUTURES_CLIENT_HOLDING.getNumber()));
        result.put(QluaEvent.EventType.ON_MONEY_LIMIT, asStringBytes(QluaEvents.EventType.ON_MONEY_LIMIT.getNumber()));
        result.put(QluaEvent.EventType.ON_MONEY_LIMIT_DELETE, asStringBytes(QluaEvents.EventType.ON_MONEY_LIMIT_DELETE.getNumber()));
        result.put(QluaEvent.EventType.ON_DEPO_LIMIT, asStringBytes(QluaEvents.EventType.ON_DEPO_LIMIT.getNumber()));
        result.put(QluaEvent.EventType.ON_DEPO_LIMIT_DELETE, asStringBytes(QluaEvents.EventType.ON_DEPO_LIMIT_DELETE.getNumber()));
        result.put(QluaEvent.EventType.ON_ACCOUNT_POSITION, asStringBytes(QluaEvents.EventType.ON_ACCOUNT_POSITION.getNumber()));
        result.put(QluaEvent.EventType.ON_NEG_DEAL, asStringBytes(QluaEvents.EventType.ON_NEG_DEAL.getNumber()));
        result.put(QluaEvent.EventType.ON_NEG_TRADE, asStringBytes(QluaEvents.EventType.ON_NEG_TRADE.getNumber()));
        result.put(QluaEvent.EventType.ON_STOP_ORDER, asStringBytes(QluaEvents.EventType.ON_STOP_ORDER.getNumber()));
        result.put(QluaEvent.EventType.ON_TRANS_REPLY, asStringBytes(QluaEvents.EventType.ON_TRANS_REPLY.getNumber()));
        result.put(QluaEvent.EventType.ON_PARAM, asStringBytes(QluaEvents.EventType.ON_PARAM.getNumber()));
        result.put(QluaEvent.EventType.ON_QUOTE, asStringBytes(QluaEvents.EventType.ON_QUOTE.getNumber()));
        result.put(QluaEvent.EventType.ON_DISCONNECTED, asStringBytes(QluaEvents.EventType.ON_DISCONNECTED.getNumber()));
        result.put(QluaEvent.EventType.ON_CONNECTED, asStringBytes(QluaEvents.EventType.ON_CONNECTED.getNumber()));
        result.put(QluaEvent.EventType.ON_CLEAN_UP, asStringBytes(QluaEvents.EventType.ON_CLEAN_UP.getNumber()));
        result.put(QluaEvent.EventType.ON_DATA_SOURCE_UPDATE, asStringBytes(QluaEvents.EventType.ON_DATA_SOURCE_UPDATE.getNumber()));

        assert (result.size() == QluaEvent.EventType.values().length);

        return result;
    }

    private static byte[] asStringBytes(final int number) {
        return Integer.toString(number).getBytes(ProtobufSerdeUtils.DEFAULT_PROTOBUF_CHARSET);
    }

    private static int hash(final int number) {
        return Arrays.hashCode( asStringBytes(number) );
    }
}
