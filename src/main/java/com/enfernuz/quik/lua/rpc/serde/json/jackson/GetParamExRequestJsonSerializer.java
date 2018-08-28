package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetParamEx;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetParamExRequestJsonSerializer extends JsonSerializer<GetParamEx.Request> {

    @Override
    public void serialize(final GetParamEx.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getParamEx");
        gen.writeStringField("class_code", value.getClassCode());
        gen.writeStringField("sec_code", value.getSecCode());
        gen.writeStringField("param_name", value.getParamName());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
