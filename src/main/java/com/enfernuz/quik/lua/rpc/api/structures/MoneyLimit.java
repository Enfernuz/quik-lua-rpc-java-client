package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

@Value
public class MoneyLimit {

    private static final String CURR_CODE = "currcode";
    private static final String TAG = "tag";
    private static final String FIRM_ID = "firmid";
    private static final String CLIENT_CODE = "client_code";
    private static final String OPEN_BAL = "openbal";
    private static final String OPEN_LIMIT = "openlimit";
    private static final String CURRENT_BAL = "currentbal";
    private static final String CURRENT_LIMIT = "currentlimit";
    private static final String LOCKED = "locked";
    private static final String LOCKED_VALUE_COEF = "locked_value_coef";
    private static final String LOCKED_MARGIN_VALUE = "locked_margin_value";
    private static final String LEVERAGE = "leverage";
    private static final String LIMIT_KIND = "limit_kind";
    private static final String WEIGHED_AVERAGE_POSITION_PRICE = "wa_position_price";
    private static final String ORDERS_COLLATERAL = "orders_collateral";
    private static final String POSITIONS_COLLATERAL = "positions_collateral";

    String currCode;
    String tag;
    String firmId;
    String clientCode;
    String openBal;
    String openLimit;
    String currentBal;
    String currentLimit;
    String locked;
    String lockedValueCoef;
    String lockedMarginValue;
    String leverage;
    int limitKind;
    String waPositionPrice;
    String ordersCollateral;
    String positionsCollateral;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient String asString;

    @JsonCreator
    @Builder
    private MoneyLimit(
            @JsonProperty(value = CURR_CODE, required = true) @NonNull final String currCode,
            @JsonProperty(value = TAG, required = true) @NonNull final String tag,
            @JsonProperty(value = FIRM_ID, required = true) @NonNull final String firmId,
            @JsonProperty(value = CLIENT_CODE, required = true) @NonNull final String clientCode,
            @JsonProperty(OPEN_BAL) final String openBal,
            @JsonProperty(OPEN_LIMIT) final String openLimit,
            @JsonProperty(CURRENT_BAL) final String currentBal,
            @JsonProperty(CURRENT_LIMIT) final String currentLimit,
            @JsonProperty(LOCKED) final String locked,
            @JsonProperty(LOCKED_VALUE_COEF) final String lockedValueCoef,
            @JsonProperty(LOCKED_MARGIN_VALUE) final String lockedMarginValue,
            @JsonProperty(LEVERAGE) final String leverage,
            @JsonProperty(value = LIMIT_KIND, required = true) final int limitKind,
            @JsonProperty(WEIGHED_AVERAGE_POSITION_PRICE) final String waPositionPrice,
            @JsonProperty(ORDERS_COLLATERAL) final String ordersCollateral,
            @JsonProperty(POSITIONS_COLLATERAL) final String positionsCollateral) {

        this.currCode = currCode;
        this.tag = tag;
        this.firmId = firmId;
        this.clientCode = clientCode;
        this.openBal = openBal;
        this.openLimit = openLimit;
        this.currentBal = currentBal;
        this.currentLimit = currentLimit;
        this.locked = locked;
        this.lockedValueCoef = lockedValueCoef;
        this.lockedMarginValue = lockedMarginValue;
        this.leverage = leverage;
        this.limitKind = limitKind;
        this.waPositionPrice = waPositionPrice;
        this.ordersCollateral = ordersCollateral;
        this.positionsCollateral = positionsCollateral;
    }

    @NotNull
    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add(CURR_CODE, currCode)
                    .add(TAG, tag)
                    .add(FIRM_ID, firmId)
                    .add(CLIENT_CODE, clientCode)
                    .add(OPEN_BAL, openBal)
                    .add(OPEN_LIMIT, openLimit)
                    .add(CURRENT_BAL, currentBal)
                    .add(CURRENT_LIMIT, currentLimit)
                    .add(LOCKED, locked)
                    .add(LOCKED_VALUE_COEF, lockedValueCoef)
                    .add(LOCKED_MARGIN_VALUE, lockedMarginValue)
                    .add(LEVERAGE, leverage)
                    .add(LIMIT_KIND, limitKind)
                    .add(WEIGHED_AVERAGE_POSITION_PRICE, waPositionPrice)
                    .add(ORDERS_COLLATERAL, ordersCollateral)
                    .add(POSITIONS_COLLATERAL, positionsCollateral)
                    .toString();
        }

        return asString;
    }
}
