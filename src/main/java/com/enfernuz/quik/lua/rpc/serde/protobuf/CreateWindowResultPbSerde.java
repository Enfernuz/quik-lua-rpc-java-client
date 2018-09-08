package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.CreateWindow;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum CreateWindowResultPbSerde implements Serde<CreateWindow.Result>, PbConverter<qlua.rpc.CreateWindow.Result, CreateWindow.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final CreateWindow.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public CreateWindow.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.CreateWindow.Result.parseFrom(data) );
    }

    @Override
    public CreateWindow.Result convertFromPb(@NotNull final qlua.rpc.CreateWindow.Result result) {
        return new CreateWindow.Result( result.getResult() );
    }

    @Override
    public qlua.rpc.CreateWindow.Result convertToPb(@NotNull final CreateWindow.Result result) {
        return qlua.rpc.CreateWindow.Result.newBuilder()
                .setResult( result.getResult() )
                .build();
    }
}
