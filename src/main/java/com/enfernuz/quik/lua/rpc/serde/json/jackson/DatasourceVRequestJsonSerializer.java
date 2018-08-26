package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.V;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class DatasourceVRequestJsonSerializer extends JsonSerializer<V.Request> {

    @Override
    public void serialize(final V.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "datasource.V");
        gen.writeStringField("datasource_uuid", value.getDatasourceUUID());
        gen.writeNumberField("candle_index", value.getCandleIndex());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
