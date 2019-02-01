package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.L;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum DsLArgsPbSerializer implements Serializer<L.Args>, ToPbConverter<L.Args, qlua.rpc.datasource.L.Args> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final L.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.L.Args convert(@NotNull final L.Args args) {

        return qlua.rpc.datasource.L.Args.newBuilder()
                .setDatasourceUuid( args.getDatasourceUUID() )
                .setCandleIndex( args.getCandleIndex() )
                .build();
    }
}
