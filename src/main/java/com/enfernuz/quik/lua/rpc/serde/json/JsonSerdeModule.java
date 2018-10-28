package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.events.api.QluaEvent;
import com.enfernuz.quik.lua.rpc.serde.SerdeException;
import com.enfernuz.quik.lua.rpc.serde.SerdeModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;

import static java.util.Objects.requireNonNull;

public enum JsonSerdeModule implements SerdeModule {

    INSTANCE;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> @NotNull byte[] serialize(final @NotNull T t) {

        requireNonNull(t);

        try {

            final byte[] result;
            if (t instanceof QluaEvent.EventType) {
                result = JsonQluaEventTypeSerde.INSTANCE.serialize((QluaEvent.EventType) t);
            } else {
                result = objectMapper.writeValueAsBytes(t);
            }

            return result;
        } catch (final Exception ex) {
            throw new SerdeException(
                    String.format("Ошибка сериализации экземпляра %s в JSON-представление.", t.getClass().getName()),
                    ex
            );
        }
    }

    @Override
    public <T> @NotNull T deserialize(final @NotNull Class<T> clazz, final @NotNull byte[] data) {

        try {

            if (QluaEvent.EventType.class == clazz) {
                // This cast is safe because JsonQluaEventTypeSerde returns an instance of QluaEvent.EventType
                // and we obliged to return an instance of Class<QluaEvent.EventType>.
                @SuppressWarnings("unchecked")
                final T result = (T) JsonQluaEventTypeSerde.INSTANCE.deserialize(data);
                return result;
            } else {
                return objectMapper.readValue(data, clazz);
            }
        } catch (final Exception ex) {
            throw new SerdeException(
                    String.format("Ошибка десериализации экземпляра %s из JSON-представления.", clazz.getName()),
                    ex
            );
        }
    }
}
