package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfoEx;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.*;

enum GetBuySellInfoExResultPbSerde implements Serde<GetBuySellInfoEx.Result>, PbConverter<qlua.rpc.GetBuySellInfoEx.Result, GetBuySellInfoEx.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetBuySellInfoEx.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetBuySellInfoEx.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetBuySellInfoEx.Result.parseFrom(data) );
    }

    @Override
    public GetBuySellInfoEx.Result convertFromPb(@NotNull final qlua.rpc.GetBuySellInfoEx.Result result) {
        return new GetBuySellInfoEx.Result( convertFromPbBuySellInfoEx(result.getBuySellInfoEx()) );
    }

    @Override
    public qlua.rpc.GetBuySellInfoEx.Result convertToPb(@NotNull final GetBuySellInfoEx.Result result) {

        return qlua.rpc.GetBuySellInfoEx.Result.newBuilder()
                .setBuySellInfoEx( convertToPbBuySellInfoEx(result.getBuySellInfoEx()) )
                .build();
    }
}
