package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetScriptPath;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class GetScriptPathResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetScriptPath.Result, GetScriptPath.Result> {

    private static final String SCRIPT_PATH = "1";

    @Override
    public @NotNull Deserializer<GetScriptPath.Result> getDeserializerUnderTest() {
        return GetScriptPathResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public GetScriptPath.Result getTargetObject() {
        return new GetScriptPath.Result(SCRIPT_PATH);
    }

    @NotNull
    @Override
    public qlua.rpc.GetScriptPath.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.GetScriptPath.Result.newBuilder()
                .setScriptPath(SCRIPT_PATH)
                .build();
    }
}
