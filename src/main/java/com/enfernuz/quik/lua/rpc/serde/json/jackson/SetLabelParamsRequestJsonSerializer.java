package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.SetLabelParams;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Map;

final class SetLabelParamsRequestJsonSerializer extends JsonSerializer<SetLabelParams.Request> {

    @Override
    public void serialize(final SetLabelParams.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "SetLabelParams");
        gen.writeStringField("chart_tag", value.getChartTag());
        gen.writeNumberField("label_id", value.getLabelId());
        gen.writeObjectFieldStart("label_params");
        for (final Map.Entry<String, String> entry : value.getLabelParams().entrySet()) {
            gen.writeStringField(entry.getKey(), entry.getValue());
        }
        gen.writeEndObject();
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
