package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetWindowRect;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public final class GetWindowRectRequestJsonSerializer extends JsonSerializer<GetWindowRect.Request> {

    @Override
    public void serialize(final GetWindowRect.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "GetWindowRect");
        gen.writeNumberField("t_id", value.getTId());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
