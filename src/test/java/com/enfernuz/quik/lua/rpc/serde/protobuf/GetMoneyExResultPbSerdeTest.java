package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetMoneyEx;
import com.enfernuz.quik.lua.rpc.api.structures.MoneyLimit;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import qlua.structs.QluaStructures;

@RunWith(Enclosed.class)
public class GetMoneyExResultPbSerdeTest  {

    private static final String CURR_CODE = "1";
    private static final String TAG = "2";
    private static final String FIRM_ID = "3";
    private static final String CLIENT_CODE = "4";
    private static final String OPEN_BAL = "5";
    private static final String OPEN_LIMIT = "6";
    private static final String CURRENT_BAL = "7";
    private static final String CURRENT_LIMIT = "8";
    private static final String LOCKED = "9";
    private static final String LOCKED_VALUE_COEF = "10";
    private static final String LOCKED_MARGIN_VALUE = "11";
    private static final String LEVERAGE = "12";
    private static final int LIMIT_KIND = 13;
    private static final String WA_POSITION_PRICE = "14";
    private static final String ORDERS_COLLATERAL = "15";
    private static final String POSITIONS_COLLATERAL = "16";

    public static class NormalGetMoneyExResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetMoneyEx.Result, GetMoneyEx.Result> {

        @Override
        public @NotNull Deserializer<GetMoneyEx.Result> getDeserializerUnderTest() {
            return GetMoneyExResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public GetMoneyEx.Result getTargetObject() {

            final MoneyLimit moneyLimit = MoneyLimit.builder()
                    .currCode(CURR_CODE)
                    .tag(TAG)
                    .firmId(FIRM_ID)
                    .clientCode(CLIENT_CODE)
                    .openBal(OPEN_BAL)
                    .openLimit(OPEN_LIMIT)
                    .currentBal(CURRENT_BAL)
                    .currentLimit(CURRENT_LIMIT)
                    .locked(LOCKED)
                    .lockedValueCoef(LOCKED_VALUE_COEF)
                    .lockedMarginValue(LOCKED_MARGIN_VALUE)
                    .leverage(LEVERAGE)
                    .limitKind(LIMIT_KIND)
                    .waPositionPrice(WA_POSITION_PRICE)
                    .ordersCollateral(ORDERS_COLLATERAL)
                    .positionsCollateral(POSITIONS_COLLATERAL)
                    .build();

            return GetMoneyEx.Result.getInstance(moneyLimit);
        }

        @NotNull
        @Override
        public qlua.rpc.GetMoneyEx.Result getTargetObjectAsPbMessage() {

            final QluaStructures.MoneyLimit moneyLimit = QluaStructures.MoneyLimit.newBuilder()
                    .setCurrcode(CURR_CODE)
                    .setTag(TAG)
                    .setFirmid(FIRM_ID)
                    .setClientCode(CLIENT_CODE)
                    .setOpenbal(OPEN_BAL)
                    .setOpenlimit(OPEN_LIMIT)
                    .setCurrentbal(CURRENT_BAL)
                    .setCurrentlimit(CURRENT_LIMIT)
                    .setLocked(LOCKED)
                    .setLockedValueCoef(LOCKED_VALUE_COEF)
                    .setLockedMarginValue(LOCKED_MARGIN_VALUE)
                    .setLeverage(LEVERAGE)
                    .setLimitKind(LIMIT_KIND)
                    .setWaPositionPrice(WA_POSITION_PRICE)
                    .setOrdersCollateral(ORDERS_COLLATERAL)
                    .setPositionsCollateral(POSITIONS_COLLATERAL)
                    .build();

            return qlua.rpc.GetMoneyEx.Result.newBuilder()
                    .setMoneyEx(moneyLimit)
                    .build();
        }
    }

    public static class ErrorGetMoneyExResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetMoneyEx.Result, GetMoneyEx.Result> {

        @Override
        public @NotNull Deserializer<GetMoneyEx.Result> getDeserializerUnderTest() {
            return GetMoneyExResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public GetMoneyEx.Result getTargetObject() {
            return GetMoneyEx.Result.getInstance(null);
        }

        @NotNull
        @Override
        public qlua.rpc.GetMoneyEx.Result getTargetObjectAsPbMessage() {
            return qlua.rpc.GetMoneyEx.Result.newBuilder().build();
        }
    }
}
