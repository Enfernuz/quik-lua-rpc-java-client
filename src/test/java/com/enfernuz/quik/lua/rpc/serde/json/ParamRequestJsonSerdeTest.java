package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.ParamRequest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class ParamRequestJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<ParamRequest.Args> {

        @Override
        public ParamRequest.Args getArgsObject() {

            return ParamRequest.Args.builder()
                    .classCode("1")
                    .secCode("2")
                    .dbName("3")
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/ParamRequest/args.json";
        }
    }

    public static class RpcTrueResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<ParamRequest.Result> {

        @Override
        public String getJsonPath() {
            return "json/ParamRequest/true.result.json";
        }

        @Override
        public ParamRequest.Result getExpectedObject() {
            return ParamRequest.Result.getInstance(true);
        }
    }

    public static class RpcFalseResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<ParamRequest.Result> {

        @Override
        public String getJsonPath() {
            return "json/ParamRequest/false.result.json";
        }

        @Override
        public ParamRequest.Result getExpectedObject() {
            return ParamRequest.Result.getInstance(false);
        }
    }
}
