package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsConnected;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum IsConnectedResultPbDeserializer implements Deserializer<IsConnected.Result>, FromPbConverter<qlua.rpc.IsConnected.Result, IsConnected.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public IsConnected.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.IsConnected.Result.parseFrom(data) );
    }

    @Override
    public IsConnected.Result convert(@NotNull final qlua.rpc.IsConnected.Result result) {
        return IsConnected.Result.getInstance( result.getIsConnected() );
    }
}
