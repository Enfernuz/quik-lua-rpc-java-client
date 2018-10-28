package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetLinesCount;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum GetLinesCountResultPbDeserializer implements Deserializer<GetLinesCount.Result>, FromPbConverter<qlua.rpc.GetLinesCount.Result, GetLinesCount.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetLinesCount.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetLinesCount.Result.parseFrom(data) );
    }

    @Override
    public GetLinesCount.Result convert(@NotNull final qlua.rpc.GetLinesCount.Result result) {
        return new GetLinesCount.Result( result.getLinesCount() );
    }
}
