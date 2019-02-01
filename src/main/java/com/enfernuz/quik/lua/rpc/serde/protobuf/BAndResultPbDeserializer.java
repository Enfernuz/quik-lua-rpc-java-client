package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BAnd;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.bit.Band;

enum BAndResultPbDeserializer implements Deserializer<BAnd.Result>, FromPbConverter<qlua.rpc.bit.Band.Result, BAnd.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public BAnd.Result deserialize(@NotNull final byte[] data) {
        return convert( Band.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public BAnd.Result convert(@NotNull final Band.Result result) {
        return new BAnd.Result( result.getResult() );
    }
}
