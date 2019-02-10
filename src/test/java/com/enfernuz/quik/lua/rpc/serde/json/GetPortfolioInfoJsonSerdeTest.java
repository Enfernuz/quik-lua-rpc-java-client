package com.enfernuz.quik.lua.rpc.serde.json;

import com.enfernuz.quik.lua.rpc.api.messages.GetPortfolioInfo;
import com.enfernuz.quik.lua.rpc.api.structures.PortfolioInfo;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class GetPortfolioInfoJsonSerdeTest {

    public static class RpcArgsSerializationTest extends AbstractJsonRpcArgsSerializationTest<GetPortfolioInfo.Args> {

        @Override
        public GetPortfolioInfo.Args getArgsObject() {

            return GetPortfolioInfo.Args.builder()
                    .firmId("1")
                    .clientCode("2")
                    .build();
        }

        @Override
        public String getArgsJsonPath() {
            return "json/getPortfolioInfo/args.json";
        }
    }

    public static class RpcResultDeserializationTest extends AbstractRpcResultJsonDeserializationTest<GetPortfolioInfo.Result> {

        @Override
        public String getJsonPath() {
            return "json/getPortfolioInfo/result.json";
        }

        @Override
        public GetPortfolioInfo.Result getExpectedObject() {

            final PortfolioInfo portfolioInfo = PortfolioInfo.builder()
                    .isLeverage(PortfolioInfoParameters.IS_LEVERAGE)
                    .inAssets(PortfolioInfoParameters.IN_ASSETS)
                    .leverage(PortfolioInfoParameters.LEVERAGE)
                    .openLimit(PortfolioInfoParameters.OPEN_LIMIT)
                    .valShort(PortfolioInfoParameters.VAL_SHORT)
                    .valLong(PortfolioInfoParameters.VAL_LONG)
                    .valLongMargin(PortfolioInfoParameters.VAL_LONG_MARGIN)
                    .valLongAsset(PortfolioInfoParameters.VAL_LONG_ASSET)
                    .assets(PortfolioInfoParameters.ASSETS)
                    .curLeverage(PortfolioInfoParameters.CUR_LEVERAGE)
                    .margin(PortfolioInfoParameters.MARGIN)
                    .limAll(PortfolioInfoParameters.LIM_ALL)
                    .avLimAll(PortfolioInfoParameters.AV_LIM_ALL)
                    .lockedBuy(PortfolioInfoParameters.LOCKED_BUY)
                    .lockedBuyMargin(PortfolioInfoParameters.LOCKED_BUY_MARGIN)
                    .lockedBuyAsset(PortfolioInfoParameters.LOCKED_BUY_ASSET)
                    .lockedSell(PortfolioInfoParameters.LOCKED_SELL)
                    .lockedValueCoef(PortfolioInfoParameters.LOCKED_VALUE_COEF)
                    .inAllAssets(PortfolioInfoParameters.IN_ALL_ASSETS)
                    .allAssets(PortfolioInfoParameters.ALL_ASSETS)
                    .profitLoss(PortfolioInfoParameters.PROFIT_LOSS)
                    .rateChange(PortfolioInfoParameters.RATE_CHANGE)
                    .limBuy(PortfolioInfoParameters.LIM_BUY)
                    .limSell(PortfolioInfoParameters.LIM_SELL)
                    .limNonMargin(PortfolioInfoParameters.LIM_NON_MARGIN)
                    .limBuyAsset(PortfolioInfoParameters.LIM_BUY_ASSET)
                    .valShortNet(PortfolioInfoParameters.VAL_SHORT_NET)
                    .valLongNet(PortfolioInfoParameters.VAL_LONG_NET)
                    .totalMoneyBal(PortfolioInfoParameters.TOTAL_MONEY_BAL)
                    .totalLockedMoney(PortfolioInfoParameters.TOTAL_LOCKED_MONEY)
                    .haircuts(PortfolioInfoParameters.HAIRCUTS)
                    .assetsWithoutHc(PortfolioInfoParameters.ASSETS_WITHOUT_HC)
                    .statusCoef(PortfolioInfoParameters.STATUS_COEF)
                    .varMargin(PortfolioInfoParameters.VAR_MARGIN)
                    .goForPositions(PortfolioInfoParameters.GO_FOR_POSITIONS)
                    .goForOrders(PortfolioInfoParameters.GO_FOR_ORDERS)
                    .rateFutures(PortfolioInfoParameters.RATE_FUTURES)
                    .isQualClient(PortfolioInfoParameters.IS_QUAL_CLIENT)
                    .isFutures(PortfolioInfoParameters.IS_FUTURES)
                    .currTag(PortfolioInfoParameters.CURR_TAG)
                    .build();

            return new GetPortfolioInfo.Result(portfolioInfo);
        }

        private static final class PortfolioInfoParameters {

            private static final String IS_LEVERAGE = "1";
            private static final String IN_ASSETS = "2";
            private static final String LEVERAGE = "3";
            private static final String OPEN_LIMIT = "4";
            private static final String VAL_SHORT = "5";
            private static final String VAL_LONG = "6";
            private static final String VAL_LONG_MARGIN = "7";
            private static final String VAL_LONG_ASSET = "8";
            private static final String ASSETS = "9";
            private static final String CUR_LEVERAGE = "10";
            private static final String MARGIN = "11";
            private static final String LIM_ALL = "12";
            private static final String AV_LIM_ALL = "13";
            private static final String LOCKED_BUY = "14";
            private static final String LOCKED_BUY_MARGIN = "15";
            private static final String LOCKED_BUY_ASSET = "16";
            private static final String LOCKED_SELL = "17";
            private static final String LOCKED_VALUE_COEF = "18";
            private static final String IN_ALL_ASSETS = "19";
            private static final String ALL_ASSETS = "20";
            private static final String PROFIT_LOSS = "21";
            private static final String RATE_CHANGE = "22";
            private static final String LIM_BUY = "23";
            private static final String LIM_SELL = "24";
            private static final String LIM_NON_MARGIN = "25";
            private static final String LIM_BUY_ASSET = "26";
            private static final String VAL_SHORT_NET = "27";
            private static final String VAL_LONG_NET = "28";
            private static final String TOTAL_MONEY_BAL = "29";
            private static final String TOTAL_LOCKED_MONEY = "30";
            private static final String HAIRCUTS = "31";
            private static final String ASSETS_WITHOUT_HC = "32";
            private static final String STATUS_COEF = "33";
            private static final String VAR_MARGIN = "34";
            private static final String GO_FOR_POSITIONS = "35";
            private static final String GO_FOR_ORDERS = "36";
            private static final String RATE_FUTURES = "37";
            private static final String IS_QUAL_CLIENT = "38";
            private static final String IS_FUTURES = "39";
            private static final String CURR_TAG = "40";
        }
    }
}
