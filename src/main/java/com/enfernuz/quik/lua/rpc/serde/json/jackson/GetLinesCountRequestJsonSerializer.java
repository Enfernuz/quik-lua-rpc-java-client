package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetLinesCount;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetLinesCountRequestJsonSerializer extends JsonSerializer<GetLinesCount.Request> {

    @Override
    public void serialize(final GetLinesCount.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getLinesCount");

        gen.writeStringField("tag", value.getTag());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
