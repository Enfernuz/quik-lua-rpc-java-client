package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetNumCandles;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetNumCandlesArgsPbSerializer implements Serializer<GetNumCandles.Args>, ToPbConverter<GetNumCandles.Args, qlua.rpc.GetNumCandles.Request> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetNumCandles.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetNumCandles.Request convert(@NotNull final GetNumCandles.Args args) {

        return qlua.rpc.GetNumCandles.Request.newBuilder()
                .setTag( args.getTag() )
                .build();
    }
}
