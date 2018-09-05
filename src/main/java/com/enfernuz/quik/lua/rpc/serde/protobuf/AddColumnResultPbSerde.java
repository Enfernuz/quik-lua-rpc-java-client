package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.AddColumn;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum AddColumnResultPbSerde implements Serde<AddColumn.Result>, PbConverter<qlua.rpc.AddColumn.Result, AddColumn.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final AddColumn.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public AddColumn.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.AddColumn.Result.parseFrom(data) );
    }

    @Override
    public AddColumn.Result convertFromPb(@NotNull final qlua.rpc.AddColumn.Result result) {
        return new AddColumn.Result( result.getResult() );
    }

    @Override
    public qlua.rpc.AddColumn.Result convertToPb(@NotNull final AddColumn.Result result) {
        return qlua.rpc.AddColumn.Result.newBuilder()
                .setResult( result.getResult() )
                .build();
    }
}
