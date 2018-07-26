package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.CancelParamRequest;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class CancelParamRequestRequestJsonSerializer extends JsonSerializer<CancelParamRequest.Request> {

    @Override
    public void serialize(
            final CancelParamRequest.Request value,
            final JsonGenerator gen,
            final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "CancelParamRequest");

        gen.writeStringField("class_code", value.getClassCode());
        gen.writeStringField("sec_code", value.getSecCode());
        gen.writeStringField("db_name", value.getDbName());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
