package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetNumberOf;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetNumberOfArgsPbSerializer implements Serializer<GetNumberOf.Args>, ToPbConverter<GetNumberOf.Args, qlua.rpc.GetNumberOf.Request> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetNumberOf.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetNumberOf.Request convert(@NotNull final GetNumberOf.Args args) {

        return qlua.rpc.GetNumberOf.Request.newBuilder()
                .setTableName( args.getTableName() )
                .build();
    }
}
