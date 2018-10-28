package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

@Value
public class AccountPosition {

    private static final String FIRM_ID = "firmid";
    private static final String CURRENCY_CODE = "currcode";
    private static final String TAG = "tag";
    private static final String DESCRIPTION = "description";
    private static final String OPEN_BALANCE = "openbal";
    private static final String CURRENT_POSITION = "currentpos";
    private static final String PLANNED_POSITION = "plannedpos";
    private static final String LIMIT_1 = "limit1";
    private static final String LIMIT_2 = "limit2";
    private static final String ORDER_BUY = "orderbuy";
    private static final String ORDER_SELL = "ordersell";
    private static final String NETTO = "netto";
    private static final String PLANNED_BALANCE = "plannedbal";
    private static final String DEBIT = "debit";
    private static final String CREDIT = "credit";
    private static final String BANK_ACCOUNT_ID = "bank_acc_id";
    private static final String MARGIN_CALL = "margincall";
    private static final String SETTLE_BALANCE = "settlebal";

    String firmId;
    String currCode;
    String tag;
    String description;
    String openBal;
    String currentPos;
    String plannedPos;
    String limit1;
    String limit2;
    String orderBuy;
    String orderSell;
    String netto;
    String plannedBal;
    String debit;
    String credit;
    String bankAccId;
    String marginCall;
    String settleBal;

    @JsonCreator
    @Builder
    private AccountPosition(
            @JsonProperty(FIRM_ID) final String firmId,
            @JsonProperty(CURRENCY_CODE) final String currCode,
            @JsonProperty(TAG) final String tag,
            @JsonProperty(DESCRIPTION) final String description,
            @JsonProperty(OPEN_BALANCE) final String openBal,
            @JsonProperty(CURRENT_POSITION) final String currentPos,
            @JsonProperty(PLANNED_POSITION) final String plannedPos,
            @JsonProperty(LIMIT_1) final String limit1,
            @JsonProperty(LIMIT_2) final String limit2,
            @JsonProperty(ORDER_BUY) final String orderBuy,
            @JsonProperty(ORDER_SELL) final String orderSell,
            @JsonProperty(NETTO) final String netto,
            @JsonProperty(PLANNED_BALANCE) final String plannedBal,
            @JsonProperty(DEBIT) final String debit,
            @JsonProperty(CREDIT) final String credit,
            @JsonProperty(BANK_ACCOUNT_ID) final String bankAccId,
            @JsonProperty(MARGIN_CALL) final String marginCall,
            @JsonProperty(SETTLE_BALANCE) final String settleBal) {

        this.firmId = firmId;
        this.currCode = currCode;
        this.tag = tag;
        this.description = description;
        this.openBal = openBal;
        this.currentPos = currentPos;
        this.plannedPos = plannedPos;
        this.limit1 = limit1;
        this.limit2 = limit2;
        this.orderBuy = orderBuy;
        this.orderSell = orderSell;
        this.netto = netto;
        this.plannedBal = plannedBal;
        this.debit = debit;
        this.credit = credit;
        this.bankAccId = bankAccId;
        this.marginCall = marginCall;
        this.settleBal = settleBal;
    }

    @NotNull
    @Override
    public String toString() {

        return MoreObjects.toStringHelper(this)
                .add(FIRM_ID, firmId)
                .add(CURRENCY_CODE, currCode)
                .add(TAG, tag)
                .add(DESCRIPTION, description)
                .add(OPEN_BALANCE, openBal)
                .add(CURRENT_POSITION, currentPos)
                .add(PLANNED_POSITION, plannedPos)
                .add(LIMIT_1, limit1)
                .add(LIMIT_2, limit2)
                .add(ORDER_BUY, orderBuy)
                .add(ORDER_SELL, orderSell)
                .add(NETTO, netto)
                .add(PLANNED_BALANCE, plannedBal)
                .add(DEBIT, debit)
                .add(CREDIT, credit)
                .add(BANK_ACCOUNT_ID, bankAccId)
                .add(MARGIN_CALL, marginCall)
                .add(SETTLE_BALANCE, settleBal)
                .toString();
    }
}
