package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetColor;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class SetColorArgsPbSerdeTest extends AbstractPbSerializationTest<SetColor.Args, qlua.rpc.SetColor.Args> {

    private static final int T_ID = 1;
    private static final int ROW = 2;
    private static final int COL = 3;
    private static final int B_COLOR = 4;
    private static final int F_COLOR = 5;
    private static final int SEL_B_COLOR = 6;
    private static final int SEL_F_COLOR = 7;

    @Override
    public @NotNull Serializer<SetColor.Args> getSerializerUnderTest() {
        return SetColorArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.SetColor.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.SetColor.Args.newBuilder()
                .setTId(T_ID)
                .setValueRow(ROW)
                .setValueCol(COL)
                .setValueBColor(B_COLOR)
                .setValueFColor(F_COLOR)
                .setValueSelBColor(SEL_B_COLOR)
                .setValueSelFColor(SEL_F_COLOR)
                .build();
    }

    @NotNull
    @Override
    public SetColor.Args getTargetObject() {
        return SetColor.Args.builder()
                .tId(T_ID)
                .row(ROW)
                .col(COL)
                .bColor(B_COLOR)
                .fColor(F_COLOR)
                .selBColor(SEL_B_COLOR)
                .selFColor(SEL_F_COLOR)
                .build();
    }
}
