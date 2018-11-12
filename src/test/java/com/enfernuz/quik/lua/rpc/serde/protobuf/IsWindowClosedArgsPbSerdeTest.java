package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsWindowClosed;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class IsWindowClosedArgsPbSerdeTest extends AbstractPbSerializationTest<IsWindowClosed.Args, qlua.rpc.IsWindowClosed.Request> {

    private static final int T_ID = 1;

    @Override
    public @NotNull Serializer<IsWindowClosed.Args> getSerializerUnderTest() {
        return IsWindowClosedArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.IsWindowClosed.Request getTargetObjectAsPbMessage() {

        return qlua.rpc.IsWindowClosed.Request.newBuilder()
                .setTId(T_ID)
                .build();
    }

    @NotNull
    @Override
    public IsWindowClosed.Args getTargetObject() {
        return new IsWindowClosed.Args(T_ID);
    }
}
