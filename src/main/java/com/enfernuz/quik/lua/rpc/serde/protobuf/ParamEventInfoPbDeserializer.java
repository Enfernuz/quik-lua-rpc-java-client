package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.ParamEventInfo;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum ParamEventInfoPbDeserializer implements Deserializer<ParamEventInfo>, FromPbConverter<QluaStructures.ParamEventInfo, ParamEventInfo> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public ParamEventInfo deserialize(final byte[] data) {
        return convert(QluaStructures.ParamEventInfo.parseFrom(data));
    }

    @Override
    public ParamEventInfo convert(@NotNull QluaStructures.ParamEventInfo paramEventInfo) {

        return ParamEventInfo.builder()
                .classCode( convertFromPbString(paramEventInfo.getClassCode()) )
                .secCode( convertFromPbString(paramEventInfo.getSecCode()) )
                .build();
    }
}
