package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsConnected;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum IsConnectedResultPbSerde implements Serde<IsConnected.Result>, PbConverter<qlua.rpc.IsConnected.Result, IsConnected.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final IsConnected.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public IsConnected.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.IsConnected.Result.parseFrom(data) );
    }

    @Override
    public IsConnected.Result convertFromPb(@NotNull final qlua.rpc.IsConnected.Result result) {
        return IsConnected.Result.getInstance( result.getIsConnected() );
    }

    @Override
    public qlua.rpc.IsConnected.Result convertToPb(@NotNull final IsConnected.Result result) {
        return qlua.rpc.IsConnected.Result.newBuilder()
                .setIsConnected( result.getIsConnected() )
                .build();
    }
}
