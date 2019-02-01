package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetDepoEx;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.RPC;

enum GetDepoExArgsPbSerializer implements Serializer<GetDepoEx.Args>, ToPbConverter<GetDepoEx.Args, qlua.rpc.GetDepoEx.Args> {

    INSTANCE;

    private static final RPC.ProcedureType PROCEDURE_TYPE = RPC.ProcedureType.GET_DEPO_EX;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetDepoEx.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetDepoEx.Args convert(@NotNull final GetDepoEx.Args args) {

        return qlua.rpc.GetDepoEx.Args.newBuilder()
                .setFirmid( args.getFirmId() )
                .setClientCode( args.getClientCode() )
                .setSecCode( args.getSecCode() )
                .setTrdaccid( args.getTrdAccId() )
                .setLimitKind( args.getLimitKind() )
                .build();
    }
}
