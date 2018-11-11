package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.CreateWindow;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class CreateWindowArgsPbSerdeTest extends AbstractPbSerializationTest<CreateWindow.Args, qlua.rpc.CreateWindow.Request> {

    private static final int T_ID = 1;

    @Override
    public @NotNull Serializer<CreateWindow.Args> getSerializerUnderTest() {
        return CreateWindowArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.CreateWindow.Request getTargetObjectAsPbMessage() {

        return qlua.rpc.CreateWindow.Request.newBuilder()
                .setTId(T_ID)
                .build();
    }

    @NotNull
    @Override
    public CreateWindow.Args getTargetObject() {
        return new CreateWindow.Args(T_ID);
    }
}
