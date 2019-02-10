package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetNumberOf;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetNumberOfJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetNumberOf.Args> {

        @Override
        public GetNumberOf.Args getArgsObject() {
            return new GetNumberOf.Args("1");
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getNumberOf/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetNumberOf.Result> {

        @Override
        public String getJsonPath() {
            return "json/getNumberOf/result.json";
        }

        @Override
        public GetNumberOf.Result getExpectedObject() {
            return new GetNumberOf.Result(1);
        }
    }
}
