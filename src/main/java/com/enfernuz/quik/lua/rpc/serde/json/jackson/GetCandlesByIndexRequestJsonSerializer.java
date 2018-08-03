package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetCandlesByIndex;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetCandlesByIndexRequestJsonSerializer extends JsonSerializer<GetCandlesByIndex.Request> {

    @Override
    public void serialize(final GetCandlesByIndex.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getCandlesByIndex");

        gen.writeStringField("tag", value.getTag());
        gen.writeNumberField("line", value.getLine());
        gen.writeNumberField("first_candle", value.getFirstCandle());
        gen.writeNumberField("count", value.getCount());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
