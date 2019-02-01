package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassSecurities;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetClassSecuritiesArgsPbSerializer implements Serializer<GetClassSecurities.Args>, ToPbConverter<GetClassSecurities.Args, qlua.rpc.GetClassSecurities.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetClassSecurities.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetClassSecurities.Args convert(@NotNull final GetClassSecurities.Args args) {

        return qlua.rpc.GetClassSecurities.Args.newBuilder()
                .setClassCode( args.getClassCode() )
                .build();
    }
}
