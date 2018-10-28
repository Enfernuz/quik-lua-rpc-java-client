package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassSecurities;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetClassSecuritiesArgsPbSerializer implements Serializer<GetClassSecurities.Args>, ToPbConverter<GetClassSecurities.Args, qlua.rpc.GetClassSecurities.Request> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetClassSecurities.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetClassSecurities.Request convert(@NotNull final GetClassSecurities.Args args) {

        return qlua.rpc.GetClassSecurities.Request.newBuilder()
                .setClassCode( args.getClassCode() )
                .build();
    }
}
