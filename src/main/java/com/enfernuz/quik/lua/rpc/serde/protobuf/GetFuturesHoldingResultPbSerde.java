package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetFuturesHolding;
import com.enfernuz.quik.lua.rpc.api.structures.FuturesClientHolding;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbFuturesClientHolding;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbFuturesClientHolding;

enum GetFuturesHoldingResultPbSerde implements Serde<GetFuturesHolding.Result>, PbConverter<qlua.rpc.GetFuturesHolding.Result, GetFuturesHolding.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetFuturesHolding.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetFuturesHolding.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetFuturesHolding.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetFuturesHolding.Result convertFromPb(@NotNull final qlua.rpc.GetFuturesHolding.Result result) {

        final FuturesClientHolding futuresClientHolding = result.hasFuturesHolding() ? convertFromPbFuturesClientHolding(result.getFuturesHolding()) : null;
        return new GetFuturesHolding.Result(futuresClientHolding);
    }

    @NotNull
    @Override
    public qlua.rpc.GetFuturesHolding.Result convertToPb(@NotNull final GetFuturesHolding.Result result) {

        final qlua.rpc.GetFuturesHolding.Result.Builder pbResult = qlua.rpc.GetFuturesHolding.Result.newBuilder();
        final FuturesClientHolding futuresClientHolding = result.getFuturesHolding();
        if (futuresClientHolding != null) {
            pbResult.setFuturesHolding( convertToPbFuturesClientHolding(futuresClientHolding) );
        }

        return pbResult.build();
    }
}
