package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.CreateWindow;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class CreateWindowResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.CreateWindow.Result, CreateWindow.Result> {

    private static final int RESULT = 1;

    @Override
    public @NotNull Deserializer<CreateWindow.Result> getDeserializerUnderTest() {
        return CreateWindowResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public CreateWindow.Result getTargetObject() {
        return new CreateWindow.Result(RESULT);
    }

    @NotNull
    @Override
    public qlua.rpc.CreateWindow.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.CreateWindow.Result.newBuilder()
                .setResult(RESULT)
                .build();
    }
}
