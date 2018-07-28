package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.DestroyTable;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class DestroyTableRequestJsonSerializer extends JsonSerializer<DestroyTable.Request> {

    @Override
    public void serialize(final DestroyTable.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "DestroyTable");

        gen.writeNumberField("t_id", value.getTId());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
