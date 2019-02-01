package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Clear;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class ClearArgsPbSerdeTest extends AbstractPbSerializationTest<Clear.Args, qlua.rpc.Clear.Args> {

    private static final int T_ID = 1;

    @Override
    public @NotNull Serializer<Clear.Args> getSerializerUnderTest() {
        return ClearArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.Clear.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.Clear.Args.newBuilder()
                .setTId(T_ID)
                .build();
    }

    @NotNull
    @Override
    public Clear.Args getTargetObject() {
        return new Clear.Args(T_ID);
    }
}
