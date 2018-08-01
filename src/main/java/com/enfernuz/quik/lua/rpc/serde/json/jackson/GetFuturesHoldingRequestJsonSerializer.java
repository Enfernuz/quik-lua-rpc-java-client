package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.GetFuturesHolding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetFuturesHoldingRequestJsonSerializer extends JsonSerializer<GetFuturesHolding.Request> {

    @Override
    public void serialize(final GetFuturesHolding.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getFuturesHolding");

        gen.writeStringField("firmid", value.getFirmId());
        gen.writeStringField("trdaccid", value.getTrdAccId());
        gen.writeStringField("sec_code", value.getSecCode());
        gen.writeNumberField("type", value.getType());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
