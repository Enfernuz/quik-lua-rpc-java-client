package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.SetWindowPos;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class SetWindowPosRequestJsonSerializer extends JsonSerializer<SetWindowPos.Request> {

    @Override
    public void serialize(final SetWindowPos.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "SetWindowPos");
        gen.writeNumberField("t_id", value.getTId());
        gen.writeNumberField("x", value.getX());
        gen.writeNumberField("y", value.getY());
        gen.writeNumberField("dx", value.getDx());
        gen.writeNumberField("dy", value.getDy());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
