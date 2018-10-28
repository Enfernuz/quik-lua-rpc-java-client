package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetFuturesHolding;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetFuturesHoldingArgsPbSerializer implements Serializer<GetFuturesHolding.Args>, ToPbConverter<GetFuturesHolding.Args, qlua.rpc.GetFuturesHolding.Request> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetFuturesHolding.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetFuturesHolding.Request convert(@NotNull final GetFuturesHolding.Args args) {

        return qlua.rpc.GetFuturesHolding.Request.newBuilder()
                .setFirmid( args.getFirmId() )
                .setTrdaccid( args.getTrdAccId() )
                .setSecCode( args.getSecCode() )
                .setType( args.getType() )
                .build();
    }
}
