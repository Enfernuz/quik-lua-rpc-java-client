package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DeleteRow;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum DeleteRowArgsPbSerializer implements Serializer<DeleteRow.Args>, ToPbConverter<DeleteRow.Args, qlua.rpc.DeleteRow.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final DeleteRow.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.DeleteRow.Args convert(@NotNull final DeleteRow.Args args) {

        return qlua.rpc.DeleteRow.Args.newBuilder()
                .setTId( args.getTId() )
                .setKey( args.getKey() )
                .build();
    }
}
