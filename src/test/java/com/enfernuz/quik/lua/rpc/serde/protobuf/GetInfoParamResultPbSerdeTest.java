package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetInfoParam;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class GetInfoParamResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetInfoParam.Result, GetInfoParam.Result> {

    private static final String INFO_PARAM = "1";

    @Override
    public @NotNull Deserializer<GetInfoParam.Result> getDeserializerUnderTest() {
        return GetInfoParamResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public GetInfoParam.Result getTargetObject() {
        return new GetInfoParam.Result(INFO_PARAM);
    }

    @NotNull
    @Override
    public qlua.rpc.GetInfoParam.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.GetInfoParam.Result.newBuilder()
                .setInfoParam(INFO_PARAM)
                .build();
    }
}
