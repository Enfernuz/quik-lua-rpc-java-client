package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.GetFuturesLimit;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetFuturesLimitRequestJsonSerializer extends JsonSerializer<GetFuturesLimit.Request> {

    @Override
    public void serialize(final GetFuturesLimit.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getFuturesLimit");

        gen.writeStringField("firmid", value.getFirmId());
        gen.writeStringField("trdaccid", value.getTrdAccId());
        gen.writeNumberField("limit_type", value.getLimitType());
        gen.writeStringField("currcode", value.getCurrCode());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
