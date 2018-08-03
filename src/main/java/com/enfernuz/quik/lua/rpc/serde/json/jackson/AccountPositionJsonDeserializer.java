package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.AccountPosition;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

final class AccountPositionJsonDeserializer extends JsonDeserializer<AccountPosition> {

    @Override
    public AccountPosition deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final JsonNode node = p.getCodec().readTree(p);
        return AccountPosition
                .builder()
                .firmId( asText(node, "firmid") )
                .currCode( asText(node, " currcode") )
                .tag( asText(node, "tag") )
                .description( asText(node, "description") )
                .openBal( asText(node, "openbal") )
                .currentPos( asText(node, "currentpos") )
                .plannedPos( asText(node, "plannedpos") )
                .limit1( asText(node, "limit1") )
                .limit2( asText(node, "limit2") )
                .orderBuy( asText(node, "orderbuy") )
                .orderSell( asText(node, "ordersell") )
                .netto( asText(node, "netto") )
                .plannedBal( asText(node, "plannedbal") )
                .debit( asText(node, "debit") )
                .credit( asText(node, "credit") )
                .bankAccId( asText(node, "bank_acc_id") )
                .marginCall( asText(node, "margincall") )
                .settleBal( asText(node, "settlebal") )
                .build();
    }
}
