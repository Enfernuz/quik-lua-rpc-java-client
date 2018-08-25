package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.PrintDbgStr;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class PrintDbgStrRequestJsonSerializer extends JsonSerializer<PrintDbgStr.Request> {

    @Override
    public void serialize(final PrintDbgStr.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "PrintDbgStr");
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
