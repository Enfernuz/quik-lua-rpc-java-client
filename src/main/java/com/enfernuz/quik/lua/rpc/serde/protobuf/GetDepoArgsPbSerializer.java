package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetDepo;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetDepoArgsPbSerializer implements Serializer<GetDepo.Args>, ToPbConverter<GetDepo.Args, qlua.rpc.GetDepo.Request> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetDepo.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetDepo.Request convert(@NotNull final GetDepo.Args args) {

        return qlua.rpc.GetDepo.Request.newBuilder()
                .setClientCode( args.getClientCode() )
                .setFirmid( args.getFirmId() )
                .setSecCode( args.getSecCode() )
                .setTrdaccid( args.getTrdAccId() )
                .build();
    }
}
