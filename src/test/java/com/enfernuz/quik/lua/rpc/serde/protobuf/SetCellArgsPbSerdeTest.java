package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetCell;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class SetCellArgsPbSerdeTest extends AbstractPbSerializationTest<SetCell.Args, qlua.rpc.SetCell.Request> {

    private static final int T_ID = 1;
    private static final int KEY = 2;
    private static final int CODE = 3;
    private static final String TEXT = "4";
    private static final double VALUE = 5.123;

    @Override
    public @NotNull Serializer<SetCell.Args> getSerializerUnderTest() {
        return SetCellArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.SetCell.Request getTargetObjectAsPbMessage() {

        return qlua.rpc.SetCell.Request.newBuilder()
                .setTId(T_ID)
                .setKey(KEY)
                .setCode(CODE)
                .setText(TEXT)
                .setValue(VALUE)
                .build();
    }

    @NotNull
    @Override
    public SetCell.Args getTargetObject() {
        return SetCell.Args.builder()
                .tId(T_ID)
                .key(KEY)
                .code(CODE)
                .text(TEXT)
                .value(VALUE)
                .build();
    }
}
