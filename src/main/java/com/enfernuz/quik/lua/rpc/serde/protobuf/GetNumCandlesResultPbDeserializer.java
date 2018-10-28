package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetNumCandles;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum GetNumCandlesResultPbDeserializer implements Deserializer<GetNumCandles.Result>, FromPbConverter<qlua.rpc.GetNumCandles.Result, GetNumCandles.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetNumCandles.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetNumCandles.Result.parseFrom(data) );
    }

    @Override
    public GetNumCandles.Result convert(@NotNull final qlua.rpc.GetNumCandles.Result result) {
        return new GetNumCandles.Result( result.getNumCandles() );
    }
}
