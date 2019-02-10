package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.bit.ToHex;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class BitToHexJsonSerdeTest {

    public static class RpcFullArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<ToHex.Args> {

        @Override
        public ToHex.Args getArgsObject() {

            return ToHex.Args.builder()
                    .x(1)
                    .n(2)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/bit/tohex/full.args.json";
        }
    }

    public static class RpcWithoutNArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<ToHex.Args> {

        @Override
        public ToHex.Args getArgsObject() {

            return ToHex.Args.builder()
                    .x(1)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/bit/tohex/without_n.args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<ToHex.Result> {

        @Override
        public String getJsonPath() {
            return "json/bit/tohex/result.json";
        }

        @Override
        public ToHex.Result getExpectedObject() {
            return new ToHex.Result("1");
        }
    }
}
