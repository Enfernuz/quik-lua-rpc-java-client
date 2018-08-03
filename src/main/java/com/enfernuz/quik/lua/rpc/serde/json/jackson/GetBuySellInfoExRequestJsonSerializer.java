package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfoEx;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetBuySellInfoExRequestJsonSerializer extends JsonSerializer<GetBuySellInfoEx.Request> {

    @Override
    public void serialize(final GetBuySellInfoEx.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getBuySellInfoEx");

        gen.writeStringField("firm_id", value.getFirmId());
        gen.writeStringField("client_code", value.getClientCode());
        gen.writeStringField("class_code", value.getClassCode());
        gen.writeStringField("sec_code", value.getSecCode());
        gen.writeStringField("price", value.getPrice());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
