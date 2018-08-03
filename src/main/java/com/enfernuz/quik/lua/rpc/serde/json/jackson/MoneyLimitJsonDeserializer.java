package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.MoneyLimit;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

final class MoneyLimitJsonDeserializer extends JsonDeserializer<MoneyLimit> {

    @Override
    public MoneyLimit deserialize(
            final JsonParser jsonParser,
            final DeserializationContext deserializationContext) throws IOException {

        final JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        return MoneyLimit.builder()
                .currCode( asText(node, "currcode") )
                .tag( asText(node, "tag") )
                .firmId( asText(node, "firmid") )
                .clientCode( asText(node, "client_code") )
                .openBal( asText(node, "openbal") )
                .openLimit( asText(node, "openlimit") )
                .currentBal( asText(node, "currentbal") )
                .currentLimit( asText(node, "currentlimit") )
                .locked( asText(node, "locked") )
                .lockedValueCoef( asText(node, "locked_value_coef") )
                .lockedMarginValue( asText(node, "locked_margin_value") )
                .leverage( asText(node, "leverage") )
                .limitKind( node.get("limit_kind").asInt() )
                .build();
    }
}
