package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Sleep;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum SleepArgsPbSerializer implements Serializer<Sleep.Args>, ToPbConverter<Sleep.Args, qlua.rpc.Sleep.Request> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final Sleep.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.Sleep.Request convert(@NotNull final Sleep.Args args) {

        return qlua.rpc.Sleep.Request.newBuilder()
                .setTime( args.getTime() )
                .build();
    }
}
