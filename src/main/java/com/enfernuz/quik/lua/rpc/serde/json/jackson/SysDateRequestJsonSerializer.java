package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.os.SysDate;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class SysDateRequestJsonSerializer extends JsonSerializer<SysDate.Request> {

    @Override
    public void serialize(final SysDate.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "os.sysdate");
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
