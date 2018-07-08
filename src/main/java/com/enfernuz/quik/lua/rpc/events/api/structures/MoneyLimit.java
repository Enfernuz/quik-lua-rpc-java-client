package com.enfernuz.quik.lua.rpc.events.api.structures;

import com.google.common.base.MoreObjects;

import java.util.Objects;

public class MoneyLimit {

    private final String currCode;
    private final String tag;
    private final String firmId;
    private final String clientCode;
    private final String openBal;
    private final String openLimit;
    private final String currentBal;
    private final String currentLimit;
    private final String locked;
    private final String lockedValueCoef;
    private final String lockedMarginValue;
    private final String leverage;
    private int limitKind;

    private transient int hashCode;
    private transient String asString;

    private MoneyLimit(
            String currCode,
            String tag,
            String firmId,
            String clientCode,
            String openBal,
            String openLimit,
            String currentBal,
            String currentLimit,
            String locked,
            String lockedValueCoef,
            String lockedMarginValue,
            String leverage,
            int limitKind) {

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

    public static Builder builder() {
        return new Builder();
    }

    public String getCurrCode() {
        return currCode;
    }

    public String getTag() {
        return tag;
    }

    public String getFirmId() {
        return firmId;
    }

    public String getClientCode() {
        return clientCode;
    }

    public String getOpenBal() {
        return openBal;
    }

    public String getOpenLimit() {
        return openLimit;
    }

    public String getCurrentBal() {
        return currentBal;
    }

    public String getCurrentLimit() {
        return currentLimit;
    }

    public String getLocked() {
        return locked;
    }

    public String getLockedValueCoef() {
        return lockedValueCoef;
    }

    public String getLockedMarginValue() {
        return lockedMarginValue;
    }

    public String getLeverage() {
        return leverage;
    }

    public int getLimitKind() {
        return limitKind;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoneyLimit that = (MoneyLimit) o;
        return Integer.compare(limitKind, that.limitKind) == 0 &&
                Objects.equals(currCode, that.currCode) &&
                Objects.equals(tag, that.tag) &&
                Objects.equals(firmId, that.firmId) &&
                Objects.equals(clientCode, that.clientCode) &&
                Objects.equals(openBal, that.openBal) &&
                Objects.equals(openLimit, that.openLimit) &&
                Objects.equals(currentBal, that.currentBal) &&
                Objects.equals(currentLimit, that.currentLimit) &&
                Objects.equals(locked, that.locked) &&
                Objects.equals(lockedValueCoef, that.lockedValueCoef) &&
                Objects.equals(lockedMarginValue, that.lockedMarginValue) &&
                Objects.equals(leverage, that.leverage);
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
                    .add("currCode", currCode)
                    .add("tag", tag)
                    .add("firmId", firmId)
                    .add("clientCode", clientCode)
                    .add("openBal", openBal)
                    .add("openLimit", openLimit)
                    .add("currentBal", currentBal)
                    .add("currentLimit", currentLimit)
                    .add("locked", locked)
                    .add("lockedValueCoef", lockedValueCoef)
                    .add("lockedMarginValue", lockedMarginValue)
                    .add("leverage", leverage)
                    .add("limitKind", limitKind)
                    .toString();
        }

        return asString;
    }

    public static class Builder {

        private String currCode;
        private String tag;
        private String firmId;
        private String clientCode;
        private String openBal;
        private String openLimit;
        private String currentBal;
        private String currentLimit;
        private String locked;
        private String lockedValueCoef;
        private String lockedMarginValue;
        private String leverage;
        private int limitKind;

        public Builder currCode(final String currCode) {
            this.currCode = currCode;
            return this;
        }

        public Builder tag(final String tag) {
            this.tag = tag;
            return this;
        }

        public Builder firmId(final String firmId) {
            this.firmId = firmId;
            return this;
        }

        public Builder clientCode(final String clientCode) {
            this.clientCode = clientCode;
            return this;
        }

        public Builder openBal(final String openBal) {
            this.openBal = openBal;
            return this;
        }

        public Builder openLimit(final String openLimit) {
            this.openLimit = openLimit;
            return this;
        }

        public Builder currentBal(final String currentBal) {
            this.currentBal = currentBal;
            return this;
        }

        public Builder currentLimit(final String currentLimit) {
            this.currentLimit = currentLimit;
            return this;
        }

        public Builder locked(final String locked) {
            this.locked = locked;
            return this;
        }

        public Builder lockedValueCoef(final String lockedValueCoef) {
            this.lockedValueCoef = lockedValueCoef;
            return this;
        }

        public Builder lockedMarginValue(final String lockedMarginValue) {
            this.lockedMarginValue = lockedMarginValue;
            return this;
        }

        public Builder leverage(final String leverage) {
            this.leverage = leverage;
            return this;
        }

        public Builder limitKind(final int limitKind) {
            this.limitKind = limitKind;
            return this;
        }

        public MoneyLimit build() {

            return new MoneyLimit(
                    this.currCode,
                    this.tag,
                    this.firmId,
                    this.clientCode,
                    this.openBal,
                    this.openLimit,
                    this.currentBal,
                    this.currentLimit,
                    this.locked,
                    this.lockedValueCoef,
                    this.lockedMarginValue,
                    this.leverage,
                    this.limitKind
            );
        }
    }

}
