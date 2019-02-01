package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetWindowRect;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetWindowRectResultPbSerdeTest {

    private static final int TOP = 1;
    private static final int LEFT = 2;
    private static final int BOTTOM = 3;
    private static final int RIGHT = 4;
    private static final GetWindowRect.WindowRect WINDOW_RECT =
            GetWindowRect.WindowRect.builder()
                .top(TOP)
                .left(LEFT)
                .bottom(BOTTOM)
                .right(RIGHT)
                .build();

    public static class NormalGetWindowRectResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetWindowRect.Result, GetWindowRect.Result> {

        @Override
        public @NotNull Deserializer<GetWindowRect.Result> getDeserializerUnderTest() {
            return GetWindowRectResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public GetWindowRect.Result getTargetObject() {
            return GetWindowRect.Result.getInstance(WINDOW_RECT);
        }

        @NotNull
        @Override
        public qlua.rpc.GetWindowRect.Result getTargetObjectAsPbMessage() {

            final qlua.rpc.GetWindowRect.WindowRect pbWindowRect = qlua.rpc.GetWindowRect.WindowRect.newBuilder()
                    .setTop(TOP)
                    .setLeft(LEFT)
                    .setBottom(BOTTOM)
                    .setRight(RIGHT)
                    .build();

            return qlua.rpc.GetWindowRect.Result.newBuilder()
                    .setWindowRect(pbWindowRect)
                    .build();
        }
    }

    public static class ErrorGetWindowRectResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetWindowRect.Result, GetWindowRect.Result> {

        @Override
        public @NotNull Deserializer<GetWindowRect.Result> getDeserializerUnderTest() {
            return GetWindowRectResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public GetWindowRect.Result getTargetObject() {
            return GetWindowRect.Result.getErrorInstance();
        }

        @NotNull
        @Override
        public qlua.rpc.GetWindowRect.Result getTargetObjectAsPbMessage() {
            return qlua.rpc.GetWindowRect.Result.newBuilder().build();
        }
    }
}
