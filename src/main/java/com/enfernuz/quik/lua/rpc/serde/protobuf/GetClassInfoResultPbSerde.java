package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassInfo;
import com.enfernuz.quik.lua.rpc.api.structures.ClassInfo;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.*;

enum GetClassInfoResultPbSerde implements Serde<GetClassInfo.Result>, PbConverter<qlua.rpc.GetClassInfo.Result, GetClassInfo.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetClassInfo.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetClassInfo.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetClassInfo.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetClassInfo.Result convertFromPb(@NotNull final qlua.rpc.GetClassInfo.Result result) {

        ClassInfo classInfo = null;
        if ( result.hasClassInfo() ) {
            classInfo = convertFromPbClassInfo(result.getClassInfo());
        }

        return new GetClassInfo.Result(classInfo);
    }

    @NotNull
    @Override
    public qlua.rpc.GetClassInfo.Result convertToPb(@NotNull final GetClassInfo.Result result) {

        final qlua.rpc.GetClassInfo.Result.Builder pbResult = qlua.rpc.GetClassInfo.Result.newBuilder();
        final ClassInfo classInfo = result.getClassInfo();
        if (classInfo != null) {
            pbResult.setClassInfo( convertToPbClassInfo(classInfo) );
        }

        return pbResult.build();
    }
}
