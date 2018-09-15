package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class PortfolioInfo {

    @JsonProperty("is_leverage") String isLeverage;
    @JsonProperty("in_assets") String inAssets;
    @JsonProperty("leverage") String leverage;
    @JsonProperty("open_limit") String openLimit;
    @JsonProperty("val_short") String valShort;
    @JsonProperty("val_long") String valLong;
    @JsonProperty("val_long_margin") String valLongMargin;
    @JsonProperty("val_long_asset") String valLongAsset;
    @JsonProperty("assets") String assets;
    @JsonProperty("cur_leverage") String curLeverage;
    @JsonProperty("margin") String margin;
    @JsonProperty("lim_all") String limAll;
    @JsonProperty("av_lim_all") String avLimAll;
    @JsonProperty("locked_buy") String lockedBuy;
    @JsonProperty("locked_buy_margin") String lockedBuyMargin;
    @JsonProperty("locked_buy_asset") String lockedBuyAsset;
    @JsonProperty("locked_sell") String lockedSell;
    @JsonProperty("locked_value_coef") String lockedValueCoef;
    @JsonProperty("in_all_assets") String inAllAssets;
    @JsonProperty("all_assets") String allAssets;
    @JsonProperty("profit_loss") String profitLoss;
    @JsonProperty("rate_change") String rateChange;
    @JsonProperty("lim_buy") String limBuy;
    @JsonProperty("lim_sell") String limSell;
    @JsonProperty("lim_non_margin") String limNonMargin;
    @JsonProperty("lim_buy_asset") String limBuyAsset;
    @JsonProperty("val_short_net") String valShortNet;
    @JsonProperty("val_long_net") String valLongNet;
    @JsonProperty("total_money_bal") String totalMoneyBal;
    @JsonProperty("total_locked_money") String totalLockedMoney;
    @JsonProperty("haircuts") String haircuts;
    @JsonProperty("assets_without_hc") String assetsWithoutHc;
    @JsonProperty("status_coef") String statusCoef;
    @JsonProperty("varmargin") String varMargin;
    @JsonProperty("go_for_positions") String goForPositions;
    @JsonProperty("go_for_orders") String goForOrders;
    @JsonProperty("rate_futures") String rateFutures;
    @JsonProperty("is_qual_client") String isQualClient;
    @JsonProperty("is_futures") String isFutures;
    @JsonProperty("curr_tag") String currTag;

    @Getter(AccessLevel.NONE)
    @JsonIgnore
    private @NonFinal transient int hashCode;

    @Getter(AccessLevel.NONE)
    @JsonIgnore
    private @NonFinal transient String asString;

    @Builder
    @JsonCreator
    private PortfolioInfo(
            final @JsonProperty("is_leverage") String isLeverage,
            final @JsonProperty("in_assets") String inAssets,
            final @JsonProperty("leverage") String leverage,
            final @JsonProperty("open_limit") String openLimit,
            final @JsonProperty("val_short") String valShort,
            final @JsonProperty("val_long") String valLong,
            final @JsonProperty("val_long_margin") String valLongMargin,
            final @JsonProperty("val_long_asset") String valLongAsset,
            final @JsonProperty("assets") String assets,
            final @JsonProperty("cur_leverage") String curLeverage,
            final @JsonProperty("margin") String margin,
            final @JsonProperty("lim_all") String limAll,
            final @JsonProperty("av_lim_all") String avLimAll,
            final @JsonProperty("locked_buy") String lockedBuy,
            final @JsonProperty("locked_buy_margin") String lockedBuyMargin,
            final @JsonProperty("locked_buy_asset") String lockedBuyAsset,
            final @JsonProperty("locked_sell") String lockedSell,
            final @JsonProperty("locked_value_coef") String lockedValueCoef,
            final @JsonProperty("in_all_assets") String inAllAssets,
            final @JsonProperty("all_assets") String allAssets,
            final @JsonProperty("profit_loss") String profitLoss,
            final @JsonProperty("rate_change") String rateChange,
            final @JsonProperty("lim_buy") String limBuy,
            final @JsonProperty("lim_sell") String limSell,
            final @JsonProperty("lim_non_margin") String limNonMargin,
            final @JsonProperty("lim_buy_asset") String limBuyAsset,
            final @JsonProperty("val_short_net") String valShortNet,
            final @JsonProperty("val_long_net") String valLongNet,
            final @JsonProperty("total_money_bal") String totalMoneyBal,
            final @JsonProperty("total_locked_money") String totalLockedMoney,
            final @JsonProperty("haircuts") String haircuts,
            final @JsonProperty("assets_without_hc") String assetsWithoutHc,
            final @JsonProperty("status_coef") String statusCoef,
            final @JsonProperty("varmargin") String varMargin,
            final @JsonProperty("go_for_positions") String goForPositions,
            final @JsonProperty("go_for_orders") String goForOrders,
            final @JsonProperty("rate_futures") String rateFutures,
            final @JsonProperty("is_qual_client") String isQualClient,
            final @JsonProperty("is_futures") String isFutures,
            final @JsonProperty("curr_tag") String currTag) {

        this.isLeverage = isLeverage;
        this.inAssets = inAssets;
        this.leverage = leverage;
        this.openLimit = openLimit;
        this.valShort = valShort;
        this.valLong = valLong;
        this.valLongMargin = valLongMargin;
        this.valLongAsset = valLongAsset;
        this.assets = assets;
        this.curLeverage = curLeverage;
        this.margin = margin;
        this.limAll = limAll;
        this.avLimAll = avLimAll;
        this.lockedBuy = lockedBuy;
        this.lockedBuyMargin = lockedBuyMargin;
        this.lockedBuyAsset = lockedBuyAsset;
        this.lockedSell = lockedSell;
        this.lockedValueCoef = lockedValueCoef;
        this.inAllAssets = inAllAssets;
        this.allAssets = allAssets;
        this.profitLoss = profitLoss;
        this.rateChange = rateChange;
        this.limBuy = limBuy;
        this.limSell = limSell;
        this.limNonMargin = limNonMargin;
        this.limBuyAsset = limBuyAsset;
        this.valShortNet = valShortNet;
        this.valLongNet = valLongNet;
        this.totalMoneyBal = totalMoneyBal;
        this.totalLockedMoney = totalLockedMoney;
        this.haircuts = haircuts;
        this.assetsWithoutHc = assetsWithoutHc;
        this.statusCoef = statusCoef;
        this.varMargin = varMargin;
        this.goForPositions = goForPositions;
        this.goForOrders = goForOrders;
        this.rateFutures = rateFutures;
        this.isQualClient = isQualClient;
        this.isFutures = isFutures;
        this.currTag = currTag;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof PortfolioInfo) ) {
            return false;
        } else {
            final PortfolioInfo that = (PortfolioInfo) o;
            return Objects.equals(isLeverage, that.isLeverage) &&
                    Objects.equals(inAssets, that.inAssets) &&
                    Objects.equals(leverage, that.leverage) &&
                    Objects.equals(openLimit, that.openLimit) &&
                    Objects.equals(valShort, that.valShort) &&
                    Objects.equals(valLong, that.valLong) &&
                    Objects.equals(valLongMargin, that.valLongMargin) &&
                    Objects.equals(valLongAsset, that.valLongAsset) &&
                    Objects.equals(assets, that.assets) &&
                    Objects.equals(curLeverage, that.curLeverage) &&
                    Objects.equals(margin, that.margin) &&
                    Objects.equals(limAll, that.limAll) &&
                    Objects.equals(avLimAll, that.avLimAll) &&
                    Objects.equals(lockedBuy, that.lockedBuy) &&
                    Objects.equals(lockedBuyMargin, that.lockedBuyMargin) &&
                    Objects.equals(lockedBuyAsset, that.lockedBuyAsset) &&
                    Objects.equals(lockedSell, that.lockedSell) &&
                    Objects.equals(lockedValueCoef, that.lockedValueCoef) &&
                    Objects.equals(inAllAssets, that.inAllAssets) &&
                    Objects.equals(allAssets, that.allAssets) &&
                    Objects.equals(profitLoss, that.profitLoss) &&
                    Objects.equals(rateChange, that.rateChange) &&
                    Objects.equals(limBuy, that.limBuy) &&
                    Objects.equals(limSell, that.limSell) &&
                    Objects.equals(limNonMargin, that.limNonMargin) &&
                    Objects.equals(limBuyAsset, that.limBuyAsset) &&
                    Objects.equals(valShortNet, that.valShortNet) &&
                    Objects.equals(valLongNet, that.valLongNet) &&
                    Objects.equals(totalMoneyBal, that.totalMoneyBal) &&
                    Objects.equals(totalLockedMoney, that.totalLockedMoney) &&
                    Objects.equals(haircuts, that.haircuts) &&
                    Objects.equals(assetsWithoutHc, that.assetsWithoutHc) &&
                    Objects.equals(statusCoef, that.statusCoef) &&
                    Objects.equals(varMargin, that.varMargin) &&
                    Objects.equals(goForPositions, that.goForPositions) &&
                    Objects.equals(goForOrders, that.goForOrders) &&
                    Objects.equals(rateFutures, that.rateFutures) &&
                    Objects.equals(isQualClient, that.isQualClient) &&
                    Objects.equals(isFutures, that.isFutures) &&
                    Objects.equals(currTag, that.currTag);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(
                    isLeverage,
                    inAssets,
                    leverage,
                    openLimit,
                    valShort,
                    valLong,
                    valLongMargin,
                    valLongAsset,
                    assets,
                    curLeverage,
                    margin,
                    limAll,
                    avLimAll,
                    lockedBuy,
                    lockedBuyMargin,
                    lockedBuyAsset,
                    lockedSell,
                    lockedValueCoef,
                    inAllAssets,
                    allAssets,
                    profitLoss,
                    rateChange,
                    limBuy,
                    limSell,
                    limNonMargin,
                    limBuyAsset,
                    valShortNet,
                    valLongNet,
                    totalMoneyBal,
                    totalLockedMoney,
                    haircuts,
                    assetsWithoutHc,
                    statusCoef,
                    varMargin,
                    goForPositions,
                    goForOrders,
                    rateFutures,
                    isQualClient,
                    isFutures,
                    currTag
            );
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("is_leverage", isLeverage)
                    .add("in_assets", inAssets)
                    .add("leverage", leverage)
                    .add("open_limit", openLimit)
                    .add("val_short", valShort)
                    .add("val_long", valLong)
                    .add("val_long_margin", valLongMargin)
                    .add("val_long_asset", valLongAsset)
                    .add("assets", assets)
                    .add("cur_leverage", curLeverage)
                    .add("margin", margin)
                    .add("lim_all", limAll)
                    .add("av_lim_all", avLimAll)
                    .add("locked_buy", lockedBuy)
                    .add("locked_buy_margin", lockedBuyMargin)
                    .add("locked_buy_asset", lockedBuyAsset)
                    .add("locked_sell", lockedSell)
                    .add("locked_value_coef", lockedValueCoef)
                    .add("in_all_assets", inAllAssets)
                    .add("all_assets", allAssets)
                    .add("profit_loss", profitLoss)
                    .add("rate_change", rateChange)
                    .add("lim_buy", limBuy)
                    .add("lim_sell", limSell)
                    .add("lim_non_margin", limNonMargin)
                    .add("lim_buy_asset", limBuyAsset)
                    .add("val_short_net", valShortNet)
                    .add("val_long_net", valLongNet)
                    .add("total_money_bal", totalMoneyBal)
                    .add("total_locked_money", totalLockedMoney)
                    .add("haircuts", haircuts)
                    .add("assets_without_hc", assetsWithoutHc)
                    .add("status_coef", statusCoef)
                    .add("varmargin", varMargin)
                    .add("go_for_positions", goForPositions)
                    .add("go_for_orders", goForOrders)
                    .add("rate_futures", rateFutures)
                    .add("is_qual_client", isQualClient)
                    .add("is_futures", isFutures)
                    .add("curr_tag", currTag)
                    .toString();
        }

        return asString;
    }
}
