package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetQuoteLevel2;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetQuoteLevel2ArgsPbSerdeTest extends AbstractPbSerializationTest<GetQuoteLevel2.Args, qlua.rpc.GetQuoteLevel2.Args> {

    private static final String CLASS_CODE = "1";
    private static final String SEC_CODE = "2";

    @Override
    public @NotNull Serializer<GetQuoteLevel2.Args> getSerializerUnderTest() {
        return GetQuoteLevel2ArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetQuoteLevel2.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.GetQuoteLevel2.Args.newBuilder()
                .setClassCode(CLASS_CODE)
                .setSecCode(SEC_CODE)
                .build();
    }

    @NotNull
    @Override
    public GetQuoteLevel2.Args getTargetObject() {

        return GetQuoteLevel2.Args.builder()
                .classCode(CLASS_CODE)
                .secCode(SEC_CODE)
                .build();
    }
}
