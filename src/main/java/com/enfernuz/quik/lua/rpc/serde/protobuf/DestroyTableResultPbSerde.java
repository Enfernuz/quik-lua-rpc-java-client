package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DestroyTable;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum DestroyTableResultPbSerde implements Serde<DestroyTable.Result>, PbConverter<qlua.rpc.DestroyTable.Result, DestroyTable.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final DestroyTable.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public DestroyTable.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.DestroyTable.Result.parseFrom(data) );
    }

    @Override
    public DestroyTable.Result convertFromPb(@NotNull final qlua.rpc.DestroyTable.Result result) {
        return DestroyTable.Result.getInstance( result.getResult() );
    }

    @Override
    public qlua.rpc.DestroyTable.Result convertToPb(@NotNull final DestroyTable.Result result) {
        return qlua.rpc.DestroyTable.Result.newBuilder()
                .setResult( result.isResult() )
                .build();
    }
}
