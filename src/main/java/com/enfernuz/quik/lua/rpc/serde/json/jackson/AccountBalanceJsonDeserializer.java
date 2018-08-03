package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.AccountBalance;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

final class AccountBalanceJsonDeserializer extends JsonDeserializer<AccountBalance> {

    @Override
    public AccountBalance deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final JsonNode node = p.getCodec().readTree(p);
        return AccountBalance.builder()
                .firmId( asText(node, "firmid") )
                .secCode( asText(node, "sec_code") )
                .trdAccId( asText(node, "trdaccid") )
                .depAccId( asText(node, "depaccid") )
                .openBal( asText(node, "openbal") )
                .currentPos( asText(node, "currentpos") )
                .plannedPosSell( asText(node, "plannedpossell") )
                .plannedPosBuy( asText(node, "plannedposbuy") )
                .planBal( asText(node, "planbal") )
                .usqtyb( asText(node, "usqtyb") )
                .usqtys( asText(node, "usqtys") )
                .planned( asText(node, "planned") )
                .settleBal( asText(node, "settlebal") )
                .bankAccId( asText(node, "bank_acc_id") )
                .firmUse( node.get("firmuse").asInt() )
                .build();
    }
}
