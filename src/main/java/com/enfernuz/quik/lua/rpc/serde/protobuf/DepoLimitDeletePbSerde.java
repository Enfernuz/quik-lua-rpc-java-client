package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DepoLimitDelete;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum DepoLimitDeletePbSerde implements Serde<DepoLimitDelete>, PbConverter<QluaStructures.DepoLimitDelete, DepoLimitDelete> {

    INSTANCE;

    @Override
    public byte[] serialize(final DepoLimitDelete depoLimitDelete) {
        return convertToPb(depoLimitDelete).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public DepoLimitDelete deserialize(final byte[] data) {
        return convertFromPb(QluaStructures.DepoLimitDelete.parseFrom(data));
    }

    @Override
    public DepoLimitDelete convertFromPb(@NotNull QluaStructures.DepoLimitDelete depoLimitDelete) {

        return DepoLimitDelete.builder()
                .secCode( convertFromPbString(depoLimitDelete.getSecCode()) )
                .trdAccId( convertFromPbString(depoLimitDelete.getTrdaccid()) )
                .firmId( convertFromPbString(depoLimitDelete.getFirmid()) )
                .clientCode( convertFromPbString(depoLimitDelete.getClientCode()) )
                .limitKind( depoLimitDelete.getLimitKind() )
                .build();
    }

    @Override
    public QluaStructures.DepoLimitDelete convertToPb(@NotNull final DepoLimitDelete depoLimitDelete) {

        return QluaStructures.DepoLimitDelete.newBuilder()
                .setSecCode( convertToPbString(depoLimitDelete.getSecCode()) )
                .setTrdaccid( convertToPbString(depoLimitDelete.getTrdAccId()) )
                .setFirmid( convertToPbString(depoLimitDelete.getFirmId()) )
                .setClientCode( convertToPbString(depoLimitDelete.getClientCode()) )
                .setLimitKind( depoLimitDelete.getLimitKind() )
                .build();
    }
}
