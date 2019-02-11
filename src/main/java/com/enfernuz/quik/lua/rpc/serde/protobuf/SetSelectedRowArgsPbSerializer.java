package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetSelectedRow;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum SetSelectedRowArgsPbSerializer implements Serializer<SetSelectedRow.Args>, ToPbConverter<SetSelectedRow.Args, qlua.rpc.SetSelectedRow.Args> {

    INSTANCE;

    @NotNull
    @Override
    public byte[] serialize(@NotNull final SetSelectedRow.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public qlua.rpc.SetSelectedRow.Args convert(@NotNull final SetSelectedRow.Args args) {

        final qlua.rpc.SetSelectedRow.Args.Builder pbResult =
                qlua.rpc.SetSelectedRow.Args.newBuilder()
                        .setTableId( args.getTableId() );

        final Integer row = args.getRow();
        if (row == null) {
            pbResult.setNullRow(true);
        } else {
            pbResult.setValueRow(row);
        }

        return pbResult.build();
    }
}
