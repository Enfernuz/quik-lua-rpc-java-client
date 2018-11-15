package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.AccountBalance;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

public class AccountBalancePbSerdeTest extends AbstractPbDeserializationTest<QluaStructures.AccountBalance, AccountBalance> {

    private static final String FIRM_ID = "1";
    private static final String SEC_CODE = "2";
    private static final String TRD_ACC_ID = "3";
    private static final String DEP_ACC_ID = "4";
    private static final String OPEN_BAL = "5";
    private static final String CURRENT_POS = "6";
    private static final String PLANNED_POS_SELL = "7";
    private static final String PLANNED_POS_BUY = "8";
    private static final String PLAN_BAL = "9";
    private static final String USQTYB = "10";
    private static final String USQTYS = "11";
    private static final String PLANNED = "12";
    private static final String SETTLE_BAL = "13";
    private static final String BANK_ACC_ID = "14";
    private static final int FIRM_USE = 15;

    @Override
    public @NotNull Deserializer<AccountBalance> getDeserializerUnderTest() {
        return AccountBalancePbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public AccountBalance getTargetObject() {

        return AccountBalance.builder()
                .firmId(FIRM_ID)
                .secCode(SEC_CODE)
                .trdAccId(TRD_ACC_ID)
                .depAccId(DEP_ACC_ID)
                .openBal(OPEN_BAL)
                .currentPos(CURRENT_POS)
                .plannedPosSell(PLANNED_POS_SELL)
                .plannedPosBuy(PLANNED_POS_BUY)
                .planBal(PLAN_BAL)
                .usqtyb(USQTYB)
                .usqtys(USQTYS)
                .planned(PLANNED)
                .settleBal(SETTLE_BAL)
                .bankAccId(BANK_ACC_ID)
                .firmUse(FIRM_USE)
                .build();
    }

    @NotNull
    @Override
    public QluaStructures.AccountBalance getTargetObjectAsPbMessage() {

        return QluaStructures.AccountBalance.newBuilder()
                .setFirmid(FIRM_ID)
                .setSecCode(SEC_CODE)
                .setTrdaccid(TRD_ACC_ID)
                .setDepaccid(DEP_ACC_ID)
                .setOpenbal(OPEN_BAL)
                .setCurrentpos(CURRENT_POS)
                .setPlannedpossell(PLANNED_POS_SELL)
                .setPlannedposbuy(PLANNED_POS_BUY)
                .setPlanbal(PLAN_BAL)
                .setUsqtyb(USQTYB)
                .setUsqtys(USQTYS)
                .setPlanned(PLANNED)
                .setSettlebal(SETTLE_BAL)
                .setBankAccId(BANK_ACC_ID)
                .setFirmuse(FIRM_USE)
                .build();
    }
}
