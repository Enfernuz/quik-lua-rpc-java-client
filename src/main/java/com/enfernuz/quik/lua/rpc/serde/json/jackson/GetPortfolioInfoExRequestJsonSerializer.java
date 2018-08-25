package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetPortfolioInfoEx;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetPortfolioInfoExRequestJsonSerializer extends JsonSerializer<GetPortfolioInfoEx.Request> {

    @Override
    public void serialize(final GetPortfolioInfoEx.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getPortfolioInfoEx");

        gen.writeStringField("firm_id", value.getFirmId());
        gen.writeStringField("client_code", value.getClientCode());
        gen.writeNumberField("limit_kind", value.getLimitKind());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
