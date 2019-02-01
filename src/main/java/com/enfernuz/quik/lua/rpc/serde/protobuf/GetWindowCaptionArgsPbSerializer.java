package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetWindowCaption;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetWindowCaptionArgsPbSerializer implements Serializer<GetWindowCaption.Args>, ToPbConverter<GetWindowCaption.Args, qlua.rpc.GetWindowCaption.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetWindowCaption.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetWindowCaption.Args convert(@NotNull final GetWindowCaption.Args args) {

        return qlua.rpc.GetWindowCaption.Args.newBuilder()
                .setTId( args.getTId() )
                .build();
    }
}
