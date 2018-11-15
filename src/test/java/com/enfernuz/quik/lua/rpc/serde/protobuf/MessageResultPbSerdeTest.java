package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Message;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class MessageResultPbSerdeTest {

    private static final int OK = 1;
    private static final int NOT_OK = 42; // any number that does not equal to 1, actually

    // sanity check
    static {
        assert NOT_OK != OK;
    }

    public static class OkMessageResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.Message.Result, Message.Result> {

        @Override
        public @NotNull Deserializer<Message.Result> getDeserializerUnderTest() {
            return MessageResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public Message.Result getTargetObject() {
            return Message.Result.getOkInstance();
        }

        @NotNull
        @Override
        public qlua.rpc.Message.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.Message.Result.newBuilder()
                    .setValueResult(OK)
                    .build();
        }
    }

    public static class NotOkMessageResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.Message.Result, Message.Result> {

        @Override
        public @NotNull Deserializer<Message.Result> getDeserializerUnderTest() {
            return MessageResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public Message.Result getTargetObject() {
            return Message.Result.getInstance(NOT_OK);
        }

        @NotNull
        @Override
        public qlua.rpc.Message.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.Message.Result.newBuilder()
                    .setValueResult(NOT_OK)
                    .build();
        }
    }

    public static class ErrorMessageResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.Message.Result, Message.Result> {

        @Override
        public @NotNull Deserializer<Message.Result> getDeserializerUnderTest() {
            return MessageResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public Message.Result getTargetObject() {
            return Message.Result.getErrorInstance();
        }

        @NotNull
        @Override
        public qlua.rpc.Message.Result getTargetObjectAsPbMessage() {

            return qlua.rpc.Message.Result.newBuilder()
                    .setNullResult(true)
                    .build();
        }
    }
}
