package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.UnsubscribeLevel2Quotes;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class UnsubscribeLevel2QuotesRequestJsonSerializer extends JsonSerializer<UnsubscribeLevel2Quotes.Request> {

    @Override
    public void serialize(final UnsubscribeLevel2Quotes.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "Unsubscribe_Level_II_Quotes");
        gen.writeStringField("class_code", value.getClassCode());
        gen.writeStringField("sec_code", value.getSecCode());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
