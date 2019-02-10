package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetInfoParam;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetInfoParamJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetInfoParam.Args> {

        @Override
        public GetInfoParam.Args getArgsObject() {
            return new GetInfoParam.Args("1");
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getInfoParam/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetInfoParam.Result> {

        @Override
        public String getJsonPath() {
            return "json/getInfoParam/result.json";
        }

        @Override
        public GetInfoParam.Result getExpectedObject() {
            return new GetInfoParam.Result("1");
        }
    }
}
