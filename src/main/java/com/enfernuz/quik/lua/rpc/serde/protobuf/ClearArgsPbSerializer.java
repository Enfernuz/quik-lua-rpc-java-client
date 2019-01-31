package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Clear;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum ClearArgsPbSerializer implements Serializer<Clear.Args>, ToPbConverter<Clear.Args, qlua.rpc.Clear.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final Clear.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.Clear.Args convert(@NotNull final Clear.Args args) {

        return qlua.rpc.Clear.Args.newBuilder()
                .setTId( args.getTId() )
                .build();
    }
}
