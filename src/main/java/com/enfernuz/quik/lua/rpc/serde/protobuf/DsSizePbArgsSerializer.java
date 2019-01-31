package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.Size;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum DsSizePbArgsSerializer implements Serializer<Size.Args>, ToPbConverter<Size.Args, qlua.rpc.datasource.Size.Args> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final Size.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.Size.Args convert(@NotNull final Size.Args args) {

        return qlua.rpc.datasource.Size.Args.newBuilder()
                .setDatasourceUuid( args.getDatasourceUUID() )
                .build();
    }
}
