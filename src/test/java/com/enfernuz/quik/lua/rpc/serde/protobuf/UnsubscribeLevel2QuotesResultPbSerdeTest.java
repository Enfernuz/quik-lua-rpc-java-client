package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.UnsubscribeLevel2Quotes;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class UnsubscribeLevel2QuotesResultPbSerdeTest {

    public static class TrueUnsubscribeLevel2QuotesResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.UnsubscribeLevelIIQuotes.Result, UnsubscribeLevel2Quotes.Result> {

        private static final boolean TRUE = true;
        // sanity check
        static { assert TRUE; }

        @Override
        public @NotNull Deserializer<UnsubscribeLevel2Quotes.Result> getDeserializerUnderTest() {
            return UnsubscribeLevel2QuotesResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public UnsubscribeLevel2Quotes.Result getTargetObject() {
            return UnsubscribeLevel2Quotes.Result.getInstance(TRUE);
        }

        @NotNull
        @Override
        public qlua.rpc.UnsubscribeLevelIIQuotes.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.UnsubscribeLevelIIQuotes.Result.newBuilder()
                    .setResult(TRUE)
                    .build();
        }
    }

    public static class FalseUnsubscribeLevel2QuotesResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.UnsubscribeLevelIIQuotes.Result, UnsubscribeLevel2Quotes.Result> {

        private static final boolean FALSE = false;
        // sanity check
        static { assert !FALSE; }

        @Override
        public @NotNull Deserializer<UnsubscribeLevel2Quotes.Result> getDeserializerUnderTest() {
            return UnsubscribeLevel2QuotesResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public UnsubscribeLevel2Quotes.Result getTargetObject() {
            return UnsubscribeLevel2Quotes.Result.getInstance(FALSE);
        }

        @NotNull
        @Override
        public qlua.rpc.UnsubscribeLevelIIQuotes.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.UnsubscribeLevelIIQuotes.Result.newBuilder()
                    .setResult(FALSE)
                    .build();
        }
    }
}
