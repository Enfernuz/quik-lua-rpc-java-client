package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

@Value
public class AllTrade {

    private static final String TRADE_NUM = "trade_num";
    private static final String FLAGS = "flags";
    private static final String PRICE = "price";
    private static final String QUANTITY = "qty";
    private static final String VALUE = "value";
    private static final String ACCRUED_INTEREST = "accruedint";
    private static final String YIELD = "yield";
    private static final String SETTLE_CODE = "settlecode";
    private static final String REPO_RATE = "reporate";
    private static final String REPO_VALUE = "repovalue";
    private static final String REPO_2_VALUE = "repo2value";
    private static final String REPO_TERM = "repoterm";
    private static final String SECURITY_CODE = "sec_code";
    private static final String CLASS_CODE = "class_code";
    private static final String DATETIME = "datetime";
    private static final String PERIOD = "period";
    private static final String OPEN_INTEREST = "open_interest";
    private static final String EXCHANGE_CODE = "exchange_code";
    private static final String EXEC_MARKET = "exec_market";

    long tradeNum;
    Integer flags;
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
    String execMarket;

    @JsonCreator
    @Builder
    private AllTrade(
            @JsonProperty(value = TRADE_NUM, required = true) final long tradeNum,
            @JsonProperty(FLAGS) final Integer flags,
            @JsonProperty(value = PRICE, required = true) @NonNull final String price,
            @JsonProperty(value = QUANTITY, required = true) final int qty,
            @JsonProperty(VALUE) final String value,
            @JsonProperty(ACCRUED_INTEREST) final String accruedInt,
            @JsonProperty(YIELD) final String yield,
            @JsonProperty(SETTLE_CODE) final String settleCode,
            @JsonProperty(REPO_RATE) final String repoRate,
            @JsonProperty(REPO_VALUE) final String repoValue,
            @JsonProperty(REPO_2_VALUE) final String repo2Value,
            @JsonProperty(REPO_TERM) final String repoTerm,
            @JsonProperty(value = SECURITY_CODE, required = true) @NonNull final String secCode,
            @JsonProperty(value = CLASS_CODE, required = true) @NonNull final String classCode,
            @JsonProperty(value = DATETIME, required = true) @NonNull final DateTimeEntry datetime,
            @JsonProperty(value = PERIOD, required = true) final int period,
            @JsonProperty(OPEN_INTEREST) final String openInterest,
            @JsonProperty(EXCHANGE_CODE) final String exchangeCode,
            @JsonProperty(EXEC_MARKET) final String execMarket) {

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
        this.execMarket = execMarket;
    }

    @NotNull
    @Override
    public String toString() {

        return MoreObjects.toStringHelper(this)
                .add(TRADE_NUM, tradeNum)
                .add(FLAGS, flags)
                .add(PRICE, price)
                .add(QUANTITY, qty)
                .add(VALUE, value)
                .add(ACCRUED_INTEREST, accruedInt)
                .add(YIELD, yield)
                .add(SETTLE_CODE, settleCode)
                .add(REPO_RATE, repoRate)
                .add(REPO_VALUE, repoValue)
                .add(REPO_2_VALUE, repo2Value)
                .add(REPO_TERM, repoTerm)
                .add(SECURITY_CODE, secCode)
                .add(CLASS_CODE, classCode)
                .add(DATETIME, datetime)
                .add(PERIOD, period)
                .add(OPEN_INTEREST, openInterest)
                .add(EXCHANGE_CODE, exchangeCode)
                .add(EXEC_MARKET, execMarket)
                .toString();
    }
}
