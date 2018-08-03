package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassSecurities;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

final class GetClassSecuritiesResultJsonDeserializer extends JsonDeserializer<GetClassSecurities.Result> {

    @Override
    public GetClassSecurities.Result deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final JsonNode node = p.getCodec().readTree(p);
        return new GetClassSecurities.Result( node.get("class_securities").asText() );
    }
}