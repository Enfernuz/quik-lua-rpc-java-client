package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetInfoParam;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetInfoParamArgsPbSerializer implements Serializer<GetInfoParam.Args>, ToPbConverter<GetInfoParam.Args, qlua.rpc.GetInfoParam.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetInfoParam.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetInfoParam.Args convert(@NotNull final GetInfoParam.Args args) {

        return qlua.rpc.GetInfoParam.Args.newBuilder()
                .setParamName( args.getParamName() )
                .build();
    }
}
