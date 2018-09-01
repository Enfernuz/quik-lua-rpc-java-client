package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.StopEventInfo;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

enum StopEventInfoPbSerde implements Serde<StopEventInfo>, PbConverter<QluaStructures.StopEventInfo, StopEventInfo> {

    INSTANCE;

    @Override
    public byte[] serialize(final StopEventInfo stopEventInfo) {
        return convertToPb(stopEventInfo).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public StopEventInfo deserialize(final byte[] data) {
        return convertFromPb(QluaStructures.StopEventInfo.parseFrom(data));
    }

    @Override
    public StopEventInfo convertFromPb(@NotNull QluaStructures.StopEventInfo stopEventInfo) {
        return new StopEventInfo( stopEventInfo.getSignal() );
    }

    @Override
    public QluaStructures.StopEventInfo convertToPb(@NotNull final StopEventInfo stopEventInfo) {

        return QluaStructures.StopEventInfo.newBuilder()
                .setSignal( stopEventInfo.getSignal() )
                .build();
    }
}
