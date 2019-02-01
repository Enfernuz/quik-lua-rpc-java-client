package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetSelectedRow;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class SetSelectedRowArgsPbSerdeTest extends AbstractPbSerializationTest<SetSelectedRow.Args, qlua.rpc.SetSelectedRow.Args> {

    private static final int TABLE_ID = 1;
    private static final int ROW = 2;

    @Override
    public @NotNull Serializer<SetSelectedRow.Args> getSerializerUnderTest() {
        return SetSelectedRowArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.SetSelectedRow.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.SetSelectedRow.Args.newBuilder()
                .setTableId(TABLE_ID)
                .setRow(ROW)
                .build();
    }

    @NotNull
    @Override
    public SetSelectedRow.Args getTargetObject() {
        return SetSelectedRow.Args.builder()
                .tableId(TABLE_ID)
                .row(ROW)
                .build();
    }
}
