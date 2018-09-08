package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.CancelParamRequest;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum CancelParamRequestResultPbSerde implements Serde<CancelParamRequest.Result>, PbConverter<qlua.rpc.CancelParamRequest.Result, CancelParamRequest.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final CancelParamRequest.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public CancelParamRequest.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.CancelParamRequest.Result.parseFrom(data) );
    }

    @Override
    public CancelParamRequest.Result convertFromPb(@NotNull final qlua.rpc.CancelParamRequest.Result result) {
        return new CancelParamRequest.Result( result.getResult() );
    }

    @Override
    public qlua.rpc.CancelParamRequest.Result convertToPb(@NotNull final CancelParamRequest.Result result) {
        return qlua.rpc.CancelParamRequest.Result.newBuilder()
                .setResult( result.isResult() )
                .build();
    }
}
