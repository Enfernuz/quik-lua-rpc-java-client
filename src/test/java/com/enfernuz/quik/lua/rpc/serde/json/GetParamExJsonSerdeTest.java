package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetParamEx;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetParamExJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetParamEx.Args> {

        @Override
        public GetParamEx.Args getArgsObject() {

            return GetParamEx.Args.builder()
                    .classCode("1")
                    .secCode("2")
                    .paramName("3")
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getParamEx/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetParamEx.Result> {

        @Override
        public String getJsonPath() {
            return "json/getParamEx/result.json";
        }

        @Override
        public GetParamEx.Result getExpectedObject() {

            final GetParamEx.ParamEx paramEx = GetParamEx.ParamEx.builder()
                    .paramType("1")
                    .paramValue("2")
                    .paramImage("3")
                    .result("4")
                    .build();

            return new GetParamEx.Result(paramEx);
        }
    }
}
