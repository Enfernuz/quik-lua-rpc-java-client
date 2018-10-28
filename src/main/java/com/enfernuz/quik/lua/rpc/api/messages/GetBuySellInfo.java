package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class GetBuySellInfo implements RemoteProcedure {

    private GetBuySellInfo() {}

    @JsonPropertyOrder({Args.FIRM_ID, Args.CLIENT_CODE, Args.CLASS_CODE, Args.SEC_CODE, Args.PRICE})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetBuySellInfo> {

        private static final String FIRM_ID = "firm_id";
        private static final String CLIENT_CODE = "client_code";
        private static final String CLASS_CODE = "class_code";
        private static final String SEC_CODE = "sec_code";
        private static final String PRICE = "price";

        @JsonProperty(FIRM_ID)
        private final String firmId;

        @JsonProperty(CLIENT_CODE)
        private final String clientCode;

        @JsonProperty(CLASS_CODE)
        private final String classCode;

        @JsonProperty(SEC_CODE)
        private final String secCode;

        @JsonProperty(PRICE)
        private final String price;

        @Builder
        private Args(
                @NonNull final String firmId,
                @NonNull final String clientCode,
                @NonNull final String classCode,
                @NonNull final String secCode,
                @NonNull final String price) {

            this.firmId = firmId;
            this.clientCode = clientCode;
            this.classCode = classCode;
            this.secCode = secCode;
            this.price = price;
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
        public String getClassCode() {
            return classCode;
        }

        @JsonIgnore
        public String getSecCode() {
            return secCode;
        }

        @JsonIgnore
        public String getPrice() {
            return price;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(FIRM_ID, firmId)
                    .add(CLIENT_CODE, clientCode)
                    .add(CLASS_CODE, classCode)
                    .add(SEC_CODE, secCode)
                    .add(PRICE, price)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetBuySellInfo> {

        private static final String BUY_SELL_INFO = "buy_sell_info";

        BuySellInfo buySellInfo;

        @JsonCreator
        public Result(@JsonProperty(value = BUY_SELL_INFO, required = true) @NonNull final BuySellInfo buySellInfo) {
            this.buySellInfo = buySellInfo;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(BUY_SELL_INFO, buySellInfo)
                    .toString();
        }
    }

    @Value
    public static class BuySellInfo {

        private static final String IS_MARGIN_SEC = "is_margin_sec";
        private static final String IS_ASSET_SEC = "is_asset_sec";
        private static final String BALANCE = "balance";
        private static final String CAN_BUY = "can_buy";
        private static final String CAN_SELL = "can_sell";
        private static final String POSITION_VALUATION = "position_valuation";
        private static final String VALUE = "value";
        private static final String OPEN_VALUE = "open_value";
        private static final String LIM_LONG = "lim_long";
        private static final String LONG_COEF = "long_coef";
        private static final String LIM_SHORT = "lim_short";
        private static final String SHORT_COEF = "short_coef";
        private static final String VALUE_COEF = "value_coef";
        private static final String OPEN_VALUE_COEF = "open_value_coef";
        private static final String SHARE = "share";
        private static final String SHORT_WA_PRICE = "short_wa_price";
        private static final String LONG_WA_PRICE = "long_wa_price";
        private static final String PROFIT_LOSS = "profit_loss";
        private static final String SPREAD_HC = "spread_hc";
        private static final String CAN_BUY_OWN = "can_buy_own";
        private static final String CAN_SELL_OWN = "can_sell_own";

        String isMarginSec;
        String isAssetSec;
        String balance;
        String canBuy;
        String canSell;
        String positionValuation;
        String value;
        String openValue;
        String limLong;
        String longCoef;
        String limShort;
        String shortCoef;
        String valueCoef;
        String openValueCoef;
        String share;
        String shortWaPrice;
        String longWaPrice;
        String profitLoss;
        String spreadHc;
        String canBuyOwn;
        String canSellOwn;

        @Getter(AccessLevel.NONE)
        @NonFinal
        private transient int hashCode;

        @Getter(AccessLevel.NONE)
        @NonFinal
        private transient String asString;

        @JsonCreator
        @Builder
        private BuySellInfo(
                @JsonProperty(IS_MARGIN_SEC) final String isMarginSec,
                @JsonProperty(IS_ASSET_SEC) final String isAssetSec,
                @JsonProperty(BALANCE) final String balance,
                @JsonProperty(CAN_BUY) final String canBuy,
                @JsonProperty(CAN_SELL) final String canSell,
                @JsonProperty(POSITION_VALUATION) final String positionValuation,
                @JsonProperty(VALUE) final String value,
                @JsonProperty(OPEN_VALUE) final String openValue,
                @JsonProperty(LIM_LONG) final String limLong,
                @JsonProperty(LONG_COEF) final String longCoef,
                @JsonProperty(LIM_SHORT) final String limShort,
                @JsonProperty(SHORT_COEF) final String shortCoef,
                @JsonProperty(VALUE_COEF) final String valueCoef,
                @JsonProperty(OPEN_VALUE_COEF) final String openValueCoef,
                @JsonProperty(SHARE) final String share,
                @JsonProperty(SHORT_WA_PRICE) final String shortWaPrice,
                @JsonProperty(LONG_WA_PRICE) final String longWaPrice,
                @JsonProperty(PROFIT_LOSS) final String profitLoss,
                @JsonProperty(SPREAD_HC) final String spreadHc,
                @JsonProperty(CAN_BUY_OWN) final String canBuyOwn,
                @JsonProperty(CAN_SELL_OWN) final String canSellOwn) {

            this.isMarginSec = isMarginSec;
            this.isAssetSec = isAssetSec;
            this.balance = balance;
            this.canBuy = canBuy;
            this.canSell = canSell;
            this.positionValuation = positionValuation;
            this.value = value;
            this.openValue = openValue;
            this.limLong = limLong;
            this.longCoef = longCoef;
            this.limShort = limShort;
            this.shortCoef = shortCoef;
            this.valueCoef = valueCoef;
            this.openValueCoef = openValueCoef;
            this.share = share;
            this.shortWaPrice = shortWaPrice;
            this.longWaPrice = longWaPrice;
            this.profitLoss = profitLoss;
            this.spreadHc = spreadHc;
            this.canBuyOwn = canBuyOwn;
            this.canSellOwn = canSellOwn;
        }

        @Override
        public boolean equals(final Object o) {

            if (o == this) {
                return true;
            } else if ( !(o instanceof BuySellInfo) ) {
                return false;
            } else {
                final BuySellInfo that = (BuySellInfo) o;
                return Objects.equals(isMarginSec, that.isMarginSec) &&
                        Objects.equals(isAssetSec, that.isAssetSec) &&
                        Objects.equals(balance, that.balance) &&
                        Objects.equals(canBuy, that.canBuy) &&
                        Objects.equals(canSell, that.canSell) &&
                        Objects.equals(positionValuation, that.positionValuation) &&
                        Objects.equals(value, that.value) &&
                        Objects.equals(openValue, that.openValue) &&
                        Objects.equals(limLong, that.limLong) &&
                        Objects.equals(longCoef, that.longCoef) &&
                        Objects.equals(limShort, that.limShort) &&
                        Objects.equals(shortCoef, that.shortCoef) &&
                        Objects.equals(valueCoef, that.valueCoef) &&
                        Objects.equals(openValueCoef, that.openValueCoef) &&
                        Objects.equals(share, that.share) &&
                        Objects.equals(shortWaPrice, that.shortWaPrice) &&
                        Objects.equals(longWaPrice, that.longWaPrice) &&
                        Objects.equals(profitLoss, that.profitLoss) &&
                        Objects.equals(spreadHc, that.spreadHc) &&
                        Objects.equals(canBuyOwn, that.canBuyOwn) &&
                        Objects.equals(canSellOwn, that.canSellOwn);
            }
        }

        @Override
        public int hashCode() {

            if (hashCode == 0) {
                hashCode = Objects.hash(
                        isMarginSec,
                        isAssetSec,
                        balance,
                        canBuy,
                        canSell,
                        positionValuation,
                        value,
                        openValue,
                        limLong,
                        longCoef,
                        limShort,
                        shortCoef,
                        valueCoef,
                        openValueCoef,
                        share,
                        shortWaPrice,
                        longWaPrice,
                        profitLoss,
                        spreadHc,
                        canBuyOwn,
                        canSellOwn
                );
            }

            return hashCode;
        }

        @NotNull
        @Override
        public String toString() {

            if (asString == null) {
                asString = MoreObjects.toStringHelper(this)
                        .add(IS_MARGIN_SEC, isMarginSec)
                        .add(IS_ASSET_SEC, isAssetSec)
                        .add(BALANCE, balance)
                        .add(CAN_BUY, canBuy)
                        .add(CAN_SELL, canSell)
                        .add(POSITION_VALUATION, positionValuation)
                        .add(VALUE, value)
                        .add(OPEN_VALUE, openValue)
                        .add(LIM_LONG, limLong)
                        .add(LONG_COEF, longCoef)
                        .add(LIM_SHORT, limShort)
                        .add(SHORT_COEF, shortCoef)
                        .add(VALUE_COEF, valueCoef)
                        .add(OPEN_VALUE_COEF, openValueCoef)
                        .add(SHARE, share)
                        .add(SHORT_WA_PRICE, shortWaPrice)
                        .add(LONG_WA_PRICE, longWaPrice)
                        .add(PROFIT_LOSS, profitLoss)
                        .add(SPREAD_HC, spreadHc)
                        .add(CAN_BUY_OWN, canBuyOwn)
                        .add(CAN_SELL_OWN, canSellOwn)
                        .toString();
            }

            return asString;
        }
    }
}
