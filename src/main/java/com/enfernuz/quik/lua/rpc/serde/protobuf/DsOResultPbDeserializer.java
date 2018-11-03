package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.O;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum DsOResultPbDeserializer implements Deserializer<O.Result>, FromPbConverter<qlua.rpc.datasource.O.Result, O.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public O.Result deserialize(@NotNull final byte[] data) {
        return convert( qlua.rpc.datasource.O.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public O.Result convert(@NotNull final qlua.rpc.datasource.O.Result result) {
        return new O.Result( result.getValue() );
    }
}
