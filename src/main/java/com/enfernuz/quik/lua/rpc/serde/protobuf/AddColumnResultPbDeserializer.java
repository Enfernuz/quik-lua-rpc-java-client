package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.AddColumn;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum AddColumnResultPbDeserializer implements Deserializer<AddColumn.Result>, FromPbConverter<qlua.rpc.AddColumn.Result, AddColumn.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public AddColumn.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.AddColumn.Result.parseFrom(data) );
    }

    @Override
    public AddColumn.Result convert(@NotNull final qlua.rpc.AddColumn.Result result) {
        return new AddColumn.Result( result.getResult() );
    }
}
