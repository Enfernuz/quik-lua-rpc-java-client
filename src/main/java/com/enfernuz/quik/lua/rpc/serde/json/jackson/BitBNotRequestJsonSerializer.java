package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BNot;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class BitBNotRequestJsonSerializer extends JsonSerializer<BNot.Request> {

    @Override
    public void serialize(final BNot.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "bit.bnot");
        gen.writeNumberField("x", value.getX());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
