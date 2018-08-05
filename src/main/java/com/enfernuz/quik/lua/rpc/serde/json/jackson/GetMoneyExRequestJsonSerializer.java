package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetMoneyEx;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetMoneyExRequestJsonSerializer extends JsonSerializer<GetMoneyEx.Request> {

    @Override
    public void serialize(final GetMoneyEx.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getMoneyEx");

        gen.writeStringField("firmid", value.getFirmId());
        gen.writeStringField("client_code", value.getClientCode());
        gen.writeStringField("tag", value.getTag());
        gen.writeStringField("currcode", value.getCurrCode());
        gen.writeNumberField("limit_kind", value.getLimitKind());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
