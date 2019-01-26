package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.UnsubscribeLevel2Quotes;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class UnsubscribeLevel2QuotesArgsPbSerdeTest extends AbstractPbSerializationTest<UnsubscribeLevel2Quotes.Args, qlua.rpc.UnsubscribeLevelIIQuotes.Request> {

    private static final String CLASS_CODE = "1";
    private static final String SEC_CODE = "2";

    @Override
    public @NotNull Serializer<UnsubscribeLevel2Quotes.Args> getSerializerUnderTest() {
        return UnsubscribeLevel2QuotesArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.UnsubscribeLevelIIQuotes.Request getTargetObjectAsPbMessage() {

        return qlua.rpc.UnsubscribeLevelIIQuotes.Request.newBuilder()
                .setClassCode(CLASS_CODE)
                .setSecCode(SEC_CODE)
                .build();
    }

    @NotNull
    @Override
    public UnsubscribeLevel2Quotes.Args getTargetObject() {

        return UnsubscribeLevel2Quotes.Args.builder()
                .classCode(CLASS_CODE)
                .secCode(SEC_CODE)
                .build();
    }
}
