package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.InsertRow;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum InsertRowResultPbDeserializer implements Deserializer<InsertRow.Result>, FromPbConverter<qlua.rpc.InsertRow.Result, InsertRow.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public InsertRow.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.InsertRow.Result.parseFrom(data) );
    }

    @Override
    public InsertRow.Result convert(@NotNull final qlua.rpc.InsertRow.Result result) {
        return new InsertRow.Result( result.getResult() );
    }
}
