package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetPortfolioInfoEx;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetPortfolioInfoExArgsPbSerializer implements Serializer<GetPortfolioInfoEx.Args>, ToPbConverter<GetPortfolioInfoEx.Args, qlua.rpc.GetPortfolioInfoEx.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetPortfolioInfoEx.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetPortfolioInfoEx.Args convert(@NotNull final GetPortfolioInfoEx.Args args) {

        return qlua.rpc.GetPortfolioInfoEx.Args.newBuilder()
                .setFirmId( args.getFirmId() )
                .setClientCode( args.getClientCode() )
                .setLimitKind( args.getLimitKind() )
                .build();
    }
}
