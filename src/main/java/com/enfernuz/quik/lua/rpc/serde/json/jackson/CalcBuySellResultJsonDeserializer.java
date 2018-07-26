package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.CalcBuySell;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

final class CalcBuySellResultJsonDeserializer extends JsonDeserializer<CalcBuySell.Result> {

    @Override
    public CalcBuySell.Result deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final JsonNode node = p.getCodec().readTree(p);
        return new CalcBuySell.Result(node.get("qty").asInt(), node.get("comission").asText());
    }
}
