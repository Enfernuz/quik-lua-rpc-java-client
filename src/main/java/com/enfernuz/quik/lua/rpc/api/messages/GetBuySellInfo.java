package com.enfernuz.quik.lua.rpc.api.messages;

import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;

import java.util.Objects;

public final class GetBuySellInfo {

    private GetBuySellInfo() {}

    @Value
    public static class Request {

        String firmId;
        String clientCode;
        String classCode;
        String secCode;
        String price;

        @Builder
        private Request(
                final @NonNull String firmId,
                final @NonNull String clientCode,
                final @NonNull String classCode,
                final @NonNull String secCode,
                final @NonNull String price) {

            this.firmId = firmId;
            this.clientCode = clientCode;
            this.classCode = classCode;
            this.secCode = secCode;
            this.price = price;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("firm_id", firmId)
                    .add("client_code", clientCode)
                    .add("class_code", classCode)
                    .add("sec_code", secCode)
                    .add("price", price)
                    .toString();
        }
    }

    @Value
    public static class Result {

        @NonNull BuySellInfo buySellInfo;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("buy_sell_info", buySellInfo)
                    .toString();
        }
    }

    @Value
    public static class BuySellInfo {

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

        private @NonFinal @Getter(AccessLevel.NONE) transient int hashCode;
        private @NonFinal @Getter(AccessLevel.NONE) transient String asString;

        @Builder
        private BuySellInfo(
                final String isMarginSec,
                final String isAssetSec,
                final String balance,
                final String canBuy,
                final String canSell,
                final String positionValuation,
                final String value,
                final String openValue,
                final String limLong,
                final String longCoef,
                final String limShort,
                final String shortCoef,
                final String valueCoef,
                final String openValueCoef,
                final String share,
                final String shortWaPrice,
                final String longWaPrice,
                final String profitLoss,
                final String spreadHc,
                final String canBuyOwn,
                final String canSellOwn) {

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

        @Override
        public String toString() {

            if (asString == null) {
                asString = MoreObjects.toStringHelper(this)
                        .add("is_margin_sec", isMarginSec)
                        .add("is_asset_sec", isAssetSec)
                        .add("balance", balance)
                        .add("can_buy", canBuy)
                        .add("can_sell", canSell)
                        .add("position_valuation", positionValuation)
                        .add("value", value)
                        .add("open_value", openValue)
                        .add("lim_long", limLong)
                        .add("long_coef", longCoef)
                        .add("lim_short", limShort)
                        .add("short_coef", shortCoef)
                        .add("value_coef", valueCoef)
                        .add("open_value_coef", openValueCoef)
                        .add("share", share)
                        .add("short_wa_price", shortWaPrice)
                        .add("long_wa_price", longWaPrice)
                        .add("profit_loss", profitLoss)
                        .add("spread_hc", spreadHc)
                        .add("can_buy_own", canBuyOwn)
                        .add("can_sell_own", canSellOwn)
                        .toString();
            }

            return asString;
        }
    }
}
