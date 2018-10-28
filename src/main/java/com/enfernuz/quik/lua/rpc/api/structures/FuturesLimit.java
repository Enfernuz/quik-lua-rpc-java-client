package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

@Value
public class FuturesLimit {

    private static final String FIRM_ID = "firmid";
    private static final String TRADING_ACCOUNT_ID = "trdaccid";
    private static final String LIMIT_TYPE = "limit_type";
    private static final String LIQUIDITY_COEF = "liquidity_coef";
    private static final String CBP_PREV_LIMIT = "cbp_prev_limit";
    private static final String CBP_LIMIT = "cbplimit";
    private static final String CBP_L_USED = "cbplused";
    private static final String CBP_L_PLANNED = "cbplplanned";
    private static final String VAR_MARGIN = "varmargin";
    private static final String ACCRUED_INTEREST = "accruedint";
    private static final String CBP_L_USED_FOR_ORDERS = "cbplused_for_orders";
    private static final String CBP_L_USED_FOR_POSITIONS = "cbplused_for_positions";
    private static final String OPTIONS_PREMIUM = "options_premium";
    private static final String TS_COMISSION = "ts_comission";
    private static final String K_GO = "kgo";
    private static final String CURRENCY_CODE = "currcode";
    private static final String REAL_VAR_MARGIN = "real_varmargin";

    String firmId;
    String trdAccId;
    int limitType;
    String liquidityCoef;
    String cbpPrevLimit;
    String cbpLimit;
    String cbplUsed;
    String cbplPlanned;
    String varMargin;
    String accruedInt;
    String cbplUsedForOrders;
    String cbplUsedForPositions;
    String optionsPremium;
    String tsComission;
    String kgo;
    String currCode;
    String realVarMargin;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient String asString;

    @JsonCreator
    @Builder
    private FuturesLimit(
            @JsonProperty(value = FIRM_ID, required = true) @NonNull final String firmId,
            @JsonProperty(value = TRADING_ACCOUNT_ID, required = true) @NonNull final String trdAccId,
            @JsonProperty(value = LIMIT_TYPE, required = true) final int limitType,
            final @JsonProperty(LIQUIDITY_COEF) String liquidityCoef,
            final @JsonProperty(CBP_PREV_LIMIT) String cbpPrevLimit,
            final @JsonProperty(CBP_LIMIT) String cbpLimit,
            final @JsonProperty(CBP_L_USED) String cbplUsed,
            final @JsonProperty(CBP_L_PLANNED) String cbplPlanned,
            final @JsonProperty(VAR_MARGIN) String varMargin,
            final @JsonProperty(ACCRUED_INTEREST) String accruedInt,
            final @JsonProperty(CBP_L_USED_FOR_ORDERS) String cbplUsedForOrders,
            final @JsonProperty(CBP_L_USED_FOR_POSITIONS) String cbplUsedForPositions,
            final @JsonProperty(OPTIONS_PREMIUM) String optionsPremium,
            final @JsonProperty(TS_COMISSION) String tsComission,
            final @JsonProperty(K_GO) String kgo,
            final @JsonProperty(value = CURRENCY_CODE, required = true) @NonNull String currCode,
            final @JsonProperty(REAL_VAR_MARGIN) String realVarMargin) {

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

    @NotNull
    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add(FIRM_ID, firmId)
                    .add(TRADING_ACCOUNT_ID, trdAccId)
                    .add(LIMIT_TYPE, limitType)
                    .add(LIQUIDITY_COEF, liquidityCoef)
                    .add(CBP_PREV_LIMIT, cbpPrevLimit)
                    .add(CBP_LIMIT, cbpLimit)
                    .add(CBP_L_USED, cbplUsed)
                    .add(CBP_L_PLANNED, cbplPlanned)
                    .add(VAR_MARGIN, varMargin)
                    .add(ACCRUED_INTEREST, accruedInt)
                    .add(CBP_L_USED_FOR_ORDERS, cbplUsedForOrders)
                    .add(CBP_L_USED_FOR_POSITIONS, cbplUsedForPositions)
                    .add(OPTIONS_PREMIUM, optionsPremium)
                    .add(TS_COMISSION, tsComission)
                    .add(K_GO, kgo)
                    .add(CURRENCY_CODE, currCode)
                    .add(REAL_VAR_MARGIN, realVarMargin)
                    .toString();
        }

        return asString;
    }
}
