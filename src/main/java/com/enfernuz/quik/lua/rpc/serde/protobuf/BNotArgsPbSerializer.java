package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BNot;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.bit.Bnot;

enum BNotArgsPbSerializer implements Serializer<BNot.Args>, ToPbConverter<BNot.Args, qlua.rpc.bit.Bnot.Request> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final BNot.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public Bnot.Request convert(@NotNull final BNot.Args args) {

        return Bnot.Request.newBuilder()
                .setX( args.getX() )
                .build();
    }
}
