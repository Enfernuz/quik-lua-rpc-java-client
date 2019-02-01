package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetWindowPos;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum SetWindowPosArgsPbSerializer implements Serializer<SetWindowPos.Args>, ToPbConverter<SetWindowPos.Args, qlua.rpc.SetWindowPos.Args> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final SetWindowPos.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.SetWindowPos.Args convert(@NotNull final SetWindowPos.Args args) {

        return qlua.rpc.SetWindowPos.Args.newBuilder()
                .setTId( args.getTId() )
                .setX( args.getX() )
                .setY( args.getY() )
                .setDx( args.getDX() )
                .setDy( args.getDY() )
                .build();
    }
}
