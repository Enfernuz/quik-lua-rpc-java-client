package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.Message;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class MessageRequestJsonSerializer extends JsonSerializer<Message.Request> {

    @Override
    public void serialize(final Message.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "message");

        gen.writeStringField("message", value.getMessage());
        gen.writeNumberField("icon_type", value.getIconType().value);

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
