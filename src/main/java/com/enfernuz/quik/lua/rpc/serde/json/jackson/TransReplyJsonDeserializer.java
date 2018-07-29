package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.events.api.structures.TransReply;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

final class TransReplyJsonDeserializer extends JsonDeserializer<TransReply> {

    @Override
    public TransReply deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final ObjectCodec objectCodec = p.getCodec();
        final JsonNode node = objectCodec.readTree(p);

        return TransReply.builder()
                .transId( node.get("trans_id").asLong() )
                .status( node.get("status").asInt() )
                .resultMsg( asText(node, "result_msg") )
                .dateTime( node.get("date_time").traverse(objectCodec).readValueAs(DateTimeEntry.class) )
                .uid( node.get("uid").asText() )
                .flags( node.get("flags").asInt() )
                .serverTransId( asText(node, "server_trans_id") )
                .orderNum( asText(node, "order_num") )
                .price( asText(node, "price") )
                .quantity( asText(node, "quantity") )
                .balance( asText(node, "balance") )
                .firmId( asText(node, "firm_id") )
                .account( asText(node, "account") )
                .clientCode( asText(node, "client_code") )
                .brokerRef( asText(node, "brokerref") )
                .classCode( asText(node, "class_code") )
                .secCode( asText(node, "sec_code") )
                .exchangeCode( asText(node, "exchange_code") )
                .build();
    }
}
