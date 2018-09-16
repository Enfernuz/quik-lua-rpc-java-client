package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsWindowClosed;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum IsWindowClosedResultPbSerde implements Serde<IsWindowClosed.Result>, PbConverter<qlua.rpc.IsWindowClosed.Result, IsWindowClosed.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final IsWindowClosed.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public IsWindowClosed.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.IsWindowClosed.Result.parseFrom(data) );
    }

    @Override
    public IsWindowClosed.Result convertFromPb(@NotNull final qlua.rpc.IsWindowClosed.Result result) {
        return IsWindowClosed.Result.getInstance( result.getResult() );
    }

    @Override
    public qlua.rpc.IsWindowClosed.Result convertToPb(@NotNull final IsWindowClosed.Result result) {
        return qlua.rpc.IsWindowClosed.Result.newBuilder()
                .setResult( result.isResult() )
                .build();
    }
}
