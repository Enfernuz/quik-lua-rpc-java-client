package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Value
public class Money {

    private static final String MONEY_OPEN_LIMIT = "money_open_limit";
    private static final String MONEY_LIMIT_LOCKED_NON_MARGINAL_VALUE = "money_limit_locked_nonmarginal_value";
    private static final String MONEY_LIMIT_LOCKED = "money_limit_locked";
    private static final String MONEY_OPEN_BALANCE = "money_open_balance";
    private static final String MONEY_CURRENT_LIMIT = "money_current_limit";
    private static final String MONEY_CURRENT_BALANCE = "money_current_balance";
    private static final String MONEY_LIMIT_AVAILABLE = "money_limit_available";

    String moneyOpenLimit;
    String moneyLimitLockedNonMarginalValue;
    String moneyLimitLocked;
    String moneyOpenBalance;
    String moneyCurrentLimit;
    String moneyCurrentBalance;
    String moneyLimitAvailable;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient int hashCode;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient String asString;

    @JsonCreator
    @Builder
    private Money(
            @JsonProperty(MONEY_OPEN_LIMIT) final String moneyOpenLimit,
            @JsonProperty(MONEY_LIMIT_LOCKED_NON_MARGINAL_VALUE) final String moneyLimitLockedNonMarginalValue,
            @JsonProperty(MONEY_LIMIT_LOCKED) final String moneyLimitLocked,
            @JsonProperty(MONEY_OPEN_BALANCE) final String moneyOpenBalance,
            @JsonProperty(MONEY_CURRENT_LIMIT) final String moneyCurrentLimit,
            @JsonProperty(MONEY_CURRENT_BALANCE) final String moneyCurrentBalance,
            @JsonProperty(MONEY_LIMIT_AVAILABLE) final String moneyLimitAvailable) {

        this.moneyOpenLimit = moneyOpenLimit;
        this.moneyLimitLockedNonMarginalValue = moneyLimitLockedNonMarginalValue;
        this.moneyLimitLocked = moneyLimitLocked;
        this.moneyOpenBalance = moneyOpenBalance;
        this.moneyCurrentLimit = moneyCurrentLimit;
        this.moneyCurrentBalance = moneyCurrentBalance;
        this.moneyLimitAvailable = moneyLimitAvailable;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof Money) ) {
            return false;
        } else {
            final Money money = (Money) o;
            return Objects.equals(moneyOpenLimit, money.moneyOpenLimit) &&
                    Objects.equals(moneyLimitLockedNonMarginalValue, money.moneyLimitLockedNonMarginalValue) &&
                    Objects.equals(moneyLimitLocked, money.moneyLimitLocked) &&
                    Objects.equals(moneyOpenBalance, money.moneyOpenBalance) &&
                    Objects.equals(moneyCurrentLimit, money.moneyCurrentLimit) &&
                    Objects.equals(moneyCurrentBalance, money.moneyCurrentBalance) &&
                    Objects.equals(moneyLimitAvailable, money.moneyLimitAvailable);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(
                    moneyOpenLimit,
                    moneyLimitLockedNonMarginalValue,
                    moneyLimitLocked,
                    moneyOpenBalance,
                    moneyCurrentLimit,
                    moneyCurrentBalance,
                    moneyLimitAvailable
            );
        }

        return hashCode;
    }

    @NotNull
    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add(MONEY_OPEN_LIMIT, moneyOpenLimit)
                    .add(MONEY_LIMIT_LOCKED_NON_MARGINAL_VALUE, moneyLimitLockedNonMarginalValue)
                    .add(MONEY_LIMIT_LOCKED, moneyLimitLocked)
                    .add(MONEY_OPEN_BALANCE, moneyOpenBalance)
                    .add(MONEY_CURRENT_LIMIT, moneyCurrentLimit)
                    .add(MONEY_CURRENT_BALANCE, moneyCurrentBalance)
                    .add(MONEY_LIMIT_AVAILABLE, moneyLimitAvailable)
                    .toString();
        }

        return asString;
    }
}
