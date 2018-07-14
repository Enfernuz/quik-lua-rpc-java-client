package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.events.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.events.api.structures.Order;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

final class OrderJsonDeserializer extends JsonDeserializer<Order> {

    @Override
    public Order deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final ObjectCodec objectCodec = p.getCodec();
        final JsonNode node = objectCodec.readTree(p);

        return Order
                .builder()
                .orderNum( node.get("order_num").asLong() )
                .flags( node.get("flags").asInt() )
                .brokerRef( asText(node, "brokerref") )
                .userId( asText(node, "userid") )
                .firmId( asText(node, "firmid") )
                .account( asText(node, "account") )
                .price( asText(node, "price") )
                .qty( node.get("qty").asInt() )
                .balance( asText(node, "balance") )
                .value( asText(node, "value") )
                .accruedInt( asText(node, "accruedint") )
                .yield( asText(node, "yield") )
                .transId( asText(node, "trans_id") )
                .clientCode( asText(node, "client_code") )
                .price2( asText(node, "price2") )
                .settleCode( asText(node, "settlecode") )
                .uid( asText(node, "uid") )
                .canceledUid( asText(node, "canceled_uid") )
                .exchangeCode( asText(node, "exchange_code") )
                .activationTime( asText(node, "activation_time") )
                .linkedOrder( asText(node, "linkedorder") )
                .expiry( asText(node, "expiry") )
                .secCode( asText(node, "sec_code") )
                .classCode( asText(node, "class_code") )
                .datetime( node.get("datetime").traverse(objectCodec).readValueAs(DateTimeEntry.class) )
                .withdrawDatetime( node.get("withdraw_datetime") == null ? null : node.get("withdraw_datetime").traverse(objectCodec).readValueAs(DateTimeEntry.class) )
                .bankAccId( asText(node, "bank_acc_id") )
                .valueEntryType( node.get("value_entry_type").asInt() )
                .repoTerm( asText(node, "repoterm") )
                .repoValue( asText(node, "repovalue") )
                .repo2Value( asText(node, "repo2value") )
                .repoValueBalance( asText(node, "repo_value_balance") )
                .startDiscount( asText(node, "start_discount") )
                .rejectReason( asText(node, "reject_reason") )
                .extOrderFlags( asText(node, "ext_order_flags") )
                .minQty( node.get("min_qty").asInt() )
                .execType( node.get("exec_type").asInt() )
                .sideQualifier( node.get("side_qualifier").asInt() )
                .acntType( node.get("acnt_type").asInt() )
                .capacity( node.get("capacity").asInt() )
                .passiveOnlyOrder( node.get("passive_only_order").asInt() )
                .visible( node.get("visible").asInt() )
                .build();
    }
}
