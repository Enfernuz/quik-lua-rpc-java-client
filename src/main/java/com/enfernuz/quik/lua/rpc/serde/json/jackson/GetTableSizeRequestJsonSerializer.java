package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetTableSize;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public final class GetTableSizeRequestJsonSerializer extends JsonSerializer<GetTableSize.Request> {

    @Override
    public void serialize(final GetTableSize.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "GetTableSize");
        gen.writeNumberField("t_id", value.getTId());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
