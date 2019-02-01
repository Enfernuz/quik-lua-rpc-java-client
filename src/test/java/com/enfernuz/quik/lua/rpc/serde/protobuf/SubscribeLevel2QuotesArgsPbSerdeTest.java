package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SubscribeLevel2Quotes;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class SubscribeLevel2QuotesArgsPbSerdeTest extends AbstractPbSerializationTest<SubscribeLevel2Quotes.Args, qlua.rpc.SubscribeLevelIIQuotes.Args> {

    private static final String CLASS_CODE = "1";
    private static final String SEC_CODE = "2";

    @Override
    public @NotNull Serializer<SubscribeLevel2Quotes.Args> getSerializerUnderTest() {
        return SubscribeLevel2QuotesArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.SubscribeLevelIIQuotes.Args getTargetObjectAsPbMessage() {

        return qlua.rpc.SubscribeLevelIIQuotes.Args.newBuilder()
                .setClassCode(CLASS_CODE)
                .setSecCode(SEC_CODE)
                .build();
    }

    @NotNull
    @Override
    public SubscribeLevel2Quotes.Args getTargetObject() {

        return SubscribeLevel2Quotes.Args.builder()
                .classCode(CLASS_CODE)
                .secCode(SEC_CODE)
                .build();
    }
}
