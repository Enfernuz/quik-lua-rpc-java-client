package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.C;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum DsCArgsPbSerializer implements Serializer<C.Args>, ToPbConverter<C.Args, qlua.rpc.datasource.C.Args> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final C.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.C.Args convert(@NotNull final C.Args args) {

        return qlua.rpc.datasource.C.Args.newBuilder()
                .setDatasourceUuid( args.getDatasourceUUID() )
                .setCandleIndex( args.getCandleIndex() )
                .build();
    }
}
