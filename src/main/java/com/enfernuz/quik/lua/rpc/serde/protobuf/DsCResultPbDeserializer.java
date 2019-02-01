package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.C;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum DsCResultPbDeserializer implements Deserializer<C.Result>, FromPbConverter<qlua.rpc.datasource.C.Result, C.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public C.Result deserialize(@NotNull final byte[] data) {
        return convert( qlua.rpc.datasource.C.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public C.Result convert(@NotNull final qlua.rpc.datasource.C.Result result) {
        return new C.Result( result.getValue() );
    }
}
