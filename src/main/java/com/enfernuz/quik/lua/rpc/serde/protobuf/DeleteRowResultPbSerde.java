package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DeleteRow;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum DeleteRowResultPbSerde implements Serde<DeleteRow.Result>, PbConverter<qlua.rpc.DeleteRow.Result, DeleteRow.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final DeleteRow.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public DeleteRow.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.DeleteRow.Result.parseFrom(data) );
    }

    @Override
    public DeleteRow.Result convertFromPb(@NotNull final qlua.rpc.DeleteRow.Result result) {
        return DeleteRow.Result.getInstance( result.getResult() );
    }

    @Override
    public qlua.rpc.DeleteRow.Result convertToPb(@NotNull final DeleteRow.Result result) {
        return qlua.rpc.DeleteRow.Result.newBuilder()
                .setResult( result.isResult() )
                .build();
    }
}
