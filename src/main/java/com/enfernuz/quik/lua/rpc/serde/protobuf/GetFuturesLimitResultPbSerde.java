package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetFuturesLimit;
import com.enfernuz.quik.lua.rpc.api.structures.FuturesLimit;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.*;

enum GetFuturesLimitResultPbSerde implements Serde<GetFuturesLimit.Result>, PbConverter<qlua.rpc.GetFuturesLimit.Result, GetFuturesLimit.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetFuturesLimit.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetFuturesLimit.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetFuturesLimit.Result.parseFrom(data) );
    }

    @NotNull
    @Override
    public GetFuturesLimit.Result convertFromPb(@NotNull final qlua.rpc.GetFuturesLimit.Result result) {

        final FuturesLimit futuresLimit = result.hasFuturesLimit() ? convertFromPbFuturesLimit(result.getFuturesLimit()) : null;
        return new GetFuturesLimit.Result(futuresLimit);
    }

    @NotNull
    @Override
    public qlua.rpc.GetFuturesLimit.Result convertToPb(@NotNull final GetFuturesLimit.Result result) {

        final qlua.rpc.GetFuturesLimit.Result.Builder pbResult = qlua.rpc.GetFuturesLimit.Result.newBuilder();
        final FuturesLimit futuresLimit = result.getFuturesLimit();
        if (futuresLimit != null) {
            pbResult.setFuturesLimit( convertToPbFuturesLimit(futuresLimit) );
        }

        return pbResult.build();
    }
}
