package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetScriptPath;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public final class GetScriptPathRequestJsonSerializer extends JsonSerializer<GetScriptPath.Request> {

    @Override
    public void serialize(final GetScriptPath.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getScriptPath");
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
