package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.events.api.structures.ConnectedEventInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

final class ConnectedEventInfoJsonDeserializer extends JsonDeserializer<ConnectedEventInfo> {

    @Override
    public ConnectedEventInfo deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final JsonNode node = p.getCodec().readTree(p);
        return new ConnectedEventInfo( node.get("flag").asInt() );
    }
}
