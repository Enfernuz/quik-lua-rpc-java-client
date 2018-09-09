package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetInfoParam;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum GetInfoParamResultPbSerde implements Serde<GetInfoParam.Result>, PbConverter<qlua.rpc.GetInfoParam.Result, GetInfoParam.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetInfoParam.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetInfoParam.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetInfoParam.Result.parseFrom(data) );
    }

    @Override
    public GetInfoParam.Result convertFromPb(@NotNull final qlua.rpc.GetInfoParam.Result result) {
        return new GetInfoParam.Result( result.getInfoParam() );
    }

    @Override
    public qlua.rpc.GetInfoParam.Result convertToPb(@NotNull final GetInfoParam.Result result) {
        return qlua.rpc.GetInfoParam.Result.newBuilder()
                .setInfoParam( result.getInfoParam() )
                .build();
    }
}
