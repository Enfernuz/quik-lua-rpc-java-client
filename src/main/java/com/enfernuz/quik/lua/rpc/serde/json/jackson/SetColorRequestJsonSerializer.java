package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.SetColor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class SetColorRequestJsonSerializer extends JsonSerializer<SetColor.Request> {

    @Override
    public void serialize(final SetColor.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "SetColor");
        gen.writeNumberField("t_id", value.getTId());
        gen.writeNumberField("row", value.getRow());
        gen.writeNumberField("col", value.getCol());
        gen.writeNumberField("b_color", value.getBColor());
        gen.writeNumberField("f_color", value.getFColor());
        gen.writeNumberField("sel_b_color", value.getSelBColor());
        gen.writeNumberField("sel_f_color", value.getSelFColor());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
