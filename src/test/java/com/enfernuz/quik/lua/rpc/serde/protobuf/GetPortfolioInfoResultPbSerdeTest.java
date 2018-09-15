package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetPortfolioInfo;
import com.enfernuz.quik.lua.rpc.api.structures.PortfolioInfo;
import com.enfernuz.quik.lua.rpc.serde.SerdeException;
import org.jetbrains.annotations.NotNull;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.instanceOf;

public class GetPortfolioInfoResultPbSerdeTest extends AbstractResultPbSerdeTest<GetPortfolioInfo.Result, qlua.rpc.GetPortfolioInfo.Result> {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Override
    public @NotNull Class<GetPortfolioInfo.Result> getTargetObjectClass() {
        return GetPortfolioInfo.Result.class;
    }

    @NotNull
    @Override
    public qlua.rpc.GetPortfolioInfo.Result getTargetObjectAsPbMessage() {

        final qlua.rpc.GetPortfolioInfo.PortfolioInfo portfolioInfo = qlua.rpc.GetPortfolioInfo.PortfolioInfo.newBuilder()
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

        return qlua.rpc.GetPortfolioInfo.Result.newBuilder()
                .setPortfolioInfo(portfolioInfo)
                .build();
    }

    @NotNull
    @Override
    public GetPortfolioInfo.Result getTargetObject() {

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

    @Test
    public void shouldFailOnUninitializedPbPortfolioInfo() {

        thrown.expect(SerdeException.class);
        thrown.expectCause(
                allOf(
                        instanceOf(IllegalArgumentException.class),
                        hasProperty("message", equalTo("Экземпляр protobuf-представления qlua.rpc.GetPortfolioInfo.Result не содержит поля 'portfolioInfo'."))
                )
        );

        getSerdeModuleUnderTest().deserialize(GetPortfolioInfo.Result.class, qlua.rpc.GetPortfolioInfo.Result.newBuilder().build().toByteArray());
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
