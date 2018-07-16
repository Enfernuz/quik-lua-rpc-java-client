package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.events.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.events.api.structures.StopOrder;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

final class StopOrderJsonDeserializer extends JsonDeserializer<StopOrder> {

    @Override
    public StopOrder deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final ObjectCodec objectCodec = p.getCodec();
        final JsonNode node = objectCodec.readTree(p);

        return StopOrder.builder()
                .orderNum( node.get("order_num").asLong() )
                .orderTime( asText(node, "ordertime") )
                .flags( node.get("flags").asInt() )
                .brokerRef( asText(node, "brokerref") )
                .firmId( asText(node, "firmid") )
                .account( asText(node, "account") )
                .condition( node.get("condition").asInt() )
                .conditionPrice( asText(node, "condition_price") )
                .price( node.get("price").asText() )
                .qty( node.get("qty").asInt() )
                .linkedOrder( asText(node, "linkedorder") )
                .expiry( asText(node, "expiry") )
                .transId( asText(node, "trans_id") )
                .clientCode( asText(node, "client_code") )
                .coOrderNum( asText(node, "co_order_num") )
                .coOrderPrice( asText(node, "co_order_price") )
                .stopOrderType( node.get("stop_order_type").asInt() )
                .orderDate( asText(node, "orderdate") )
                .allTradeNum( asText(node, "alltrade_num") )
                .stopFlags( node.get("stopflags").asInt() )
                .offset( asText(node, "offset") )
                .spread( asText(node, "spread") )
                .balance( asText(node, "balance") )
                .uid( asText(node, "uid") )
                .filledQty( node.get("filled_qty").asInt() )
                .withdrawTime( asText(node, "withdraw_time") )
                .conditionPrice2( asText(node, "condition_price2") )
                .activeFromTime( asText(node, "active_from_time") )
                .activeToTime( asText(node, "active_to_time") )
                .secCode( asText(node, "sec_code") )
                .classCode( asText(node, "class_code") )
                .conditionSecCode( asText(node, "condition_sec_code") )
                .conditionClassCode( asText(node, "condition_class_code") )
                .canceledUid( asText(node, "canceled_uid") )
                .orderDateTime( node.get("order_date_time").traverse(objectCodec).readValueAs(DateTimeEntry.class) )
                .withdrawDateTime( node.get("withdraw_datetime") == null ? null : node.get("withdraw_datetime").traverse(objectCodec).readValueAs(DateTimeEntry.class) )
                .build();
    }
}
