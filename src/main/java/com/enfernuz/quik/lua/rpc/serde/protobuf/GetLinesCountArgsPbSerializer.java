package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetLinesCount;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetLinesCountArgsPbSerializer implements Serializer<GetLinesCount.Args>, ToPbConverter<GetLinesCount.Args, qlua.rpc.GetLinesCount.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetLinesCount.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetLinesCount.Args convert(@NotNull final GetLinesCount.Args args) {

        return qlua.rpc.GetLinesCount.Args.newBuilder()
                .setTag( args.getTag() )
                .build();
    }
}
