package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.SetWindowCaption;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SetWindowCaptionResultPbSerdeTest {

    public static class TrueSetWindowCaptionResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.SetWindowCaption.Result, SetWindowCaption.Result> {

        private static final boolean TRUE = true;
        // sanity check
        static { assert TRUE; }

        @Override
        public @NotNull Deserializer<SetWindowCaption.Result> getDeserializerUnderTest() {
            return SetWindowCaptionResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SetWindowCaption.Result getTargetObject() {
            return SetWindowCaption.Result.getInstance(TRUE);
        }

        @NotNull
        @Override
        public qlua.rpc.SetWindowCaption.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.SetWindowCaption.Result.newBuilder()
                    .setResult(TRUE)
                    .build();
        }
    }

    public static class FalseSetWindowCaptionResultPbDeserializationTest
            extends AbstractPbDeserializationTest<qlua.rpc.SetWindowCaption.Result, SetWindowCaption.Result> {

        private static final boolean FALSE = false;
        // sanity check
        static { assert !FALSE; }

        @Override
        public @NotNull Deserializer<SetWindowCaption.Result> getDeserializerUnderTest() {
            return SetWindowCaptionResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public SetWindowCaption.Result getTargetObject() {
            return SetWindowCaption.Result.getInstance(FALSE);
        }

        @NotNull
        @Override
        public qlua.rpc.SetWindowCaption.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.SetWindowCaption.Result.newBuilder()
                    .setResult(FALSE)
                    .build();
        }
    }
}
