package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.NegTrade;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum NegTradePbDeserializer implements Deserializer<NegTrade>, FromPbConverter<QluaStructures.NegTrade, NegTrade> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public NegTrade deserialize(final byte[] data) {
        return convert(QluaStructures.NegTrade.parseFrom(data));
    }

    @Override
    public NegTrade convert(@NotNull QluaStructures.NegTrade negTrade) {

        return NegTrade.builder()
                .tradeNum( negTrade.getTradeNum() )
                .tradeDate( convertFromPbString(negTrade.getTradeDate()) )
                .settleDate( convertFromPbString(negTrade.getSettleDate()) )
                .flags( negTrade.getFlags() )
                .brokerRef( convertFromPbString(negTrade.getBrokerref()) )
                .firmId( convertFromPbString(negTrade.getFirmid()) )
                .account( convertFromPbString(negTrade.getAccount()) )
                .cpFirmId( convertFromPbString(negTrade.getCpfirmid()) )
                .cpAccount( convertFromPbString(negTrade.getCpaccount()) )
                .price( convertFromPbString(negTrade.getPrice()) )
                .qty( negTrade.getQty() )
                .value( convertFromPbString(negTrade.getValue()) )
                .settleCode( convertFromPbString(negTrade.getSettlecode()) )
                .reportNum( convertFromPbString(negTrade.getReportNum()) )
                .cpReportNum( convertFromPbString(negTrade.getCpreportNum()) )
                .accruedInt( convertFromPbString(negTrade.getAccruedint()) )
                .repoTradeNo( convertFromPbString(negTrade.getRepotradeno()) )
                .price1( convertFromPbString(negTrade.getPrice1()) )
                .repoRate( convertFromPbString(negTrade.getReporate()) )
                .price2( convertFromPbString(negTrade.getPrice2()) )
                .clientCode( convertFromPbString(negTrade.getClientCode()) )
                .tsComission( convertFromPbString(negTrade.getTsComission()) )
                .balance( convertFromPbString(negTrade.getBalance()) )
                .settleTime( convertFromPbString(negTrade.getSettleTime()) )
                .amount( convertFromPbString(negTrade.getAmount()) )
                .repoValue( convertFromPbString(negTrade.getRepovalue()) )
                .repoTerm( convertFromPbString(negTrade.getRepoterm()) )
                .repo2Value( convertFromPbString(negTrade.getRepo2Value()) )
                .returnValue( convertFromPbString(negTrade.getReturnValue()) )
                .discount( convertFromPbString(negTrade.getDiscount()) )
                .lowerDiscount( convertFromPbString(negTrade.getLowerDiscount()) )
                .upperDiscount( convertFromPbString(negTrade.getUpperDiscount()) )
                .blockSecurities( convertFromPbString(negTrade.getBlockSecurities()) )
                .urgencyFlag( convertFromPbString(negTrade.getUrgencyFlag()) )
                .type( negTrade.getType() )
                .operationType( negTrade.getOperationType() )
                .expectedDiscount( convertFromPbString(negTrade.getExpectedDiscount()) )
                .expectedQuantity( convertFromPbString(negTrade.getExpectedQuantity()) )
                .expectedRepoValue( convertFromPbString(negTrade.getExpectedRepovalue()) )
                .expectedRepo2Value( convertFromPbString(negTrade.getExpectedRepo2Value()) )
                .expectedReturnValue( convertFromPbString(negTrade.getExpectedReturnValue()) )
                .orderNum( convertFromPbString(negTrade.getOrderNum()) )
                .reportTradeDate( convertFromPbString(negTrade.getReportTradeDate()) )
                .settled( negTrade.getSettled() )
                .clearingType( negTrade.getClearingType() )
                .reportComission( convertFromPbString(negTrade.getReportComission()) )
                .couponPayment( convertFromPbString(negTrade.getCouponPayment()) )
                .principalPayment( convertFromPbString(negTrade.getPrincipalPayment()) )
                .principalPaymentDate( convertFromPbString(negTrade.getPrincipalPaymentDate()) )
                .nextDaySettle( convertFromPbString(negTrade.getNextdaysettle()) )
                .settleCurrency( convertFromPbString(negTrade.getSettleCurrency()) )
                .secCode( convertFromPbString(negTrade.getSecCode()) )
                .classCode( convertFromPbString(negTrade.getClassCode()) )
                .compVal( convertFromPbString(negTrade.getCompval()) )
                .parentTradeNo( convertFromPbString(negTrade.getParenttradeno()) )
                .bankId( convertFromPbString(negTrade.getBankid()) )
                .bankAccId( convertFromPbString(negTrade.getBankaccid()) )
                .preciseBalance( convertFromPbString(negTrade.getPrecisebalance()) )
                .confirmTime( convertFromPbString(negTrade.getConfirmtime()) )
                .exFlags( negTrade.getExFlags() )
                .confirmReport( convertFromPbString(negTrade.getConfirmreport()) )
                .extRef( convertFromPbString(negTrade.getExtref()) )
                .build();
    }
}
