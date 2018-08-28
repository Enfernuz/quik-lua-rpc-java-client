package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.SetEmptyCallback;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class DatasourceSetEmptyCallbackRequestJsonSerializer extends JsonSerializer<SetEmptyCallback.Request> {

    @Override
    public void serialize(final SetEmptyCallback.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "datasource.SetEmptyCallback");
        gen.writeStringField("datasource_uuid", value.getDatasourceUUID());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
