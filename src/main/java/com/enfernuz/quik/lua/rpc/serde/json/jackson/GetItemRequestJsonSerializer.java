package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetItem;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetItemRequestJsonSerializer extends JsonSerializer<GetItem.Request> {

    @Override
    public void serialize(final GetItem.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getItem");

        gen.writeStringField("table_name", value.getTableName());
        gen.writeNumberField("index", value.getIndex());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
