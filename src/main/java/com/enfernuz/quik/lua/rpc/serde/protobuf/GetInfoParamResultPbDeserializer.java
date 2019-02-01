package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetInfoParam;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum GetInfoParamResultPbDeserializer implements Deserializer<GetInfoParam.Result>, FromPbConverter<qlua.rpc.GetInfoParam.Result, GetInfoParam.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetInfoParam.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetInfoParam.Result.parseFrom(data) );
    }

    @Override
    public GetInfoParam.Result convert(@NotNull final qlua.rpc.GetInfoParam.Result result) {
        return new GetInfoParam.Result( result.getInfoParam() );
    }
}
