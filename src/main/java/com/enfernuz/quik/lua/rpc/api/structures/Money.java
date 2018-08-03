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

import java.util.Objects;

@Value
public class Money {

    String moneyOpenLimit;
    String moneyLimitLockedNonMarginalValue;
    String moneyLimitLocked;
    String moneyOpenBalance;
    String moneyCurrentLimit;
    String moneyCurrentBalance;
    String moneyLimitAvailable;

    @Getter(AccessLevel.NONE)
    private @JsonIgnore @NonFinal transient int hashCode;

    @Getter(AccessLevel.NONE)
    private @JsonIgnore @NonFinal transient String asString;

    @Builder
    @JsonCreator
    private Money(
            final @JsonProperty("money_open_limit") String moneyOpenLimit,
            final @JsonProperty("money_limit_locked_nonmarginal_value") String moneyLimitLockedNonMarginalValue,
            final @JsonProperty("money_limit_locked") String moneyLimitLocked,
            final @JsonProperty("money_open_balance") String moneyOpenBalance,
            final @JsonProperty("money_current_limit") String moneyCurrentLimit,
            final @JsonProperty("money_current_balance") String moneyCurrentBalance,
            final @JsonProperty("money_limit_available") String moneyLimitAvailable) {

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

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("money_open_limit", moneyOpenLimit)
                    .add("money_limit_locked_nonmarginal_value", moneyLimitLockedNonMarginalValue)
                    .add("money_limit_locked", moneyLimitLocked)
                    .add("money_open_balance", moneyOpenBalance)
                    .add("money_current_limit", moneyCurrentLimit)
                    .add("money_current_balance", moneyCurrentBalance)
                    .add("money_limit_available", moneyLimitAvailable)
                    .toString();
        }

        return asString;
    }
}
