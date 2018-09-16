package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.InsertRow;
import com.google.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qlua.rpc.RPC;

public class InsertRowRequestPbSerdeTest extends AbstractRequestPbSerdeTest<InsertRow.Request> {

    private static final int T_ID = 1;
    private static final int KEY = 2;

    @Override
    public RPC.@NotNull ProcedureType getProcedureType() {
        return RPC.ProcedureType.INSERT_ROW;
    }

    @Override
    public @Nullable MessageLite getPbRequestArgs() {
        return qlua.rpc.InsertRow.Request.newBuilder()
                .setTId(T_ID)
                .setKey(KEY)
                .build();
    }

    @Override
    public @NotNull Class<InsertRow.Request> getTargetObjectClass() {
        return InsertRow.Request.class;
    }

    @NotNull
    @Override
    public InsertRow.Request getTargetObject() {
        return InsertRow.Request.builder()
                .tId(T_ID)
                .key(KEY)
                .build();
    }
}
