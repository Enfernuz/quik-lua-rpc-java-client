package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BXor;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class BitBXorJsonSerdeTest {

    public static class RpcFullArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<BXor.Args> {

        @Override
        public BXor.Args getArgsObject() {

            return BXor.Args.builder()
                    .x1(1L)
                    .x2(2L)
                    .xi(new long[] {3L, 5L, 7L, 9L})
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/bit/bxor/full.args.json";
        }
    }

    public static class RpcWithoutXiArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<BXor.Args> {

        @Override
        public BXor.Args getArgsObject() {

            return BXor.Args.builder()
                    .x1(1L)
                    .x2(2L)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/bit/bxor/without_xi.args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<BXor.Result> {

        @Override
        public String getJsonPath() {
            return "json/bit/bxor/result.json";
        }

        @Override
        public BXor.Result getExpectedObject() {
            return new BXor.Result(1);
        }
    }
}
