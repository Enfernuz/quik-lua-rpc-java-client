package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetNumCandles;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetNumCandlesJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetNumCandles.Args> {

        @Override
        public GetNumCandles.Args getArgsObject() {
            return new GetNumCandles.Args("1");
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getNumCandles/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetNumCandles.Result> {

        @Override
        public String getJsonPath() {
            return "json/getNumCandles/result.json";
        }

        @Override
        public GetNumCandles.Result getExpectedObject() {
            return new GetNumCandles.Result(1);
        }
    }
}
