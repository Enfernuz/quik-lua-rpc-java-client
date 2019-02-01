package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BXor;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.bit.Bxor;

enum BXorResultPbDeserializer implements Deserializer<BXor.Result>, FromPbConverter<Bxor.Result, BXor.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public BXor.Result deserialize(@NotNull final byte[] data) {
        return convert( Bxor.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public BXor.Result convert(@NotNull final Bxor.Result result) {
        return new BXor.Result( result.getResult() );
    }
}
