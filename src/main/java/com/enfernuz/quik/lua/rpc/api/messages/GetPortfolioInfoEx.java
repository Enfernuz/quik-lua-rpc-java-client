package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.enfernuz.quik.lua.rpc.api.structures.PortfolioInfo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class GetPortfolioInfoEx implements RemoteProcedure {

    private GetPortfolioInfoEx() {}

    @JsonPropertyOrder({Args.FIRM_ID, Args.CLIENT_CODE, Args.LIMIT_KIND})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetPortfolioInfoEx> {

        private static final String FIRM_ID = "firm_id";
        private static final String CLIENT_CODE = "client_code";
        private static final String LIMIT_KIND = "limit_kind";

        @JsonProperty(FIRM_ID)
        private final String firmId;

        @JsonProperty(CLIENT_CODE)
        private final String clientCode;

        @JsonProperty(LIMIT_KIND)
        private final int limitKind;

        @Builder
        private Args(@NonNull final String firmId, @NonNull final String clientCode, final int limitKind) {

            this.firmId = firmId;
            this.clientCode = clientCode;
            this.limitKind = limitKind;
        }

        @JsonIgnore
        public String getFirmId() {
            return firmId;
        }

        @JsonIgnore
        public String getClientCode() {
            return clientCode;
        }

        @JsonIgnore
        public int getLimitKind() {
            return limitKind;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(FIRM_ID, firmId)
                    .add(CLIENT_CODE, clientCode)
                    .add(LIMIT_KIND, limitKind)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetPortfolioInfoEx> {

        private static final String PORTFOLIO_INFO = "portfolio_info";
        private static final String INIT_MARGIN = "init_margin";
        private static final String MIN_MARGIN = "min_margin";
        private static final String CORRECTED_MARGIN = "corrected_margin";
        private static final String CLIENT_TYPE = "client_type";
        private static final String PORTFOLIO_VALUE = "portfolio_value";
        private static final String START_LIMIT_OPEN_POS = "start_limit_open_pos";
        private static final String TOTAL_LIMIT_OPEN_POS = "total_limit_open_pos";
        private static final String LIMIT_OPEN_POS = "limit_open_pos";
        private static final String USED_LIM_OPEN_POS = "used_lim_open_pos";
        private static final String ACC_VAR_MARGIN = "acc_var_margin";
        private static final String CL_VAR_MARGIN = "cl_var_margin";
        private static final String OPT_LIQUID_COST = "opt_liquid_cost";
        private static final String FUT_ASSET = "fut_asset";
        private static final String FUT_TOTAL_ASSET = "fut_total_asset";
        private static final String FUT_DEBT = "fut_debt";
        private static final String FUT_RATE_ASSET = "fut_rate_asset";
        private static final String FUT_RATE_ASSET_OPEN = "fut_rate_asset_open";
        private static final String FUT_RATE_GO = "fut_rate_go";
        private static final String PLANED_RATE_GO = "planed_rate_go";
        private static final String CASH_LEVERAGE = "cash_leverage";
        private static final String FUT_POSITION_TYPE = "fut_position_type";
        private static final String FUT_ACCRUED_INT = "fut_accured_int";

        PortfolioInfo portfolioInfo;
        String initMargin;
        String minMargin;
        String correctedMargin;
        String clientType;
        String portfolioValue;
        String startLimitOpenPos;
        String totalLimitOpenPos;
        String limitOpenPos;
        String usedLimOpenPos;
        String accVarMargin;
        String clVarMargin;
        String optLiquidCost;
        String futAsset;
        String futTotalAsset;
        String futDebt;
        String futRateAsset;
        String futRateAssetOpen;
        String futRateGo;
        String planedRateGo;
        String cashLeverage;
        String futPositionType;
        String futAccruedInt;

        @Getter(AccessLevel.NONE)
        @NonFinal
        private transient int hashCode;

        @Getter(AccessLevel.NONE)
        @NonFinal
        private transient String asString;

        @JsonCreator
        @Builder
        private Result(@JsonProperty(value = PORTFOLIO_INFO, required = true) final @NonNull PortfolioInfo portfolioInfo,
                       @JsonProperty(INIT_MARGIN) final String initMargin,
                       @JsonProperty(MIN_MARGIN) final String minMargin,
                       @JsonProperty(CORRECTED_MARGIN) final String correctedMargin,
                       @JsonProperty(CLIENT_TYPE) final String clientType,
                       @JsonProperty(PORTFOLIO_VALUE) final String portfolioValue,
                       @JsonProperty(START_LIMIT_OPEN_POS) final String startLimitOpenPos,
                       @JsonProperty(TOTAL_LIMIT_OPEN_POS) final String totalLimitOpenPos,
                       @JsonProperty(LIMIT_OPEN_POS) final String limitOpenPos,
                       @JsonProperty(USED_LIM_OPEN_POS) final String usedLimOpenPos,
                       @JsonProperty(ACC_VAR_MARGIN) final String accVarMargin,
                       @JsonProperty(CL_VAR_MARGIN) final String clVarMargin,
                       @JsonProperty(OPT_LIQUID_COST) final String optLiquidCost,
                       @JsonProperty(FUT_ASSET) final String futAsset,
                       @JsonProperty(FUT_TOTAL_ASSET) final String futTotalAsset,
                       @JsonProperty(FUT_DEBT) final String futDebt,
                       @JsonProperty(FUT_RATE_ASSET) final String futRateAsset,
                       @JsonProperty(FUT_RATE_ASSET_OPEN) final String futRateAssetOpen,
                       @JsonProperty(FUT_RATE_GO) final String futRateGo,
                       @JsonProperty(PLANED_RATE_GO) final String planedRateGo,
                       @JsonProperty(CASH_LEVERAGE) final String cashLeverage,
                       @JsonProperty(FUT_POSITION_TYPE) final String futPositionType,
                       @JsonProperty(FUT_ACCRUED_INT) final String futAccruedInt) {

            this.portfolioInfo = portfolioInfo;
            this.initMargin = initMargin;
            this.minMargin = minMargin;
            this.correctedMargin = correctedMargin;
            this.clientType = clientType;
            this.portfolioValue = portfolioValue;
            this.startLimitOpenPos = startLimitOpenPos;
            this.totalLimitOpenPos = totalLimitOpenPos;
            this.limitOpenPos = limitOpenPos;
            this.usedLimOpenPos = usedLimOpenPos;
            this.accVarMargin = accVarMargin;
            this.clVarMargin = clVarMargin;
            this.optLiquidCost = optLiquidCost;
            this.futAsset = futAsset;
            this.futTotalAsset = futTotalAsset;
            this.futDebt = futDebt;
            this.futRateAsset = futRateAsset;
            this.futRateAssetOpen = futRateAssetOpen;
            this.futRateGo = futRateGo;
            this.planedRateGo = planedRateGo;
            this.cashLeverage = cashLeverage;
            this.futPositionType = futPositionType;
            this.futAccruedInt = futAccruedInt;
        }

        @Override
        public boolean equals(final Object o) {

            if (o == this) {
                return true;
            } else if ( !(o instanceof Result) ) {
                return false;
            } else {
                final Result result = (Result) o;
                return Objects.equals(portfolioInfo, result.portfolioInfo) &&
                        Objects.equals(initMargin, result.initMargin) &&
                        Objects.equals(minMargin, result.minMargin) &&
                        Objects.equals(correctedMargin, result.correctedMargin) &&
                        Objects.equals(clientType, result.clientType) &&
                        Objects.equals(portfolioValue, result.portfolioValue) &&
                        Objects.equals(startLimitOpenPos, result.startLimitOpenPos) &&
                        Objects.equals(totalLimitOpenPos, result.totalLimitOpenPos) &&
                        Objects.equals(limitOpenPos, result.limitOpenPos) &&
                        Objects.equals(usedLimOpenPos, result.usedLimOpenPos) &&
                        Objects.equals(accVarMargin, result.accVarMargin) &&
                        Objects.equals(clVarMargin, result.clVarMargin) &&
                        Objects.equals(optLiquidCost, result.optLiquidCost) &&
                        Objects.equals(futAsset, result.futAsset) &&
                        Objects.equals(futTotalAsset, result.futTotalAsset) &&
                        Objects.equals(futDebt, result.futDebt) &&
                        Objects.equals(futRateAsset, result.futRateAsset) &&
                        Objects.equals(futRateAssetOpen, result.futRateAssetOpen) &&
                        Objects.equals(futRateGo, result.futRateGo) &&
                        Objects.equals(planedRateGo, result.planedRateGo) &&
                        Objects.equals(cashLeverage, result.cashLeverage) &&
                        Objects.equals(futPositionType, result.futPositionType) &&
                        Objects.equals(futAccruedInt, result.futAccruedInt);
            }
        }

        @Override
        public int hashCode() {

            if (hashCode == 0) {
                hashCode = Objects.hash(
                        portfolioInfo,
                        initMargin,
                        minMargin,
                        correctedMargin,
                        clientType,
                        portfolioValue,
                        startLimitOpenPos,
                        totalLimitOpenPos,
                        limitOpenPos,
                        usedLimOpenPos,
                        accVarMargin,
                        clVarMargin,
                        optLiquidCost,
                        futAsset,
                        futTotalAsset,
                        futDebt,
                        futRateAsset,
                        futRateAssetOpen,
                        futRateGo,
                        planedRateGo,
                        cashLeverage,
                        futPositionType,
                        futAccruedInt
                );
            }

            return hashCode;
        }

        @Override
        public String toString() {

            if (asString == null) {
                asString = MoreObjects.toStringHelper(this)
                        .add(PORTFOLIO_INFO, portfolioInfo)
                        .add(INIT_MARGIN, initMargin)
                        .add(MIN_MARGIN, minMargin)
                        .add(CORRECTED_MARGIN, correctedMargin)
                        .add(CLIENT_TYPE, clientType)
                        .add(PORTFOLIO_VALUE, portfolioValue)
                        .add(START_LIMIT_OPEN_POS, startLimitOpenPos)
                        .add(TOTAL_LIMIT_OPEN_POS, totalLimitOpenPos)
                        .add(LIMIT_OPEN_POS, limitOpenPos)
                        .add(USED_LIM_OPEN_POS, usedLimOpenPos)
                        .add(ACC_VAR_MARGIN, accVarMargin)
                        .add(CL_VAR_MARGIN, clVarMargin)
                        .add(OPT_LIQUID_COST, optLiquidCost)
                        .add(FUT_ASSET, futAsset)
                        .add(FUT_TOTAL_ASSET, futTotalAsset)
                        .add(FUT_DEBT, futDebt)
                        .add(FUT_RATE_ASSET, futRateAsset)
                        .add(FUT_RATE_ASSET_OPEN, futRateAssetOpen)
                        .add(FUT_RATE_GO, futRateGo)
                        .add(PLANED_RATE_GO, planedRateGo)
                        .add(CASH_LEVERAGE, cashLeverage)
                        .add(FUT_POSITION_TYPE, futPositionType)
                        .add(FUT_ACCRUED_INT, futAccruedInt)
                        .toString();
            }

            return asString;
        }
    }
}
