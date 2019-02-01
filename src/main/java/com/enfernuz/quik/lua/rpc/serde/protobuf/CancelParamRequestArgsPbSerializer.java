package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.CancelParamRequest;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum CancelParamRequestArgsPbSerializer implements Serializer<CancelParamRequest.Args>, ToPbConverter<CancelParamRequest.Args, qlua.rpc.CancelParamRequest.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final CancelParamRequest.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.CancelParamRequest.Args convert(@NotNull final CancelParamRequest.Args args) {

        return qlua.rpc.CancelParamRequest.Args.newBuilder()
                .setClassCode( args.getClassCode() )
                .setSecCode( args.getSecCode() )
                .setDbName( args.getDbName() )
                .build();
    }
}
