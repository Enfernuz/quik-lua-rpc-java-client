package com.enfernuz.quik.lua.rpc.events.api.structures;

import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class FuturesLimit {

    String firmId;
    String trdAccId;
    int limitType;
    String liquidityCoef;
    String cbpPrevLimit;
    String cbpLimit;
    String cbpLUsed;
    String cbpLPlanned;
    String varMargin;
    String accruedInt;
    String cbpLUsedForOrders;
    String cbpLUsedForPositions;
    String optionsPremium;
    String tsComission;
    String kgo;
    String currCode;
    String realVarMargin;

    private transient @NonFinal @Getter(AccessLevel.NONE) int hashCode;
    private transient @NonFinal @Getter(AccessLevel.NONE) String asString;

    @Builder
    private FuturesLimit(
            final String firmId,
            final String trdAccId,
            final int limitType,
            final String liquidityCoef,
            final String cbpPrevLimit,
            final String cbpLimit,
            final String cbpLUsed,
            final String cbpLPlanned,
            final String varMargin,
            final String accruedInt,
            final String cbpLUsedForOrders,
            final String cbpLUsedForPositions,
            final String optionsPremium,
            final String tsComission,
            final String kgo,
            final String currCode,
            final String realVarMargin) {

        this.firmId = firmId;
        this.trdAccId = trdAccId;
        this.limitType = limitType;
        this.liquidityCoef = liquidityCoef;
        this.cbpPrevLimit = cbpPrevLimit;
        this.cbpLimit = cbpLimit;
        this.cbpLUsed = cbpLUsed;
        this.cbpLPlanned = cbpLPlanned;
        this.varMargin = varMargin;
        this.accruedInt = accruedInt;
        this.cbpLUsedForOrders = cbpLUsedForOrders;
        this.cbpLUsedForPositions = cbpLUsedForPositions;
        this.optionsPremium = optionsPremium;
        this.tsComission = tsComission;
        this.kgo = kgo;
        this.currCode = currCode;
        this.realVarMargin = realVarMargin;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof FuturesLimit) ) {
            return false;
        } else {
            final FuturesLimit that = (FuturesLimit) o;
            return limitType == that.limitType &&
                    Objects.equals(firmId, that.firmId) &&
                    Objects.equals(trdAccId, that.trdAccId) &&
                    Objects.equals(liquidityCoef, that.liquidityCoef) &&
                    Objects.equals(cbpPrevLimit, that.cbpPrevLimit) &&
                    Objects.equals(cbpLimit, that.cbpLimit) &&
                    Objects.equals(cbpLUsed, that.cbpLUsed) &&
                    Objects.equals(cbpLPlanned, that.cbpLPlanned) &&
                    Objects.equals(varMargin, that.varMargin) &&
                    Objects.equals(accruedInt, that.accruedInt) &&
                    Objects.equals(cbpLUsedForOrders, that.cbpLUsedForOrders) &&
                    Objects.equals(cbpLUsedForPositions, that.cbpLUsedForPositions) &&
                    Objects.equals(optionsPremium, that.optionsPremium) &&
                    Objects.equals(tsComission, that.tsComission) &&
                    Objects.equals(kgo, that.kgo) &&
                    Objects.equals(currCode, that.currCode) &&
                    Objects.equals(realVarMargin, that.realVarMargin);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(
                    firmId,
                    trdAccId,
                    limitType,
                    liquidityCoef,
                    cbpPrevLimit,
                    cbpLimit,
                    cbpLUsed,
                    cbpLPlanned,
                    varMargin,
                    accruedInt,
                    cbpLUsedForOrders,
                    cbpLUsedForPositions,
                    optionsPremium,
                    tsComission,
                    kgo,
                    currCode,
                    realVarMargin
            );
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("firmid", firmId)
                    .add("trdaccid", trdAccId)
                    .add("limit_type", limitType)
                    .add("liquidity_coef", liquidityCoef)
                    .add("cbp_prev_limit", cbpPrevLimit)
                    .add("cbplimit", cbpLimit)
                    .add("cbplused", cbpLUsed)
                    .add("cbplplanned", cbpLPlanned)
                    .add("varmargin", varMargin)
                    .add("accruedint", accruedInt)
                    .add("cbplused_for_orders", cbpLUsedForOrders)
                    .add("cbplused_for_positions", cbpLUsedForPositions)
                    .add("options_premium", optionsPremium)
                    .add("ts_comission", tsComission)
                    .add("kgo", kgo)
                    .add("currcode", currCode)
                    .add("real_varmargin", realVarMargin)
                    .toString();
        }

        return asString;
    }
}
