package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfo;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.*;

enum GetBuySellInfoResultPbSerde implements Serde<GetBuySellInfo.Result>, PbConverter<qlua.rpc.GetBuySellInfo.Result, GetBuySellInfo.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetBuySellInfo.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetBuySellInfo.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetBuySellInfo.Result.parseFrom(data) );
    }

    @Override
    public GetBuySellInfo.Result convertFromPb(@NotNull final qlua.rpc.GetBuySellInfo.Result result) {
        return new GetBuySellInfo.Result( convertFromPbBuySellInfo(result.getBuySellInfo()) );
    }

    @Override
    public qlua.rpc.GetBuySellInfo.Result convertToPb(@NotNull final GetBuySellInfo.Result result) {

        return qlua.rpc.GetBuySellInfo.Result.newBuilder()
                .setBuySellInfo( convertToPbBuySellInfo(result.getBuySellInfo()) )
                .build();
    }
}
