package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.InsertRow;
import org.jetbrains.annotations.NotNull;

public class InsertRowResultPbSerdeTest extends AbstractResultPbSerdeTest<InsertRow.Result, qlua.rpc.InsertRow.Result> {

    private static final int RESULT = 1;

    @Override
    public @NotNull Class<InsertRow.Result> getTargetObjectClass() {
        return InsertRow.Result.class;
    }

    @NotNull
    @Override
    public qlua.rpc.InsertRow.Result getTargetObjectAsPbMessage() {
        return qlua.rpc.InsertRow.Result.newBuilder()
                .setResult(RESULT)
                .build();
    }

    @NotNull
    @Override
    public InsertRow.Result getTargetObject() {
        return new InsertRow.Result(RESULT);
    }
}
