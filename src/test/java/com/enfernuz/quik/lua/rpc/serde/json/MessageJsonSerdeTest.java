package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.Message;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class MessageJsonSerdeTest {

    public static class RpcFullArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<Message.Args> {

        @Override
        public Message.Args getArgsObject() {
            return new Message.Args("1", Message.IconType.WARNING);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/message/full.args.json";
        }
    }

    public static class RpcWithoutIconTypeArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<Message.Args> {

        @Override
        public Message.Args getArgsObject() {
            return new Message.Args("1");
        }

        @Override
        public String getArgsJsonPath() {
            return "json/message/without_icon_type.args.json";
        }
    }

    public static class RpcOkResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<Message.Result> {

        @Override
        public String getJsonPath() {
            return "json/message/ok.result.json";
        }

        @Override
        public Message.Result getExpectedObject() {
            return Message.Result.getOkInstance();
        }
    }

    public static class RpcErrorResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<Message.Result> {

        @Override
        public String getJsonPath() {
            return "json/message/error.result.json";
        }

        @Override
        public Message.Result getExpectedObject() {
            return Message.Result.getErrorInstance();
        }
    }

    public static class RpcOtherResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<Message.Result> {

        @Override
        public String getJsonPath() {
            return "json/message/other.result.json";
        }

        @Override
        public Message.Result getExpectedObject() {
            return Message.Result.getInstance(789);
        }
    }
}
