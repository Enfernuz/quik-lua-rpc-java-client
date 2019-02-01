package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetItem;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum GetItemResultPbDeserializer implements Deserializer<GetItem.Result>, FromPbConverter<qlua.rpc.GetItem.Result, GetItem.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetItem.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetItem.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetItem.Result convert(@NotNull final qlua.rpc.GetItem.Result result) {
        return GetItem.Result.getInstance(result.getNullTableRow() ? null : result.getTableRowMap());
    }
}
