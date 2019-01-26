package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SubscribeLevel2Quotes;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SubscribeLevel2QuotesResultPbSerdeTest {

    public static class TrueSubscribeLevel2QuotesResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.SubscribeLevelIIQuotes.Result, SubscribeLevel2Quotes.Result> {

        private static final boolean TRUE = true;
        // sanity check
        static { assert TRUE; }

        @Override
        public @NotNull Deserializer<SubscribeLevel2Quotes.Result> getDeserializerUnderTest() {
            return SubscribeLevel2QuotesResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SubscribeLevel2Quotes.Result getTargetObject() {
            return SubscribeLevel2Quotes.Result.getInstance(TRUE);
        }

        @NotNull
        @Override
        public qlua.rpc.SubscribeLevelIIQuotes.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.SubscribeLevelIIQuotes.Result.newBuilder()
                    .setResult(TRUE)
                    .build();
        }
    }

    public static class FalseSubscribeLevel2QuotesResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.SubscribeLevelIIQuotes.Result, SubscribeLevel2Quotes.Result> {

        private static final boolean FALSE = false;
        // sanity check
        static { assert !FALSE; }

        @Override
        public @NotNull Deserializer<SubscribeLevel2Quotes.Result> getDeserializerUnderTest() {
            return SubscribeLevel2QuotesResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SubscribeLevel2Quotes.Result getTargetObject() {
            return SubscribeLevel2Quotes.Result.getInstance(FALSE);
        }

        @NotNull
        @Override
        public qlua.rpc.SubscribeLevelIIQuotes.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.SubscribeLevelIIQuotes.Result.newBuilder()
                    .setResult(FALSE)
                    .build();
        }
    }
}
