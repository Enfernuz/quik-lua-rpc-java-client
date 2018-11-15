package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetWindowCaption;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetWindowCaptionResultPbSerdeTest {

    private static final String CAPTION = "1";

    public static class NormalGetWindowCaptionResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetWindowCaption.Result, GetWindowCaption.Result> {

        @Override
        public @NotNull Deserializer<GetWindowCaption.Result> getDeserializerUnderTest() {
            return GetWindowCaptionResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public GetWindowCaption.Result getTargetObject() {
            return GetWindowCaption.Result.getInstance(CAPTION);
        }

        @NotNull
        @Override
        public qlua.rpc.GetWindowCaption.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.GetWindowCaption.Result.newBuilder()
                    .setCaption(CAPTION)
                    .build();
        }
    }

    public static class ErrorGetWindowCaptionResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetWindowCaption.Result, GetWindowCaption.Result> {

        @Override
        public @NotNull Deserializer<GetWindowCaption.Result> getDeserializerUnderTest() {
            return GetWindowCaptionResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public GetWindowCaption.Result getTargetObject() {
            return GetWindowCaption.Result.getErrorInstance();
        }

        @NotNull
        @Override
        public qlua.rpc.GetWindowCaption.Result getTargetObjectAsPbMessage() {
            return qlua.rpc.GetWindowCaption.Result.newBuilder().build();
        }
    }
}
