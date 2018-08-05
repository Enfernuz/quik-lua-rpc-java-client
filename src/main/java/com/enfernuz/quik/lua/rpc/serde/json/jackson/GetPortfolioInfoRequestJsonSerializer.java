package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetPortfolioInfo;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetPortfolioInfoRequestJsonSerializer extends JsonSerializer<GetPortfolioInfo.Request> {

    @Override
    public void serialize(final GetPortfolioInfo.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getPortfolioInfo");

        gen.writeStringField("firm_id", value.getFirmId());
        gen.writeStringField("client_code", value.getClientCode());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
