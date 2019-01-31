package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetMoneyEx;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetMoneyExArgsPbSerializer implements Serializer<GetMoneyEx.Args>, ToPbConverter<GetMoneyEx.Args, qlua.rpc.GetMoneyEx.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetMoneyEx.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetMoneyEx.Args convert(@NotNull final GetMoneyEx.Args args) {

        return qlua.rpc.GetMoneyEx.Args.newBuilder()
                .setFirmid( args.getFirmId() )
                .setClientCode( args.getClientCode() )
                .setTag( args.getTag() )
                .setCurrcode( args.getCurrCode() )
                .setLimitKind( args.getLimitKind() )
                .build();
    }
}
