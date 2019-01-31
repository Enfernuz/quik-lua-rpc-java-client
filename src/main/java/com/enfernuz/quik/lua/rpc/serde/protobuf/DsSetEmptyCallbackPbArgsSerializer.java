package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.SetEmptyCallback;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum DsSetEmptyCallbackPbArgsSerializer implements Serializer<SetEmptyCallback.Args>, ToPbConverter<SetEmptyCallback.Args, qlua.rpc.datasource.SetEmptyCallback.Args> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final SetEmptyCallback.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.SetEmptyCallback.Args convert(@NotNull final SetEmptyCallback.Args args) {

        return qlua.rpc.datasource.SetEmptyCallback.Args.newBuilder()
                .setDatasourceUuid( args.getDatasourceUUID() )
                .build();
    }
}
