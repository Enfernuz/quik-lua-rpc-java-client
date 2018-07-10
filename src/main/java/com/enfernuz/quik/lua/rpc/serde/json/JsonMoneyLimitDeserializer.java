package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.events.api.structures.MoneyLimit;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.enfernuz.quik.lua.rpc.serde.SerdeException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Value
public class JsonMoneyLimitDeserializer implements Deserializer<MoneyLimit> {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    ObjectMapper objectMapper;

    @Override
    public MoneyLimit deserialize(final byte[] data) {

        try {
            return objectMapper.readValue(data, MoneyLimit.class);
        } catch (final Exception ex) {
            throw new SerdeException(); //TODO
        }
    }
}
