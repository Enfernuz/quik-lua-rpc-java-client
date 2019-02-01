package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsSubscribedLevel2Quotes;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class IsSubscribedLevel2QuotesArgsPbSerdeTest extends AbstractPbSerializationTest<IsSubscribedLevel2Quotes.Args, qlua.rpc.IsSubscribedLevelIIQuotes.Args> {

    private static final String CLASS_CODE = "1";
    private static final String SEC_CODE = "2";

    @Override
    public @NotNull Serializer<IsSubscribedLevel2Quotes.Args> getSerializerUnderTest() {
        return IsSubscribedLevel2QuotesArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.IsSubscribedLevelIIQuotes.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.IsSubscribedLevelIIQuotes.Args.newBuilder()
                .setClassCode(CLASS_CODE)
                .setSecCode(SEC_CODE)
                .build();
    }

    @NotNull
    @Override
    public IsSubscribedLevel2Quotes.Args getTargetObject() {

        return IsSubscribedLevel2Quotes.Args.builder()
                .classCode(CLASS_CODE)
                .secCode(SEC_CODE)
                .build();
    }
}
