package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Sleep;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum SleepResultPbDeserializer implements Deserializer<Sleep.Result>, FromPbConverter<qlua.rpc.Sleep.Result, Sleep.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Sleep.Result deserialize(@NotNull final byte[] data) {
        return convert( qlua.rpc.Sleep.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public Sleep.Result convert(@NotNull final qlua.rpc.Sleep.Result result) {

        return result.getNullResult() ?
                Sleep.Result.getErrorInstance()
                :
                Sleep.Result.getInstance( result.getValueResult() );
    }
}
