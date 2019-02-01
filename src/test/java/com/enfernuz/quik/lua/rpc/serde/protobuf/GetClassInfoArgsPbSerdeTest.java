package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassInfo;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetClassInfoArgsPbSerdeTest extends AbstractPbSerializationTest<GetClassInfo.Args, qlua.rpc.GetClassInfo.Args> {

    private static final String CLASS_CODE = "1";

    @Override
    public @NotNull Serializer<GetClassInfo.Args> getSerializerUnderTest() {
        return GetClassInfoArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetClassInfo.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.GetClassInfo.Args.newBuilder()
                .setClassCode(CLASS_CODE)
                .build();
    }

    @NotNull
    @Override
    public GetClassInfo.Args getTargetObject() {
        return new GetClassInfo.Args(CLASS_CODE);
    }
}
