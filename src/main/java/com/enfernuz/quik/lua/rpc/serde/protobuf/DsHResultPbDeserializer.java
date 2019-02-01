package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.H;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum DsHResultPbDeserializer implements Deserializer<H.Result>, FromPbConverter<qlua.rpc.datasource.H.Result, H.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public H.Result deserialize(@NotNull final byte[] data) {
        return convert( qlua.rpc.datasource.H.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public H.Result convert(@NotNull final qlua.rpc.datasource.H.Result result) {
        return new H.Result( result.getValue() );
    }
}
