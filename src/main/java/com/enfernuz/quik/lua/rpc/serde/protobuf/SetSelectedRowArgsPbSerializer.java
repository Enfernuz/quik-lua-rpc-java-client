package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetSelectedRow;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum SetSelectedRowArgsPbSerializer implements Serializer<SetSelectedRow.Args>, ToPbConverter<SetSelectedRow.Args, qlua.rpc.SetSelectedRow.Request> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final SetSelectedRow.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.SetSelectedRow.Request convert(@NotNull final SetSelectedRow.Args args) {

        return qlua.rpc.SetSelectedRow.Request.newBuilder()
                .setTableId( args.getTableId() )
                .setRow( args.getRow() )
                .build();
    }
}
