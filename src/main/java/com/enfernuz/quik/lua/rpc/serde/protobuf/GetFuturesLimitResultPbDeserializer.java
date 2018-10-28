package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetFuturesLimit;
import com.enfernuz.quik.lua.rpc.api.structures.FuturesLimit;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbFuturesLimit;

enum GetFuturesLimitResultPbDeserializer implements Deserializer<GetFuturesLimit.Result>, FromPbConverter<qlua.rpc.GetFuturesLimit.Result, GetFuturesLimit.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetFuturesLimit.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetFuturesLimit.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetFuturesLimit.Result convert(@NotNull final qlua.rpc.GetFuturesLimit.Result result) {

        final FuturesLimit futuresLimit = result.hasFuturesLimit() ? convertFromPbFuturesLimit(result.getFuturesLimit()) : null;
        return GetFuturesLimit.Result.getInstance(futuresLimit);
    }
}
