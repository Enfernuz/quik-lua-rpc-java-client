package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.Close;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum DsClosePbArgsSerializer implements Serializer<Close.Args>, ToPbConverter<Close.Args, qlua.rpc.datasource.Close.Args> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final Close.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.Close.Args convert(@NotNull final Close.Args args) {

        return qlua.rpc.datasource.Close.Args.newBuilder()
                .setDatasourceUuid( args.getDatasourceUUID() )
                .build();
    }
}
