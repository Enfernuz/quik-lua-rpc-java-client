package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DestroyTable;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum DestroyTableArgsPbSerializer implements Serializer<DestroyTable.Args>, ToPbConverter<DestroyTable.Args, qlua.rpc.DestroyTable.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final DestroyTable.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.DestroyTable.Args convert(@NotNull final DestroyTable.Args args) {

        return qlua.rpc.DestroyTable.Args.newBuilder()
                .setTId( args.getTId() )
                .build();
    }
}
