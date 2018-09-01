package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.*;
import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.enfernuz.quik.lua.rpc.serde.SerdeException;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public enum ProtobufSerdeModule implements SerdeModule {

    INSTANCE;

    private static final Map<Class<?>, Deserializer<?>> CLASS_TO_DESERIALIZER_MAP = createClassToDeserializerMap();

    @Override
    public <T> byte[] serialize(final T t) {

        requireNonNull(t, "Аргумент не должен быть null.");

        if (t instanceof QluaEvent.EventType) {
            return ProtobufQluaEventTypeSerde.INSTANCE.serialize((QluaEvent.EventType) t);
        } else {
            throw new SerdeException( new IllegalArgumentException("Неподдерживаемый класс аргумента.") );
        }
    }

    @Override
    public <T> T deserialize(final Class<T> clazz, final byte[] data) {

        // This cast is safe because we used the addDeserializer method to fill the map.
        @SuppressWarnings("unchecked")
        final Deserializer<T> deserializer = (Deserializer<T>) CLASS_TO_DESERIALIZER_MAP.get(clazz);

        if (deserializer == null) {
            throw new SerdeException( new IllegalArgumentException("Неподдерживаемый класс для десериализации.") );
        } else {
            try {
                if (QluaEvent.EventType.class == clazz) {

                    // This cast is safe because the ProtobufQluaEventTypeSerde returns an instance of QluaEvent.EventType
                    // and we obliged to return an instance of Class<QluaEvent.EventType>.
                    @SuppressWarnings("unchecked")
                    final T result = (T) ProtobufQluaEventTypeSerde.INSTANCE.deserialize(data);
                    return result;
                } else {
                    return deserializer.deserialize(data);
                }
            } catch (final Exception ex) {
                throw new SerdeException(
                        String.format("Ошибка при десериализации экземпляра класса '%s' из protobuf-представления.", clazz.getName()),
                        ex
                );
            }
        }
    }

    private static <T> void registerDeserializer(
            @NotNull final Map<Class<?>, Deserializer<?>> map,
            @NotNull final Class<T> clazz,
            @NotNull final Deserializer<T> deserializer) {

        map.put(clazz, deserializer);
    }

    private static Map<Class<?>, Deserializer<?>> createClassToDeserializerMap() {

        final Map<Class<?>, Deserializer<?>> result = new HashMap<>();

        registerDeserializer(result, QluaEvent.EventType.class, ProtobufQluaEventTypeSerde.INSTANCE);
        registerDeserializer(result, Firm.class, FirmPbSerde.INSTANCE);
        registerDeserializer(result, MoneyLimit.class, MoneyLimitPbSerde.INSTANCE);
        registerDeserializer(result, AccountBalance.class, AccountBalancePbSerde.INSTANCE);
        registerDeserializer(result, AccountPosition.class, AccountPositionPbSerde.INSTANCE);
        registerDeserializer(result, DateTimeEntry.class, DateTimeEntryPbSerde.INSTANCE);
        registerDeserializer(result, AllTrade.class, AllTradePbSerde.INSTANCE);
        registerDeserializer(result, FuturesClientHolding.class, FuturesClientHoldingPbSerde.INSTANCE);

        return result;
    }
}
