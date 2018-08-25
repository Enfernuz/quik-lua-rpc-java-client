package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.Highlight;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public final class HighlightRequestJsonSerializer extends JsonSerializer<Highlight.Request> {

    @Override
    public void serialize(final Highlight.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "Highlight");
        gen.writeNumberField("t_id", value.getTId());
        gen.writeNumberField("row", value.getRow());
        gen.writeNumberField("col", value.getCol());
        gen.writeNumberField("b_color", value.getBColor());
        gen.writeNumberField("f_color", value.getFColor());
        gen.writeNumberField("timeout", value.getTimeout());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}