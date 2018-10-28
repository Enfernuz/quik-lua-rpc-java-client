package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.StopEventInfo;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

enum StopEventInfoPbDeserializer implements Deserializer<StopEventInfo>, FromPbConverter<QluaStructures.StopEventInfo, StopEventInfo> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public StopEventInfo deserialize(final byte[] data) {
        return convert(QluaStructures.StopEventInfo.parseFrom(data));
    }

    @Override
    public StopEventInfo convert(@NotNull QluaStructures.StopEventInfo stopEventInfo) {
        return StopEventInfo.getInstance( stopEventInfo.getFlag() );
    }
}
