package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetMoneyEx;
import com.enfernuz.quik.lua.rpc.api.structures.MoneyLimit;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import qlua.structs.QluaStructures;

public class GetMoneyExResultPbSerdeTest extends AbstractResultPbSerdeTest<GetMoneyEx.Result, qlua.rpc.GetMoneyEx.Result> {

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

    @Test
    @Override
    public void testSerialize_WithNonEssentialFieldsInitializedByDefault() {
        super.testSerialize_WithNonEssentialFieldsInitializedByDefault();
    }

    @Test
    @Override
    public void testDeserialize_WithNonEssentialFieldsInitializedByDefault() {
        super.testDeserialize_WithNonEssentialFieldsInitializedByDefault();
    }

    @Override
    public @NotNull Class<GetMoneyEx.Result> getTargetObjectClass() {
        return GetMoneyEx.Result.class;
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
                .build();

        return qlua.rpc.GetMoneyEx.Result.newBuilder()
                .setMoneyEx(moneyLimit)
                .build();
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
                .build();

        return GetMoneyEx.Result.getInstance(moneyLimit);
    }

    @NotNull
    @Override
    public qlua.rpc.GetMoneyEx.Result getTargetObject_WithNonEssentialFieldsInitializedByDefault_AsPbMessage() {
        return qlua.rpc.GetMoneyEx.Result.newBuilder().build();
    }

    @NotNull
    @Override
    public GetMoneyEx.Result getTargetObject_WithNonEssentialFieldsInitializedByDefault() {
        return GetMoneyEx.Result.getInstance(null);
    }
}
