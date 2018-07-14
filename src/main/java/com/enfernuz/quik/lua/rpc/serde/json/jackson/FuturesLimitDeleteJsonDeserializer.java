package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.events.api.structures.FuturesLimitDelete;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

final class FuturesLimitDeleteJsonDeserializer extends JsonDeserializer<FuturesLimitDelete> {

    @Override
    public FuturesLimitDelete deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final JsonNode node = p.getCodec().readTree(p);
        return FuturesLimitDelete
                .builder()
                .firmId( asText(node, "firmid") )
                .limitType( node.get("limit_type").asInt() )
                .build();
    }
}
