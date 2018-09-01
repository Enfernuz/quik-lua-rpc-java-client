package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.AccountBalance;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum AccountBalancePbSerde implements Serde<AccountBalance>, PbConverter<QluaStructures.AccountBalance, AccountBalance> {

    INSTANCE;

    @Override
    public byte[] serialize(final AccountBalance accountBalance) {
        return convertToPb(accountBalance).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public AccountBalance deserialize(final byte[] data) {
        return convertFromPb( QluaStructures.AccountBalance.parseFrom(data) );
    }

    @Override
    public AccountBalance convertFromPb(@NotNull final QluaStructures.AccountBalance accountBalance) {

        return AccountBalance
                .builder()
                .firmId( convertFromPbString(accountBalance.getFirmid()) )
                .secCode( convertFromPbString(accountBalance.getSecCode()) )
                .trdAccId( convertFromPbString(accountBalance.getTrdaccid()) )
                .depAccId( convertFromPbString(accountBalance.getDepaccid()) )
                .openBal( convertFromPbString(accountBalance.getOpenbal()) )
                .currentPos( convertFromPbString(accountBalance.getCurrentpos()) )
                .plannedPosSell( convertFromPbString(accountBalance.getPlannedpossell()) )
                .plannedPosBuy( convertFromPbString(accountBalance.getPlannedposbuy()) )
                .planBal( convertFromPbString(accountBalance.getPlanbal()) )
                .usqtyb( convertFromPbString(accountBalance.getUsqtyb()) )
                .usqtys( convertFromPbString(accountBalance.getUsqtys()) )
                .planned( convertFromPbString(accountBalance.getPlanned()) )
                .settleBal( convertFromPbString(accountBalance.getSettlebal()) )
                .bankAccId( convertFromPbString(accountBalance.getBankAccId()) )
                .firmUse( accountBalance.getFirmuse() )
                .build();
    }

    @Override
    public QluaStructures.AccountBalance convertToPb(@NotNull final AccountBalance accountBalance) {

        return QluaStructures.AccountBalance.newBuilder()
                .setFirmid( convertToPbString(accountBalance.getFirmId()) )
                .setSecCode( convertToPbString(accountBalance.getSecCode()) )
                .setTrdaccid( convertToPbString(accountBalance.getTrdAccId()) )
                .setDepaccid( convertToPbString(accountBalance.getDepAccId()) )
                .setOpenbal( convertToPbString(accountBalance.getOpenBal()) )
                .setCurrentpos( convertToPbString(accountBalance.getCurrentPos()) )
                .setPlannedpossell( convertToPbString(accountBalance.getPlannedPosSell()) )
                .setPlannedposbuy( convertToPbString(accountBalance.getPlannedPosBuy()) )
                .setPlanbal( convertToPbString(accountBalance.getPlanBal()) )
                .setUsqtyb( convertToPbString(accountBalance.getUsqtyb()) )
                .setUsqtys( convertToPbString(accountBalance.getUsqtys()) )
                .setPlanned( convertToPbString(accountBalance.getPlanned()) )
                .setSettlebal( convertToPbString(accountBalance.getSettleBal()) )
                .setBankAccId( convertToPbString(accountBalance.getBankAccId()) )
                .setFirmuse( accountBalance.getFirmUse() )
                .build();
    }
}
