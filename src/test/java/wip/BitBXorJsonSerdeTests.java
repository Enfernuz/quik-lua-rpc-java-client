package wip;

import com.enfernuz.quik.lua.rpc.api.messages.bit.BXor;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class BitBXorJsonSerdeTests {

    public static class RpcFullArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<BXor.Args> {

        @Override
        public BXor.Args getArgsObject() {

            return BXor.Args.builder()
                    .x1(1)
                    .x2(2)
                    .xi(new int[] {3, 5, 7, 9})
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
                    .x1(1)
                    .x2(2)
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
