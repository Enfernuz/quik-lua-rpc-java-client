package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetCell;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

final class GetCellResultJsonDeserializer extends JsonDeserializer<GetCell.Result> {

    @Override
    public GetCell.Result deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final JsonNode node = p.getCodec().readTree(p);
        return GetCell.Result
                .builder()
                .image( node.get("image").asText() )
                .value( node.get("value").asText() )
                .build();
    }
}