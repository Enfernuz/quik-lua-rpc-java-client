package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.H;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum DsHArgsPbSerializer implements Serializer<H.Args>, ToPbConverter<H.Args, qlua.rpc.datasource.H.Args> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final H.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.H.Args convert(@NotNull final H.Args args) {

        return qlua.rpc.datasource.H.Args.newBuilder()
                .setDatasourceUuid( args.getDatasourceUUID() )
                .setCandleIndex( args.getCandleIndex() )
                .build();
    }
}
