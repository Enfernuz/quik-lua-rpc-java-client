package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import qlua.events.QluaEvents;

/**
 * Сериализатор в формат Protocol Buffers / десериализатор из формата Protocol Buffers событий API QLua терминала QUIK
 * в рамках удалённого RPC-сервиса <b>quik-lua-rpc</b>.
 * <br/>
 * @see <a href="https://github.com/Enfernuz/quik-lua-rpc">quik-lua-rpc</a>
 * @see <a href="https://developers.google.com/protocol-buffers">Protocol Buffers</a>
 */
enum ProtobufQluaEventTypeSerde implements Serde<QluaEvent.EventType> {

    INSTANCE;

    private static final BiMap<byte[], QluaEvent.EventType> PB_EVENT_TYPE_TO_EVENT_TYPE_MAP =
            createPbEventTypeToEventTypeBiMap();

    /**
     * Сериализует тип события API QLua терминала QUIK в рамках удалённого RPC-сервиса
     * <b>quik-lua-rpc</b> в бинарное представление в формате Protocol Buffers.
     *
     * @param eventType  тип события API QLua терминала QUIK
     * @return  бинарное представление в формате Protocol Buffers, отвечающее данному типу события;
     * null в случае отсутствия соответствия, а также в случае, когда аргумент {@code eventType} является null
     */
    @Override
    public byte[] serialize(final QluaEvent.EventType eventType) {

        if (eventType == null) {
            return null;
        }

        return PB_EVENT_TYPE_TO_EVENT_TYPE_MAP.inverse().get(eventType);
    }

    /**
     * Десериализует бинарное представление в формате Protocol Buffers типа события API QLua терминала QUIK в рамках
     * удалённого RPC-сервиса <b>quik-lua-rpc</b>.
     *
     * @param data  бинарное представление типа события в формате Protocol Buffers
     * @return  экземпляр {@link QluaEvent.EventType}, отвечающий данному бинарному представлению;
     * null в случае отсутствия соответствия, а также в случае когда аргумент {@code data} является null
     */
    @Override
    public QluaEvent.EventType deserialize(final byte[] data) {

        if (data == null) {
            return null;
        }

        return PB_EVENT_TYPE_TO_EVENT_TYPE_MAP.get(data);
    }

    private static BiMap<byte[], QluaEvent.EventType> createPbEventTypeToEventTypeBiMap() {

        final BiMap<byte[], QluaEvent.EventType> result = HashBiMap.create(QluaEvent.EventType.values().length);

        result.put(asByteArray(QluaEvents.EventType.ON_CLOSE.getNumber()), QluaEvent.EventType.ON_CLOSE);
        result.put(asByteArray(QluaEvents.EventType.ON_STOP.getNumber()), QluaEvent.EventType.ON_STOP);
        result.put(asByteArray(QluaEvents.EventType.ON_FIRM.getNumber()), QluaEvent.EventType.ON_FIRM);
        result.put(asByteArray(QluaEvents.EventType.ON_ALL_TRADE.getNumber()), QluaEvent.EventType.ON_ALL_TRADE);
        result.put(asByteArray(QluaEvents.EventType.ON_TRADE.getNumber()), QluaEvent.EventType.ON_TRADE);
        result.put(asByteArray(QluaEvents.EventType.ON_ORDER.getNumber()), QluaEvent.EventType.ON_ORDER);
        result.put(asByteArray(QluaEvents.EventType.ON_ACCOUNT_BALANCE.getNumber()), QluaEvent.EventType.ON_ACCOUNT_BALANCE);
        result.put(asByteArray(QluaEvents.EventType.ON_FUTURES_LIMIT_CHANGE.getNumber()), QluaEvent.EventType.ON_FUTURES_LIMIT_CHANGE);
        result.put(asByteArray(QluaEvents.EventType.ON_FUTURES_LIMIT_DELETE.getNumber()), QluaEvent.EventType.ON_FUTURES_LIMIT_DELETE);
        result.put(asByteArray(QluaEvents.EventType.ON_FUTURES_CLIENT_HOLDING.getNumber()), QluaEvent.EventType.ON_FUTURES_CLIENT_HOLDING);
        result.put(asByteArray(QluaEvents.EventType.ON_MONEY_LIMIT.getNumber()), QluaEvent.EventType.ON_MONEY_LIMIT);
        result.put(asByteArray(QluaEvents.EventType.ON_MONEY_LIMIT_DELETE.getNumber()), QluaEvent.EventType.ON_MONEY_LIMIT_DELETE);
        result.put(asByteArray(QluaEvents.EventType.ON_DEPO_LIMIT.getNumber()), QluaEvent.EventType.ON_DEPO_LIMIT);
        result.put(asByteArray(QluaEvents.EventType.ON_DEPO_LIMIT_DELETE.getNumber()), QluaEvent.EventType.ON_DEPO_LIMIT_DELETE);
        result.put(asByteArray(QluaEvents.EventType.ON_ACCOUNT_POSITION.getNumber()), QluaEvent.EventType.ON_ACCOUNT_POSITION);
        result.put(asByteArray(QluaEvents.EventType.ON_NEG_DEAL.getNumber()), QluaEvent.EventType.ON_NEG_DEAL);
        result.put(asByteArray(QluaEvents.EventType.ON_NEG_TRADE.getNumber()), QluaEvent.EventType.ON_NEG_TRADE);
        result.put(asByteArray(QluaEvents.EventType.ON_STOP_ORDER.getNumber()), QluaEvent.EventType.ON_STOP_ORDER);
        result.put(asByteArray(QluaEvents.EventType.ON_TRANS_REPLY.getNumber()), QluaEvent.EventType.ON_TRANS_REPLY);
        result.put(asByteArray(QluaEvents.EventType.ON_PARAM.getNumber()), QluaEvent.EventType.ON_PARAM);
        result.put(asByteArray(QluaEvents.EventType.ON_QUOTE.getNumber()), QluaEvent.EventType.ON_QUOTE);
        result.put(asByteArray(QluaEvents.EventType.ON_DISCONNECTED.getNumber()), QluaEvent.EventType.ON_DISCONNECTED);
        result.put(asByteArray(QluaEvents.EventType.ON_CONNECTED.getNumber()), QluaEvent.EventType.ON_CONNECTED);
        result.put(asByteArray(QluaEvents.EventType.ON_CLEAN_UP.getNumber()), QluaEvent.EventType.ON_CLEAN_UP);

        return result;
    }

    private static byte[] asByteArray(final int number) {
        return String.valueOf(number).getBytes(ProtobufSerdeUtils.DEFAULT_PROTOBUF_CHARSET);
    }
}
