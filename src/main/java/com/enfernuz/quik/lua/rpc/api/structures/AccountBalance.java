package com.enfernuz.quik.lua.rpc.api.structures;

import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class AccountBalance {

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

    private transient @NonFinal @Getter(AccessLevel.NONE) int hashCode;
    private transient @NonFinal @Getter(AccessLevel.NONE) String asString;

    @Builder
    private AccountBalance(
            final String firmId,
            final String secCode,
            final String trdAccId,
            final String depAccId,
            final String openBal,
            final String currentPos,
            final String plannedPosSell,
            final String plannedPosBuy,
            final String planBal,
            final String usqtyb,
            final String usqtys,
            final String planned,
            final String settleBal,
            final String bankAccId,
            final int firmUse) {

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
