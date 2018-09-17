package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.ParamRequest;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum ParamRequestResultPbSerde implements Serde<ParamRequest.Result>, PbConverter<qlua.rpc.ParamRequest.Result, ParamRequest.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final ParamRequest.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public ParamRequest.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.ParamRequest.Result.parseFrom(data) );
    }

    @Override
    public ParamRequest.Result convertFromPb(@NotNull final qlua.rpc.ParamRequest.Result result) {
        return ParamRequest.Result.getInstance( result.getResult() );
    }

    @Override
    public qlua.rpc.ParamRequest.Result convertToPb(@NotNull final ParamRequest.Result result) {
        return qlua.rpc.ParamRequest.Result.newBuilder()
                .setResult( result.isResult() )
                .build();
    }
}
