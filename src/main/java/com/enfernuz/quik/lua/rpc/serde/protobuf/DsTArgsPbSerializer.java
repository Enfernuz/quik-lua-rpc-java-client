package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.T;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum DsTArgsPbSerializer implements Serializer<T.Args>, ToPbConverter<T.Args, qlua.rpc.datasource.T.Args> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final T.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.T.Args convert(@NotNull final T.Args args) {

        return qlua.rpc.datasource.T.Args.newBuilder()
                .setDatasourceUuid( args.getDatasourceUUID() )
                .setCandleIndex( args.getCandleIndex() )
                .build();
    }
}
