package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Highlight;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class HighlightResultPbSerdeTest {

    public static class TrueHighlightPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.Highlight.Result, Highlight.Result> {

        private static final boolean TRUE = true;
        // sanity check
        static { assert TRUE; }

        @Override
        public @NotNull Deserializer<Highlight.Result> getDeserializerUnderTest() {
            return HighlightResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public Highlight.Result getTargetObject() {
            return Highlight.Result.getInstance(TRUE);
        }

        @NotNull
        @Override
        public qlua.rpc.Highlight.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.Highlight.Result.newBuilder()
                    .setResult(TRUE)
                    .build();
        }
    }

    public static class FalseHighlightResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.Highlight.Result, Highlight.Result> {

        private static final boolean FALSE = false;
        // sanity check
        static { assert !FALSE; }

        @Override
        public @NotNull Deserializer<Highlight.Result> getDeserializerUnderTest() {
            return HighlightResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public Highlight.Result getTargetObject() {
            return Highlight.Result.getInstance(FALSE);
        }

        @NotNull
        @Override
        public qlua.rpc.Highlight.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.Highlight.Result.newBuilder()
                    .setResult(FALSE)
                    .build();
        }
    }
}
