package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.L;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum DsLResultPbDeserializer implements Deserializer<L.Result>, FromPbConverter<qlua.rpc.datasource.L.Result, L.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public L.Result deserialize(@NotNull final byte[] data) {
        return convert( qlua.rpc.datasource.L.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public L.Result convert(@NotNull final qlua.rpc.datasource.L.Result result) {
        return new L.Result( result.getValue() );
    }
}
