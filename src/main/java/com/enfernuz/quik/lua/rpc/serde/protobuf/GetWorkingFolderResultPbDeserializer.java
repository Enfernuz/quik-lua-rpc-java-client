package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetWorkingFolder;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

enum GetWorkingFolderResultPbDeserializer implements Deserializer<GetWorkingFolder.Result>, FromPbConverter<qlua.rpc.GetWorkingFolder.Result, GetWorkingFolder.Result> {

    INSTANCE;

    @NotNull
    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public GetWorkingFolder.Result deserialize(final byte[] data) {
        return convert( qlua.rpc.GetWorkingFolder.Result.parseFrom(data) );
    }

    @Override
    public GetWorkingFolder.Result convert(@NotNull final qlua.rpc.GetWorkingFolder.Result result) {
        return new GetWorkingFolder.Result( result.getWorkingFolder() );
    }
}
