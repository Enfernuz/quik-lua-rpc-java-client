package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.DestroyTable;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class DestroyTableArgsPbSerdeTest extends AbstractPbSerializationTest<DestroyTable.Args, qlua.rpc.DestroyTable.Args> {

    private static final int T_ID = 1;

    @Override
    public @NotNull Serializer<DestroyTable.Args> getSerializerUnderTest() {
        return DestroyTableArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.DestroyTable.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.DestroyTable.Args.newBuilder()
                .setTId(T_ID)
                .build();
    }

    @NotNull
    @Override
    public DestroyTable.Args getTargetObject() {
        return new DestroyTable.Args(T_ID);
    }
}
