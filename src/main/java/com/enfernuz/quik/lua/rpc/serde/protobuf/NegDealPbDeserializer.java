package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.NegDeal;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbDateTimeEntry;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum NegDealPbDeserializer implements Deserializer<NegDeal>, FromPbConverter<QluaStructures.NegDeal, NegDeal> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public NegDeal deserialize(final byte[] data) {
        return convert(QluaStructures.NegDeal.parseFrom(data));
    }

    @Override
    public NegDeal convert(@NotNull QluaStructures.NegDeal negDeal) {

        final NegDeal.NegDealBuilder result = NegDeal.builder()
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
                .linkedOrder( convertFromPbString(negDeal.getLinkedorder()) );

        if (negDeal.hasActivationDateTime()) {
            result.activationDateTime( convertFromPbDateTimeEntry(negDeal.getActivationDateTime()) );
        }

        if (negDeal.hasWithdrawDateTime()) {
            result.withdrawDateTime( convertFromPbDateTimeEntry(negDeal.getWithdrawDateTime()) );
        }

        if (negDeal.hasDateTime()) {
            result.dateTime( convertFromPbDateTimeEntry(negDeal.getDateTime()) );
        }

        return result.build();
    }
}
