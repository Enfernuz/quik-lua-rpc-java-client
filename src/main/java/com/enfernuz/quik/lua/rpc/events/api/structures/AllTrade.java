package com.enfernuz.quik.lua.rpc.events.api.structures;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class AllTrade {

    long tradeNum;
    int flags;
    String price;
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
    DateTimeEntry datetime;
    int period;
    String openInterest;
    String exchangeCode;

    private @NonFinal @Getter(AccessLevel.NONE) transient int hashCode;
    private @NonFinal @Getter(AccessLevel.NONE) transient String asString;

    @Builder
    private AllTrade(final long tradeNum,
                    final int flags,
                    final String price,
                    final int qty,
                    final String value,
                    final String accruedInt,
                    final String yield,
                    final String settleCode,
                    final String repoRate,
                    final String repoValue,
                    final String repo2Value,
                    final String repoTerm,
                    final String secCode,
                    final String classCode,
                    final DateTimeEntry datetime,
                    final int period,
                    final String openInterest,
                    final String exchangeCode) {

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
