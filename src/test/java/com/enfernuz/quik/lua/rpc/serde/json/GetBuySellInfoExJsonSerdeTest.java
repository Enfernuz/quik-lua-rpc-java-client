package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfo;
import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfoEx;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetBuySellInfoExJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetBuySellInfoEx.Args> {

        @Override
        public GetBuySellInfoEx.Args getArgsObject() {

            return GetBuySellInfoEx.Args.builder()
                    .firmId("1")
                    .clientCode("2")
                    .classCode("3")
                    .secCode("4")
                    .price("5")
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getBuySellInfoEx/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetBuySellInfoEx.Result> {

        @Override
        public String getJsonPath() {
            return "json/getBuySellInfoEx/result.json";
        }

        @Override
        public GetBuySellInfoEx.Result getExpectedObject() {

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
            final GetBuySellInfoEx.BuySellInfoEx buySellInfoEx = GetBuySellInfoEx.BuySellInfoEx.builder()
                    .buySellInfo(buySellInfo)
                    .limitKind("2")
                    .dLong("3")
                    .dMinLong("4")
                    .dShort("5")
                    .dMinShort("6")
                    .clientType("7")
                    .isLongAllowed("8")
                    .isShortAllowed("9")
                    .build();

            return new GetBuySellInfoEx.Result(buySellInfoEx);
        }
    }
}
