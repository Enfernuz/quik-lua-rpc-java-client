package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfo;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetBuySellInfoJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetBuySellInfo.Args> {

        @Override
        public GetBuySellInfo.Args getArgsObject() {

            return GetBuySellInfo.Args.builder()
                    .firmId("1")
                    .clientCode("2")
                    .classCode("3")
                    .secCode("4")
                    .price("5")
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getBuySellInfo/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetBuySellInfo.Result> {

        @Override
        public String getJsonPath() {
            return "json/getBuySellInfo/result.json";
        }

        @Override
        public GetBuySellInfo.Result getExpectedObject() {

            final GetBuySellInfo.BuySellInfo buySellInfo = GetBuySellInfo.BuySellInfo.builder()
                    .isMarginSec("1")
                    .isAssetSec("2")
                    .balance("3")
                    .canBuy("4")
                    .canSell("5")
                    .positionValuation("6")
                    .value("7")
                    .openValue("8")
                    .limLong("9")
                    .longCoef("10")
                    .limShort("11")
                    .shortCoef("12")
                    .valueCoef("13")
                    .openValueCoef("14")
                    .share("15")
                    .shortWaPrice("16")
                    .longWaPrice("17")
                    .profitLoss("18")
                    .spreadHc("19")
                    .canBuyOwn("20")
                    .canSellOwn("21")
                    .build();

            return new GetBuySellInfo.Result(buySellInfo);
        }
    }
}
