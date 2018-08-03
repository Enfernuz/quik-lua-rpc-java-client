package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassesList;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetClassesListRequestJsonSerializer extends JsonSerializer<GetClassesList.Request> {

    @Override
    public void serialize(final GetClassesList.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getClassesList");
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
