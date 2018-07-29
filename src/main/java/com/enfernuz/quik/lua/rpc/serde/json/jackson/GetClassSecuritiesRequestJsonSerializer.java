package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.GetClassSecurities;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetClassSecuritiesRequestJsonSerializer extends JsonSerializer<GetClassSecurities.Request> {

    @Override
    public void serialize(final GetClassSecurities.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getClassSecurities");

        gen.writeStringField("class_code", value.getClassCode());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
