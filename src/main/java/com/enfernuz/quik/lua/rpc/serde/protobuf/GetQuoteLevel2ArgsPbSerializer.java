package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetQuoteLevel2;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetQuoteLevel2ArgsPbSerializer implements Serializer<GetQuoteLevel2.Args>, ToPbConverter<GetQuoteLevel2.Args, qlua.rpc.GetQuoteLevel2.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetQuoteLevel2.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetQuoteLevel2.Args convert(@NotNull final GetQuoteLevel2.Args args) {

        return qlua.rpc.GetQuoteLevel2.Args.newBuilder()
                .setClassCode( args.getClassCode() )
                .setSecCode( args.getSecCode() )
                .build();
    }
}
