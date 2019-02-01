package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

@Value
public class AccountBalance {

    private static final String FIRM_ID = "firmid";
    private static final String SECURITY_CODE = "sec_code";
    private static final String TRADING_ACCOUNT_ID = "trdaccid";
    private static final String DEPOSIT_ACCOUNT_ID = "depaccid";
    private static final String OPEN_BALANCE = "openbal";
    private static final String CURRENT_POSITION = "currentpos";
    private static final String PLANNED_POSITION_SELL = "plannedpossell";
    private static final String PLANNED_POSITION_BUY = "plannedposbuy";
    private static final String PLANNED_BALANCE = "planbal";
    private static final String US_QTY_BOUGHT = "usqtyb";
    private static final String US_QTY_SOLD = "usqtys";
    private static final String PLANNED = "planned";
    private static final String SETTLE_BALANCE = "settlebal";
    private static final String BANK_ACCOUNT_ID = "bank_acc_id";
    private static final String FIRM_USE = "firmuse";

    String firmId;
    String secCode;
    String trdAccId;
    String depAccId;
    String openBal;
    String currentPos;
    String plannedPosSell;
    String plannedPosBuy;
    String planBal;
    String usqtyb;
    String usqtys;
    String planned;
    String settleBal;
    String bankAccId;
    int firmUse;

    @JsonCreator
    @Builder
    private AccountBalance(
            @JsonProperty(FIRM_ID) final String firmId,
            @JsonProperty(SECURITY_CODE) final String secCode,
            @JsonProperty(TRADING_ACCOUNT_ID) final String trdAccId,
            @JsonProperty(DEPOSIT_ACCOUNT_ID) final String depAccId,
            @JsonProperty(OPEN_BALANCE) final String openBal,
            @JsonProperty(CURRENT_POSITION) final String currentPos,
            @JsonProperty(PLANNED_POSITION_SELL) final String plannedPosSell,
            @JsonProperty(PLANNED_POSITION_BUY) final String plannedPosBuy,
            @JsonProperty(PLANNED_BALANCE) final String planBal,
            @JsonProperty(US_QTY_BOUGHT) final String usqtyb,
            @JsonProperty(US_QTY_SOLD) final String usqtys,
            @JsonProperty(PLANNED) final String planned,
            @JsonProperty(SETTLE_BALANCE) final String settleBal,
            @JsonProperty(BANK_ACCOUNT_ID) final String bankAccId,
            @JsonProperty(value = FIRM_USE, required = true) final int firmUse) {

        this.firmId = firmId;
        this.secCode = secCode;
        this.trdAccId = trdAccId;
        this.depAccId = depAccId;
        this.openBal = openBal;
        this.currentPos = currentPos;
        this.plannedPosSell = plannedPosSell;
        this.plannedPosBuy = plannedPosBuy;
        this.planBal = planBal;
        this.usqtyb = usqtyb;
        this.usqtys = usqtys;
        this.planned = planned;
        this.settleBal = settleBal;
        this.bankAccId = bankAccId;
        this.firmUse = firmUse;
    }

    @NotNull
    @Override
    public String toString() {

        return MoreObjects.toStringHelper(this)
                .add(FIRM_ID, firmId)
                .add(SECURITY_CODE, secCode)
                .add(TRADING_ACCOUNT_ID, trdAccId)
                .add(DEPOSIT_ACCOUNT_ID, depAccId)
                .add(OPEN_BALANCE, openBal)
                .add(CURRENT_POSITION, currentPos)
                .add(PLANNED_POSITION_SELL, plannedPosSell)
                .add(PLANNED_POSITION_BUY, plannedPosBuy)
                .add(PLANNED_BALANCE, planBal)
                .add(US_QTY_BOUGHT, usqtyb)
                .add(US_QTY_SOLD, usqtys)
                .add(PLANNED, planned)
                .add(SETTLE_BALANCE, settleBal)
                .add(BANK_ACCOUNT_ID, bankAccId)
                .add(FIRM_USE, firmUse)
                .toString();
    }
}
