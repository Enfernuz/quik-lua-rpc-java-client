package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassInfo;
import com.enfernuz.quik.lua.rpc.api.structures.ClassInfo;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbClassInfo;

enum GetClassInfoResultPbDeserializer implements Deserializer<GetClassInfo.Result>, FromPbConverter<qlua.rpc.GetClassInfo.Result, GetClassInfo.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetClassInfo.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetClassInfo.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetClassInfo.Result convert(@NotNull final qlua.rpc.GetClassInfo.Result result) {

        ClassInfo classInfo = null;
        if ( result.hasClassInfo() ) {
            classInfo = convertFromPbClassInfo(result.getClassInfo());
        }

        return new GetClassInfo.Result(classInfo);
    }
}
