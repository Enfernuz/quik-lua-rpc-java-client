package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesLimitDelete;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum FuturesLimitDeletePbSerde implements Serde<FuturesLimitDelete>, PbConverter<QluaStructures.FuturesLimitDelete, FuturesLimitDelete> {

    INSTANCE;

    @Override
    public byte[] serialize(final FuturesLimitDelete futuresLimitDelete) {
        return convertToPb(futuresLimitDelete).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public FuturesLimitDelete deserialize(final byte[] data) {
        return convertFromPb(QluaStructures.FuturesLimitDelete.parseFrom(data));
    }

    @Override
    public FuturesLimitDelete convertFromPb(@NotNull QluaStructures.FuturesLimitDelete futuresLimitDelete) {

        return FuturesLimitDelete.builder()
                .firmId( convertFromPbString(futuresLimitDelete.getFirmid()) )
                .limitType( futuresLimitDelete.getLimitType() )
                .build();
    }

    @Override
    public QluaStructures.FuturesLimitDelete convertToPb(@NotNull final FuturesLimitDelete futuresLimitDelete) {

        return QluaStructures.FuturesLimitDelete.newBuilder()
                .setFirmid( convertToPbString(futuresLimitDelete.getFirmId()) )
                .setLimitType( futuresLimitDelete.getLimitType() )
                .build();
    }
}
