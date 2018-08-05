package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetNumberOf;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetNumberOfRequestJsonSerializer extends JsonSerializer<GetNumberOf.Request> {

    @Override
    public void serialize(final GetNumberOf.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getNumberOf");

        gen.writeStringField("table_name", value.getTableName());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
