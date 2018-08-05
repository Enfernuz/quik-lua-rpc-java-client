package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetOrderByNumber;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetOrderByNumberRequestJsonSerializer extends JsonSerializer<GetOrderByNumber.Request> {

    @Override
    public void serialize(final GetOrderByNumber.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "getOrderByNumber");

        gen.writeStringField("class_code", value.getClassCode());
        gen.writeNumberField("order_id", value.getOrderId());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
