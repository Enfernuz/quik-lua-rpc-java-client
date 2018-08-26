package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.bit.Test;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class BitTestRequestJsonSerializer extends JsonSerializer<Test.Request> {

    @Override
    public void serialize(final Test.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "bit.test");
        gen.writeNumberField("x", value.getX());
        gen.writeNumberField("n", value.getN());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
