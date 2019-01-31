package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetMoney;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetMoneyArgsPbSerializer implements Serializer<GetMoney.Args>, ToPbConverter<GetMoney.Args, qlua.rpc.GetMoney.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetMoney.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetMoney.Args convert(@NotNull final GetMoney.Args args) {

        return qlua.rpc.GetMoney.Args.newBuilder()
                .setClientCode( args.getClientCode() )
                .setFirmid( args.getFirmId() )
                .setTag( args.getTag() )
                .setCurrcode( args.getCurrCode() )
                .build();
    }
}
