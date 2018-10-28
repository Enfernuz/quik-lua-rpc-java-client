package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DestroyTable;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum DestroyTableResultPbDeserializer implements Deserializer<DestroyTable.Result>, FromPbConverter<qlua.rpc.DestroyTable.Result, DestroyTable.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public DestroyTable.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.DestroyTable.Result.parseFrom(data) );
    }

    @Override
    public DestroyTable.Result convert(@NotNull final qlua.rpc.DestroyTable.Result result) {
        return DestroyTable.Result.getInstance( result.getResult() );
    }
}
