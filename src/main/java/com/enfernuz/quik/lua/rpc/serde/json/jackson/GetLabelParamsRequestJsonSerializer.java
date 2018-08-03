package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetLabelParams;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class GetLabelParamsRequestJsonSerializer extends JsonSerializer<GetLabelParams.Request> {

    @Override
    public void serialize(final GetLabelParams.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "GetLabelParams");

        gen.writeStringField("chart_tag", value.getChartTag());
        gen.writeNumberField("label_id", value.getLabelId());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
