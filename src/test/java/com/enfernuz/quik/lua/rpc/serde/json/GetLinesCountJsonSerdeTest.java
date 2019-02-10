package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetLinesCount;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetLinesCountJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetLinesCount.Args> {

        @Override
        public GetLinesCount.Args getArgsObject() {
            return new GetLinesCount.Args("1");
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getLinesCount/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetLinesCount.Result> {

        @Override
        public String getJsonPath() {
            return "json/getLinesCount/result.json";
        }

        @Override
        public GetLinesCount.Result getExpectedObject() {
            return new GetLinesCount.Result(1);
        }
    }
}
