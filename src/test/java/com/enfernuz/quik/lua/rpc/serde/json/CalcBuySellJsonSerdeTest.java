package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.CalcBuySell;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class CalcBuySellJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<CalcBuySell.Args> {

        @Override
        public CalcBuySell.Args getArgsObject() {

            return CalcBuySell.Args.builder()
                    .classCode("1")
                    .secCode("2")
                    .clientCode("3")
                    .account("4")
                    .price("5")
                    .isBuy(true)
                    .isMarket(true)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/CalcBuySell/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<CalcBuySell.Result> {

        @Override
        public String getJsonPath() {
            return "json/CalcBuySell/result.json";
        }

        @Override
        public CalcBuySell.Result getExpectedObject() {
            return new CalcBuySell.Result(1, "2");
        }
    }
}
