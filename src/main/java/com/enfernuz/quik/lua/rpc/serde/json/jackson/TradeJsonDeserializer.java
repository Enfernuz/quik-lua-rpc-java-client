package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.events.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.events.api.structures.Trade;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

final class TradeJsonDeserializer extends JsonDeserializer<Trade> {

    @Override
    public Trade deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final ObjectCodec objectCodec = p.getCodec();
        final JsonNode node = objectCodec.readTree(p);

        return Trade
                .builder()
                .tradeNum( node.get("trade_num").asLong() )
                .orderNum( node.get("order_num").asLong() )
                .brokerRef( asText(node, "brokerref") )
                .userId( asText(node, "userid") )
                .firmId( asText(node, "firmid") )
                .canceledUid( asText(node, "canceled_uid") )
                .account( asText(node, "account") )
                .price( node.get("price").asText() )
                .qty( node.get("qty").asInt() )
                .value( node.get("value").asText() )
                .accruedInt( asText(node, "accruedint") )
                .yield( asText(node, "yield") )
                .settleCode( asText(node, "settlecode") )
                .cpFirmId( asText(node, "cpfirmid") )
                .flags( node.get("flags").asInt() )
                .price2( asText(node, "price2") )
                .repoRate( asText(node, "reporate") )
                .clientCode( asText(node, "client_code") )
                .accrued2( asText(node, "accrued2") )
                .repoTerm( asText(node, "repoterm") )
                .repoValue( asText(node, "repovalue") )
                .repo2Value( asText(node, "repo2value") )
                .startDiscount( asText(node, "start_discount") )
                .lowerDiscount( asText(node, "lower_discount") )
                .upperDiscount( asText(node, "upper_discount") )
                .blockSecurities( asText(node, "block_securities") )
                .clearingComission( asText(node, "clearing_comission") )
                .exchangeComission( asText(node, "exchange_comission") )
                .techCenterComission( asText(node, "tech_center_comission") )
                .settleDate( asText(node, "settle_date") )
                .settleCurrency( asText(node, "settle_currency") )
                .tradeCurrency( asText(node, "trade_currency") )
                .exchangeCode( asText(node, "exchange_code") )
                .stationId( asText(node, "station_id") )
                .secCode( asText(node, "sec_code") )
                .classCode( asText(node, "class_code") )
                .datetime( node.get("datetime").traverse(objectCodec).readValueAs(DateTimeEntry.class) )
                .bankAccId( asText(node, "bank_acc_id") )
                .brokerComission( asText(node, "broker_comission") )
                .linkedTrade( asText(node, "linked_trade") )
                .period( node.get("period").asInt() )
                .transId( asText(node, "trans_id") )
                .kind( node.get("kind").asInt() )
                .clearingBankAccId( asText(node, "clearing_bank_accid") )
                .canceledDatetime(node.hasNonNull("canceled_datetime") ? node.get("canceled_datetime").traverse(objectCodec).readValueAs(DateTimeEntry.class) : null)
                .clearingFirmId( asText(node, "clearing_firmid") )
                .systemRef( asText(node, "system_ref") )
                .uid( asText(node, "uid") )
                .build();
    }
}
