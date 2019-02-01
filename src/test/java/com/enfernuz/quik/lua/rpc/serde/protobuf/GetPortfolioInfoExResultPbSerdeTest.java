package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetPortfolioInfoEx;
import com.enfernuz.quik.lua.rpc.api.structures.PortfolioInfo;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class GetPortfolioInfoExResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetPortfolioInfoEx.Result, GetPortfolioInfoEx.Result> {

    @Override
    public @NotNull Deserializer<GetPortfolioInfoEx.Result> getDeserializerUnderTest() {
        return GetPortfolioInfoExResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public GetPortfolioInfoEx.Result getTargetObject() {

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

        return GetPortfolioInfoEx.Result.builder()
                .portfolioInfo(portfolioInfo)
                .initMargin(PortfolioInfoExParameters.INIT_MARGIN)
                .minMargin(PortfolioInfoExParameters.MIN_MARGIN)
                .correctedMargin(PortfolioInfoExParameters.CORRECTED_MARGIN)
                .clientType(PortfolioInfoExParameters.CLIENT_TYPE)
                .portfolioValue(PortfolioInfoExParameters.PORTFOLIO_VALUE)
                .startLimitOpenPos(PortfolioInfoExParameters.START_LIMIT_OPEN_POS)
                .totalLimitOpenPos(PortfolioInfoExParameters.TOTAL_LIMIT_OPEN_POS)
                .limitOpenPos(PortfolioInfoExParameters.LIMIT_OPEN_POS)
                .usedLimOpenPos(PortfolioInfoExParameters.USED_LIM_OPEN_POS)
                .accVarMargin(PortfolioInfoExParameters.ACC_VAR_MARGIN)
                .clVarMargin(PortfolioInfoExParameters.CL_VAR_MARGIN)
                .optLiquidCost(PortfolioInfoExParameters.OPT_LIQUID_COST)
                .futAsset(PortfolioInfoExParameters.FUT_ASSET)
                .futTotalAsset(PortfolioInfoExParameters.FUT_TOTAL_ASSET)
                .futDebt(PortfolioInfoExParameters.FUT_DEBT)
                .futRateAsset(PortfolioInfoExParameters.FUT_RATE_ASSET)
                .futRateAssetOpen(PortfolioInfoExParameters.FUT_RATE_ASSET_OPEN)
                .futRateGo(PortfolioInfoExParameters.FUT_RATE_GO)
                .planedRateGo(PortfolioInfoExParameters.PLANED_RATE_GO)
                .cashLeverage(PortfolioInfoExParameters.CASH_LEVERAGE)
                .futPositionType(PortfolioInfoExParameters.FUT_POSITION_TYPE)
                .futAccruedInt(PortfolioInfoExParameters.FUT_ACCURED_INT)
                .build();
    }

    @NotNull
    @Override
    public qlua.rpc.GetPortfolioInfoEx.Result getTargetObjectAsPbMessage() {

        final qlua.rpc.GetPortfolioInfo.PortfolioInfo portfolioInfo =
                qlua.rpc.GetPortfolioInfo.PortfolioInfo.newBuilder()
                    .setIsLeverage(PortfolioInfoParameters.IS_LEVERAGE)
                    .setInAssets(PortfolioInfoParameters.IN_ASSETS)
                    .setLeverage(PortfolioInfoParameters.LEVERAGE)
                    .setOpenLimit(PortfolioInfoParameters.OPEN_LIMIT)
                    .setValShort(PortfolioInfoParameters.VAL_SHORT)
                    .setValLong(PortfolioInfoParameters.VAL_LONG)
                    .setValLongMargin(PortfolioInfoParameters.VAL_LONG_MARGIN)
                    .setValLongAsset(PortfolioInfoParameters.VAL_LONG_ASSET)
                    .setAssets(PortfolioInfoParameters.ASSETS)
                    .setCurLeverage(PortfolioInfoParameters.CUR_LEVERAGE)
                    .setMargin(PortfolioInfoParameters.MARGIN)
                    .setLimAll(PortfolioInfoParameters.LIM_ALL)
                    .setAvLimAll(PortfolioInfoParameters.AV_LIM_ALL)
                    .setLockedBuy(PortfolioInfoParameters.LOCKED_BUY)
                    .setLockedBuyMargin(PortfolioInfoParameters.LOCKED_BUY_MARGIN)
                    .setLockedBuyAsset(PortfolioInfoParameters.LOCKED_BUY_ASSET)
                    .setLockedSell(PortfolioInfoParameters.LOCKED_SELL)
                    .setLockedValueCoef(PortfolioInfoParameters.LOCKED_VALUE_COEF)
                    .setInAllAssets(PortfolioInfoParameters.IN_ALL_ASSETS)
                    .setAllAssets(PortfolioInfoParameters.ALL_ASSETS)
                    .setProfitLoss(PortfolioInfoParameters.PROFIT_LOSS)
                    .setRateChange(PortfolioInfoParameters.RATE_CHANGE)
                    .setLimBuy(PortfolioInfoParameters.LIM_BUY)
                    .setLimSell(PortfolioInfoParameters.LIM_SELL)
                    .setLimNonMargin(PortfolioInfoParameters.LIM_NON_MARGIN)
                    .setLimBuyAsset(PortfolioInfoParameters.LIM_BUY_ASSET)
                    .setValShortNet(PortfolioInfoParameters.VAL_SHORT_NET)
                    .setValLongNet(PortfolioInfoParameters.VAL_LONG_NET)
                    .setTotalMoneyBal(PortfolioInfoParameters.TOTAL_MONEY_BAL)
                    .setTotalLockedMoney(PortfolioInfoParameters.TOTAL_LOCKED_MONEY)
                    .setHaircuts(PortfolioInfoParameters.HAIRCUTS)
                    .setAssetsWithoutHc(PortfolioInfoParameters.ASSETS_WITHOUT_HC)
                    .setStatusCoef(PortfolioInfoParameters.STATUS_COEF)
                    .setVarmargin(PortfolioInfoParameters.VAR_MARGIN)
                    .setGoForPositions(PortfolioInfoParameters.GO_FOR_POSITIONS)
                    .setGoForOrders(PortfolioInfoParameters.GO_FOR_ORDERS)
                    .setRateFutures(PortfolioInfoParameters.RATE_FUTURES)
                    .setIsQualClient(PortfolioInfoParameters.IS_QUAL_CLIENT)
                    .setIsFutures(PortfolioInfoParameters.IS_FUTURES)
                    .setCurrTag(PortfolioInfoParameters.CURR_TAG)
                    .build();

        final qlua.rpc.GetPortfolioInfoEx.PortfolioInfoEx portfolioInfoEx =
                qlua.rpc.GetPortfolioInfoEx.PortfolioInfoEx.newBuilder()
                    .setPortfolioInfo(portfolioInfo)
                        .setInitMargin(PortfolioInfoExParameters.INIT_MARGIN)
                        .setMinMargin(PortfolioInfoExParameters.MIN_MARGIN)
                        .setCorrectedMargin(PortfolioInfoExParameters.CORRECTED_MARGIN)
                        .setClientType(PortfolioInfoExParameters.CLIENT_TYPE)
                        .setPortfolioValue(PortfolioInfoExParameters.PORTFOLIO_VALUE)
                        .setStartLimitOpenPos(PortfolioInfoExParameters.START_LIMIT_OPEN_POS)
                        .setTotalLimitOpenPos(PortfolioInfoExParameters.TOTAL_LIMIT_OPEN_POS)
                        .setLimitOpenPos(PortfolioInfoExParameters.LIMIT_OPEN_POS)
                        .setUsedLimOpenPos(PortfolioInfoExParameters.USED_LIM_OPEN_POS)
                        .setAccVarMargin(PortfolioInfoExParameters.ACC_VAR_MARGIN)
                        .setClVarMargin(PortfolioInfoExParameters.CL_VAR_MARGIN)
                        .setOptLiquidCost(PortfolioInfoExParameters.OPT_LIQUID_COST)
                        .setFutAsset(PortfolioInfoExParameters.FUT_ASSET)
                        .setFutTotalAsset(PortfolioInfoExParameters.FUT_TOTAL_ASSET)
                        .setFutDebt(PortfolioInfoExParameters.FUT_DEBT)
                        .setFutRateAsset(PortfolioInfoExParameters.FUT_RATE_ASSET)
                        .setFutRateAssetOpen(PortfolioInfoExParameters.FUT_RATE_ASSET_OPEN)
                        .setFutRateGo(PortfolioInfoExParameters.FUT_RATE_GO)
                        .setPlanedRateGo(PortfolioInfoExParameters.PLANED_RATE_GO)
                        .setCashLeverage(PortfolioInfoExParameters.CASH_LEVERAGE)
                        .setFutPositionType(PortfolioInfoExParameters.FUT_POSITION_TYPE)
                        .setFutAccuredInt(PortfolioInfoExParameters.FUT_ACCURED_INT)
                        .build();

        return qlua.rpc.GetPortfolioInfoEx.Result.newBuilder()
                .setPortfolioInfoEx(portfolioInfoEx)
                .build();
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

    private static final class PortfolioInfoExParameters {

        private static final String INIT_MARGIN = "2";
        private static final String MIN_MARGIN = "3";
        private static final String CORRECTED_MARGIN = "4";
        private static final String CLIENT_TYPE = "5";
        private static final String PORTFOLIO_VALUE = "6";
        private static final String START_LIMIT_OPEN_POS = "7";
        private static final String TOTAL_LIMIT_OPEN_POS = "8";
        private static final String LIMIT_OPEN_POS = "9";
        private static final String USED_LIM_OPEN_POS = "10";
        private static final String ACC_VAR_MARGIN = "11";
        private static final String CL_VAR_MARGIN = "12";
        private static final String OPT_LIQUID_COST = "13";
        private static final String FUT_ASSET = "14";
        private static final String FUT_TOTAL_ASSET = "15";
        private static final String FUT_DEBT = "16";
        private static final String FUT_RATE_ASSET = "17";
        private static final String FUT_RATE_ASSET_OPEN = "18";
        private static final String FUT_RATE_GO = "19";
        private static final String PLANED_RATE_GO = "20";
        private static final String CASH_LEVERAGE = "21";
        private static final String FUT_POSITION_TYPE = "22";
        private static final String FUT_ACCURED_INT = "23";
    }
}
