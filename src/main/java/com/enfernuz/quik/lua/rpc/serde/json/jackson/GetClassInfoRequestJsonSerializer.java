package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassInfo;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetClassInfoRequestJsonSerializer extends JsonSerializer<GetClassInfo.Request> {

    @Override
    public void serialize(final GetClassInfo.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getClassInfo");

        gen.writeStringField("class_code", value.getClassCode());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
