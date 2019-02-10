package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BNot;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class BitBNotJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<BNot.Args> {

        @Override
        public BNot.Args getArgsObject() { return new BNot.Args(1);}

        @Override
        public String getArgsJsonPath() {
            return "json/bit/bnot/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<BNot.Result> {

        @Override
        public String getJsonPath() {
            return "json/bit/bnot/result.json";
        }

        @Override
        public BNot.Result getExpectedObject() {
            return new BNot.Result(1);
        }
    }
}
