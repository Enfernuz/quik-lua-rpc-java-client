package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class PortfolioInfo {
    
    private static final String IS_LEVERAGE = "is_leverage";
    private static final String IN_ASSETS = "in_assets";
    private static final String LEVERAGE = "leverage";
    private static final String OPEN_LIMIT = "open_limit";
    private static final String VAL_SHORT = "val_short";
    private static final String VAL_LONG = "val_long";
    private static final String VAL_LONG_MARGIN = "val_long_margin";
    private static final String VAL_LONG_ASSET = "val_long_asset";
    private static final String ASSETS = "assets";
    private static final String CUR_LEVERAGE = "cur_leverage";
    private static final String MARGIN = "margin";
    private static final String LIM_ALL = "lim_all";
    private static final String AV_LIM_ALL = "av_lim_all";
    private static final String LOCKED_BUY = "locked_buy";
    private static final String LOCKED_BUY_MARGIN = "locked_buy_margin";
    private static final String LOCKED_BUY_ASSET = "locked_buy_asset";
    private static final String LOCKED_SELL = "locked_sell";
    private static final String LOCKED_VALUE_COEF = "locked_value_coef";
    private static final String IN_ALL_ASSETS = "in_all_assets";
    private static final String ALL_ASSETS = "all_assets";
    private static final String PROFIT_LOSS = "profit_loss";
    private static final String RATE_CHANGE = "rate_change";
    private static final String LIM_BUY = "lim_buy";
    private static final String LIM_SELL = "lim_sell";
    private static final String LIM_NON_MARGIN = "lim_non_margin";
    private static final String LIM_BUY_ASSET = "lim_buy_asset";
    private static final String VAL_SHORT_NET = "val_short_net";
    private static final String VAL_LONG_NET = "val_long_net";
    private static final String TOTAL_MONEY_BAL = "total_money_bal";
    private static final String TOTAL_LOCKED_MONEY = "total_locked_money";
    private static final String HAIRCUTS = "haircuts";
    private static final String ASSETS_WITHOUT_HC = "assets_without_hc";
    private static final String STATUS_COEF = "status_coef";
    private static final String VAR_MARGIN = "varmargin";
    private static final String GO_FOR_POSITIONS = "go_for_positions";
    private static final String GO_FOR_ORDERS = "go_for_orders";
    private static final String RATE_FUTURES = "rate_futures";
    private static final String IS_QUAL_CLIENT = "is_qual_client";
    private static final String IS_FUTURES = "is_futures";
    private static final String CURR_TAG = "curr_tag";
            
    String isLeverage;
    String inAssets;
    String leverage;
    String openLimit;
    String valShort;
    String valLong;
    String valLongMargin;
    String valLongAsset;
    String assets;
    String curLeverage;
    String margin;
    String limAll;
    String avLimAll;
    String lockedBuy;
    String lockedBuyMargin;
    String lockedBuyAsset;
    String lockedSell;
    String lockedValueCoef;
    String inAllAssets;
    String allAssets;
    String profitLoss;
    String rateChange;
    String limBuy;
    String limSell;
    String limNonMargin;
    String limBuyAsset;
    String valShortNet;
    String valLongNet;
    String totalMoneyBal;
    String totalLockedMoney;
    String haircuts;
    String assetsWithoutHc;
    String statusCoef;
    String varMargin;
    String goForPositions;
    String goForOrders;
    String rateFutures;
    String isQualClient;
    String isFutures;
    String currTag;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient int hashCode;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient String asString;

    @JsonCreator
    @Builder
    private PortfolioInfo(
            @JsonProperty(IS_LEVERAGE) final String isLeverage,
            @JsonProperty(IN_ASSETS) final String inAssets,
            @JsonProperty(LEVERAGE) final String leverage,
            @JsonProperty(OPEN_LIMIT) final String openLimit,
            @JsonProperty(VAL_SHORT) final String valShort,
            @JsonProperty(VAL_LONG) final String valLong,
            @JsonProperty(VAL_LONG_MARGIN) final String valLongMargin,
            @JsonProperty(VAL_LONG_ASSET) final String valLongAsset,
            @JsonProperty(ASSETS) final String assets,
            @JsonProperty(CUR_LEVERAGE) final String curLeverage,
            @JsonProperty(MARGIN) final String margin,
            @JsonProperty(LIM_ALL) final String limAll,
            @JsonProperty(AV_LIM_ALL) final String avLimAll,
            @JsonProperty(LOCKED_BUY) final String lockedBuy,
            @JsonProperty(LOCKED_BUY_MARGIN) final String lockedBuyMargin,
            @JsonProperty(LOCKED_BUY_ASSET) final String lockedBuyAsset,
            @JsonProperty(LOCKED_SELL) final String lockedSell,
            @JsonProperty(LOCKED_VALUE_COEF) final String lockedValueCoef,
            @JsonProperty(IN_ALL_ASSETS) final String inAllAssets,
            @JsonProperty(ALL_ASSETS) final String allAssets,
            @JsonProperty(PROFIT_LOSS) final String profitLoss,
            @JsonProperty(RATE_CHANGE) final String rateChange,
            @JsonProperty(LIM_BUY) final String limBuy,
            @JsonProperty(LIM_SELL) final String limSell,
            @JsonProperty(LIM_NON_MARGIN) final String limNonMargin,
            @JsonProperty(LIM_BUY_ASSET) final String limBuyAsset,
            @JsonProperty(VAL_SHORT_NET) final String valShortNet,
            @JsonProperty(VAL_LONG_NET) final String valLongNet,
            @JsonProperty(TOTAL_MONEY_BAL) final String totalMoneyBal,
            @JsonProperty(TOTAL_LOCKED_MONEY) final String totalLockedMoney,
            @JsonProperty(HAIRCUTS) final String haircuts,
            @JsonProperty(ASSETS_WITHOUT_HC) final String assetsWithoutHc,
            @JsonProperty(STATUS_COEF) final String statusCoef,
            @JsonProperty(VAR_MARGIN) final String varMargin,
            @JsonProperty(GO_FOR_POSITIONS) final String goForPositions,
            @JsonProperty(GO_FOR_ORDERS) final String goForOrders,
            @JsonProperty(RATE_FUTURES) final String rateFutures,
            @JsonProperty(IS_QUAL_CLIENT) final String isQualClient,
            @JsonProperty(IS_FUTURES) final String isFutures,
            @JsonProperty(CURR_TAG) final String currTag) {

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
                    .add(IS_LEVERAGE, isLeverage)
                    .add(IN_ASSETS, inAssets)
                    .add(LEVERAGE, leverage)
                    .add(OPEN_LIMIT, openLimit)
                    .add(VAL_SHORT, valShort)
                    .add(VAL_LONG, valLong)
                    .add(VAL_LONG_MARGIN, valLongMargin)
                    .add(VAL_LONG_ASSET, valLongAsset)
                    .add(ASSETS, assets)
                    .add(CUR_LEVERAGE, curLeverage)
                    .add(MARGIN, margin)
                    .add(LIM_ALL, limAll)
                    .add(AV_LIM_ALL, avLimAll)
                    .add(LOCKED_BUY, lockedBuy)
                    .add(LOCKED_BUY_MARGIN, lockedBuyMargin)
                    .add(LOCKED_BUY_ASSET, lockedBuyAsset)
                    .add(LOCKED_SELL, lockedSell)
                    .add(LOCKED_VALUE_COEF, lockedValueCoef)
                    .add(IN_ALL_ASSETS, inAllAssets)
                    .add(ALL_ASSETS, allAssets)
                    .add(PROFIT_LOSS, profitLoss)
                    .add(RATE_CHANGE, rateChange)
                    .add(LIM_BUY, limBuy)
                    .add(LIM_SELL, limSell)
                    .add(LIM_NON_MARGIN, limNonMargin)
                    .add(LIM_BUY_ASSET, limBuyAsset)
                    .add(VAL_SHORT_NET, valShortNet)
                    .add(VAL_LONG_NET, valLongNet)
                    .add(TOTAL_MONEY_BAL, totalMoneyBal)
                    .add(TOTAL_LOCKED_MONEY, totalLockedMoney)
                    .add(HAIRCUTS, haircuts)
                    .add(ASSETS_WITHOUT_HC, assetsWithoutHc)
                    .add(STATUS_COEF, statusCoef)
                    .add(VAR_MARGIN, varMargin)
                    .add(GO_FOR_POSITIONS, goForPositions)
                    .add(GO_FOR_ORDERS, goForOrders)
                    .add(RATE_FUTURES, rateFutures)
                    .add(IS_QUAL_CLIENT, isQualClient)
                    .add(IS_FUTURES, isFutures)
                    .add(CURR_TAG, currTag)
                    .toString();
        }

        return asString;
    }
}
