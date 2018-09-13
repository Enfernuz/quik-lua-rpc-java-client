package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetNumberOf;
import org.jetbrains.annotations.NotNull;

public class GetNumberOfResultPbSerdeTest extends AbstractResultPbSerdeTest<GetNumberOf.Result, qlua.rpc.GetNumberOf.Result> {

    private static final int RESULT = 1;

    @Override
    public @NotNull Class<GetNumberOf.Result> getTargetObjectClass() {
        return GetNumberOf.Result.class;
    }

    @NotNull
    @Override
    public qlua.rpc.GetNumberOf.Result getTargetObjectAsPbMessage() {
        return qlua.rpc.GetNumberOf.Result.newBuilder()
                .setResult(RESULT)
                .build();
    }

    @NotNull
    @Override
    public GetNumberOf.Result getTargetObject() {
        return new GetNumberOf.Result(RESULT);
    }
}
