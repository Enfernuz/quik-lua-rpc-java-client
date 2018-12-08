package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetPortfolioInfo;
import com.enfernuz.quik.lua.rpc.api.structures.PortfolioInfo;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class GetPortfolioInfoResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetPortfolioInfo.Result, GetPortfolioInfo.Result> {

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

    @Override
    public @NotNull Deserializer<GetPortfolioInfo.Result> getDeserializerUnderTest() {
        return GetPortfolioInfoResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public GetPortfolioInfo.Result getTargetObject() {

        final PortfolioInfo portfolioInfo = PortfolioInfo.builder()
                .isLeverage(IS_LEVERAGE)
                .inAssets(IN_ASSETS)
                .leverage(LEVERAGE)
                .openLimit(OPEN_LIMIT)
                .valShort(VAL_SHORT)
                .valLong(VAL_LONG)
                .valLongMargin(VAL_LONG_MARGIN)
                .valLongAsset(VAL_LONG_ASSET)
                .assets(ASSETS)
                .curLeverage(CUR_LEVERAGE)
                .margin(MARGIN)
                .limAll(LIM_ALL)
                .avLimAll(AV_LIM_ALL)
                .lockedBuy(LOCKED_BUY)
                .lockedBuyMargin(LOCKED_BUY_MARGIN)
                .lockedBuyAsset(LOCKED_BUY_ASSET)
                .lockedSell(LOCKED_SELL)
                .lockedValueCoef(LOCKED_VALUE_COEF)
                .inAllAssets(IN_ALL_ASSETS)
                .allAssets(ALL_ASSETS)
                .profitLoss(PROFIT_LOSS)
                .rateChange(RATE_CHANGE)
                .limBuy(LIM_BUY)
                .limSell(LIM_SELL)
                .limNonMargin(LIM_NON_MARGIN)
                .limBuyAsset(LIM_BUY_ASSET)
                .valShortNet(VAL_SHORT_NET)
                .valLongNet(VAL_LONG_NET)
                .totalMoneyBal(TOTAL_MONEY_BAL)
                .totalLockedMoney(TOTAL_LOCKED_MONEY)
                .haircuts(HAIRCUTS)
                .assetsWithoutHc(ASSETS_WITHOUT_HC)
                .statusCoef(STATUS_COEF)
                .varMargin(VAR_MARGIN)
                .goForPositions(GO_FOR_POSITIONS)
                .goForOrders(GO_FOR_ORDERS)
                .rateFutures(RATE_FUTURES)
                .isQualClient(IS_QUAL_CLIENT)
                .isFutures(IS_FUTURES)
                .currTag(CURR_TAG)
                .build();

        return new GetPortfolioInfo.Result(portfolioInfo);
    }

    @NotNull
    @Override
    public qlua.rpc.GetPortfolioInfo.Result getTargetObjectAsPbMessage() {

        final qlua.rpc.GetPortfolioInfo.PortfolioInfo portfolioInfo =
                qlua.rpc.GetPortfolioInfo.PortfolioInfo.newBuilder()
                    .setIsLeverage(IS_LEVERAGE)
                    .setInAssets(IN_ASSETS)
                    .setLeverage(LEVERAGE)
                    .setOpenLimit(OPEN_LIMIT)
                    .setValShort(VAL_SHORT)
                    .setValLong(VAL_LONG)
                    .setValLongMargin(VAL_LONG_MARGIN)
                    .setValLongAsset(VAL_LONG_ASSET)
                    .setAssets(ASSETS)
                    .setCurLeverage(CUR_LEVERAGE)
                    .setMargin(MARGIN)
                    .setLimAll(LIM_ALL)
                    .setAvLimAll(AV_LIM_ALL)
                    .setLockedBuy(LOCKED_BUY)
                    .setLockedBuyMargin(LOCKED_BUY_MARGIN)
                    .setLockedBuyAsset(LOCKED_BUY_ASSET)
                    .setLockedSell(LOCKED_SELL)
                    .setLockedValueCoef(LOCKED_VALUE_COEF)
                    .setInAllAssets(IN_ALL_ASSETS)
                    .setAllAssets(ALL_ASSETS)
                    .setProfitLoss(PROFIT_LOSS)
                    .setRateChange(RATE_CHANGE)
                    .setLimBuy(LIM_BUY)
                    .setLimSell(LIM_SELL)
                    .setLimNonMargin(LIM_NON_MARGIN)
                    .setLimBuyAsset(LIM_BUY_ASSET)
                    .setValShortNet(VAL_SHORT_NET)
                    .setValLongNet(VAL_LONG_NET)
                    .setTotalMoneyBal(TOTAL_MONEY_BAL)
                    .setTotalLockedMoney(TOTAL_LOCKED_MONEY)
                    .setHaircuts(HAIRCUTS)
                    .setAssetsWithoutHc(ASSETS_WITHOUT_HC)
                    .setStatusCoef(STATUS_COEF)
                    .setVarmargin(VAR_MARGIN)
                    .setGoForPositions(GO_FOR_POSITIONS)
                    .setGoForOrders(GO_FOR_ORDERS)
                    .setRateFutures(RATE_FUTURES)
                    .setIsQualClient(IS_QUAL_CLIENT)
                    .setIsFutures(IS_FUTURES)
                    .setCurrTag(CURR_TAG)
                    .build();

        return qlua.rpc.GetPortfolioInfo.Result.newBuilder()
                .setPortfolioInfo(portfolioInfo)
                .build();
    }
}
