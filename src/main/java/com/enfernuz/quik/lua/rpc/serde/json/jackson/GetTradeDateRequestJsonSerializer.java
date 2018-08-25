package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetTradeDate;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public final class GetTradeDateRequestJsonSerializer extends JsonSerializer<GetTradeDate.Request> {

    @Override
    public void serialize(final GetTradeDate.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getTradeDate");
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
