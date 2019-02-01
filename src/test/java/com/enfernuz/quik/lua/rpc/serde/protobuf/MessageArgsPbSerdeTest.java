package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.Message;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class MessageArgsPbSerdeTest {

    public static class FullMessageArgsPbSerdeTest extends AbstractPbSerializationTest<Message.Args, qlua.rpc.Message.Args> {

        private static final String MESSAGE = "1";
        private static final Message.IconType ICON_TYPE = Message.IconType.WARNING;
        private static final qlua.rpc.Message.IconType PB_ICON_TYPE = qlua.rpc.Message.IconType.WARNING;

        @Override
        public @NotNull Serializer<Message.Args> getSerializerUnderTest() {
            return MessageArgsPbSerializer.INSTANCE;
        }

        @NotNull
        @Override
        public qlua.rpc.Message.Args getTargetObjectAsPbMessage() {

            return qlua.rpc.Message.Args.newBuilder()
                    .setMessage(MESSAGE)
                    .setIconType(PB_ICON_TYPE)
                    .build();
        }

        @NotNull
        @Override
        public Message.Args getTargetObject() {
            return new Message.Args(MESSAGE, ICON_TYPE);
        }
    }

    public static class WithoutIconTypeMessageArgsPbSerdeTest extends AbstractPbSerializationTest<Message.Args, qlua.rpc.Message.Args> {

        private static final String MESSAGE = "1";

        @Override
        public @NotNull Serializer<Message.Args> getSerializerUnderTest() {
            return MessageArgsPbSerializer.INSTANCE;
        }

        @NotNull
        @Override
        public qlua.rpc.Message.Args getTargetObjectAsPbMessage() {

            return qlua.rpc.Message.Args.newBuilder()
                    .setMessage(MESSAGE)
                    .build();
        }

        @NotNull
        @Override
        public Message.Args getTargetObject() {
            return new Message.Args(MESSAGE);
        }
    }
}
