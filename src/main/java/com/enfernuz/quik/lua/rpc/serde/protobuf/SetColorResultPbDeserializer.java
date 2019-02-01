package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetColor;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum SetColorResultPbDeserializer implements Deserializer<SetColor.Result>, FromPbConverter<qlua.rpc.SetColor.Result, SetColor.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public SetColor.Result deserialize(@NotNull final byte[] data) {
        return convert( qlua.rpc.SetColor.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public SetColor.Result convert(@NotNull final qlua.rpc.SetColor.Result result) {
        return SetColor.Result.getInstance( result.getResult() );
    }
}
