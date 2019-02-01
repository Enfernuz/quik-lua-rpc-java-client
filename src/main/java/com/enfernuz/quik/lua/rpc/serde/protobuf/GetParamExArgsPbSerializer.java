package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetParamEx;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetParamExArgsPbSerializer implements Serializer<GetParamEx.Args>, ToPbConverter<GetParamEx.Args, qlua.rpc.GetParamEx.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetParamEx.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetParamEx.Args convert(@NotNull final GetParamEx.Args args) {

        return qlua.rpc.GetParamEx.Args.newBuilder()
                .setClassCode( args.getClassCode() )
                .setSecCode( args.getSecCode() )
                .setParamName( args.getParamName() )
                .build();
    }
}
