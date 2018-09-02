package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.NegTrade;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum NegTradePbSerde implements Serde<NegTrade>, PbConverter<QluaStructures.NegTrade, NegTrade> {

    INSTANCE;

    @Override
    public byte[] serialize(final NegTrade negTrade) {
        return convertToPb(negTrade).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public NegTrade deserialize(final byte[] data) {
        return convertFromPb(QluaStructures.NegTrade.parseFrom(data));
    }

    @Override
    public NegTrade convertFromPb(@NotNull QluaStructures.NegTrade negTrade) {

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
                .build();
    }

    @Override
    public QluaStructures.NegTrade convertToPb(@NotNull final NegTrade negTrade) {

        return QluaStructures.NegTrade.newBuilder()
                .setTradeNum( negTrade.getTradeNum() )
                .setTradeDate( convertToPbString(negTrade.getTradeDate()) )
                .setSettleDate( convertToPbString(negTrade.getSettleDate()) )
                .setFlags( negTrade.getFlags() )
                .setBrokerref( convertToPbString(negTrade.getBrokerRef()) )
                .setFirmid( convertToPbString(negTrade.getFirmId()) )
                .setAccount( convertToPbString(negTrade.getAccount()) )
                .setCpfirmid( convertToPbString(negTrade.getCpFirmId()) )
                .setCpaccount( convertToPbString(negTrade.getCpAccount()) )
                .setPrice( convertToPbString(negTrade.getPrice()) )
                .setQty( negTrade.getQty() )
                .setValue( convertToPbString(negTrade.getValue()) )
                .setSettlecode( convertToPbString(negTrade.getSettleCode()) )
                .setReportNum( convertToPbString(negTrade.getReportNum()) )
                .setCpreportNum( convertToPbString(negTrade.getCpReportNum()) )
                .setAccruedint( convertToPbString(negTrade.getAccruedInt()) )
                .setRepotradeno( convertToPbString(negTrade.getRepoTradeNo()) )
                .setPrice1( convertToPbString(negTrade.getPrice1()) )
                .setReporate( convertToPbString(negTrade.getRepoRate()) )
                .setPrice2( convertToPbString(negTrade.getPrice2()) )
                .setClientCode( convertToPbString(negTrade.getClientCode()) )
                .setTsComission( convertToPbString(negTrade.getTsComission()) )
                .setBalance( convertToPbString(negTrade.getBalance()) )
                .setSettleTime( convertToPbString(negTrade.getSettleTime()) )
                .setAmount( convertToPbString(negTrade.getAmount()) )
                .setRepovalue( convertToPbString(negTrade.getRepoValue()) )
                .setRepoterm( convertToPbString(negTrade.getRepoTerm()) )
                .setRepo2Value( convertToPbString(negTrade.getRepo2Value()) )
                .setReturnValue( convertToPbString(negTrade.getReturnValue()) )
                .setDiscount( convertToPbString(negTrade.getDiscount()) )
                .setLowerDiscount( convertToPbString(negTrade.getLowerDiscount()) )
                .setUpperDiscount( convertToPbString(negTrade.getUpperDiscount()) )
                .setBlockSecurities( convertToPbString(negTrade.getBlockSecurities()) )
                .setUrgencyFlag( convertToPbString(negTrade.getUrgencyFlag()) )
                .setType( negTrade.getType() )
                .setOperationType( negTrade.getOperationType() )
                .setExpectedDiscount( convertToPbString(negTrade.getExpectedDiscount()) )
                .setExpectedQuantity( convertToPbString(negTrade.getExpectedQuantity()) )
                .setExpectedRepovalue( convertToPbString(negTrade.getExpectedRepoValue()) )
                .setExpectedRepo2Value( convertToPbString(negTrade.getExpectedRepo2Value()) )
                .setExpectedReturnValue( convertToPbString(negTrade.getExpectedReturnValue()) )
                .setOrderNum( convertToPbString(negTrade.getOrderNum()) )
                .setReportTradeDate( convertToPbString(negTrade.getReportTradeDate()) )
                .setSettled( negTrade.getSettled() )
                .setClearingType( negTrade.getClearingType() )
                .setReportComission( convertToPbString(negTrade.getReportComission()) )
                .setCouponPayment( convertToPbString(negTrade.getCouponPayment()) )
                .setPrincipalPayment( convertToPbString(negTrade.getPrincipalPayment()) )
                .setPrincipalPaymentDate( convertToPbString(negTrade.getPrincipalPaymentDate()) )
                .setNextdaysettle( convertToPbString(negTrade.getNextDaySettle()) )
                .setSettleCurrency( convertToPbString(negTrade.getSettleCurrency()) )
                .setSecCode( convertToPbString(negTrade.getSecCode()) )
                .setClassCode( convertToPbString(negTrade.getClassCode()) )
                .setCompval( convertToPbString(negTrade.getCompVal()) )
                .setParenttradeno( convertToPbString(negTrade.getParentTradeNo()) )
                .setBankid( convertToPbString(negTrade.getBankId()) )
                .setBankaccid( convertToPbString(negTrade.getBankAccId()) )
                .setPrecisebalance( convertToPbString(negTrade.getPreciseBalance()) )
                .setConfirmtime( convertToPbString(negTrade.getConfirmTime()) )
                .setExFlags( negTrade.getExFlags() )
                .setConfirmreport( convertToPbString(negTrade.getConfirmReport()) )
                .build();
    }
}
