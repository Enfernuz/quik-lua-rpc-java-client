package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.IsConnected;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class IsConnectedResultPbSerdeTest {

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int OTHER = 42;

    // sanity check
    static {
        assert ONE == 1;
        assert TWO == 2;
        assert OTHER != 1 && OTHER != 2;
    }

    public static class OneResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.IsConnected.Result, IsConnected.Result> {

        @Override
        public @NotNull Deserializer<IsConnected.Result> getDeserializerUnderTest() {
            return IsConnectedResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public IsConnected.Result getTargetObject() {
            return IsConnected.Result.getInstance(ONE);
        }

        @NotNull
        @Override
        public qlua.rpc.IsConnected.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.IsConnected.Result.newBuilder()
                    .setIsConnected(ONE)
                    .build();
        }
    }

    public static class TwoResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.IsConnected.Result, IsConnected.Result> {

        @Override
        public @NotNull Deserializer<IsConnected.Result> getDeserializerUnderTest() {
            return IsConnectedResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public IsConnected.Result getTargetObject() {
            return IsConnected.Result.getInstance(TWO);
        }

        @NotNull
        @Override
        public qlua.rpc.IsConnected.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.IsConnected.Result.newBuilder()
                    .setIsConnected(TWO)
                    .build();
        }
    }

    public static class OtherResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.IsConnected.Result, IsConnected.Result> {

        @Override
        public @NotNull Deserializer<IsConnected.Result> getDeserializerUnderTest() {
            return IsConnectedResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public IsConnected.Result getTargetObject() {
            return IsConnected.Result.getInstance(OTHER);
        }

        @NotNull
        @Override
        public qlua.rpc.IsConnected.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.IsConnected.Result.newBuilder()
                    .setIsConnected(OTHER)
                    .build();
        }
    }
}
