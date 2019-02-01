package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Clear;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum ClearResultPbDeserializer implements Deserializer<Clear.Result>, FromPbConverter<qlua.rpc.Clear.Result, Clear.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Clear.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.Clear.Result.parseFrom(data) );
    }

    @Override
    public Clear.Result convert(@NotNull final qlua.rpc.Clear.Result result) {
        return Clear.Result.getInstance( result.getResult() );
    }
}
