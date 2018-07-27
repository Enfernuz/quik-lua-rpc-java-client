package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.DeleteRow;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class DeleteRowRequestJsonSerializer extends JsonSerializer<DeleteRow.Request> {

    @Override
    public void serialize(
            final DeleteRow.Request value,
            final JsonGenerator gen,
            final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "DeleteRow");

        gen.writeNumberField("t_id", value.getTId());
        gen.writeNumberField("key", value.getKey());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
