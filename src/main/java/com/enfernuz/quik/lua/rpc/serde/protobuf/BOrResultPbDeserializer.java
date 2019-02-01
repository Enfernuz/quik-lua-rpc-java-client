package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BOr;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.bit.Bor;

enum BOrResultPbDeserializer implements Deserializer<BOr.Result>, FromPbConverter<Bor.Result, BOr.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public BOr.Result deserialize(@NotNull final byte[] data) {
        return convert( Bor.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public BOr.Result convert(@NotNull final Bor.Result result) {
        return new BOr.Result( result.getResult() );
    }
}
