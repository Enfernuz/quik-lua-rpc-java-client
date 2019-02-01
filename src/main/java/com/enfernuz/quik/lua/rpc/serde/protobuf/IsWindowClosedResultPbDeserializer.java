package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsWindowClosed;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum IsWindowClosedResultPbDeserializer implements Deserializer<IsWindowClosed.Result>, FromPbConverter<qlua.rpc.IsWindowClosed.Result, IsWindowClosed.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public IsWindowClosed.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.IsWindowClosed.Result.parseFrom(data) );
    }

    @Override
    public IsWindowClosed.Result convert(@NotNull final qlua.rpc.IsWindowClosed.Result result) {

        return result.getNullWindowClosed() ?
                IsWindowClosed.Result.getInstance(null) : IsWindowClosed.Result.getInstance(result.getValueWindowClosed());
    }
}
