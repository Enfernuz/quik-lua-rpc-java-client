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
public class AccountBalance {

    @JsonProperty("firmid") String firmId;
    @JsonProperty("sec_code") String secCode;
    @JsonProperty("trdaccid") String trdAccId;
    @JsonProperty("depaccid") String depAccId;
    @JsonProperty("openbal") String openBal;
    @JsonProperty("currentpos") String currentPos;
    @JsonProperty("plannedpossell") String plannedPosSell;
    @JsonProperty("plannedposbuy") String plannedPosBuy;
    @JsonProperty("planbal") String planBal;
    @JsonProperty("usqtyb") String usqtyb;
    @JsonProperty("usqtys") String usqtys;
    @JsonProperty("planned") String planned;
    @JsonProperty("settlebal") String settleBal;
    @JsonProperty("bank_acc_id") String bankAccId;
    @JsonProperty(value = "firmuse") int firmUse;

    private transient @NonFinal @Getter(AccessLevel.NONE) int hashCode;
    private transient @NonFinal @Getter(AccessLevel.NONE) String asString;

    @Builder
    @JsonCreator
    private AccountBalance(
            @JsonProperty("firmid") final String firmId,
            @JsonProperty("sec_code") final String secCode,
            @JsonProperty("trdaccid") final String trdAccId,
            @JsonProperty("depaccid") final String depAccId,
            @JsonProperty("openbal") final String openBal,
            @JsonProperty("currentpos") final String currentPos,
            @JsonProperty("plannedpossell") final String plannedPosSell,
            @JsonProperty("plannedposbuy") final String plannedPosBuy,
            @JsonProperty("planbal") final String planBal,
            @JsonProperty("usqtyb") final String usqtyb,
            @JsonProperty("usqtys") final String usqtys,
            @JsonProperty("planned") final String planned,
            @JsonProperty("settlebal") final String settleBal,
            @JsonProperty("bank_acc_id") final String bankAccId,
            @JsonProperty(value = "firmuse", required = true) final int firmUse) {

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

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if (!(o instanceof AccountBalance)) {
            return false;
        } else {
            final AccountBalance that = (AccountBalance) o;
            return firmUse == that.firmUse &&
                    Objects.equals(firmId, that.firmId) &&
                    Objects.equals(secCode, that.secCode) &&
                    Objects.equals(trdAccId, that.trdAccId) &&
                    Objects.equals(depAccId, that.depAccId) &&
                    Objects.equals(openBal, that.openBal) &&
                    Objects.equals(currentPos, that.currentPos) &&
                    Objects.equals(plannedPosSell, that.plannedPosSell) &&
                    Objects.equals(plannedPosBuy, that.plannedPosBuy) &&
                    Objects.equals(planBal, that.planBal) &&
                    Objects.equals(usqtyb, that.usqtyb) &&
                    Objects.equals(usqtys, that.usqtys) &&
                    Objects.equals(planned, that.planned) &&
                    Objects.equals(settleBal, that.settleBal) &&
                    Objects.equals(bankAccId, that.bankAccId);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(
                    firmId,
                    secCode,
                    trdAccId,
                    depAccId,
                    openBal,
                    currentPos,
                    plannedPosSell,
                    plannedPosBuy,
                    planBal,
                    usqtyb,
                    usqtys,
                    planned,
                    settleBal,
                    bankAccId,
                    firmUse
            );
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("firmid", firmId)
                    .add("sec_code", secCode)
                    .add("trdaccid", trdAccId)
                    .add("depaccid", depAccId)
                    .add("openbal", openBal)
                    .add("currentpos", currentPos)
                    .add("plannedpossell", plannedPosSell)
                    .add("plannedposbuy", plannedPosBuy)
                    .add("planbal", planBal)
                    .add("usqtyb", usqtyb)
                    .add("usqtys", usqtys)
                    .add("planned", planned)
                    .add("settlebal", settleBal)
                    .add("bank_acc_id", bankAccId)
                    .add("firmuse", firmUse)
                    .toString();
        }

        return asString;
    }
}
