package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetInfoParam;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetInfoParamRequestJsonSerializer extends JsonSerializer<GetInfoParam.Request> {

    @Override
    public void serialize(final GetInfoParam.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getInfoParam");

        gen.writeStringField("param_name", value.getParamName());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
