package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfo;
import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfoEx;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class GetBuySellnfoExResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetBuySellInfoEx.Result, GetBuySellInfoEx.Result> {

    private static final String IS_MARGIN_SEC = "1";
    private static final String IS_ASSET_SEC = "2";
    private static final String BALANCE = "3";
    private static final String CAN_BUY = "4";
    private static final String CAN_SELL = "5";
    private static final String POSITION_VALUATION = "6";
    private static final String VALUE = "7";
    private static final String OPEN_VALUE = "8";
    private static final String LIM_LONG = "9";
    private static final String LONG_COEF = "10";
    private static final String LIM_SHORT = "11";
    private static final String SHORT_COEF = "12";
    private static final String VALUE_COEF = "13";
    private static final String OPEN_VALUE_COEF = "14";
    private static final String SHARE = "15";
    private static final String SHORT_WA_PRICE = "16";
    private static final String LONG_WA_PRICE = "17";
    private static final String PROFIT_LOSS = "18";
    private static final String SPREAD_HC = "19";
    private static final String CAN_BUY_OWN = "20";
    private static final String CAN_SELL_OWN = "21";

    private static final String LIMIT_KIND = "22";
    private static final String D_LONG = "23";
    private static final String D_MIN_LONG = "24";
    private static final String D_SHORT = "25";
    private static final String D_MIN_SHORT = "26";
    private static final String CLIENT_TYPE = "27";
    private static final String IS_LONG_ALLOWED = "28";
    private static final String IS_SHORT_ALLOWED = "29";

    @Override
    public @NotNull Deserializer<GetBuySellInfoEx.Result> getDeserializerUnderTest() {
        return GetBuySellInfoExResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public GetBuySellInfoEx.Result getTargetObject() {

        final GetBuySellInfo.BuySellInfo buySellInfo = GetBuySellInfo.BuySellInfo.builder()
                .isMarginSec(IS_MARGIN_SEC)
                .isAssetSec(IS_ASSET_SEC)
                .balance(BALANCE)
                .canBuy(CAN_BUY)
                .canSell(CAN_SELL)
                .positionValuation(POSITION_VALUATION)
                .value(VALUE)
                .openValue(OPEN_VALUE)
                .limLong(LIM_LONG)
                .longCoef(LONG_COEF)
                .limShort(LIM_SHORT)
                .shortCoef(SHORT_COEF)
                .valueCoef(VALUE_COEF)
                .openValueCoef(OPEN_VALUE_COEF)
                .share(SHARE)
                .shortWaPrice(SHORT_WA_PRICE)
                .longWaPrice(LONG_WA_PRICE)
                .profitLoss(PROFIT_LOSS)
                .spreadHc(SPREAD_HC)
                .canBuyOwn(CAN_BUY_OWN)
                .canSellOwn(CAN_SELL_OWN)
                .build();

        final GetBuySellInfoEx.BuySellInfoEx buySellInfoEx = GetBuySellInfoEx.BuySellInfoEx.builder()
                .buySellInfo(buySellInfo)
                .limitKind(LIMIT_KIND)
                .dLong(D_LONG)
                .dMinLong(D_MIN_LONG)
                .dShort(D_SHORT)
                .dMinShort(D_MIN_SHORT)
                .clientType(CLIENT_TYPE)
                .isLongAllowed(IS_LONG_ALLOWED)
                .isShortAllowed(IS_SHORT_ALLOWED)
                .build();

        return new GetBuySellInfoEx.Result(buySellInfoEx);
    }

    @NotNull
    @Override
    public qlua.rpc.GetBuySellInfoEx.Result getTargetObjectAsPbMessage() {

        final qlua.rpc.GetBuySellInfo.BuySellInfo pbBuySellInfo = qlua.rpc.GetBuySellInfo.BuySellInfo.newBuilder()
                .setIsMarginSec(IS_MARGIN_SEC)
                .setIsAssetSec(IS_ASSET_SEC)
                .setBalance(BALANCE)
                .setCanBuy(CAN_BUY)
                .setCanSell(CAN_SELL)
                .setPositionValuation(POSITION_VALUATION)
                .setValue(VALUE)
                .setOpenValue(OPEN_VALUE)
                .setLimLong(LIM_LONG)
                .setLongCoef(LONG_COEF)
                .setLimShort(LIM_SHORT)
                .setShortCoef(SHORT_COEF)
                .setValueCoef(VALUE_COEF)
                .setOpenValueCoef(OPEN_VALUE_COEF)
                .setShare(SHARE)
                .setShortWaPrice(SHORT_WA_PRICE)
                .setLongWaPrice(LONG_WA_PRICE)
                .setProfitLoss(PROFIT_LOSS)
                .setSpreadHc(SPREAD_HC)
                .setCanBuyOwn(CAN_BUY_OWN)
                .setCanSellOwn(CAN_SELL_OWN)
                .build();

        final qlua.rpc.GetBuySellInfoEx.BuySellInfoEx pbBuySellInfoEx = qlua.rpc.GetBuySellInfoEx.BuySellInfoEx.newBuilder()
                .setBuySellInfo(pbBuySellInfo)
                .setLimitKind(LIMIT_KIND)
                .setDLong(D_LONG)
                .setDMinLong(D_MIN_LONG)
                .setDShort(D_SHORT)
                .setDMinShort(D_MIN_SHORT)
                .setClientType(CLIENT_TYPE)
                .setIsLongAllowed(IS_LONG_ALLOWED)
                .setIsShortAllowed(IS_SHORT_ALLOWED)
                .build();

        return qlua.rpc.GetBuySellInfoEx.Result.newBuilder()
                .setBuySellInfoEx(pbBuySellInfoEx)
                .build();
    }
}
