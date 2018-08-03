package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.MoneyLimitDelete;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

final class MoneyLimitDeleteJsonDeserializer extends JsonDeserializer<MoneyLimitDelete> {

    @Override
    public MoneyLimitDelete deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final JsonNode node = p.getCodec().readTree(p);
        return MoneyLimitDelete
                .builder()
                .currCode( asText(node, "currcode") )
                .tag( asText(node, "tag") )
                .clientCode( asText(node, "client_code") )
                .firmId( asText(node, "firmid") )
                .limitKind( node.get("limit_kind").asInt() )
                .build();
    }
}
