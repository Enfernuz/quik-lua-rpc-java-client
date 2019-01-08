package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsSubscribedLevel2Quotes;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class IsSubscribedLevel2QuotesResultPbSerdeTest {

    public static class TrueIsSubscribedLevel2QuotesResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.IsSubscribedLevelIIQuotes.Result, IsSubscribedLevel2Quotes.Result> {

        private static final boolean TRUE = true;
        // sanity check
        static { assert TRUE; }

        @Override
        public @NotNull Deserializer<IsSubscribedLevel2Quotes.Result> getDeserializerUnderTest() {
            return IsSubscribedLevel2QuotesResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public IsSubscribedLevel2Quotes.Result getTargetObject() {
            return IsSubscribedLevel2Quotes.Result.getInstance(TRUE);
        }

        @NotNull
        @Override
        public qlua.rpc.IsSubscribedLevelIIQuotes.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.IsSubscribedLevelIIQuotes.Result.newBuilder()
                    .setResult(TRUE)
                    .build();
        }
    }

    public static class FalseIsSubscribedLevel2QuotesResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.IsSubscribedLevelIIQuotes.Result, IsSubscribedLevel2Quotes.Result> {

        private static final boolean FALSE = false;
        // sanity check
        static { assert !FALSE; }

        @Override
        public @NotNull Deserializer<IsSubscribedLevel2Quotes.Result> getDeserializerUnderTest() {
            return IsSubscribedLevel2QuotesResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public IsSubscribedLevel2Quotes.Result getTargetObject() {
            return IsSubscribedLevel2Quotes.Result.getInstance(FALSE);
        }

        @NotNull
        @Override
        public qlua.rpc.IsSubscribedLevelIIQuotes.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.IsSubscribedLevelIIQuotes.Result.newBuilder()
                    .setResult(FALSE)
                    .build();
        }
    }
}
