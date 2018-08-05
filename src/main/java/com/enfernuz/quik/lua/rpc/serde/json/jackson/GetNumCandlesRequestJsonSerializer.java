package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetNumCandles;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetNumCandlesRequestJsonSerializer extends JsonSerializer<GetNumCandles.Request> {

    @Override
    public void serialize(final GetNumCandles.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getNumCandles");

        gen.writeStringField("tag", value.getTag());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
