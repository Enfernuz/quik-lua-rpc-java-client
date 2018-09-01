package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class AllTrade {

    long tradeNum;
    int flags;
    @NonNull String price;
    int qty;
    String value;
    String accruedInt;
    String yield;
    String settleCode;
    String repoRate;
    String repoValue;
    String repo2Value;
    String repoTerm;
    String secCode;
    String classCode;
    @NonNull DateTimeEntry datetime;
    int period;
    String openInterest;
    String exchangeCode;

    private @NonFinal @Getter(AccessLevel.NONE) transient int hashCode;
    private @NonFinal @Getter(AccessLevel.NONE) transient String asString;

    @Builder
    @JsonCreator
    private AllTrade(
            @JsonProperty(value = "trade_num", required = true) final long tradeNum,
            @JsonProperty(value = "flags", required = true) final int flags,
            @JsonProperty(value = "price", required = true) final String price,
            @JsonProperty(value = "qty", required = true) final int qty,
            @JsonProperty("value") final String value,
            @JsonProperty("accruedint") final String accruedInt,
            @JsonProperty("yield") final String yield,
            @JsonProperty("settlecode") final String settleCode,
            @JsonProperty("reporate") final String repoRate,
            @JsonProperty("repovalue") final String repoValue,
            @JsonProperty("repo2value") final String repo2Value,
            @JsonProperty("repoterm") final String repoTerm,
            @JsonProperty("sec_code") final String secCode,
            @JsonProperty("class_code") final String classCode,
            @JsonProperty(value = "datetime", required = true) final DateTimeEntry datetime,
            @JsonProperty(value = "period", required = true) final int period,
            @JsonProperty("open_interest") final String openInterest,
            @JsonProperty("exchange_code") final String exchangeCode) {

        this.tradeNum = tradeNum;
        this.flags = flags;
        this.price = price;
        this.qty = qty;
        this.value = value;
        this.accruedInt = accruedInt;
        this.yield = yield;
        this.settleCode = settleCode;
        this.repoRate = repoRate;
        this.repoValue = repoValue;
        this.repo2Value = repo2Value;
        this.repoTerm = repoTerm;
        this.secCode = secCode;
        this.classCode = classCode;
        this.datetime = datetime;
        this.period = period;
        this.openInterest = openInterest;
        this.exchangeCode = exchangeCode;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof AllTrade) ) {
            return false;
        } else {
            final AllTrade allTrade = (AllTrade) o;
            return tradeNum == allTrade.tradeNum &&
                    flags == allTrade.flags &&
                    qty == allTrade.qty &&
                    period == allTrade.period &&
                    Objects.equals(price, allTrade.price) &&
                    Objects.equals(value, allTrade.value) &&
                    Objects.equals(accruedInt, allTrade.accruedInt) &&
                    Objects.equals(yield, allTrade.yield) &&
                    Objects.equals(settleCode, allTrade.settleCode) &&
                    Objects.equals(repoRate, allTrade.repoRate) &&
                    Objects.equals(repoValue, allTrade.repoValue) &&
                    Objects.equals(repo2Value, allTrade.repo2Value) &&
                    Objects.equals(repoTerm, allTrade.repoTerm) &&
                    Objects.equals(secCode, allTrade.secCode) &&
                    Objects.equals(classCode, allTrade.classCode) &&
                    Objects.equals(datetime, allTrade.datetime) &&
                    Objects.equals(openInterest, allTrade.openInterest) &&
                    Objects.equals(exchangeCode, allTrade.exchangeCode);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode =
                    Objects.hash(
                            tradeNum,
                            flags,
                            price,
                            qty,
                            value,
                            accruedInt,
                            yield,
                            settleCode,
                            repoRate,
                            repoValue,
                            repo2Value,
                            repoTerm,
                            secCode,
                            classCode,
                            datetime,
                            period,
                            openInterest,
                            exchangeCode
                    );
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("trade_num", tradeNum)
                    .add("flags", flags)
                    .add("price", price)
                    .add("qty", qty)
                    .add("value", value)
                    .add("accruedint", accruedInt)
                    .add("yield", yield)
                    .add("settlecode", settleCode)
                    .add("reporate", repoRate)
                    .add("repovalue", repoValue)
                    .add("repo2value", repo2Value)
                    .add("repoterm", repoTerm)
                    .add("sec_code", secCode)
                    .add("class_code", classCode)
                    .add("datetime", datetime)
                    .add("period", period)
                    .add("open_interest", openInterest)
                    .add("exchange_code", exchangeCode)
                    .toString();
        }

        return asString;
    }
}
