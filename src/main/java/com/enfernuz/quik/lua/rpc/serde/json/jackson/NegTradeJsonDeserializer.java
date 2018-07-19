package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.events.api.structures.NegTrade;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

final class NegTradeJsonDeserializer extends JsonDeserializer<NegTrade> {

    @Override
    public NegTrade deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final JsonNode node = p.getCodec().readTree(p);

        return NegTrade.builder()
                .tradeNum( node.get("trade_num").asLong() )
                .tradeDate( asText(node, "trade_date") )
                .settleDate( asText(node, "settle_date") )
                .flags( node.get("flags").asInt() )
                .brokerRef( asText(node, "brokerref") )
                .firmId( asText(node, "firmid") )
                .account( asText(node, "account") )
                .cpFirmId( asText(node, "cpfirmid") )
                .cpAccount( asText(node, "cpaccount") )
                .price( node.get("price").asText() )
                .qty( node.get("qty").asInt() )
                .value( asText(node, "value") )
                .settleCode( asText(node, "settlecode") )
                .reportNum( asText(node, "report_num") )
                .cpReportNum( asText(node, "cpreport_num") )
                .accruedInt( asText(node, "accruedint") )
                .repoTradeNo( asText(node, "repotradeno") )
                .price1( asText(node, "price1") )
                .repoRate( asText(node, "reporate") )
                .price2( asText(node,"price2") )
                .clientCode( asText(node, "client_code") )
                .tsComission( asText(node, "ts_comission") )
                .balance( asText(node, "balance") )
                .settleTime( asText(node, "settle_time") )
                .amount( asText(node, "amount") )
                .repoValue( asText(node, "repovalue") )
                .repoTerm( asText(node, "repoterm") )
                .repo2Value( asText(node, "repo2value") )
                .returnValue( asText(node, "return_value") )
                .discount( asText(node, "discount") )
                .lowerDiscount( asText(node, "lower_discount") )
                .upperDiscount( asText(node, "upper_discount") )
                .blockSecurities( asText(node, "block_securities") )
                .urgencyFlag( asText(node, "urgency_flag") )
                .type( node.get("type").asInt() )
                .operationType( node.get("operation_type").asInt() )
                .expectedDiscount( asText(node, "expected_discount") )
                .expectedQuantity( asText(node, "expected_quantity") )
                .expectedRepoValue( asText(node, "expected_repovalue") )
                .expectedRepo2Value( asText(node, "expected_repo2value") )
                .expectedReturnValue( asText(node, "expected_return_value") )
                .orderNum( asText(node, "order_num") )
                .reportTradeDate( asText(node, "report_trade_date") )
                .settled( node.get("settled").asInt() )
                .clearingType( node.get("clearing_type").asInt() )
                .reportComission( asText(node, "report_comission") )
                .couponPayment( asText(node, "coupon_payment") )
                .principalPayment( asText(node, "principal_payment") )
                .principalPaymentDate( asText(node, "principal_payment_date") )
                .nextDaySettle( asText(node, "nextdaysettle") )
                .settleCurrency( asText(node, "settle_currency") )
                .secCode( asText(node, "sec_code") )
                .classCode( asText(node, "class_code") )
                .compVal( asText(node, "compval") )
                .parentTradeNo( asText(node, "parenttradeno") )
                .bankId( asText(node, "bankid") )
                .bankAccId( asText(node, "bankaccid") )
                .preciseBalance( asText(node, "precisebalance") )
                .confirmTime( asText(node, "confirmtime") )
                .exFlags( node.get("ex_flags").asInt() )
                .confirmReport( asText(node, "confirmreport") )
                .build();
    }
}
