package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BOr;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class BitBOrJsonSerdeTests {

    public static class RpcFullArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<BOr.Args> {

        @Override
        public BOr.Args getArgsObject() {

            return BOr.Args.builder()
                    .x1(1)
                    .x2(2)
                    .xi(new int[] {3, 5, 7, 9})
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/bit/bor/full.args.json";
        }
    }

    public static class RpcWithoutXiArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<BOr.Args> {

        @Override
        public BOr.Args getArgsObject() {

            return BOr.Args.builder()
                    .x1(1)
                    .x2(2)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/bit/bor/without_xi.args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<BOr.Result> {

        @Override
        public String getJsonPath() {
            return "json/bit/bor/result.json";
        }

        @Override
        public BOr.Result getExpectedObject() {
            return new BOr.Result(1);
        }
    }
}
