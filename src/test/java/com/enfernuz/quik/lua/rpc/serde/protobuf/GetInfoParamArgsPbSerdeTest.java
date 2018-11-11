package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetInfoParam;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetInfoParamArgsPbSerdeTest extends AbstractPbSerializationTest<GetInfoParam.Args, qlua.rpc.GetInfoParam.Request> {

    private static final String PARAM_NAME = "1";

    @Override
    public @NotNull Serializer<GetInfoParam.Args> getSerializerUnderTest() {
        return GetInfoParamArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetInfoParam.Request getTargetObjectAsPbMessage() {

        return qlua.rpc.GetInfoParam.Request.newBuilder()
                .setParamName(PARAM_NAME)
                .build();
    }

    @NotNull
    @Override
    public GetInfoParam.Args getTargetObject() {
        return new GetInfoParam.Args(PARAM_NAME);
    }
}
