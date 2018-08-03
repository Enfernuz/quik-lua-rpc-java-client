package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.AllocTable;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class AllocTableRequestJsonSerializer extends JsonSerializer<AllocTable.Request> {

    @Override
    public void serialize(AllocTable.Request value, JsonGenerator gen, SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "AllocTable");
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
