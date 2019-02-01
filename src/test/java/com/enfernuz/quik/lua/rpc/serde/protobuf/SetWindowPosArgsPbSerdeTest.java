package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetWindowPos;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class SetWindowPosArgsPbSerdeTest extends AbstractPbSerializationTest<SetWindowPos.Args, qlua.rpc.SetWindowPos.Args> {

    private static final int T_ID = 1;
    private static final int X = 2;
    private static final int Y = 3;
    private static final int DX = 4;
    private static final int DY = 5;

    @Override
    public @NotNull Serializer<SetWindowPos.Args> getSerializerUnderTest() {
        return SetWindowPosArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.SetWindowPos.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.SetWindowPos.Args.newBuilder()
                .setTId(T_ID)
                .setX(X)
                .setY(Y)
                .setDx(DX)
                .setDy(DY)
                .build();
    }

    @NotNull
    @Override
    public SetWindowPos.Args getTargetObject() {
        return SetWindowPos.Args.builder()
                .tId(T_ID)
                .x(X)
                .y(Y)
                .dx(DX)
                .dy(DY)
                .build();
    }
}
