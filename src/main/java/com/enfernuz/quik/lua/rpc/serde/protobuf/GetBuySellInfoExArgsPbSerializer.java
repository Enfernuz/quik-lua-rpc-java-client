package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfoEx;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetBuySellInfoExArgsPbSerializer implements Serializer<GetBuySellInfoEx.Args>, ToPbConverter<GetBuySellInfoEx.Args, qlua.rpc.GetBuySellInfoEx.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetBuySellInfoEx.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetBuySellInfoEx.Args convert(@NotNull final GetBuySellInfoEx.Args args) {

        return qlua.rpc.GetBuySellInfoEx.Args.newBuilder()
                .setFirmId( args.getFirmId() )
                .setClientCode( args.getClientCode() )
                .setClassCode( args.getClassCode() )
                .setSecCode( args.getSecCode() )
                .setPrice( args.getPrice() )
                .build();
    }
}
