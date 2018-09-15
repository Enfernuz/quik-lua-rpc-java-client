package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Highlight;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;

public class HighlightRequestPbSerdeTest extends AbstractRequestPbSerdeTest<Highlight.Request> {

    private static final int T_ID = 1;
    private static final int ROW = 2;
    private static final int COL = 3;
    private static final int B_COLOR = 4;
    private static final int F_COLOR = 5;
    private static final int TIMEOUT = 6;

    @Override
    public RPC.@NotNull ProcedureType getProcedureType() {
        return RPC.ProcedureType.HIGHLIGHT;
    }

    @Override
    public @Nullable MessageLite getPbRequestArgs() {
        return qlua.rpc.Highlight.Request.newBuilder()
                .setTId(T_ID)
                .setRow(ROW)
                .setCol(COL)
                .setBColor(B_COLOR)
                .setFColor(F_COLOR)
                .setTimeout(TIMEOUT)
                .build();
    }

    @Override
    public @NotNull Class<Highlight.Request> getTargetObjectClass() {
        return Highlight.Request.class;
    }

    @NotNull
    @Override
    public Highlight.Request getTargetObject() {
        return Highlight.Request.builder()
                .tId(T_ID)
                .row(ROW)
                .col(COL)
                .bColor(B_COLOR)
                .fColor(F_COLOR)
                .timeout(TIMEOUT)
                .build();
    }
}
