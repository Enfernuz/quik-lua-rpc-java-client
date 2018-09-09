package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetDepo;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.*;

enum GetDepoResultPbSerde implements Serde<GetDepo.Result>, PbConverter<qlua.rpc.GetDepo.Result, GetDepo.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetDepo.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetDepo.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetDepo.Result.parseFrom(data) );
    }

    @Override
    public GetDepo.Result convertFromPb(@NotNull final qlua.rpc.GetDepo.Result result) {
        return new GetDepo.Result( convertFromPbDepo(result.getDepo()) );
    }

    @Override
    public qlua.rpc.GetDepo.Result convertToPb(@NotNull final GetDepo.Result result) {

        return qlua.rpc.GetDepo.Result.newBuilder()
                .setDepo( convertToPbDepo(result.getDepo()) )
                .build();
    }
}
