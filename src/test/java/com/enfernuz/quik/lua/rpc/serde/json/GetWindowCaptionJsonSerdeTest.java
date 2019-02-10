package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetWindowCaption;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetWindowCaptionJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetWindowCaption.Args> {

        @Override
        public GetWindowCaption.Args getArgsObject() {
            return new GetWindowCaption.Args(1);
        }

        @Override
        public String getArgsJsonPath() {
            return "json/GetWindowCaption/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetWindowCaption.Result> {

        @Override
        public String getJsonPath() {
            return "json/GetWindowCaption/result.json";
        }

        @Override
        public GetWindowCaption.Result getExpectedObject() {
            return GetWindowCaption.Result.getInstance("1");
        }
    }

    public static class RpcErrorResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetWindowCaption.Result> {

        @Override
        public String getJsonPath() {
            return "json/GetWindowCaption/error.result.json";
        }

        @Override
        public GetWindowCaption.Result getExpectedObject() {
            return GetWindowCaption.Result.getErrorInstance();
        }
    }
}
