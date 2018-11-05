package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.SetEmptyCallback;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum DsSetEmptyCallbackPbResultDeserializer implements Deserializer<SetEmptyCallback.Result>, FromPbConverter<qlua.rpc.datasource.SetEmptyCallback.Result, SetEmptyCallback.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public SetEmptyCallback.Result deserialize(@NotNull final byte[] data) {
        return convert( qlua.rpc.datasource.SetEmptyCallback.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public SetEmptyCallback.Result convert(@NotNull final qlua.rpc.datasource.SetEmptyCallback.Result result) {
        return SetEmptyCallback.Result.getInstance( result.getResult() );
    }
}
