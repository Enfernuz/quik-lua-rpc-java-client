package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BNot;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.bit.Bnot;

enum BNotResultPbDeserializer implements Deserializer<BNot.Result>, FromPbConverter<qlua.rpc.bit.Bnot.Result, BNot.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public BNot.Result deserialize(@NotNull final byte[] data) {
        return convert( Bnot.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public BNot.Result convert(@NotNull final Bnot.Result result) {
        return new BNot.Result( result.getResult() );
    }
}
