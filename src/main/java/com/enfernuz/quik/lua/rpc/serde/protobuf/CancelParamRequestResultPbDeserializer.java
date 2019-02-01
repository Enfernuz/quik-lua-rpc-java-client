package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.CancelParamRequest;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum CancelParamRequestResultPbDeserializer implements Deserializer<CancelParamRequest.Result>, FromPbConverter<qlua.rpc.CancelParamRequest.Result, CancelParamRequest.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public CancelParamRequest.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.CancelParamRequest.Result.parseFrom(data) );
    }

    @Override
    public CancelParamRequest.Result convert(@NotNull final qlua.rpc.CancelParamRequest.Result result) {
        return new CancelParamRequest.Result( result.getResult() );
    }
}
