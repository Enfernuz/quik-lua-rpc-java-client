package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetWindowPos;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum SetWindowPosResultPbDeserializer implements Deserializer<SetWindowPos.Result>, FromPbConverter<qlua.rpc.SetWindowPos.Result, SetWindowPos.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public SetWindowPos.Result deserialize(@NotNull final byte[] data) {
        return convert( qlua.rpc.SetWindowPos.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public SetWindowPos.Result convert(@NotNull final qlua.rpc.SetWindowPos.Result result) {
        return SetWindowPos.Result.getInstance( result.getResult() );
    }
}
