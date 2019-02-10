package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetParamEx2;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetParamEx2JsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetParamEx2.Args> {

        @Override
        public GetParamEx2.Args getArgsObject() {

            return GetParamEx2.Args.builder()
                    .classCode("1")
                    .secCode("2")
                    .paramName("3")
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getParamEx2/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetParamEx2.Result> {

        @Override
        public String getJsonPath() {
            return "json/getParamEx2/result.json";
        }

        @Override
        public GetParamEx2.Result getExpectedObject() {

            final GetParamEx2.ParamEx2 paramEx = GetParamEx2.ParamEx2.builder()
                    .paramType("1")
                    .paramValue("2")
                    .paramImage("3")
                    .result("4")
                    .build();

            return new GetParamEx2.Result(paramEx);
        }
    }
}
