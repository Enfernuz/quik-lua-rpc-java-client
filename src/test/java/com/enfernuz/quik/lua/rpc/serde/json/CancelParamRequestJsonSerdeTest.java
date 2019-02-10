package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.CancelParamRequest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class CancelParamRequestJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<CancelParamRequest.Args> {

        @Override
        public CancelParamRequest.Args getArgsObject() {

            return CancelParamRequest.Args.builder()
                    .classCode("1")
                    .secCode("2")
                    .dbName("3")
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/CancelParamRequest/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<CancelParamRequest.Result> {

        @Override
        public String getJsonPath() {
            return "json/CancelParamRequest/result.json";
        }

        @Override
        public CancelParamRequest.Result getExpectedObject() {
            return new CancelParamRequest.Result(true);
        }
    }
}
