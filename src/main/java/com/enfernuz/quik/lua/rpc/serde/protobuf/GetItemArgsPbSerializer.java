package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetItem;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetItemArgsPbSerializer implements Serializer<GetItem.Args>, ToPbConverter<GetItem.Args, qlua.rpc.GetItem.Request> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetItem.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetItem.Request convert(@NotNull final GetItem.Args args) {

        return qlua.rpc.GetItem.Request.newBuilder()
                .setTableName( args.getTableName() )
                .setIndex( args.getIndex() )
                .build();
    }
}
