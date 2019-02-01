package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.O;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum DsOArgsPbSerializer implements Serializer<O.Args>, ToPbConverter<O.Args, qlua.rpc.datasource.O.Args> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final O.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.O.Args convert(@NotNull final O.Args args) {

        return qlua.rpc.datasource.O.Args.newBuilder()
                .setDatasourceUuid( args.getDatasourceUUID() )
                .setCandleIndex( args.getCandleIndex() )
                .build();
    }
}
