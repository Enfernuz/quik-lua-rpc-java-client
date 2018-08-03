package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.CalcBuySell;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class CalcBuySellRequestJsonSerializer extends JsonSerializer<CalcBuySell.Request> {

    @Override
    public void serialize(
            final CalcBuySell.Request value,
            final JsonGenerator gen,
            final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "CalcBuySell");

        gen.writeStringField("class_code", value.getClassCode());
        gen.writeStringField("sec_code", value.getSecCode());
        gen.writeStringField("client_code", value.getClientCode());
        gen.writeStringField("account", value.getAccount());
        gen.writeStringField("price", value.getPrice());
        gen.writeBooleanField("is_buy", value.isBuy());
        gen.writeBooleanField("is_market", value.isMarket());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
