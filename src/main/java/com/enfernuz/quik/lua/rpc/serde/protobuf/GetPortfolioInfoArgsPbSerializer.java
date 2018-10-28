package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetPortfolioInfo;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetPortfolioInfoArgsPbSerializer implements Serializer<GetPortfolioInfo.Args>, ToPbConverter<GetPortfolioInfo.Args, qlua.rpc.GetPortfolioInfo.Request> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetPortfolioInfo.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetPortfolioInfo.Request convert(@NotNull final GetPortfolioInfo.Args args) {

        return qlua.rpc.GetPortfolioInfo.Request.newBuilder()
                .setFirmId( args.getFirmId() )
                .setClientCode( args.getClientCode() )
                .build();
    }
}
