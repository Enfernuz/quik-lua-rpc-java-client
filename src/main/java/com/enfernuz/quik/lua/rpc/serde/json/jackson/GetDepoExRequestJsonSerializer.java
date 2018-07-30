package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.GetDepoEx;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetDepoExRequestJsonSerializer extends JsonSerializer<GetDepoEx.Request> {

    @Override
    public void serialize(final GetDepoEx.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getDepoEx");

        gen.writeStringField("firmid", value.getFirmId());
        gen.writeStringField("client_code", value.getClientCode());
        gen.writeStringField("sec_code", value.getSecCode());
        gen.writeStringField("trdaccid", value.getTrdAccId());
        gen.writeNumberField("limit_kind", value.getLimitKind());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
