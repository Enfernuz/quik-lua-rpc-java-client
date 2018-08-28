package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.SetUpdateCallback;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class DatasourceSetUpdateCallbackRequestJsonSerializer extends JsonSerializer<SetUpdateCallback.Request> {

    @Override
    public void serialize(final SetUpdateCallback.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "datasource.SetUpdateCallback");
        gen.writeStringField("datasource_uuid", value.getDatasourceUUID());
        gen.writeStringField("f_cb_def", value.getFCbDef());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
