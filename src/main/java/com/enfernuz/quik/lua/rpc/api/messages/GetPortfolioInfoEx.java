package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.PortfolioInfo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class GetPortfolioInfoEx {

    private GetPortfolioInfoEx() {}

    @Value
    public static class Request {

        String firmId;
        String clientCode;
        int limitKind;

        @Builder
        private Request(@NonNull final String firmId, @NonNull final String clientCode, final int limitKind) {
            this.firmId = firmId;
            this.clientCode = clientCode;
            this.limitKind = limitKind;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("firm_id", firmId)
                    .add("client_code", clientCode)
                    .add("limit_kind", limitKind)
                    .toString();
        }
    }

    @Value
    public static class Result {

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

        private @NonFinal @Getter(AccessLevel.NONE) transient int hashCode;
        private @NonFinal @Getter(AccessLevel.NONE) transient String asString;

        @JsonCreator
        @Builder
        private Result(final @JsonProperty(value = "portfolio_info", required = true) @NonNull PortfolioInfo portfolioInfo,
                       final @JsonProperty(value = "init_margin") String initMargin,
                       final @JsonProperty(value = "min_margin") String minMargin,
                       final @JsonProperty(value = "corrected_margin") String correctedMargin,
                       final @JsonProperty(value = "client_type") String clientType,
                       final @JsonProperty(value = "portfolio_value") String portfolioValue,
                       final @JsonProperty(value = "start_limit_open_pos") String startLimitOpenPos,
                       final @JsonProperty(value = "total_limit_open_pos") String totalLimitOpenPos,
                       final @JsonProperty(value = "limit_open_pos") String limitOpenPos,
                       final @JsonProperty(value = "used_lim_open_pos") String usedLimOpenPos,
                       final @JsonProperty(value = "acc_var_margin") String accVarMargin,
                       final @JsonProperty(value = "cl_var_margin") String clVarMargin,
                       final @JsonProperty(value = "opt_liquid_cost") String optLiquidCost,
                       final @JsonProperty(value = "fut_asset") String futAsset,
                       final @JsonProperty(value = "fut_total_asset") String futTotalAsset,
                       final @JsonProperty(value = "fut_debt") String futDebt,
                       final @JsonProperty(value = "fut_rate_asset") String futRateAsset,
                       final @JsonProperty(value = "fut_rate_asset_open") String futRateAssetOpen,
                       final @JsonProperty(value = "fut_rate_go") String futRateGo,
                       final @JsonProperty(value = "planed_rate_go") String planedRateGo,
                       final @JsonProperty(value = "cash_leverage") String cashLeverage,
                       final @JsonProperty(value = "fut_position_type") String futPositionType,
                       final @JsonProperty(value = "fut_accured_int") String futAccruedInt) {

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
                        .add("portfolio_info", portfolioInfo)
                        .add("init_margin", initMargin)
                        .add("min_margin", minMargin)
                        .add("corrected_margin", correctedMargin)
                        .add("client_type", clientType)
                        .add("portfolio_value", portfolioValue)
                        .add("start_limit_open_pos", startLimitOpenPos)
                        .add("total_limit_open_pos", totalLimitOpenPos)
                        .add("limit_open_pos", limitOpenPos)
                        .add("used_lim_open_pos", usedLimOpenPos)
                        .add("acc_var_margin", accVarMargin)
                        .add("cl_var_margin", clVarMargin)
                        .add("opt_liquid_cost", optLiquidCost)
                        .add("fut_asset", futAsset)
                        .add("fut_total_asset", futTotalAsset)
                        .add("fut_debt", futDebt)
                        .add("fut_rate_asset", futRateAsset)
                        .add("fut_rate_asset_open", futRateAssetOpen)
                        .add("fut_rate_go", futRateGo)
                        .add("planed_rate_go", planedRateGo)
                        .add("cash_leverage", cashLeverage)
                        .add("fut_position_type", futPositionType)
                        .add("fut_accured_int", futAccruedInt)
                        .toString();
            }

            return asString;
        }
    }
}
