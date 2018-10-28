package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetTableSize;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetTableSizeArgsPbSerializer implements Serializer<GetTableSize.Args>, ToPbConverter<GetTableSize.Args, qlua.rpc.GetTableSize.Request> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetTableSize.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetTableSize.Request convert(@NotNull final GetTableSize.Args request) {

        return qlua.rpc.GetTableSize.Request.newBuilder()
                .setTId( request.getTId() )
                .build();
    }
}
