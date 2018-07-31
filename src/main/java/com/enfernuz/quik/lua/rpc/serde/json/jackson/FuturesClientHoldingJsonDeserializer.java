package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesClientHolding;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

final class FuturesClientHoldingJsonDeserializer extends JsonDeserializer<FuturesClientHolding> {

    @Override
    public FuturesClientHolding deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final JsonNode node = p.getCodec().readTree(p);
        return FuturesClientHolding.builder()
                .firmId( asText(node, "firmid") )
                .trdAccId( asText(node, "trdaccid") )
                .secCode( asText(node, "sec_code") )
                .type( node.get("type").asInt() )
                .startBuy( asText(node, "startbuy") )
                .startSell( asText(node, "startsell") )
                .todayBuy( asText(node, "todaybuy") )
                .todaySell( asText(node, "todaysell") )
                .totalNet( asText(node, "totalnet") )
                .openBuys( node.get("openbuys").asInt() )
                .openSells( node.get("opensells").asInt() )
                .cbplUsed( asText(node, "cbplused") )
                .cbplPlanned( asText(node, "cbplplanned") )
                .varMargin( asText(node, "varmargin") )
                .avrPosnPrice( asText(node, "avrposnprice") )
                .positionValue( asText(node, "positionvalue") )
                .realVarMargin( asText(node, "real_varmargin") )
                .totalVarMargin( asText(node, "total_varmargin") )
                .sessionStatus( node.get("session_status").asInt() )
                .build();

    }
}
