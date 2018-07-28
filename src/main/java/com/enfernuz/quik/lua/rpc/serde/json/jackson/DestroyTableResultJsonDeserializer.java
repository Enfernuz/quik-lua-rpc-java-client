package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.DestroyTable;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

final class DestroyTableResultJsonDeserializer extends JsonDeserializer<DestroyTable.Result> {

    @Override
    public DestroyTable.Result deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final JsonNode node = p.getCodec().readTree(p);

        return new DestroyTable.Result( node.get("result").asBoolean() );
    }
}