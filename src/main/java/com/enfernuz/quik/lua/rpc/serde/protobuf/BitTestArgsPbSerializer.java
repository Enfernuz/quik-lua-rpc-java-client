package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.bit.Test;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.bit.Btest;

enum BitTestArgsPbSerializer implements Serializer<Test.Args>, ToPbConverter<Test.Args, qlua.rpc.bit.Btest.Request> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final Test.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public Btest.Request convert(@NotNull final Test.Args args) {

        return Btest.Request.newBuilder()
                .setX( args.getX() )
                .setN( args.getN() )
                .build();
    }
}
