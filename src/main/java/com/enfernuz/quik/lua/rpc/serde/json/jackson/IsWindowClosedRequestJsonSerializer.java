package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.IsWindowClosed;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class IsWindowClosedRequestJsonSerializer extends JsonSerializer<IsWindowClosed.Request> {

    @Override
    public void serialize(final IsWindowClosed.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "IsWindowClosed");
        gen.writeNumberField("t_id", value.getTId());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
