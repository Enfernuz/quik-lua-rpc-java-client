package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.AddColumn;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class AddColumnResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.AddColumn.Result, AddColumn.Result> {

    private static final int RESULT = 1;

    @Override
    public @NotNull Deserializer<AddColumn.Result> getDeserializerUnderTest() {
        return AddColumnResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public AddColumn.Result getTargetObject() {
        return new AddColumn.Result(RESULT);
    }

    @NotNull
    @Override
    public qlua.rpc.AddColumn.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.AddColumn.Result.newBuilder()
                .setResult(RESULT)
                .build();
    }
}
