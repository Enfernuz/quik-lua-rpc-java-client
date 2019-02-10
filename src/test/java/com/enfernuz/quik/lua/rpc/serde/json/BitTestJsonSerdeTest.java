package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.bit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class BitTestJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<Test.Args> {

        @Override
        public Test.Args getArgsObject() {

            return Test.Args.builder()
                    .x(1)
                    .n(2)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/bit/test/args.json";
        }
    }

    public static class RpcTrueResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<Test.Result> {

        @Override
        public String getJsonPath() {
            return "json/bit/test/true.result.json";
        }

        @Override
        public Test.Result getExpectedObject() {
            return Test.Result.getInstance(true);
        }
    }

    public static class RpcFalseResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<Test.Result> {

        @Override
        public String getJsonPath() {
            return "json/bit/test/false.result.json";
        }

        @Override
        public Test.Result getExpectedObject() {
            return Test.Result.getInstance(false);
        }
    }
}
