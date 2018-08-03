package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.DelLabel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class DelLabelRequestJsonSerializer extends JsonSerializer<DelLabel.Request> {

    @Override
    public void serialize(final DelLabel.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "DelLabel");

        gen.writeStringField("chart_tag", value.getChartTag());
        gen.writeNumberField("label_id", value.getLabelId());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
