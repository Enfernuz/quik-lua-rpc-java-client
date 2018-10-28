package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.RGB;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum RGBResultPbDeserializer implements Deserializer<RGB.Result>, FromPbConverter<qlua.rpc.RGB.Result, RGB.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public RGB.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.RGB.Result.parseFrom(data) );
    }

    @Override
    public RGB.Result convert(@NotNull final qlua.rpc.RGB.Result result) {
        return new RGB.Result( result.getResult() );
    }
}
