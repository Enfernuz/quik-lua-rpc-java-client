package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.V;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum DsVResultPbDeserializer implements Deserializer<V.Result>, FromPbConverter<qlua.rpc.datasource.V.Result, V.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public V.Result deserialize(@NotNull final byte[] data) {
        return convert( qlua.rpc.datasource.V.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public V.Result convert(@NotNull final qlua.rpc.datasource.V.Result result) {
        return new V.Result( result.getValue() );
    }
}
