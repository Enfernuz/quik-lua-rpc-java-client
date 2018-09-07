package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.AddLabel;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum AddLabelResultPbSerde implements Serde<AddLabel.Result>, PbConverter<qlua.rpc.AddLabel.Result, AddLabel.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final AddLabel.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public AddLabel.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.AddLabel.Result.parseFrom(data) );
    }

    @Override
    public AddLabel.Result convertFromPb(@NotNull final qlua.rpc.AddLabel.Result result) {
        return new AddLabel.Result( result.getLabelId() );
    }

    @Override
    public qlua.rpc.AddLabel.Result convertToPb(@NotNull final AddLabel.Result result) {
        return qlua.rpc.AddLabel.Result.newBuilder()
                .setLabelId( result.getLabelId() )
                .build();
    }
}
