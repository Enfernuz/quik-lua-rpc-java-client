package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetSelectedRow;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum SetSelectedRowResultPbDeserializer implements Deserializer<SetSelectedRow.Result>, FromPbConverter<qlua.rpc.SetSelectedRow.Result, SetSelectedRow.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public SetSelectedRow.Result deserialize(@NotNull final byte[] data) {
        return convert( qlua.rpc.SetSelectedRow.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public SetSelectedRow.Result convert(@NotNull final qlua.rpc.SetSelectedRow.Result result) {
        return SetSelectedRow.Result.getInstance( result.getResult() );
    }
}
