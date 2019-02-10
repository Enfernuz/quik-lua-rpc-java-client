package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetDepoEx;
import com.enfernuz.quik.lua.rpc.api.structures.DepoLimit;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetDepoExJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetDepoEx.Args> {

        @Override
        public GetDepoEx.Args getArgsObject() {

            return GetDepoEx.Args.builder()
                    .firmId("1")
                    .clientCode("2")
                    .secCode("3")
                    .trdAccId("4")
                    .limitKind(5)
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getDepoEx/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetDepoEx.Result> {

        @Override
        public String getJsonPath() {
            return "json/getDepoEx/result.json";
        }

        @Override
        public GetDepoEx.Result getExpectedObject() {

            final DepoLimit depoEx = DepoLimit.builder()
                    .secCode("1")
                    .trdAccId("2")
                    .firmId("3")
                    .clientCode("4")
                    .openBal(5)
                    .openLimit(6)
                    .currentBal(7)
                    .currentLimit(8)
                    .lockedSell(9)
                    .lockedBuy(10)
                    .lockedBuyValue("11")
                    .lockedSellValue("12")
                    .waPositionPrice("13")
                    .limitKind(14)
                    .build();


            return GetDepoEx.Result.getInstance(depoEx);
        }
    }
}
