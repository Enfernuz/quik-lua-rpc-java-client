package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.CreateDataSource;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.base.Strings;

import java.io.IOException;

final class DatasourceCreateDatasourceRequestJsonSerializer extends JsonSerializer<CreateDataSource.Request> {

    @Override
    public void serialize(final CreateDataSource.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "datasource.CreateDataSource");
        gen.writeStringField("class_code", value.getClassCode());
        gen.writeStringField("sec_code", value.getSecCode());
        gen.writeStringField("interval", value.getInterval().name());
        final String param = value.getParam();
        if ( !Strings.isNullOrEmpty(param) ) {
            gen.writeStringField("param", param);
        }
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
