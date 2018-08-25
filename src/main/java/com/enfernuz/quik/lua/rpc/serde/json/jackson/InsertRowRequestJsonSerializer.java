package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.InsertRow;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public final class InsertRowRequestJsonSerializer extends JsonSerializer<InsertRow.Request> {

    @Override
    public void serialize(final InsertRow.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "InsertRow");
        gen.writeNumberField("t_id", value.getTId());
        gen.writeNumberField("key", value.getKey());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
