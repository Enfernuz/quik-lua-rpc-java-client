package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DeleteRow;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum DeleteRowResultPbDeserializer implements Deserializer<DeleteRow.Result>, FromPbConverter<qlua.rpc.DeleteRow.Result, DeleteRow.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public DeleteRow.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.DeleteRow.Result.parseFrom(data) );
    }

    @Override
    public DeleteRow.Result convert(@NotNull final qlua.rpc.DeleteRow.Result result) {
        return DeleteRow.Result.getInstance( result.getResult() );
    }
}
