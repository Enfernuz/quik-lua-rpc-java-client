package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.events.api.structures.FuturesLimit;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

final class FuturesLimitJsonDeserializer extends JsonDeserializer<FuturesLimit> {

    @Override
    public FuturesLimit deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final JsonNode node = p.getCodec().readTree(p);
        return FuturesLimit
                .builder()
                .firmId( asText(node, "firmid") )
                .trdAccId( asText(node, "trdaccid") )
                .limitType( node.get("limit_type").asInt() )
                .liquidityCoef( asText(node, "liquidity_coef") )
                .cbpPrevLimit( asText(node, "cbp_prev_limit") )
                .cbpLimit( asText(node, "cbplimit") )
                .cbpLUsed( asText(node, "cbplused") )
                .cbpLPlanned( asText(node, "cbplplanned") )
                .varMargin( asText(node, "varmargin") )
                .accruedInt( asText(node, "accruedint") )
                .cbpLUsedForOrders( asText(node, "cbplused_for_orders") )
                .cbpLUsedForPositions( asText(node, "cbplused_for_positions") )
                .optionsPremium( asText(node, "options_premium") )
                .tsComission( asText(node, "ts_comission") )
                .kgo( asText(node, "kgo") )
                .currCode( asText(node, "currcode") )
                .realVarMargin( asText(node, "real_varmargin") )
                .build();
    }
}
