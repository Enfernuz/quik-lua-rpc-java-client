package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetNumberOf;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetNumberOfArgsPbSerializer implements Serializer<GetNumberOf.Args>, ToPbConverter<GetNumberOf.Args, qlua.rpc.GetNumberOf.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetNumberOf.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetNumberOf.Args convert(@NotNull final GetNumberOf.Args args) {

        return qlua.rpc.GetNumberOf.Args.newBuilder()
                .setTableName( args.getTableName() )
                .build();
    }
}
