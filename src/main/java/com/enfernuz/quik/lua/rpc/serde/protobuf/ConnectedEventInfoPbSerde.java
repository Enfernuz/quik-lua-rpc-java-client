package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.ConnectedEventInfo;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

enum ConnectedEventInfoPbSerde implements Serde<ConnectedEventInfo>, PbConverter<QluaStructures.ConnectedEventInfo, ConnectedEventInfo> {

    INSTANCE;

    @Override
    public byte[] serialize(final ConnectedEventInfo connectedEventInfo) {
        return convertToPb(connectedEventInfo).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public ConnectedEventInfo deserialize(final byte[] data) {
        return convertFromPb(QluaStructures.ConnectedEventInfo.parseFrom(data));
    }

    @Override
    public ConnectedEventInfo convertFromPb(@NotNull QluaStructures.ConnectedEventInfo connectedEventInfo) {
        return new ConnectedEventInfo( connectedEventInfo.getFlag() );
    }

    @Override
    public QluaStructures.ConnectedEventInfo convertToPb(@NotNull final ConnectedEventInfo connectedEventInfo) {

        return QluaStructures.ConnectedEventInfo.newBuilder()
                .setFlag( connectedEventInfo.getFlag() )
                .build();
    }
}
