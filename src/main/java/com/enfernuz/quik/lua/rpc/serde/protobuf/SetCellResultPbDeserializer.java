package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetCell;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum SetCellResultPbDeserializer implements Deserializer<SetCell.Result>, FromPbConverter<qlua.rpc.SetCell.Result, SetCell.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public SetCell.Result deserialize(@NotNull final byte[] data) {
        return convert( qlua.rpc.SetCell.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public SetCell.Result convert(@NotNull final qlua.rpc.SetCell.Result result) {
        return SetCell.Result.getInstance( result.getResult() );
    }
}
