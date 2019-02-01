package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.*;
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
            @JsonProperty(value = SECURITY_CODE, required = true) @NonNull final String secCode,
            @JsonProperty(value = TRADING_ACCOUNT_ID, required = true) @NonNull final String trdAccId,
            @JsonProperty(value = FIRM_ID, required = true) @NonNull final String firmId,
            @JsonProperty(value = CLIENT_CODE, required = true) @NonNull final String clientCode,
            @JsonProperty(value = OPEN_BALANCE, required = true) final int openBal,
            @JsonProperty(value = OPEN_LIMIT, required = true) final int openLimit,
            @JsonProperty(value = CURRENT_BALANCE, required = true) final int currentBal,
            @JsonProperty(value = CURRENT_LIMIT, required = true) final int currentLimit,
            @JsonProperty(value = LOCKED_SELL, required = true) final int lockedSell,
            @JsonProperty(value = LOCKED_BUY, required = true) final int lockedBuy,
            @JsonProperty(value = LOCKED_BUY_VALUE, required = true) @NonNull final String lockedBuyValue,
            @JsonProperty(value = LOCKED_SELL_VALUE, required = true) @NonNull final String lockedSellValue,
            @JsonProperty(value = WEIGHTED_AVERAGE_POSITION_PRICE, required = true) @NonNull final String waPositionPrice,
            @JsonProperty(value = LIMIT_KIND, required = true) final int limitKind) {

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
