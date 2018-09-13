package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetNumCandles;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum GetNumCandlesResultPbSerde implements Serde<GetNumCandles.Result>, PbConverter<qlua.rpc.GetNumCandles.Result, GetNumCandles.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetNumCandles.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetNumCandles.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetNumCandles.Result.parseFrom(data) );
    }

    @Override
    public GetNumCandles.Result convertFromPb(@NotNull final qlua.rpc.GetNumCandles.Result result) {
        return new GetNumCandles.Result( result.getNumCandles() );
    }

    @Override
    public qlua.rpc.GetNumCandles.Result convertToPb(@NotNull final GetNumCandles.Result result) {
        return qlua.rpc.GetNumCandles.Result.newBuilder()
                .setNumCandles( result.getNumCandles() )
                .build();
    }
}
