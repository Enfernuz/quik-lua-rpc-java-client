package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetClassSecurities;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetClassSecuritiesJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetClassSecurities.Args> {

        @Override
        public GetClassSecurities.Args getArgsObject() {
            return new GetClassSecurities.Args("1");
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getClassSecurities/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetClassSecurities.Result> {

        @Override
        public String getJsonPath() {
            return "json/getClassSecurities/result.json";
        }

        @Override
        public GetClassSecurities.Result getExpectedObject() {
            return new GetClassSecurities.Result("1");
        }
    }
}
