package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetWindowCaption;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public final class GetWindowCaptionRequestJsonSerializer extends JsonSerializer<GetWindowCaption.Request> {

    @Override
    public void serialize(final GetWindowCaption.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "GetWindowCaption");
        gen.writeNumberField("t_id", value.getTId());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
