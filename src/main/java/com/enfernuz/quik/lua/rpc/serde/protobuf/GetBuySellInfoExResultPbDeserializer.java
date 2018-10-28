package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfoEx;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbBuySellInfoEx;

enum GetBuySellInfoExResultPbDeserializer implements Deserializer<GetBuySellInfoEx.Result>, FromPbConverter<qlua.rpc.GetBuySellInfoEx.Result, GetBuySellInfoEx.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetBuySellInfoEx.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetBuySellInfoEx.Result.parseFrom(data) );
    }

    @Override
    public GetBuySellInfoEx.Result convert(@NotNull final qlua.rpc.GetBuySellInfoEx.Result result) {
        return new GetBuySellInfoEx.Result( convertFromPbBuySellInfoEx(result.getBuySellInfoEx()) );
    }
}
