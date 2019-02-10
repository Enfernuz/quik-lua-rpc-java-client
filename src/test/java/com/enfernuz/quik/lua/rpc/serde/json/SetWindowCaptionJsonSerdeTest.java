package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.SetWindowCaption;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class SetWindowCaptionJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<SetWindowCaption.Args> {

        @Override
        public SetWindowCaption.Args getArgsObject() {
            return new SetWindowCaption.Args(1, "2");
        }

        @Override
        public String getArgsJsonPath() {
            return "json/SetWindowCaption/args.json";
        }
    }

    public static class RpcTrueResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SetWindowCaption.Result> {

        @Override
        public String getJsonPath() {
            return "json/SetWindowCaption/true.result.json";
        }

        @Override
        public SetWindowCaption.Result getExpectedObject() {
            return SetWindowCaption.Result.getInstance(true);
        }
    }

    public static class RpcFalseResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<SetWindowCaption.Result> {

        @Override
        public String getJsonPath() {
            return "json/SetWindowCaption/false.result.json";
        }

        @Override
        public SetWindowCaption.Result getExpectedObject() {
            return SetWindowCaption.Result.getInstance(false);
        }
    }
}
