package com.enfernuz.quik.lua.rpc.api.structures;

import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class Depo {

    String depoLimitLockedBuyValue;
    String depoCurrentBalance;
    String depoLimitLockedBuy;
    String depoLimitLocked;
    String depoLimitAvailable;
    String depoCurrentLimit;
    String depoOpenBalance;
    String depoOpenLimit;

    @Getter(AccessLevel.NONE)
    private @NonFinal transient int hashCode;

    @Getter(AccessLevel.NONE)
    private @NonFinal transient String asString;

    @Builder
    private Depo(
            final String depoLimitLockedBuyValue,
            final String depoCurrentBalance,
            final String depoLimitLockedBuy,
            final String depoLimitLocked,
            final String depoLimitAvailable,
            final String depoCurrentLimit,
            final String depoOpenBalance,
            final String depoOpenLimit) {

        this.depoLimitLockedBuyValue = depoLimitLockedBuyValue;
        this.depoCurrentBalance = depoCurrentBalance;
        this.depoLimitLockedBuy = depoLimitLockedBuy;
        this.depoLimitLocked = depoLimitLocked;
        this.depoLimitAvailable = depoLimitAvailable;
        this.depoCurrentLimit = depoCurrentLimit;
        this.depoOpenBalance = depoOpenBalance;
        this.depoOpenLimit = depoOpenLimit;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof Depo) ) {
            return false;
        } else {
            final Depo depo = (Depo) o;
            return Objects.equals(depoLimitLockedBuyValue, depo.depoLimitLockedBuyValue) &&
                    Objects.equals(depoCurrentBalance, depo.depoCurrentBalance) &&
                    Objects.equals(depoLimitLockedBuy, depo.depoLimitLockedBuy) &&
                    Objects.equals(depoLimitLocked, depo.depoLimitLocked) &&
                    Objects.equals(depoLimitAvailable, depo.depoLimitAvailable) &&
                    Objects.equals(depoCurrentLimit, depo.depoCurrentLimit) &&
                    Objects.equals(depoOpenBalance, depo.depoOpenBalance) &&
                    Objects.equals(depoOpenLimit, depo.depoOpenLimit);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(
                    depoLimitLockedBuyValue,
                    depoCurrentBalance,
                    depoLimitLockedBuy,
                    depoLimitLocked,
                    depoLimitAvailable,
                    depoCurrentLimit,
                    depoOpenBalance,
                    depoOpenLimit
            );
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("depo_limit_locked_buy_value", depoLimitLockedBuyValue)
                    .add("depo_current_balance", depoCurrentBalance)
                    .add("depo_limit_locked_buy", depoLimitLockedBuy)
                    .add("depo_limit_locked", depoLimitLocked)
                    .add("depo_limit_available", depoLimitAvailable)
                    .add("depo_current_limit", depoCurrentLimit)
                    .add("depo_open_balance", depoOpenBalance)
                    .add("depo_open_limit", depoOpenLimit)
                    .toString();
        }

        return asString;
    }
}
