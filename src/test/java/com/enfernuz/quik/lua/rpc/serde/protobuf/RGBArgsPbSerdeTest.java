package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.RGB;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class RGBArgsPbSerdeTest extends AbstractPbSerializationTest<RGB.Args, qlua.rpc.RGB.Args> {

    private static final int RED = 1;
    private static final int GREEN = 2;
    private static final int BLUE = 3;

    @Override
    public @NotNull Serializer<RGB.Args> getSerializerUnderTest() {
        return RGBArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.RGB.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.RGB.Args.newBuilder()
                .setRed(RED)
                .setGreen(GREEN)
                .setBlue(BLUE)
                .build();
    }

    @NotNull
    @Override
    public RGB.Args getTargetObject() {
        return RGB.Args.builder()
                .red(RED)
                .green(GREEN)
                .blue(BLUE)
                .build();
    }
}
