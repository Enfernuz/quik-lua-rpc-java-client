package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.CalcBuySell;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum CalcBuySellArgsPbSerializer implements Serializer<CalcBuySell.Args>, ToPbConverter<CalcBuySell.Args, qlua.rpc.CalcBuySell.Request> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final CalcBuySell.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.CalcBuySell.Request convert(@NotNull final CalcBuySell.Args args) {

        return qlua.rpc.CalcBuySell.Request.newBuilder()
                .setClassCode( args.getClassCode() )
                .setSecCode( args.getSecCode() )
                .setClientCode( args.getClientCode() )
                .setAccount( args.getAccount() )
                .setPrice( args.getPrice() )
                .setIsBuy( args.isBuy() )
                .setIsMarket( args.isMarket() )
                .build();
    }
}
