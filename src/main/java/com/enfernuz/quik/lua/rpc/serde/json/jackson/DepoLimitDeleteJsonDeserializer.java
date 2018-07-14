package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.events.api.structures.DepoLimitDelete;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

final class DepoLimitDeleteJsonDeserializer extends JsonDeserializer<DepoLimitDelete> {

    @Override
    public DepoLimitDelete deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final JsonNode node = p.getCodec().readTree(p);
        return DepoLimitDelete
                .builder()
                .secCode( asText(node, "sec_code") )
                .trdAccId( asText(node, "trdaccid") )
                .firmId( asText(node, "firmid") )
                .clientCode( asText(node, "client_code") )
                .limitKind( node.get("limit_kind").asInt() )
                .build();
    }
}
