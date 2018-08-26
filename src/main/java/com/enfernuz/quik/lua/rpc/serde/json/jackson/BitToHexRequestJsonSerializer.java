package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.bit.ToHex;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class BitToHexRequestJsonSerializer extends JsonSerializer<ToHex.Request> {

    @Override
    public void serialize(final ToHex.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "bit.tohex");
        gen.writeNumberField("x", value.getX());
        gen.writeNumberField("n", value.getN());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
