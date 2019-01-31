package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetParamEx2;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetParamEx2ArgsPbSerializer implements Serializer<GetParamEx2.Args>, ToPbConverter<GetParamEx2.Args, qlua.rpc.GetParamEx2.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetParamEx2.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetParamEx2.Args convert(@NotNull final GetParamEx2.Args args) {

        return qlua.rpc.GetParamEx2.Args.newBuilder()
                .setClassCode( args.getClassCode() )
                .setSecCode( args.getSecCode() )
                .setParamName( args.getParamName() )
                .build();
    }
}
