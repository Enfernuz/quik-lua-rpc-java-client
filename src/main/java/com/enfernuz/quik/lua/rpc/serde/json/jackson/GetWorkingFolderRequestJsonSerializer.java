package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetWorkingFolder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public final class GetWorkingFolderRequestJsonSerializer extends JsonSerializer<GetWorkingFolder.Request> {

    @Override
    public void serialize(final GetWorkingFolder.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getWorkingFolder");
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
