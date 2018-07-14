package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.fasterxml.jackson.databind.JsonNode;

final class QluaJsonJacksonUtils {

    private QluaJsonJacksonUtils() {
        throw new AssertionError("This should never be invoked.");
    }

    static String asText(final JsonNode node, final String fieldName) {

        final JsonNode value = node.get(fieldName);
        return value == null ? null : value.asText();
    }
}
