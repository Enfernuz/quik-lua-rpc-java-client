package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassInfo;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetClassInfoArgsPbSerializer implements Serializer<GetClassInfo.Args>, ToPbConverter<GetClassInfo.Args, qlua.rpc.GetClassInfo.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetClassInfo.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public qlua.rpc.GetClassInfo.Args convert(@NotNull final GetClassInfo.Args args) {

        return qlua.rpc.GetClassInfo.Args.newBuilder()
                .setClassCode( args.getClassCode() )
                .build();
    }
}
