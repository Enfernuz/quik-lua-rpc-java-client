package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetInfoParam;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetInfoParamArgsPbSerdeTest extends AbstractPbSerializationTest<GetInfoParam.Args, qlua.rpc.GetInfoParam.Args> {

    private static final String PARAM_NAME = "1";

    @Override
    public @NotNull Serializer<GetInfoParam.Args> getSerializerUnderTest() {
        return GetInfoParamArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetInfoParam.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.GetInfoParam.Args.newBuilder()
                .setParamName(PARAM_NAME)
                .build();
    }

    @NotNull
    @Override
    public GetInfoParam.Args getTargetObject() {
        return new GetInfoParam.Args(PARAM_NAME);
    }
}
