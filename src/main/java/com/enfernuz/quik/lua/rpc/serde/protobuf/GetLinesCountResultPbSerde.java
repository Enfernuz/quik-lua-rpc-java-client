package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetLinesCount;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum GetLinesCountResultPbSerde implements Serde<GetLinesCount.Result>, PbConverter<qlua.rpc.GetLinesCount.Result, GetLinesCount.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetLinesCount.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetLinesCount.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetLinesCount.Result.parseFrom(data) );
    }

    @Override
    public GetLinesCount.Result convertFromPb(@NotNull final qlua.rpc.GetLinesCount.Result result) {
        return new GetLinesCount.Result( result.getLinesCount() );
    }

    @Override
    public qlua.rpc.GetLinesCount.Result convertToPb(@NotNull final GetLinesCount.Result result) {
        return qlua.rpc.GetLinesCount.Result.newBuilder()
                .setLinesCount( result.getLinesCount() )
                .build();
    }
}
