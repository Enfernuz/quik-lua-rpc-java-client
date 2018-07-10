package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.events.api.structures.MoneyLimit;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class MoneyLimitJsonDeserializer extends JsonDeserializer<MoneyLimit> {

    @Override
    public MoneyLimit deserialize(
            final JsonParser jsonParser,
            final DeserializationContext deserializationContext) throws IOException {

        final JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        return MoneyLimit.builder()
                .currCode( node.get("currcode").asText() )
                .tag( node.get("tag").asText() )
                .firmId( node.get("firmid").asText() )
                .clientCode( node.get("client_code").asText() )
                .openBal( node.get("openbal").asText() )
                .openLimit( node.get("openlimit").asText() )
                .currentBal( node.get("currentbal").asText() )
                .currentLimit( node.get("currentlimit").asText() )
                .locked( node.get("locked").asText() )
                .lockedValueCoef( node.get("locked_value_coef").asText() )
                .lockedMarginValue( node.get("locked_margin_value").asText() )
                .leverage( node.get("leverage").asText() )
                .limitKind( node.get("limit_kind").asInt() )
                .build();
    }
}
