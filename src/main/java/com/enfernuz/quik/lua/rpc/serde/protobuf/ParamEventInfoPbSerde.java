package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.Firm;
import com.enfernuz.quik.lua.rpc.api.structures.ParamEventInfo;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum ParamEventInfoPbSerde implements Serde<ParamEventInfo>, PbConverter<QluaStructures.ParamEventInfo, ParamEventInfo> {

    INSTANCE;

    @Override
    public byte[] serialize(final ParamEventInfo paramEventInfo) {
        return convertToPb(paramEventInfo).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public ParamEventInfo deserialize(final byte[] data) {
        return convertFromPb(QluaStructures.ParamEventInfo.parseFrom(data));
    }

    @Override
    public ParamEventInfo convertFromPb(@NotNull QluaStructures.ParamEventInfo paramEventInfo) {

        return ParamEventInfo.builder()
                .classCode( convertFromPbString(paramEventInfo.getClassCode()) )
                .secCode( convertFromPbString(paramEventInfo.getSecCode()) )
                .build();
    }

    @Override
    public QluaStructures.ParamEventInfo convertToPb(@NotNull final ParamEventInfo paramEventInfo) {

        return QluaStructures.ParamEventInfo.newBuilder()
                .setClassCode( convertToPbString(paramEventInfo.getClassCode()) )
                .setSecCode( convertToPbString(paramEventInfo.getSecCode()) )
                .build();
    }
}
