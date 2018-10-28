package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsWindowClosed;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum IsWindowClosedArgsPbSerializer implements Serializer<IsWindowClosed.Args>, ToPbConverter<IsWindowClosed.Args, qlua.rpc.IsWindowClosed.Request> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final IsWindowClosed.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.IsWindowClosed.Request convert(@NotNull final IsWindowClosed.Args args) {

        return qlua.rpc.IsWindowClosed.Request.newBuilder()
                .setTId( args.getTId() )
                .build();
    }
}
