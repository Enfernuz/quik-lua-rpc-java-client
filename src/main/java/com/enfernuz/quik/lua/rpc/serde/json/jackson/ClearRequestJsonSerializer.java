package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.Clear;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class ClearRequestJsonSerializer extends JsonSerializer<Clear.Request> {

    @Override
    public void serialize(
            final Clear.Request value,
            final JsonGenerator gen,
            final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "Clear");

        gen.writeNumberField("t_id", value.getTId());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
