package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BAnd;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class BitBAndJsonSerdeTest {

    public static class RpcFullArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<BAnd.Args> {

        @Override
        public BAnd.Args getArgsObject() {

            return BAnd.Args.builder()
                    .x1(1L)
                    .x2(2L)
                    .xi(new long[] {3L, 5L, 7L, 9L})
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/bit/band/full.args.json";
        }
    }

    public static class RpcWithoutXiSerializationTest extends AbstractJsonRpcArgsSerializationTest<BAnd.Args> {

        @Override
        public BAnd.Args getArgsObject() {

            return BAnd.Args.builder()
                    .x1(1L)
                    .x2(2L)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/bit/band/without_xi.args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<BAnd.Result> {

        @Override
        public String getJsonPath() {
            return "json/bit/band/result.json";
        }

        @Override
        public BAnd.Result getExpectedObject() {
            return new BAnd.Result(1);
        }
    }
}
