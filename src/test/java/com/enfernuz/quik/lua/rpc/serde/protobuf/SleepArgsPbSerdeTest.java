package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Sleep;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class SleepArgsPbSerdeTest extends AbstractPbSerializationTest<Sleep.Args, qlua.rpc.Sleep.Args> {

    private static final int TIME = 1;

    @Override
    public @NotNull Serializer<Sleep.Args> getSerializerUnderTest() {
        return SleepArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.Sleep.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.Sleep.Args.newBuilder()
                .setTime(TIME)
                .build();
    }

    @NotNull
    @Override
    public Sleep.Args getTargetObject() {
        return new Sleep.Args(TIME);
    }
}
