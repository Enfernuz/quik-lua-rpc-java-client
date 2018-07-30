package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.DepoLimit;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

final class DepoLimitJsonDeserializer extends JsonDeserializer<DepoLimit> {

    @Override
    public DepoLimit deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final JsonNode node = p.getCodec().readTree(p);
        return DepoLimit
                .builder()
                .secCode( asText(node, "sec_code") )
                .trdAccId( asText(node, "trdaccid") )
                .firmId( asText(node, "firmid") )
                .clientCode( asText(node, "client_code") )
                .openBal( node.get("openbal").asInt() )
                .openLimit( node.get("openlimit").asInt() )
                .currentBal( node.get("currentbal").asInt() )
                .currentLimit( node.get("currentlimit").asInt() )
                .lockedSell( node.get("locked_sell").asInt() )
                .lockedBuy( node.get("locked_buy").asInt() )
                .lockedBuyValue( node.get("locked_buy_value").asText() )
                .lockedSellValue( node.get("locked_sell_value").asText() )
                .awgPositionPrice( node.get("awg_position_price").asText() )
                .limitKind( node.get("limit_kind").asInt() )
                .build();
    }
}
