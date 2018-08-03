package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.AddColumn;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class AddColumnRequestJsonSerializer extends JsonSerializer<AddColumn.Request> {

    @Override
    public void serialize(
            final AddColumn.Request value,
            final JsonGenerator gen,
            final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "AddColumn");

        gen.writeNumberField("t_id", value.getTId());
        gen.writeNumberField("icode", value.getICode());
        gen.writeStringField("name", value.getName());
        gen.writeBooleanField("is_default", value.isDefault());
        gen.writeStringField("par_type", value.getParType().name());
        gen.writeNumberField("width", value.getWidth());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}