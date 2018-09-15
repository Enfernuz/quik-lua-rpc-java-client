package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetWorkingFolder;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum GetWorkingFolderResultPbSerde implements Serde<GetWorkingFolder.Result>, PbConverter<qlua.rpc.GetWorkingFolder.Result, GetWorkingFolder.Result> {

    INSTANCE;

    @Override
    public byte[] serialize(final GetWorkingFolder.Result result) {
        return convertToPb(result).toByteArray();
    }

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetWorkingFolder.Result deserialize(final byte[] data) {
        return convertFromPb( qlua.rpc.GetWorkingFolder.Result.parseFrom(data) );
    }

    @Override
    public GetWorkingFolder.Result convertFromPb(@NotNull final qlua.rpc.GetWorkingFolder.Result result) {
        return new GetWorkingFolder.Result( result.getWorkingFolder() );
    }

    @Override
    public qlua.rpc.GetWorkingFolder.Result convertToPb(@NotNull final GetWorkingFolder.Result result) {
        return qlua.rpc.GetWorkingFolder.Result.newBuilder()
                .setWorkingFolder( result.getWorkingFolder() )
                .build();
    }
}
