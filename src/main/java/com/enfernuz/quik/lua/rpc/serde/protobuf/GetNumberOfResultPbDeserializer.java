package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetNumberOf;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum GetNumberOfResultPbDeserializer implements Deserializer<GetNumberOf.Result>, FromPbConverter<qlua.rpc.GetNumberOf.Result, GetNumberOf.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetNumberOf.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetNumberOf.Result.parseFrom(data) );
    }

    @Override
    public GetNumberOf.Result convert(@NotNull final qlua.rpc.GetNumberOf.Result result) {
        return new GetNumberOf.Result( result.getResult() );
    }
}
