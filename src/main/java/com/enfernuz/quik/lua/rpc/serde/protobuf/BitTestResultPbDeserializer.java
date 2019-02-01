package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.Test;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.bit.Btest;

enum BitTestResultPbDeserializer implements Deserializer<Test.Result>, FromPbConverter<qlua.rpc.bit.Btest.Result, Test.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Test.Result deserialize(@NotNull final byte[] data) {
        return convert( Btest.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public Test.Result convert(@NotNull final Btest.Result result) {
        return Test.Result.getInstance( result.getResult() );
    }
}
