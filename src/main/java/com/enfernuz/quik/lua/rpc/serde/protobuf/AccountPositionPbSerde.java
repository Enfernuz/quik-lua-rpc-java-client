package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.AccountPosition;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum AccountPositionPbSerde implements Deserializer<AccountPosition>, PbConverter<QluaStructures.AccountPosition, AccountPosition> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public AccountPosition deserialize(final byte[] data) {
        return convertFromPb( QluaStructures.AccountPosition.parseFrom(data) );
    }

    @Override
    public AccountPosition convertFromPb(@NotNull final QluaStructures.AccountPosition accountPosition) {

        return AccountPosition
                .builder()
                .firmId( convertFromPbString(accountPosition.getFirmid()) )
                .currCode( convertFromPbString(accountPosition.getCurrcode()) )
                .tag( convertFromPbString(accountPosition.getTag()) )
                .description( convertFromPbString(accountPosition.getDescription()) )
                .openBal( convertFromPbString(accountPosition.getOpenbal()) )
                .currentPos( convertFromPbString(accountPosition.getCurrentpos()) )
                .plannedPos( convertFromPbString(accountPosition.getPlannedpos()) )
                .limit1( convertFromPbString(accountPosition.getLimit1()) )
                .limit2( convertFromPbString(accountPosition.getLimit2()) )
                .orderBuy( convertFromPbString(accountPosition.getOrderbuy()) )
                .orderSell( convertFromPbString(accountPosition.getOrdersell()) )
                .netto( convertFromPbString(accountPosition.getNetto()) )
                .plannedBal( convertFromPbString(accountPosition.getPlannedbal()) )
                .debit( convertFromPbString(accountPosition.getDebit()) )
                .credit( convertFromPbString(accountPosition.getCredit()) )
                .bankAccId( convertFromPbString(accountPosition.getBankAccId()) )
                .marginCall( convertFromPbString(accountPosition.getMargincall()) )
                .settleBal( convertFromPbString(accountPosition.getSettlebal()) )
                .build();
    }

    @Override
    public QluaStructures.AccountPosition convertToPb(@NotNull final AccountPosition accountPosition) {

        return QluaStructures.AccountPosition.newBuilder()
                .setFirmid( convertToPbString(accountPosition.getFirmId()) )
                .setCurrcode( convertToPbString(accountPosition.getCurrCode()) )
                .setTag( convertToPbString(accountPosition.getTag()) )
                .setDescription( convertToPbString(accountPosition.getDescription()) )
                .setOpenbal( convertToPbString(accountPosition.getOpenBal()) )
                .setCurrentpos( convertToPbString(accountPosition.getCurrentPos()) )
                .setPlannedpos( convertToPbString(accountPosition.getPlannedPos()) )
                .setLimit1( convertToPbString(accountPosition.getLimit1()) )
                .setLimit2( convertToPbString(accountPosition.getLimit2()) )
                .setOrderbuy( convertToPbString(accountPosition.getOrderBuy()) )
                .setOrdersell( convertToPbString(accountPosition.getOrderSell()) )
                .setNetto( convertToPbString(accountPosition.getNetto()) )
                .setPlannedbal( convertToPbString(accountPosition.getPlannedBal()) )
                .setDebit( convertToPbString(accountPosition.getDebit()) )
                .setCredit( convertToPbString(accountPosition.getCredit()) )
                .setBankAccId( convertToPbString(accountPosition.getBankAccId()) )
                .setMargincall( convertToPbString(accountPosition.getMarginCall()) )
                .setSettlebal( convertToPbString(accountPosition.getSettleBal()) )
                .build();
    }


}
