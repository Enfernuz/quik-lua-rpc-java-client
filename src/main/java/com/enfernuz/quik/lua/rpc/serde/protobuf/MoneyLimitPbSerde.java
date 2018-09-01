package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.MoneyLimit;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum MoneyLimitPbSerde implements Serde<MoneyLimit>, PbConverter<QluaStructures.MoneyLimit, MoneyLimit> {

    INSTANCE;

    @Override
    public byte[] serialize(final MoneyLimit moneyLimit) {
        return convertToPb(moneyLimit).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public MoneyLimit deserialize(final byte[] data) {
        return convertFromPb( QluaStructures.MoneyLimit.parseFrom(data) );
    }

    @Override
    public MoneyLimit convertFromPb(@NotNull QluaStructures.MoneyLimit moneyLimit) {

        return MoneyLimit
                .builder()
                .currCode( convertFromPbString(moneyLimit.getCurrcode()) )
                .tag( convertFromPbString(moneyLimit.getTag()) )
                .firmId( convertFromPbString(moneyLimit.getFirmid()) )
                .clientCode( convertFromPbString(moneyLimit.getClientCode()) )
                .openBal( convertFromPbString(moneyLimit.getOpenbal()) )
                .openLimit( convertFromPbString(moneyLimit.getOpenlimit()) )
                .currentBal( convertFromPbString(moneyLimit.getCurrentbal()) )
                .currentLimit( convertFromPbString(moneyLimit.getCurrentlimit()) )
                .locked( convertFromPbString(moneyLimit.getLocked()) )
                .lockedValueCoef( convertFromPbString(moneyLimit.getLockedValueCoef()) )
                .lockedMarginValue( convertFromPbString(moneyLimit.getLockedMarginValue()) )
                .leverage( convertFromPbString(moneyLimit.getLeverage()) )
                .limitKind( moneyLimit.getLimitKind() )
                .build();
    }

    @Override
    public QluaStructures.MoneyLimit convertToPb(@NotNull final MoneyLimit moneyLimit) {

        return QluaStructures.MoneyLimit.newBuilder()
                .setCurrcode( convertToPbString(moneyLimit.getCurrCode()) )
                .setTag( convertToPbString(moneyLimit.getTag()) )
                .setFirmid( convertToPbString(moneyLimit.getFirmId()) )
                .setClientCode( convertToPbString(moneyLimit.getClientCode()) )
                .setOpenbal( convertToPbString(moneyLimit.getOpenBal()) )
                .setOpenlimit( convertToPbString(moneyLimit.getOpenLimit()) )
                .setCurrentbal( convertToPbString(moneyLimit.getCurrentBal()) )
                .setCurrentlimit( convertToPbString(moneyLimit.getCurrentLimit()) )
                .setLocked( convertToPbString(moneyLimit.getLocked()) )
                .setLockedValueCoef( convertToPbString(moneyLimit.getLockedValueCoef()) )
                .setLockedMarginValue( convertToPbString(moneyLimit.getLockedMarginValue()) )
                .setLeverage( convertToPbString(moneyLimit.getLeverage()) )
                .setLimitKind( moneyLimit.getLimitKind() )
                .build();
    }
}
