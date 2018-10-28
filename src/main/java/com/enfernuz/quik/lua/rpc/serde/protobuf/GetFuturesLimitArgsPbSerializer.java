package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetFuturesLimit;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetFuturesLimitArgsPbSerializer implements Serializer<GetFuturesLimit.Args>, ToPbConverter< GetFuturesLimit.Args, qlua.rpc.GetFuturesLimit.Request> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetFuturesLimit.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetFuturesLimit.Request convert(@NotNull final GetFuturesLimit.Args args) {

        return qlua.rpc.GetFuturesLimit.Request.newBuilder()
                .setFirmid( args.getFirmId() )
                .setTrdaccid( args.getTrdAccId() )
                .setLimitType( args.getLimitType() )
                .setCurrcode( args.getCurrCode() )
                .build();
    }
}
