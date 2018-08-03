package com.enfernuz.quik.lua.rpc.api.structures;

import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class AccountPosition {

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

    private transient @NonFinal @Getter(AccessLevel.NONE) int hashCode;
    private transient @NonFinal @Getter(AccessLevel.NONE) String asString;

    @Builder
    private AccountPosition(
            final String firmId,
            final String currCode,
            final String tag,
            final String description,
            final String openBal,
            final String currentPos,
            final String plannedPos,
            final String limit1,
            final String limit2,
            final String orderBuy,
            final String orderSell,
            final String netto,
            final String plannedBal,
            final String debit,
            final String credit,
            final String bankAccId,
            final String marginCall,
            final String settleBal) {

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

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof AccountPosition) ) {
            return false;
        } else {
            final AccountPosition that = (AccountPosition) o;
            return Objects.equals(firmId, that.firmId) &&
                    Objects.equals(currCode, that.currCode) &&
                    Objects.equals(tag, that.tag) &&
                    Objects.equals(description, that.description) &&
                    Objects.equals(openBal, that.openBal) &&
                    Objects.equals(currentPos, that.currentPos) &&
                    Objects.equals(plannedPos, that.plannedPos) &&
                    Objects.equals(limit1, that.limit1) &&
                    Objects.equals(limit2, that.limit2) &&
                    Objects.equals(orderBuy, that.orderBuy) &&
                    Objects.equals(orderSell, that.orderSell) &&
                    Objects.equals(netto, that.netto) &&
                    Objects.equals(plannedBal, that.plannedBal) &&
                    Objects.equals(debit, that.debit) &&
                    Objects.equals(credit, that.credit) &&
                    Objects.equals(bankAccId, that.bankAccId) &&
                    Objects.equals(marginCall, that.marginCall) &&
                    Objects.equals(settleBal, that.settleBal);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(
                    firmId,
                    currCode,
                    tag,
                    description,
                    openBal,
                    currentPos,
                    plannedPos,
                    limit1,
                    limit2,
                    orderBuy,
                    orderSell,
                    netto,
                    plannedBal,
                    debit,
                    credit,
                    bankAccId,
                    marginCall,
                    settleBal
            );
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("firmid", firmId)
                    .add("currcode", currCode)
                    .add("tag", tag)
                    .add("description", description)
                    .add("openbal", openBal)
                    .add("currentpos", currentPos)
                    .add("plannedpos", plannedPos)
                    .add("limit1", limit1)
                    .add("limit2", limit2)
                    .add("orderbuy", orderBuy)
                    .add("ordersell", orderSell)
                    .add("netto", netto)
                    .add("plannedbal", plannedBal)
                    .add("debit", debit)
                    .add("credit", credit)
                    .add("bank_acc_id", bankAccId)
                    .add("margincall", marginCall)
                    .add("settlebal", settleBal)
                    .toString();
        }

        return asString;
    }
}


//    string firmid = 1;
//    string currcode = 2;
//    string tag = 3;
//    string description = 4;
//    string openbal = 5; // NUMBER in QLUA
//    string currentpos = 6; // NUMBER in QLUA
//    string plannedpos = 7; // NUMBER in QLUA
//    string limit1 = 8; // NUMBER in QLUA
//    string limit2 = 9; // NUMBER in QLUA
//    string orderbuy = 10; // NUMBER in QLUA
//    string ordersell = 11; // NUMBER in QLUA
//    string netto = 12; // NUMBER in QLUA
//    string plannedbal = 13; // NUMBER in QLUA
//    string debit = 14; // NUMBER in QLUA
//    string credit = 15; // NUMBER in QLUA
//    string bank_acc_id = 16;
//    string margincall = 17; // NUMBER in QLUA
//    string settlebal = 18; // NUMBER in QLUA