package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetCell;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetCellArgsPbSerializer implements Serializer<GetCell.Args>, ToPbConverter<GetCell.Args, qlua.rpc.GetCell.Args> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetCell.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetCell.Args convert(@NotNull final GetCell.Args args) {

        return qlua.rpc.GetCell.Args.newBuilder()
                .setTId( args.getTId() )
                .setKey( args.getKey() )
                .setCode( args.getCode() )
                .build();
    }
}
