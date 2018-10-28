package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

@Value
public class DepoLimit {

    private static final String SECURITY_CODE = "sec_code";
    private static final String TRADING_ACCOUNT_ID = "trdaccid";
    private static final String FIRM_ID = "firmid";
    private static final String CLIENT_CODE = "client_code";
    private static final String OPEN_BALANCE = "openbal";
    private static final String OPEN_LIMIT = "openlimit";
    private static final String CURRENT_BALANCE = "currentbal";
    private static final String CURRENT_LIMIT = "currentlimit";
    private static final String LOCKED_SELL = "locked_sell";
    private static final String LOCKED_BUY = "locked_buy";
    private static final String LOCKED_BUY_VALUE = "locked_buy_value";
    private static final String LOCKED_SELL_VALUE = "locked_sell_value";
    private static final String WEIGHTED_AVERAGE_POSITION_PRICE = "wa_position_price";
    private static final String LIMIT_KIND = "limit_kind";

    String secCode;
    String trdAccId;
    String firmId;
    String clientCode;
    int openBal;
    int openLimit;
    int currentBal;
    int currentLimit;
    int lockedSell;
    int lockedBuy;
    String lockedBuyValue;
    String lockedSellValue;
    String waPositionPrice;
    int limitKind;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient String asString;

    @JsonCreator
    @Builder
    private DepoLimit(
            @JsonProperty(SECURITY_CODE) final String secCode,
            @JsonProperty(TRADING_ACCOUNT_ID) final String trdAccId,
            @JsonProperty(FIRM_ID) final String firmId,
            @JsonProperty(CLIENT_CODE) final String clientCode,
            @JsonProperty(OPEN_BALANCE) final int openBal,
            @JsonProperty(OPEN_LIMIT) final int openLimit,
            @JsonProperty(CURRENT_BALANCE) final int currentBal,
            @JsonProperty(CURRENT_LIMIT) final int currentLimit,
            @JsonProperty(LOCKED_SELL) final int lockedSell,
            @JsonProperty(LOCKED_BUY) final int lockedBuy,
            @JsonProperty(LOCKED_BUY_VALUE) final String lockedBuyValue,
            @JsonProperty(LOCKED_SELL_VALUE) final String lockedSellValue,
            @JsonProperty(WEIGHTED_AVERAGE_POSITION_PRICE) final String waPositionPrice,
            @JsonProperty(LIMIT_KIND) final int limitKind) {

        this.secCode = secCode;
        this.trdAccId = trdAccId;
        this.firmId = firmId;
        this.clientCode = clientCode;
        this.openBal = openBal;
        this.openLimit = openLimit;
        this.currentBal = currentBal;
        this.currentLimit = currentLimit;
        this.lockedSell = lockedSell;
        this.lockedBuy = lockedBuy;
        this.lockedBuyValue = lockedBuyValue;
        this.lockedSellValue = lockedSellValue;
        this.waPositionPrice = waPositionPrice;
        this.limitKind = limitKind;
    }

    @NotNull
    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add(SECURITY_CODE, secCode)
                    .add(TRADING_ACCOUNT_ID, trdAccId)
                    .add(FIRM_ID, firmId)
                    .add(CLIENT_CODE, clientCode)
                    .add(OPEN_BALANCE, openBal)
                    .add(OPEN_LIMIT, openLimit)
                    .add(CURRENT_BALANCE, currentBal)
                    .add(CURRENT_LIMIT, currentLimit)
                    .add(LOCKED_SELL, lockedSell)
                    .add(LOCKED_BUY, lockedBuy)
                    .add(LOCKED_BUY_VALUE, lockedBuyValue)
                    .add(LOCKED_SELL_VALUE, lockedSellValue)
                    .add(WEIGHTED_AVERAGE_POSITION_PRICE, waPositionPrice)
                    .add(LIMIT_KIND, limitKind)
                    .toString();
        }

        return asString;
    }
}
