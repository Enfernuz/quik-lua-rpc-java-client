package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.MoneyLimitDelete;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum MoneyLimitDeletePbSerde implements Serde<MoneyLimitDelete>, PbConverter<QluaStructures.MoneyLimitDelete, MoneyLimitDelete> {

    INSTANCE;

    @Override
    public byte[] serialize(final MoneyLimitDelete moneyLimitDelete) {
        return convertToPb(moneyLimitDelete).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public MoneyLimitDelete deserialize(final byte[] data) {
        return convertFromPb(QluaStructures.MoneyLimitDelete.parseFrom(data));
    }

    @Override
    public MoneyLimitDelete convertFromPb(@NotNull QluaStructures.MoneyLimitDelete moneyLimitDelete) {

        return MoneyLimitDelete.builder()
                .currCode( convertFromPbString(moneyLimitDelete.getCurrcode()) )
                .tag( convertFromPbString(moneyLimitDelete.getTag()) )
                .clientCode( convertFromPbString(moneyLimitDelete.getClientCode()) )
                .firmId( convertFromPbString(moneyLimitDelete.getFirmid()) )
                .limitKind( moneyLimitDelete.getLimitKind() )
                .build();
    }

    @Override
    public QluaStructures.MoneyLimitDelete convertToPb(@NotNull final MoneyLimitDelete moneyLimitDelete) {

        return QluaStructures.MoneyLimitDelete.newBuilder()
                .setCurrcode( convertToPbString(moneyLimitDelete.getCurrCode()) )
                .setTag( convertToPbString(moneyLimitDelete.getTag()) )
                .setClientCode( convertToPbString(moneyLimitDelete.getClientCode()) )
                .setFirmid( convertToPbString(moneyLimitDelete.getFirmId()) )
                .setLimitKind( moneyLimitDelete.getLimitKind() )
                .build();
    }
}
