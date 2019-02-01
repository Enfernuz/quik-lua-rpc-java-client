package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetTableNotificationCallback;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class SetTableNotificationCallbackArgsPbSerdeTest extends AbstractPbSerializationTest<SetTableNotificationCallback.Args, qlua.rpc.SetTableNotificationCallback.Args> {

    private static final int T_ID = 1;
    private static final String F_CB_DEF = "2";

    @Override
    public @NotNull Serializer<SetTableNotificationCallback.Args> getSerializerUnderTest() {
        return SetTableNotificationCallbackArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.SetTableNotificationCallback.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.SetTableNotificationCallback.Args.newBuilder()
                .setTId(T_ID)
                .setFCbDef(F_CB_DEF)
                .build();
    }

    @NotNull
    @Override
    public SetTableNotificationCallback.Args getTargetObject() {
        return new SetTableNotificationCallback.Args(T_ID, F_CB_DEF);
    }
}
