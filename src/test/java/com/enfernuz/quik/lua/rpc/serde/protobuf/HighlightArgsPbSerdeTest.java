package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Highlight;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class HighlightArgsPbSerdeTest extends AbstractPbSerializationTest<Highlight.Args, qlua.rpc.Highlight.Args> {

    private static final int T_ID = 1;
    private static final int ROW = 2;
    private static final int COL = 3;
    private static final int B_COLOR = 4;
    private static final int F_COLOR = 5;
    private static final int TIMEOUT = 6;

    @Override
    public @NotNull Serializer<Highlight.Args> getSerializerUnderTest() {
        return HighlightArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.Highlight.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.Highlight.Args.newBuilder()
                .setTId(T_ID)
                .setValueRow(ROW)
                .setValueCol(COL)
                .setValueBColor(B_COLOR)
                .setValueFColor(F_COLOR)
                .setTimeout(TIMEOUT)
                .build();
    }

    @NotNull
    @Override
    public Highlight.Args getTargetObject() {

        return Highlight.Args.builder()
                .tId(T_ID)
                .row(ROW)
                .col(COL)
                .bColor(B_COLOR)
                .fColor(F_COLOR)
                .timeout(TIMEOUT)
                .build();
    }
}
