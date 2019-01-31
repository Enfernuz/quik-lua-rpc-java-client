package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetFuturesHolding;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetFuturesHoldingArgsPbSerializer implements Serializer<GetFuturesHolding.Args>, ToPbConverter<GetFuturesHolding.Args, qlua.rpc.GetFuturesHolding.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetFuturesHolding.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetFuturesHolding.Args convert(@NotNull final GetFuturesHolding.Args args) {

        return qlua.rpc.GetFuturesHolding.Args.newBuilder()
                .setFirmid( args.getFirmId() )
                .setTrdaccid( args.getTrdAccId() )
                .setSecCode( args.getSecCode() )
                .setType( args.getType() )
                .build();
    }
}
