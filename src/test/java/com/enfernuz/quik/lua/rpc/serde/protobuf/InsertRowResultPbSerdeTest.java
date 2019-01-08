package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.InsertRow;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class InsertRowResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.InsertRow.Result, InsertRow.Result> {

    private static final int RESULT = 1;

    @Override
    public @NotNull Deserializer<InsertRow.Result> getDeserializerUnderTest() {
        return InsertRowResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public InsertRow.Result getTargetObject() {
        return new InsertRow.Result(RESULT);
    }

    @NotNull
    @Override
    public qlua.rpc.InsertRow.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.InsertRow.Result.newBuilder()
                .setResult(RESULT)
                .build();
    }
}
