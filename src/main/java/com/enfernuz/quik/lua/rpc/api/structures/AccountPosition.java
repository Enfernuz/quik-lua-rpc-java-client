package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class AccountPosition {

    @JsonProperty("firmid") String firmId;
    @JsonProperty("currcode") String currCode;
    @JsonProperty("tag") String tag;
    @JsonProperty("description") String description;
    @JsonProperty("openbal") String openBal;
    @JsonProperty("currentpos") String currentPos;
    @JsonProperty("plannedpos") String plannedPos;
    @JsonProperty("limit1") String limit1;
    @JsonProperty("limit2") String limit2;
    @JsonProperty("orderbuy") String orderBuy;
    @JsonProperty("ordersell") String orderSell;
    @JsonProperty("netto") String netto;
    @JsonProperty("plannedbal") String plannedBal;
    @JsonProperty("debit") String debit;
    @JsonProperty("credit") String credit;
    @JsonProperty("bank_acc_id") String bankAccId;
    @JsonProperty("margincall") String marginCall;
    @JsonProperty("settlebal") String settleBal;

    private transient @NonFinal @Getter(AccessLevel.NONE) int hashCode;
    private transient @NonFinal @Getter(AccessLevel.NONE) String asString;

    @Builder
    @JsonCreator
    private AccountPosition(
            @JsonProperty("firmid") final String firmId,
            @JsonProperty("currcode") final String currCode,
            @JsonProperty("tag") final String tag,
            @JsonProperty("description") final String description,
            @JsonProperty("openbal") final String openBal,
            @JsonProperty("currentpos") final String currentPos,
            @JsonProperty("plannedpos") final String plannedPos,
            @JsonProperty("limit1") final String limit1,
            @JsonProperty("limit2") final String limit2,
            @JsonProperty("orderbuy") final String orderBuy,
            @JsonProperty("ordersell") final String orderSell,
            @JsonProperty("netto") final String netto,
            @JsonProperty("plannedbal") final String plannedBal,
            @JsonProperty("debit") final String debit,
            @JsonProperty("credit") final String credit,
            @JsonProperty("bank_acc_id") final String bankAccId,
            @JsonProperty("margincall") final String marginCall,
            @JsonProperty("settlebal") final String settleBal) {

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