package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.InsertRow;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum InsertRowArgsPbSerializer implements Serializer<InsertRow.Args>, ToPbConverter<InsertRow.Args, qlua.rpc.InsertRow.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final InsertRow.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.InsertRow.Args convert(@NotNull final InsertRow.Args args) {

        return qlua.rpc.InsertRow.Args.newBuilder()
                .setTId( args.getTId() )
                .setKey( args.getKey() )
                .build();
    }
}
