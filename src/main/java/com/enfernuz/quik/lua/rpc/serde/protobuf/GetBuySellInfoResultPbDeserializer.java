package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfo;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbBuySellInfo;

enum GetBuySellInfoResultPbDeserializer implements Deserializer<GetBuySellInfo.Result>, FromPbConverter<qlua.rpc.GetBuySellInfo.Result, GetBuySellInfo.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetBuySellInfo.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetBuySellInfo.Result.parseFrom(data) );
    }

    @Override
    public GetBuySellInfo.Result convert(@NotNull final qlua.rpc.GetBuySellInfo.Result result) {
        return new GetBuySellInfo.Result( convertFromPbBuySellInfo(result.getBuySellInfo()) );
    }
}
