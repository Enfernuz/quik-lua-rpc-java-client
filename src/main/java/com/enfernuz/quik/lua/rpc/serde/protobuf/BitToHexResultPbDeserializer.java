package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.ToHex;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.bit.Tohex;

enum BitToHexResultPbDeserializer implements Deserializer<ToHex.Result>, FromPbConverter<qlua.rpc.bit.Tohex.Result, ToHex.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public ToHex.Result deserialize(@NotNull final byte[] data) {
        return convert( Tohex.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public ToHex.Result convert(@NotNull final Tohex.Result result) {
        return new ToHex.Result( result.getResult() );
    }
}
