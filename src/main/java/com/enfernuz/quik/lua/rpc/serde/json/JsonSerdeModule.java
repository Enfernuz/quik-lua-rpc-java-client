package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.serde.SerdeException;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;

import static java.util.Objects.requireNonNull;

public enum JsonSerdeModule implements SerdeModule {

    INSTANCE;

    private final ObjectMapper objectMapper;

    private JsonSerdeModule() {

        objectMapper = new ObjectMapper();
        objectMapper.registerModule( new QluaJsonModule() );
    }

    @Override
    public <T> byte[] serialize(final T t) {

        requireNonNull(t, "The argument must not be null.");

        if (t instanceof QluaEvent.EventType) {
            return JsonQluaEventTypeSerde.INSTANCE.serialize((QluaEvent.EventType) t);
        } else {
            throw new SerdeException(); // TODO
        }
    }

    @Override
    public <T> T deserialize(final Class<T> clazz, byte[] data) {

        try {

            if (QluaEvent.EventType.class == clazz) {
                // This cast is safe because the JsonQluaEventTypeSerde returns an instance of QluaEvent.EventType
                // and we obliged to return an instance of Class<QluaEvent.EventType>.
                @SuppressWarnings("unchecked")
                final T result = (T) JsonQluaEventTypeSerde.INSTANCE.deserialize(data);
                return result;
            } else {
                return objectMapper.readValue(data, clazz);
            }
        } catch (final Exception ex) {
            ex.printStackTrace();
            throw new SerdeException(); // TODO
        }
    }
}
