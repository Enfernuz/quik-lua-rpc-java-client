package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.SetUpdateCallback;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum DsSetUpdateCallbackPbResultDeserializer implements Deserializer<SetUpdateCallback.Result>, FromPbConverter<qlua.rpc.datasource.SetUpdateCallback.Result, SetUpdateCallback.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public SetUpdateCallback.Result deserialize(@NotNull final byte[] data) {
        return convert( qlua.rpc.datasource.SetUpdateCallback.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public SetUpdateCallback.Result convert(@NotNull final qlua.rpc.datasource.SetUpdateCallback.Result result) {
        return SetUpdateCallback.Result.getInstance( result.getResult() );
    }
}
