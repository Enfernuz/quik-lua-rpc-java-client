package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.Close;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum DsClosePbResultDeserializer implements Deserializer<Close.Result>, FromPbConverter<qlua.rpc.datasource.Close.Result, Close.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Close.Result deserialize(@NotNull final byte[] data) {
        return convert( qlua.rpc.datasource.Close.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public Close.Result convert(@NotNull final qlua.rpc.datasource.Close.Result result) {
        return Close.Result.getInstance( result.getResult() );
    }
}
