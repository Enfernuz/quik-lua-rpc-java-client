package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetSecurityInfo;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetSecurityInfoArgsPbSerializer implements Serializer<GetSecurityInfo.Args>, ToPbConverter<GetSecurityInfo.Args, qlua.rpc.GetSecurityInfo.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetSecurityInfo.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetSecurityInfo.Args convert(@NotNull final GetSecurityInfo.Args args) {

        return qlua.rpc.GetSecurityInfo.Args.newBuilder()
                .setClassCode( args.getClassCode() )
                .setSecCode( args.getSecCode() )
                .build();
    }
}
