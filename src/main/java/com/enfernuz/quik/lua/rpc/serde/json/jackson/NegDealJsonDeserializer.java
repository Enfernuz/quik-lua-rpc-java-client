package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.events.api.structures.NegDeal;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

final class NegDealJsonDeserializer extends JsonDeserializer<NegDeal> {

    @Override
    public NegDeal deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final ObjectCodec objectCodec = p.getCodec();
        final JsonNode node = objectCodec.readTree(p);

        return NegDeal.builder()
                .negDealNum( node.get("neg_deal_num").asLong() )
                .negDealTime( asText(node, "neg_deal_time") )
                .flags( node.get("flags").asInt() )
                .brokerRef( asText(node, "brokerref") )
                .userId( asText(node, "userid") )
                .firmId( asText(node, "firmid") )
                .cpUserId( asText(node, "cpuserid") )
                .cpFirmId( asText(node, "cpfirmid") )
                .account( asText(node, "account") )
                .price( node.get("price").asText() )
                .qty( node.get("qty").asInt() )
                .matchRef( asText(node, "matchref") )
                .settleCode( asText(node, "settlecode") )
                .yield( asText(node, "yield") )
                .accruedInt( asText(node, "accruedint") )
                .value( asText(node, "value") )
                .price2( asText(node, "price2") )
                .repoRate( asText(node, "reporate") )
                .refundRate( asText(node, "refundrate") )
                .transId( asText(node, "trans_id") )
                .clientCode( asText(node, "client_code") )
                .repoEntry( node.get("repoentry").asInt() )
                .repoValue( asText(node, "repovalue") )
                .repo2Value( asText(node, "repo2value") )
                .repoTerm( asText(node, "repoterm") )
                .startDiscount( asText(node, "start_discount") )
                .lowerDiscount( asText(node, "lower_discount") )
                .upperDiscount( asText(node, "upper_discount") )
                .blockSecurities( asText(node, "block_securities") )
                .uid( asText(node, "uid") )
                .withdrawTime( asText(node, "withdraw_time") )
                .negDealDate( asText(node, "neg_deal_date") )
                .balance( asText(node, "balance") )
                .originRepoValue( asText(node, "origin_repovalue") )
                .originQty( asText(node, "origin_qty") )
                .originDiscount( asText(node, "origin_discount") )
                .negDealActivationDate( asText(node, "neg_deal_activation_date") )
                .negDealActivationTime( asText(node, "neg_deal_activation_time") )
                .quoteNo( asText(node, "quoteno") )
                .settleCurrency( asText(node, "settle_currency") )
                .secCode( asText(node, "sec_code") )
                .classCode( asText(node, "class_code") )
                .bankAccId( asText(node, "bank_acc_id") )
                .withdrawDate( asText(node, "withdraw_date") )
                .linkedOrder( asText(node, "linkedorder") )
                .activationDateTime( node.get("activation_date_time") == null ? null : node.get("activation_date_time").traverse(objectCodec).readValueAs(DateTimeEntry.class) )
                .withdrawDateTime( node.get("withdraw_date_time") == null ? null : node.get("withdraw_date_time").traverse(objectCodec).readValueAs(DateTimeEntry.class) )
                .dateTime( node.get("date_time").traverse(objectCodec).readValueAs(DateTimeEntry.class) )
                .build();
    }
}
