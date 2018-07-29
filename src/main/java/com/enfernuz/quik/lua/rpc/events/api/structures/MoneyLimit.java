package com.enfernuz.quik.lua.rpc.events.api.structures;

import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class MoneyLimit {

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

    private @NonFinal @Getter(AccessLevel.NONE) transient int hashCode;
    private @NonFinal @Getter(AccessLevel.NONE) transient String asString;

    @Builder
    private MoneyLimit(
            final String currCode,
            final String tag,
            final String firmId,
            final String clientCode,
            final String openBal,
            final String openLimit,
            final String currentBal,
            final String currentLimit,
            final String locked,
            final String lockedValueCoef,
            final String lockedMarginValue,
            final String leverage,
            final int limitKind) {

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
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof MoneyLimit) ) {
            return false;
        } else {
            final MoneyLimit other = (MoneyLimit) o;
            return Integer.compare(limitKind, other.limitKind) == 0 &&
                    Objects.equals(currCode, other.currCode) &&
                    Objects.equals(tag, other.tag) &&
                    Objects.equals(firmId, other.firmId) &&
                    Objects.equals(clientCode, other.clientCode) &&
                    Objects.equals(openBal, other.openBal) &&
                    Objects.equals(openLimit, other.openLimit) &&
                    Objects.equals(currentBal, other.currentBal) &&
                    Objects.equals(currentLimit, other.currentLimit) &&
                    Objects.equals(locked, other.locked) &&
                    Objects.equals(lockedValueCoef, other.lockedValueCoef) &&
                    Objects.equals(lockedMarginValue, other.lockedMarginValue) &&
                    Objects.equals(leverage, other.leverage);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(
                    currCode,
                    tag,
                    firmId,
                    clientCode,
                    openBal,
                    openLimit,
                    currentBal,
                    currentLimit,
                    locked,
                    lockedValueCoef,
                    lockedMarginValue,
                    leverage,
                    limitKind
            );
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("currcode", currCode)
                    .add("tag", tag)
                    .add("firmid", firmId)
                    .add("client_code", clientCode)
                    .add("openbal", openBal)
                    .add("openlimit", openLimit)
                    .add("currentbal", currentBal)
                    .add("currentlimit", currentLimit)
                    .add("locked", locked)
                    .add("locked_value_coef", lockedValueCoef)
                    .add("locked_margin_value", lockedMarginValue)
                    .add("leverage", leverage)
                    .add("limit_kind", limitKind)
                    .toString();
        }

        return asString;
    }
}
