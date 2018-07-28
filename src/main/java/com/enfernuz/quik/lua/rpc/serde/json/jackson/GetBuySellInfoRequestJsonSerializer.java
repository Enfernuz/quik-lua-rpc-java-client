package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.GetBuySellInfo;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetBuySellInfoRequestJsonSerializer extends JsonSerializer<GetBuySellInfo.Request> {

    @Override
    public void serialize(final GetBuySellInfo.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getBuySellInfo");

        gen.writeStringField("firm_id", value.getFirmId());
        gen.writeStringField("client_code", value.getClientCode());
        gen.writeStringField("class_code", value.getClassCode());
        gen.writeStringField("sec_code", value.getSecCode());
        gen.writeStringField("price", value.getPrice());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
