package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassSecurities;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum GetClassSecuritiesResultPbSerde implements Serde<GetClassSecurities.Result>, PbConverter<qlua.rpc.GetClassSecurities.Result, GetClassSecurities.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetClassSecurities.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetClassSecurities.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetClassSecurities.Result.parseFrom(data) );
    }

    @Override
    public GetClassSecurities.Result convertFromPb(@NotNull final qlua.rpc.GetClassSecurities.Result result) {
        return new GetClassSecurities.Result( convertFromPbString(result.getClassSecurities()) );
    }

    @Override
    public qlua.rpc.GetClassSecurities.Result convertToPb(@NotNull final GetClassSecurities.Result result) {
        return qlua.rpc.GetClassSecurities.Result.newBuilder()
                .setClassSecurities( convertToPbString(result.getClassSecurities()) )
                .build();
    }
}
