package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassSecurities;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetClassSecuritiesArgsPbSerdeTest extends AbstractPbSerializationTest<GetClassSecurities.Args, qlua.rpc.GetClassSecurities.Request> {

    private static final String CLASS_CODE = "1";

    @Override
    public @NotNull Serializer<GetClassSecurities.Args> getSerializerUnderTest() {
        return GetClassSecuritiesArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetClassSecurities.Request getTargetObjectAsPbMessage() {

        return qlua.rpc.GetClassSecurities.Request.newBuilder()
                .setClassCode(CLASS_CODE)
                .build();
    }

    @NotNull
    @Override
    public GetClassSecurities.Args getTargetObject() {
        return new GetClassSecurities.Args(CLASS_CODE);
    }
}
