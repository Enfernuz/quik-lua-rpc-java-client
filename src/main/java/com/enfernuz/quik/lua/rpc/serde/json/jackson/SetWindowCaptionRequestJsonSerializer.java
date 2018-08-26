package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.SetWindowCaption;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class SetWindowCaptionRequestJsonSerializer extends JsonSerializer<SetWindowCaption.Request> {

    @Override
    public void serialize(final SetWindowCaption.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "SetWindowCaption");
        gen.writeNumberField("t_id", value.getTId());
        gen.writeStringField("str", value.getStr());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
