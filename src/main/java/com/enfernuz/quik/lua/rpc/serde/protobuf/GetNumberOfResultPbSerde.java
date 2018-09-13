package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetNumberOf;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum GetNumberOfResultPbSerde implements Serde<GetNumberOf.Result>, PbConverter<qlua.rpc.GetNumberOf.Result, GetNumberOf.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetNumberOf.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetNumberOf.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetNumberOf.Result.parseFrom(data) );
    }

    @Override
    public GetNumberOf.Result convertFromPb(@NotNull final qlua.rpc.GetNumberOf.Result result) {
        return new GetNumberOf.Result( result.getResult() );
    }

    @Override
    public qlua.rpc.GetNumberOf.Result convertToPb(@NotNull final GetNumberOf.Result result) {
        return qlua.rpc.GetNumberOf.Result.newBuilder()
                .setResult( result.getResult() )
                .build();
    }
}
