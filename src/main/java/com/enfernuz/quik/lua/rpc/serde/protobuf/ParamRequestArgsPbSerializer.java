package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.ParamRequest;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum ParamRequestArgsPbSerializer implements Serializer<ParamRequest.Args>, ToPbConverter<ParamRequest.Args, qlua.rpc.ParamRequest.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final ParamRequest.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.ParamRequest.Args convert(@NotNull final ParamRequest.Args args) {

        return qlua.rpc.ParamRequest.Args.newBuilder()
                .setClassCode( args.getClassCode() )
                .setSecCode( args.getSecCode() )
                .setDbName( args.getDbName() )
                .build();
    }
}
