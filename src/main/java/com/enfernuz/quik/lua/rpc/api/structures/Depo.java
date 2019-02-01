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
public class Depo {

    private static final String DEPO_LIMIT_LOCKED_BUY_VALUE = "depo_limit_locked_buy_value";
    private static final String DEPO_CURRENT_BALANCE = "depo_current_balance";
    private static final String DEPO_LIMIT_LOCKED_BUY = "depo_limit_locked_buy";
    private static final String DEPO_LIMIT_LOCKED = "depo_limit_locked";
    private static final String DEPO_LIMIT_AVAILABLE = "depo_limit_available";
    private static final String DEPO_CURRENT_LIMIT = "depo_current_limit";
    private static final String DEPO_OPEN_BALANCE = "depo_open_balance";
    private static final String DEPO_OPEN_LIMIT = "depo_open_limit";

    String depoLimitLockedBuyValue;
    String depoCurrentBalance;
    String depoLimitLockedBuy;
    String depoLimitLocked;
    String depoLimitAvailable;
    String depoCurrentLimit;
    String depoOpenBalance;
    String depoOpenLimit;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient String asString;

    @JsonCreator
    @Builder
    private Depo(
            @JsonProperty(DEPO_LIMIT_LOCKED_BUY_VALUE) final String depoLimitLockedBuyValue,
            @JsonProperty(DEPO_CURRENT_BALANCE) final String depoCurrentBalance,
            @JsonProperty(DEPO_LIMIT_LOCKED_BUY) final String depoLimitLockedBuy,
            @JsonProperty(DEPO_LIMIT_LOCKED) final String depoLimitLocked,
            @JsonProperty(DEPO_LIMIT_AVAILABLE) final String depoLimitAvailable,
            @JsonProperty(DEPO_CURRENT_LIMIT) final String depoCurrentLimit,
            @JsonProperty(DEPO_OPEN_BALANCE) final String depoOpenBalance,
            @JsonProperty(DEPO_OPEN_LIMIT) final String depoOpenLimit) {

        this.depoLimitLockedBuyValue = depoLimitLockedBuyValue;
        this.depoCurrentBalance = depoCurrentBalance;
        this.depoLimitLockedBuy = depoLimitLockedBuy;
        this.depoLimitLocked = depoLimitLocked;
        this.depoLimitAvailable = depoLimitAvailable;
        this.depoCurrentLimit = depoCurrentLimit;
        this.depoOpenBalance = depoOpenBalance;
        this.depoOpenLimit = depoOpenLimit;
    }

    @NotNull
    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add(DEPO_LIMIT_LOCKED_BUY_VALUE, depoLimitLockedBuyValue)
                    .add(DEPO_CURRENT_BALANCE, depoCurrentBalance)
                    .add(DEPO_LIMIT_LOCKED_BUY, depoLimitLockedBuy)
                    .add(DEPO_LIMIT_LOCKED, depoLimitLocked)
                    .add(DEPO_LIMIT_AVAILABLE, depoLimitAvailable)
                    .add(DEPO_CURRENT_LIMIT, depoCurrentLimit)
                    .add(DEPO_OPEN_BALANCE, depoOpenBalance)
                    .add(DEPO_OPEN_LIMIT, depoOpenLimit)
                    .toString();
        }

        return asString;
    }
}
