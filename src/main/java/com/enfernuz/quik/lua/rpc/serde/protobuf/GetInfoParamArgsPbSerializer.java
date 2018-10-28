package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetInfoParam;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetInfoParamArgsPbSerializer implements Serializer<GetInfoParam.Args>, ToPbConverter<GetInfoParam.Args, qlua.rpc.GetInfoParam.Request> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetInfoParam.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetInfoParam.Request convert(@NotNull final GetInfoParam.Args args) {

        return qlua.rpc.GetInfoParam.Request.newBuilder()
                .setParamName( args.getParamName() )
                .build();
    }
}
