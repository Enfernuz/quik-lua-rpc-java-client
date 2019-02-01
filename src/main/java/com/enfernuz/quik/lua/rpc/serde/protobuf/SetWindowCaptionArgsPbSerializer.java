package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetWindowCaption;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum SetWindowCaptionArgsPbSerializer implements Serializer<SetWindowCaption.Args>, ToPbConverter<SetWindowCaption.Args, qlua.rpc.SetWindowCaption.Args> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final SetWindowCaption.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.SetWindowCaption.Args convert(@NotNull final SetWindowCaption.Args args) {

        return qlua.rpc.SetWindowCaption.Args.newBuilder()
                .setTId( args.getTId() )
                .setStr( args.getStr() )
                .build();
    }
}
