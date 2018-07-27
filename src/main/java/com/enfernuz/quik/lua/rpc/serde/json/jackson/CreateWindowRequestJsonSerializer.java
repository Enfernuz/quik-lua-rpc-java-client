package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.CreateWindow;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class CreateWindowRequestJsonSerializer extends JsonSerializer<CreateWindow.Request> {

    @Override
    public void serialize(
            final CreateWindow.Request value,
            final JsonGenerator gen,
            final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "CreateWindow");

        gen.writeNumberField("t_id", value.getTId());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
