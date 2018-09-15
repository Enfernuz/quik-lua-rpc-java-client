package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetWindowRect;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

public class GetWindowRectResultPbSerdeTest extends AbstractResultPbSerdeTest<GetWindowRect.Result, qlua.rpc.GetWindowRect.Result> {

    @Override
    public @NotNull Class<GetWindowRect.Result> getTargetObjectClass() {
        return GetWindowRect.Result.class;
    }

    @NotNull
    @Override
    public qlua.rpc.GetWindowRect.Result getTargetObjectAsPbMessage() {

        final qlua.rpc.GetWindowRect.WindowRect windowRect = qlua.rpc.GetWindowRect.WindowRect.newBuilder()
                .setTop(WindowRectParameters.TOP)
                .setLeft(WindowRectParameters.LEFT)
                .setBottom(WindowRectParameters.BOTTOM)
                .setRight(WindowRectParameters.RIGHT)
                .build();

        return qlua.rpc.GetWindowRect.Result.newBuilder()
                .setWindowRect(windowRect)
                .build();
    }

    @NotNull
    @Override
    public GetWindowRect.Result getTargetObject() {

        final GetWindowRect.WindowRect windowRect = GetWindowRect.WindowRect.builder()
                .top(WindowRectParameters.TOP)
                .left(WindowRectParameters.LEFT)
                .bottom(WindowRectParameters.BOTTOM)
                .right(WindowRectParameters.RIGHT)
                .build();

        return GetWindowRect.Result.getInstance(windowRect);
    }

    @Test
    @Override
    public void testSerializeErrorObject() {
        super.testSerializeErrorObject();
    }

    @Test
    @Override
    public void testDeserializeErrorObject() {
        super.testDeserializeErrorObject();
    }

    @NotNull
    @Override
    public qlua.rpc.GetWindowRect.Result getErrorObject_AsPbMessage() {
        return qlua.rpc.GetWindowRect.Result.newBuilder().build();
    }

    @NotNull
    @Override
    public GetWindowRect.Result getErrorObject() {
        return GetWindowRect.Result.getErrorInstance();
    }

    private static final class WindowRectParameters {

        private static final int TOP = 1;
        private static final int LEFT = 2;
        private static final int BOTTOM = 3;
        private static final int RIGHT = 4;
    }
}
