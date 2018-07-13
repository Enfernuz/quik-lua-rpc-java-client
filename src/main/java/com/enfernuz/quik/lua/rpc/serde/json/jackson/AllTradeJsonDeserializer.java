package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.events.api.structures.AllTrade;
import com.enfernuz.quik.lua.rpc.events.api.structures.DateTimeEntry;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

public final class AllTradeJsonDeserializer extends JsonDeserializer<AllTrade> {

    @Override
    public AllTrade deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext)
            throws IOException {

        final ObjectCodec objectCodec = jsonParser.getCodec();
        final JsonNode node = objectCodec.readTree(jsonParser);

        return AllTrade
                .builder()
                .tradeNum( node.get("trade_num").asLong() )
                .flags( node.get("flags").asInt() )
                .price( node.get("price").asText() )
                .qty( node.get("qty").asInt() )
                .value( asText(node, "value") )
                .accruedInt( asText(node, "accruedint") )
                .yield( asText(node, "yield") )
                .settleCode( asText(node, "settlecode") )
                .repoRate( asText(node, "reporate") )
                .repoValue( asText(node, "repovalue") )
                .repo2Value( asText(node, "repo2value") )
                .repoTerm( asText(node, "repoterm") )
                .secCode( asText(node, "sec_code") )
                .classCode( asText(node, "class_code") )
                .dateTime( node.get("datetime").traverse(objectCodec).readValueAs(DateTimeEntry.class) )
                .period( node.get("period").asInt() )
                .openInterest( asText(node, "open_interest") )
                .exchangeCode( asText(node, "exchange_code") )
                .build();
    }
}
