package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.api.structures.NegDeal;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.*;

enum NegDealPbSerde implements Serde<NegDeal>, PbConverter<QluaStructures.NegDeal, NegDeal> {

    INSTANCE;

    @Override
    public byte[] serialize(final NegDeal negDeal) {
        return convertToPb(negDeal).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public NegDeal deserialize(final byte[] data) {
        return convertFromPb(QluaStructures.NegDeal.parseFrom(data));
    }

    @Override
    public NegDeal convertFromPb(@NotNull QluaStructures.NegDeal negDeal) {

        return NegDeal.builder()
                .negDealNum( negDeal.getNegDealNum() )
                .negDealTime( convertFromPbString(negDeal.getNegDealTime()) )
                .flags( negDeal.getFlags() )
                .brokerRef( convertFromPbString(negDeal.getBrokerref()) )
                .userId( convertFromPbString(negDeal.getUserid()) )
                .firmId( convertFromPbString(negDeal.getFirmid()) )
                .cpUserId( convertFromPbString(negDeal.getCpuserid()) )
                .cpFirmId( convertFromPbString(negDeal.getCpfirmid()) )
                .account( convertFromPbString(negDeal.getAccount()) )
                .price( convertFromPbString(negDeal.getPrice()) )
                .qty( negDeal.getQty() )
                .matchRef( convertFromPbString(negDeal.getMatchref()) )
                .settleCode( convertFromPbString(negDeal.getSettlecode()) )
                .yield( convertFromPbString(negDeal.getYield()) )
                .accruedInt( convertFromPbString(negDeal.getAccruedint()) )
                .value( convertFromPbString(negDeal.getValue()) )
                .price2( convertFromPbString(negDeal.getPrice2()) )
                .repoRate( convertFromPbString(negDeal.getReporate()) )
                .refundRate( convertFromPbString(negDeal.getRefundrate()) )
                .transId( convertFromPbString(negDeal.getTransId()) )
                .clientCode( convertFromPbString(negDeal.getClientCode()) )
                .repoEntry( negDeal.getRepoentry() )
                .repoValue( convertFromPbString(negDeal.getRepovalue()) )
                .repo2Value( convertFromPbString(negDeal.getRepo2Value()) )
                .repoTerm( convertFromPbString(negDeal.getRepoterm()) )
                .startDiscount( convertFromPbString(negDeal.getStartDiscount()) )
                .lowerDiscount( convertFromPbString(negDeal.getLowerDiscount()) )
                .upperDiscount( convertFromPbString(negDeal.getUpperDiscount()) )
                .blockSecurities( convertFromPbString(negDeal.getBlockSecurities()) )
                .uid( convertFromPbString(negDeal.getUid()) )
                .withdrawTime( convertFromPbString(negDeal.getWithdrawTime()) )
                .negDealDate( convertFromPbString(negDeal.getNegDealDate()) )
                .balance( convertFromPbString(negDeal.getBalance()) )
                .originRepoValue( convertFromPbString(negDeal.getOriginRepovalue()) )
                .originQty( convertFromPbString(negDeal.getOriginQty()) )
                .originDiscount( convertFromPbString(negDeal.getOriginDiscount()) )
                .negDealActivationDate( convertFromPbString(negDeal.getNegDealActivationDate()) )
                .negDealActivationTime( convertFromPbString(negDeal.getNegDealActivationTime()) )
                .quoteNo( convertFromPbString(negDeal.getQuoteno()) )
                .settleCurrency( convertFromPbString(negDeal.getSettleCurrency()) )
                .secCode( convertFromPbString(negDeal.getSecCode()) )
                .classCode( convertFromPbString(negDeal.getClassCode()) )
                .bankAccId( convertFromPbString(negDeal.getBankAccId()) )
                .withdrawDate( convertFromPbString(negDeal.getWithdrawDate()) )
                .linkedOrder( convertFromPbString(negDeal.getLinkedorder()) )
                .activationDateTime( convertFromPbDateTimeEntry(negDeal.getActivationDateTime()) )
                .withdrawDateTime( convertFromPbDateTimeEntry(negDeal.getWithdrawDateTime()) )
                .dateTime( convertFromPbDateTimeEntry(negDeal.getDateTime()) )
                .build();
    }

    @Override
    public QluaStructures.NegDeal convertToPb(@NotNull final NegDeal negDeal) {

        final QluaStructures.NegDeal.Builder result = QluaStructures.NegDeal.newBuilder()
                .setNegDealNum( negDeal.getNegDealNum() )
                .setNegDealTime( convertToPbString(negDeal.getNegDealTime()) )
                .setFlags( negDeal.getFlags() )
                .setBrokerref( convertToPbString(negDeal.getBrokerRef()) )
                .setUserid( convertToPbString(negDeal.getUserId()) )
                .setFirmid( convertToPbString(negDeal.getFirmId()) )
                .setCpuserid( convertToPbString(negDeal.getCpUserId()) )
                .setCpfirmid( convertToPbString(negDeal.getCpFirmId()) )
                .setAccount( convertToPbString(negDeal.getAccount()) )
                .setPrice( convertToPbString(negDeal.getPrice()) )
                .setQty( negDeal.getQty() )
                .setMatchref( convertToPbString(negDeal.getMatchRef()) )
                .setSettlecode( convertToPbString(negDeal.getSettleCode()) )
                .setYield( convertToPbString(negDeal.getYield()) )
                .setAccruedint( convertToPbString(negDeal.getAccruedInt()) )
                .setValue( convertToPbString(negDeal.getValue()) )
                .setPrice2( convertToPbString(negDeal.getPrice2()) )
                .setReporate( convertToPbString(negDeal.getRepoRate()) )
                .setRefundrate( convertToPbString(negDeal.getRefundRate()) )
                .setTransId( convertToPbString(negDeal.getTransId()) )
                .setClientCode( convertToPbString(negDeal.getClientCode()) )
                .setRepoentry( negDeal.getRepoEntry() )
                .setRepovalue( convertToPbString(negDeal.getRepoValue()) )
                .setRepo2Value( convertToPbString(negDeal.getRepo2Value()) )
                .setRepoterm( convertToPbString(negDeal.getRepoTerm()) )
                .setStartDiscount( convertToPbString(negDeal.getStartDiscount()) )
                .setLowerDiscount( convertToPbString(negDeal.getLowerDiscount()) )
                .setUpperDiscount( convertToPbString(negDeal.getUpperDiscount()) )
                .setBlockSecurities( convertToPbString(negDeal.getBlockSecurities()) )
                .setUid( convertToPbString(negDeal.getUid()) )
                .setWithdrawTime( convertToPbString(negDeal.getWithdrawTime()) )
                .setNegDealDate( convertToPbString(negDeal.getNegDealDate()) )
                .setBalance( convertToPbString(negDeal.getBalance()) )
                .setOriginRepovalue( convertToPbString(negDeal.getOriginRepoValue()) )
                .setOriginQty( convertToPbString(negDeal.getOriginQty()) )
                .setOriginDiscount( convertToPbString(negDeal.getOriginDiscount()) )
                .setNegDealActivationDate( convertToPbString(negDeal.getNegDealActivationDate()) )
                .setNegDealActivationTime( convertToPbString(negDeal.getNegDealActivationTime()) )
                .setQuoteno( convertToPbString(negDeal.getQuoteNo()) )
                .setSettleCurrency( convertToPbString(negDeal.getSettleCurrency()) )
                .setSecCode( convertToPbString(negDeal.getSecCode()) )
                .setClassCode( convertToPbString(negDeal.getClassCode()) )
                .setBankAccId( convertToPbString(negDeal.getBankAccId()) )
                .setWithdrawDate( convertToPbString(negDeal.getWithdrawDate()) )
                .setLinkedorder( convertToPbString(negDeal.getLinkedOrder()) );

        final DateTimeEntry activationDateTime = negDeal.getActivationDateTime();
        if (activationDateTime != null) {
            result.setActivationDateTime( convertToPbDateTimeEntry(activationDateTime) );
        }

        final DateTimeEntry withdrawDateTime = negDeal.getWithdrawDateTime();
        if (withdrawDateTime != null) {
            result.setWithdrawDateTime( convertToPbDateTimeEntry(withdrawDateTime) );
        }

        final DateTimeEntry dateTime = negDeal.getDateTime();
        if (dateTime != null) {
            result.setDateTime( convertToPbDateTimeEntry(dateTime) );
        }

        return result.build();
    }
}
