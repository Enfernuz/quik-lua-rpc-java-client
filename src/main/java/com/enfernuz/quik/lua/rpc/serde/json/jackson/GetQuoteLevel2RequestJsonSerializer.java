package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetQuoteLevel2;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetQuoteLevel2RequestJsonSerializer extends JsonSerializer<GetQuoteLevel2.Request> {

    @Override
    public void serialize(final GetQuoteLevel2.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getQuoteLevel2");

        gen.writeStringField("class_code", value.getClassCode());
        gen.writeStringField("sec_code", value.getSecCode());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
