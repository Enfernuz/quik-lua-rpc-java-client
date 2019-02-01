package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetFuturesHolding;
import com.enfernuz.quik.lua.rpc.api.structures.FuturesClientHolding;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbFuturesClientHolding;

enum GetFuturesHoldingResultPbDeserializer implements Deserializer<GetFuturesHolding.Result>, FromPbConverter<qlua.rpc.GetFuturesHolding.Result, GetFuturesHolding.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetFuturesHolding.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetFuturesHolding.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetFuturesHolding.Result convert(@NotNull final qlua.rpc.GetFuturesHolding.Result result) {

        final FuturesClientHolding futuresClientHolding = result.hasFuturesHolding() ? convertFromPbFuturesClientHolding(result.getFuturesHolding()) : null;
        return GetFuturesHolding.Result.getInstance(futuresClientHolding);
    }
}
