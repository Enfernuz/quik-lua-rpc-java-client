package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetMoney;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetMoneyRequestJsonSerializer extends JsonSerializer<GetMoney.Request> {

    @Override
    public void serialize(final GetMoney.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getMoney");

        gen.writeStringField("client_code", value.getClientCode());
        gen.writeStringField("firmid", value.getFirmId());
        gen.writeStringField("tag", value.getTag());
        gen.writeStringField("currcode", value.getCurrCode());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
