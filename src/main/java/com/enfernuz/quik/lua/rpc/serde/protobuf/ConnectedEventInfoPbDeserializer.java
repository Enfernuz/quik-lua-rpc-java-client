package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.ConnectedEventInfo;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

enum ConnectedEventInfoPbDeserializer implements Deserializer<ConnectedEventInfo>, FromPbConverter<QluaStructures.ConnectedEventInfo, ConnectedEventInfo> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public ConnectedEventInfo deserialize(final byte[] data) {
        return convert(QluaStructures.ConnectedEventInfo.parseFrom(data));
    }

    @Override
    public ConnectedEventInfo convert(@NotNull QluaStructures.ConnectedEventInfo connectedEventInfo) {
        return ConnectedEventInfo.getInstance( connectedEventInfo.getFlag() );
    }
}
