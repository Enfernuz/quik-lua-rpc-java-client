package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class FuturesLimit {

    @JsonProperty("firmid") String firmId;
    @JsonProperty("trdaccid") String trdAccId;
    @JsonProperty(value = "limit_type") int limitType;
    @JsonProperty("liquidity_coef") String liquidityCoef;
    @JsonProperty("cbp_prev_limit") String cbpPrevLimit;
    @JsonProperty("cbplimit") String cbpLimit;
    @JsonProperty("cbplused") String cbplUsed;
    @JsonProperty("cbplplanned") String cbplPlanned;
    @JsonProperty("varmargin") String varMargin;
    @JsonProperty("accruedint") String accruedInt;
    @JsonProperty("cbplused_for_orders") String cbplUsedForOrders;
    @JsonProperty("cbplused_for_positions") String cbplUsedForPositions;
    @JsonProperty("options_premium") String optionsPremium;
    @JsonProperty("ts_comission") String tsComission;
    @JsonProperty("kgo") String kgo;
    @JsonProperty("currcode") String currCode;
    @JsonProperty("real_varmargin") String realVarMargin;

    @Getter(AccessLevel.NONE)
    @JsonIgnore
    private @NonFinal transient int hashCode;

    @Getter(AccessLevel.NONE)
    @JsonIgnore
    private @NonFinal transient String asString;

    @Builder
    @JsonCreator
    private FuturesLimit(
            final @JsonProperty("firmid") String firmId,
            final @JsonProperty("trdaccid") String trdAccId,
            final @JsonProperty(value = "limit_type", required = true) int limitType,
            final @JsonProperty("liquidity_coef") String liquidityCoef,
            final @JsonProperty("cbp_prev_limit") String cbpPrevLimit,
            final @JsonProperty("cbplimit") String cbpLimit,
            final @JsonProperty("cbplused") String cbplUsed,
            final @JsonProperty("cbplplanned") String cbplPlanned,
            final @JsonProperty("varmargin") String varMargin,
            final @JsonProperty("accruedint") String accruedInt,
            final @JsonProperty("cbplused_for_orders") String cbplUsedForOrders,
            final @JsonProperty("cbplused_for_positions") String cbplUsedForPositions,
            final @JsonProperty("options_premium") String optionsPremium,
            final @JsonProperty("ts_comission") String tsComission,
            final @JsonProperty("kgo") String kgo,
            final @JsonProperty("currcode") String currCode,
            final @JsonProperty("real_varmargin") String realVarMargin) {

        this.firmId = firmId;
        this.trdAccId = trdAccId;
        this.limitType = limitType;
        this.liquidityCoef = liquidityCoef;
        this.cbpPrevLimit = cbpPrevLimit;
        this.cbpLimit = cbpLimit;
        this.cbplUsed = cbplUsed;
        this.cbplPlanned = cbplPlanned;
        this.varMargin = varMargin;
        this.accruedInt = accruedInt;
        this.cbplUsedForOrders = cbplUsedForOrders;
        this.cbplUsedForPositions = cbplUsedForPositions;
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
                    Objects.equals(cbplUsed, that.cbplUsed) &&
                    Objects.equals(cbplPlanned, that.cbplPlanned) &&
                    Objects.equals(varMargin, that.varMargin) &&
                    Objects.equals(accruedInt, that.accruedInt) &&
                    Objects.equals(cbplUsedForOrders, that.cbplUsedForOrders) &&
                    Objects.equals(cbplUsedForPositions, that.cbplUsedForPositions) &&
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
                    cbplUsed,
                    cbplPlanned,
                    varMargin,
                    accruedInt,
                    cbplUsedForOrders,
                    cbplUsedForPositions,
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
                    .add("cbplused", cbplUsed)
                    .add("cbplplanned", cbplPlanned)
                    .add("varmargin", varMargin)
                    .add("accruedint", accruedInt)
                    .add("cbplused_for_orders", cbplUsedForOrders)
                    .add("cbplused_for_positions", cbplUsedForPositions)
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
