package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DelLabel;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum DelLabelResultPbSerde implements Serde<DelLabel.Result>, PbConverter<qlua.rpc.DelLabel.Result, DelLabel.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final DelLabel.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public DelLabel.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.DelLabel.Result.parseFrom(data) );
    }

    @Override
    public DelLabel.Result convertFromPb(@NotNull final qlua.rpc.DelLabel.Result result) {
        return DelLabel.Result.getInstance( result.getResult() );
    }

    @Override
    public qlua.rpc.DelLabel.Result convertToPb(@NotNull final DelLabel.Result result) {
        return qlua.rpc.DelLabel.Result.newBuilder()
                .setResult( result.isResult() )
                .build();
    }
}
