package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BAnd;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class BitBAndRequestJsonSerializer extends JsonSerializer<BAnd.Request> {

    @Override
    public void serialize(final BAnd.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "bit.band");
        gen.writeNumberField("x1", value.getX1());
        gen.writeNumberField("x2", value.getX2());
        final int[] xi = value.getXi();
        if (xi != null) {
            gen.writeFieldName("xi");
            gen.writeArray(xi, 0, xi.length);
        }
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
