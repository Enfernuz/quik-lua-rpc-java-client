package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.PrintDbgStr;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum PrintDbgStrArgsPbSerializer implements Serializer<PrintDbgStr.Args>, ToPbConverter<PrintDbgStr.Args, qlua.rpc.PrintDbgStr.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final PrintDbgStr.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.PrintDbgStr.Args convert(@NotNull final PrintDbgStr.Args args) {

        return qlua.rpc.PrintDbgStr.Args.newBuilder()
                .setS( args.getS() )
                .build();
    }
}
