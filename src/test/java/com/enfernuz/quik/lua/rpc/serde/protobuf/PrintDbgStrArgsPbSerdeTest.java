package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.PrintDbgStr;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class PrintDbgStrArgsPbSerdeTest extends AbstractPbSerializationTest<PrintDbgStr.Args, qlua.rpc.PrintDbgStr.Args> {

    private static final String S = "1";

    @Override
    public @NotNull Serializer<PrintDbgStr.Args> getSerializerUnderTest() {
        return PrintDbgStrArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.PrintDbgStr.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.PrintDbgStr.Args.newBuilder()
                .setS(S)
                .build();
    }

    @NotNull
    @Override
    public PrintDbgStr.Args getTargetObject() {
        return new PrintDbgStr.Args(S);
    }
}
