package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Clear;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum ClearResultPbSerde implements Serde<Clear.Result>, PbConverter<qlua.rpc.Clear.Result, Clear.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final Clear.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Clear.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.Clear.Result.parseFrom(data) );
    }

    @Override
    public Clear.Result convertFromPb(@NotNull final qlua.rpc.Clear.Result result) {
        return Clear.Result.getInstance( result.getResult() );
    }

    @Override
    public qlua.rpc.Clear.Result convertToPb(@NotNull final Clear.Result result) {
        return qlua.rpc.Clear.Result.newBuilder()
                .setResult( result.isResult() )
                .build();
    }
}
