package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetCell;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetCellRequestJsonSerializer extends JsonSerializer<GetCell.Request> {

    @Override
    public void serialize(final GetCell.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "GetCell");

        gen.writeNumberField("t_id", value.getTId());
        gen.writeNumberField("key", value.getKey());
        gen.writeNumberField("code", value.getCode());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
