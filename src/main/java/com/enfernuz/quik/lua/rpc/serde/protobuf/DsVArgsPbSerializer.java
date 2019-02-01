package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.V;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum DsVArgsPbSerializer implements Serializer<V.Args>, ToPbConverter<V.Args, qlua.rpc.datasource.V.Args> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final V.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.V.Args convert(@NotNull final V.Args args) {

        return qlua.rpc.datasource.V.Args.newBuilder()
                .setDatasourceUuid( args.getDatasourceUUID() )
                .setCandleIndex( args.getCandleIndex() )
                .build();
    }
}
