package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetScriptPath;
import org.jetbrains.annotations.NotNull;

public class GetScriptPathResultPbSerdeTest extends AbstractResultPbSerdeTest<GetScriptPath.Result, qlua.rpc.GetScriptPath.Result> {

    private static final String SCRIPT_PATH = "1";

    @Override
    public @NotNull Class<GetScriptPath.Result> getTargetObjectClass() {
        return GetScriptPath.Result.class;
    }

    @NotNull
    @Override
    public qlua.rpc.GetScriptPath.Result getTargetObjectAsPbMessage() {
        return qlua.rpc.GetScriptPath.Result.newBuilder()
                .setScriptPath(SCRIPT_PATH)
                .build();
    }

    @NotNull
    @Override
    public GetScriptPath.Result getTargetObject() {
        return new GetScriptPath.Result(SCRIPT_PATH);
    }
}
