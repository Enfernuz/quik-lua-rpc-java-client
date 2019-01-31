package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetWindowRect;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetWindowRectArgsPbSerializer implements Serializer<GetWindowRect.Args>, ToPbConverter<GetWindowRect.Args, qlua.rpc.GetWindowRect.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetWindowRect.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetWindowRect.Args convert(@NotNull final GetWindowRect.Args args) {

        return qlua.rpc.GetWindowRect.Args.newBuilder()
                .setTId( args.getTId() )
                .build();
    }
}
