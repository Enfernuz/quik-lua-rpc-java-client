package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.SetCell;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class SetCellRequestJsonSerializer extends JsonSerializer<SetCell.Request> {

    @Override
    public void serialize(final SetCell.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "SetCell");
        gen.writeNumberField("t_id", value.getTId());
        gen.writeNumberField("key", value.getKey());
        gen.writeNumberField("code", value.getCode());
        gen.writeStringField("text", value.getText());
        gen.writeNumberField("value", value.getValue());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
