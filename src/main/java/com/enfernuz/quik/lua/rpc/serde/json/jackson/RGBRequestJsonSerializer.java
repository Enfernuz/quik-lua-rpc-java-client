package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.RGB;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class RGBRequestJsonSerializer extends JsonSerializer<RGB.Request> {

    @Override
    public void serialize(final RGB.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "RGB");
        gen.writeNumberField("red", value.getRed());
        gen.writeNumberField("blue", value.getBlue());
        gen.writeNumberField("green", value.getGreen());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
