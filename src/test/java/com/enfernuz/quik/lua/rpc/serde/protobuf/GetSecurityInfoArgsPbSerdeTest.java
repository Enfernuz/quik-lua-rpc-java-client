package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetSecurityInfo;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetSecurityInfoArgsPbSerdeTest extends AbstractPbSerializationTest<GetSecurityInfo.Args, qlua.rpc.GetSecurityInfo.Args> {

    private static final String CLASS_CODE = "1";
    private static final String SEC_CODE = "2";

    @Override
    public @NotNull Serializer<GetSecurityInfo.Args> getSerializerUnderTest() {
        return GetSecurityInfoArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetSecurityInfo.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.GetSecurityInfo.Args.newBuilder()
                .setClassCode(CLASS_CODE)
                .setSecCode(SEC_CODE)
                .build();
    }

    @NotNull
    @Override
    public GetSecurityInfo.Args getTargetObject() {

        return GetSecurityInfo.Args.builder()
                .classCode(CLASS_CODE)
                .secCode(SEC_CODE)
                .build();
    }
}
