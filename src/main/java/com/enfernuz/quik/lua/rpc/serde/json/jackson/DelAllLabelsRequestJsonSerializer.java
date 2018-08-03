package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.DelAllLabels;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class DelAllLabelsRequestJsonSerializer extends JsonSerializer<DelAllLabels.Request> {

    @Override
    public void serialize(
            final DelAllLabels.Request value,
            final JsonGenerator gen,
            final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "DelAllLabels");

        gen.writeStringField("chart_tag", value.getChartTag());

        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
