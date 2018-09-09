package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetCell;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum GetCellResultPbSerde implements Serde<GetCell.Result>, PbConverter<qlua.rpc.GetCell.Result, GetCell.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetCell.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetCell.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetCell.Result.parseFrom(data) );
    }

    @Override
    public GetCell.Result convertFromPb(@NotNull final qlua.rpc.GetCell.Result result) {
        return GetCell.Result.builder()
                .image( result.getImage() )
                .value( result.getValue() )
                .build();
    }

    @Override
    public qlua.rpc.GetCell.Result convertToPb(@NotNull final GetCell.Result result) {
        return qlua.rpc.GetCell.Result.newBuilder()
                .setImage( result.getImage() )
                .setValue( result.getValue() )
                .build();
    }
}
