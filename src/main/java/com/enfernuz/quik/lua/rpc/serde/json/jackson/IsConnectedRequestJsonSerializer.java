package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.IsConnected;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class IsConnectedRequestJsonSerializer extends JsonSerializer<IsConnected.Request> {

    @Override
    public void serialize(final IsConnected.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "isConnected");
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
