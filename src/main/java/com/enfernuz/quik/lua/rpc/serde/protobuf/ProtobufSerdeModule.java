package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.events.api.structures.Firm;
import com.enfernuz.quik.lua.rpc.events.api.structures.MoneyLimit;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.enfernuz.quik.lua.rpc.serde.SerdeException;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public enum ProtobufSerdeModule implements SerdeModule {

    INSTANCE;

    private static final Map<Class<?>, Deserializer<?>> CLASS_TO_DESERIALIZER_MAP = new HashMap<>();

    static {
        addDeserializer(QluaEvent.EventType.class, ProtobufQluaEventTypeSerde.INSTANCE);
        addDeserializer(Firm.class, ProtobufFirmDeserializer.INSTANCE);
        addDeserializer(MoneyLimit.class, ProtobufMoneyLimitDeserializer.INSTANCE);
    }

    private static <T> void addDeserializer(Class<T> clazz, Deserializer<T> deserializer) {
        CLASS_TO_DESERIALIZER_MAP.put(clazz, deserializer);
    }


    @Override
    public <T> byte[] serialize(final T t) {

        requireNonNull(t, "The argument must not be null.");

        if (t instanceof QluaEvent.EventType) {
            return ProtobufQluaEventTypeSerde.INSTANCE.serialize((QluaEvent.EventType) t);
        } else {
            throw new SerdeException(); // TODO
        }
    }

    @Override
    public <T> T deserialize(final Class<T> clazz, final byte[] data) {

        // This cast is safe because we used the addDeserializer method to fill the map.
        @SuppressWarnings("unchecked")
        final Deserializer<T> deserializer = (Deserializer<T>) CLASS_TO_DESERIALIZER_MAP.get(clazz);

        if (deserializer == null) {
            throw new SerdeException(); // TODO
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
            } catch (final RuntimeException ex) {
                throw new SerdeException(); // TODO
            }
        }
    }
}
