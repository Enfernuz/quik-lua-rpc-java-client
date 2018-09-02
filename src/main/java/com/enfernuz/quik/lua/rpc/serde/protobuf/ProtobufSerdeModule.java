package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.*;
import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.enfernuz.quik.lua.rpc.serde.SerdeException;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public enum ProtobufSerdeModule implements SerdeModule {

    INSTANCE;

    private static final Map<Class<?>, Serde<?>> CLASS_TO_SERDE_MAP = createClassToSerdeMap();

    @Override
    public <T> byte[] serialize(final T t) {

        requireNonNull(t, "Аргумент не должен быть null.");

        // This cast is safe because we used the registerSerde method to fill the map.
        @SuppressWarnings("unchecked")
        final Serde<T> serde = (Serde<T>) CLASS_TO_SERDE_MAP.get(t.getClass());
        if (serde == null) {
            throw new SerdeException( new IllegalArgumentException("Неподдерживаемый класс для сериализации.") );
        } else {
            try {
                return serde.serialize(t);
            } catch (final Exception ex) {
                throw new SerdeException(
                        String.format("Ошибка при сериализации экземпляра класса '%s' в protobuf-представление.", t.getClass().getName()),
                        ex
                );
            }
        }
    }

    @Override
    public <T> T deserialize(final Class<T> clazz, final byte[] data) {

        // This cast is safe because we used the registerSerde method to fill the map.
        @SuppressWarnings("unchecked")
        final Serde<T> serde = (Serde<T>) CLASS_TO_SERDE_MAP.get(clazz);
        if (serde == null) {
            throw new SerdeException( new IllegalArgumentException("Неподдерживаемый класс для десериализации.") );
        } else {
            try {
                return serde.deserialize(data);
            } catch (final Exception ex) {
                throw new SerdeException(
                        String.format("Ошибка при десериализации экземпляра класса '%s' из protobuf-представления.", clazz.getName()),
                        ex
                );
            }
        }
    }

    private static <T> void registerSerde(
            @NotNull final Map<Class<?>, Serde<?>> map,
            @NotNull final Class<T> clazz,
            @NotNull final Serde<T> serde) {

        map.put(clazz, serde);
    }

    private static Map<Class<?>, Serde<?>> createClassToSerdeMap() {

        final Map<Class<?>, Serde<?>> result = new HashMap<>();

        registerSerde(result, QluaEvent.EventType.class, ProtobufQluaEventTypeSerde.INSTANCE);
        registerSerde(result, StopEventInfo.class, StopEventInfoPbSerde.INSTANCE);
        registerSerde(result, ConnectedEventInfo.class, ConnectedEventInfoPbSerde.INSTANCE);
        registerSerde(result, Trade.class, TradePbSerde.INSTANCE);
        registerSerde(result, Order.class, OrderPbSerde.INSTANCE);
        registerSerde(result, FuturesLimitDelete.class, FuturesLimitDeletePbSerde.INSTANCE);
        registerSerde(result, Firm.class, FirmPbSerde.INSTANCE);
        registerSerde(result, MoneyLimit.class, MoneyLimitPbSerde.INSTANCE);
        registerSerde(result, MoneyLimitDelete.class, MoneyLimitDeletePbSerde.INSTANCE);
        registerSerde(result, DepoLimit.class, DepoLimitPbSerde.INSTANCE);
        registerSerde(result, DepoLimitDelete.class, DepoLimitDeletePbSerde.INSTANCE);
        registerSerde(result, AccountBalance.class, AccountBalancePbSerde.INSTANCE);
        registerSerde(result, AccountPosition.class, AccountPositionPbSerde.INSTANCE);
        registerSerde(result, DateTimeEntry.class, DateTimeEntryPbSerde.INSTANCE);
        registerSerde(result, AllTrade.class, AllTradePbSerde.INSTANCE);
        registerSerde(result, FuturesClientHolding.class, FuturesClientHoldingPbSerde.INSTANCE);
        registerSerde(result, FuturesLimit.class, FuturesLimitPbSerde.INSTANCE);

        return result;
    }
}
