package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetNumberOf;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class GetNumberOfResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetNumberOf.Result, GetNumberOf.Result> {

    private static final int RESULT = 1;

    @Override
    public @NotNull Deserializer<GetNumberOf.Result> getDeserializerUnderTest() {
        return GetNumberOfResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public GetNumberOf.Result getTargetObject() {
        return new GetNumberOf.Result(RESULT);
    }

    @NotNull
    @Override
    public qlua.rpc.GetNumberOf.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.GetNumberOf.Result.newBuilder()
                .setResult(RESULT)
                .build();
    }
}
