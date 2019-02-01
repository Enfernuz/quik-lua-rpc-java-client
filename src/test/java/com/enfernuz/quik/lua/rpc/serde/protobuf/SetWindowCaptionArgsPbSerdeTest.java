package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetWindowCaption;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class SetWindowCaptionArgsPbSerdeTest extends AbstractPbSerializationTest<SetWindowCaption.Args, qlua.rpc.SetWindowCaption.Args> {

    private static final int T_ID = 1;
    private static final String STR = "2";

    @Override
    public @NotNull Serializer<SetWindowCaption.Args> getSerializerUnderTest() {
        return SetWindowCaptionArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.SetWindowCaption.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.SetWindowCaption.Args.newBuilder()
                .setTId(T_ID)
                .setStr(STR)
                .build();
    }

    @NotNull
    @Override
    public SetWindowCaption.Args getTargetObject() {
        return new SetWindowCaption.Args(T_ID, STR);
    }
}
