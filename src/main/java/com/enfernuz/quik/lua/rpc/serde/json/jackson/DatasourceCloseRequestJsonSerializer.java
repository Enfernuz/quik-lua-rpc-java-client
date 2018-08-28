package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.Close;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class DatasourceCloseRequestJsonSerializer extends JsonSerializer<Close.Request> {

    @Override
    public void serialize(final Close.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "datasource.Close");
        gen.writeStringField("datasource_uuid", value.getDatasourceUUID());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
