package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.Sleep;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class SleepRequestJsonSerializer extends JsonSerializer<Sleep.Request> {

    @Override
    public void serialize(final Sleep.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "sleep");
        gen.writeNumberField("time", value.getTime());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
