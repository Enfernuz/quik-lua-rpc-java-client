package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DelAllLabels;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum DelAllLabelsResultPbSerde implements Serde<DelAllLabels.Result>, PbConverter<qlua.rpc.DelAllLabels.Result, DelAllLabels.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final DelAllLabels.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public DelAllLabels.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.DelAllLabels.Result.parseFrom(data) );
    }

    @Override
    public DelAllLabels.Result convertFromPb(@NotNull final qlua.rpc.DelAllLabels.Result result) {
        return DelAllLabels.Result.getInstance( result.getResult() );
    }

    @Override
    public qlua.rpc.DelAllLabels.Result convertToPb(@NotNull final DelAllLabels.Result result) {
        return qlua.rpc.DelAllLabels.Result.newBuilder()
                .setResult( result.isResult() )
                .build();
    }
}
