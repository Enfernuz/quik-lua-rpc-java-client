package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.ParamRequest;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum ParamRequestResultPbDeserializer implements Deserializer<ParamRequest.Result>, FromPbConverter<qlua.rpc.ParamRequest.Result, ParamRequest.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public ParamRequest.Result deserialize(@NotNull final byte[] data) {
        return convert( qlua.rpc.ParamRequest.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public ParamRequest.Result convert(@NotNull final qlua.rpc.ParamRequest.Result result) {
        return ParamRequest.Result.getInstance( result.getResult() );
    }
}
