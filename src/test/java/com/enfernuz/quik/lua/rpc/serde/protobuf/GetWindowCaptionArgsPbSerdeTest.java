package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetWindowCaption;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetWindowCaptionArgsPbSerdeTest extends AbstractPbSerializationTest<GetWindowCaption.Args, qlua.rpc.GetWindowCaption.Request> {

    private static final int T_ID = 1;

    @Override
    public @NotNull Serializer<GetWindowCaption.Args> getSerializerUnderTest() {
        return GetWindowCaptionArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetWindowCaption.Request getTargetObjectAsPbMessage() {

        return qlua.rpc.GetWindowCaption.Request.newBuilder()
                .setTId(T_ID)
                .build();
    }

    @NotNull
    @Override
    public GetWindowCaption.Args getTargetObject() {
        return new GetWindowCaption.Args(T_ID);
    }
}
