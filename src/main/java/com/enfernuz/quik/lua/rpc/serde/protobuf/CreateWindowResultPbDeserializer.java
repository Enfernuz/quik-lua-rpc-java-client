package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.CreateWindow;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum CreateWindowResultPbDeserializer implements Deserializer<CreateWindow.Result>, FromPbConverter<qlua.rpc.CreateWindow.Result, CreateWindow.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public CreateWindow.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.CreateWindow.Result.parseFrom(data) );
    }

    @Override
    public CreateWindow.Result convert(@NotNull final qlua.rpc.CreateWindow.Result result) {
        return new CreateWindow.Result( result.getResult() );
    }
}
