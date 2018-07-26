package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

final class QluaJsonJacksonUtils {

    private QluaJsonJacksonUtils() {
        throw new AssertionError("This should never be invoked.");
    }

    static String asText(final JsonNode node, final String fieldName) {

        final JsonNode value = node.get(fieldName);
        return value == null ? null : value.asText();
    }

    static void prepareJsonGeneratorForMethod(final JsonGenerator jsonGenerator, final String methodName)
            throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("method", methodName);
        jsonGenerator.writeObjectFieldStart("args");
    }

    static void finishJsonGenerator(final JsonGenerator jsonGenerator)
            throws IOException {

        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndObject();
    }
}
