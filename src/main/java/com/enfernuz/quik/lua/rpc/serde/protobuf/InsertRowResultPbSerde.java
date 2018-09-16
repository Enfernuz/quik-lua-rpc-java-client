package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.InsertRow;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum InsertRowResultPbSerde implements Serde<InsertRow.Result>, PbConverter<qlua.rpc.InsertRow.Result, InsertRow.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final InsertRow.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public InsertRow.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.InsertRow.Result.parseFrom(data) );
    }

    @Override
    public InsertRow.Result convertFromPb(@NotNull final qlua.rpc.InsertRow.Result result) {
        return new InsertRow.Result( result.getResult() );
    }

    @Override
    public qlua.rpc.InsertRow.Result convertToPb(@NotNull final InsertRow.Result result) {
        return qlua.rpc.InsertRow.Result.newBuilder()
                .setResult( result.getResult() )
                .build();
    }
}
