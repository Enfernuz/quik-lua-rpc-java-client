package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.Size;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum DsSizeResultPbDeserializer implements Deserializer<Size.Result>, FromPbConverter<qlua.rpc.datasource.Size.Result, Size.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Size.Result deserialize(@NotNull final byte[] data) {
        return convert( qlua.rpc.datasource.Size.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public Size.Result convert(@NotNull final qlua.rpc.datasource.Size.Result result) {
        return new Size.Result( result.getValue() );
    }
}
