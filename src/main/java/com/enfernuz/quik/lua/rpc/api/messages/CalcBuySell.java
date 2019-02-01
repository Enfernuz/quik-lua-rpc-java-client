package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import lombok.*;
import org.jetbrains.annotations.NotNull;

public final class CalcBuySell implements RemoteProcedure {

    private CalcBuySell() {}

    @JsonPropertyOrder({Args.CLASS_CODE, Args.SEC_CODE, Args.CLIENT_CODE, Args.ACCOUNT, Args.PRICE, Args.IS_BUY, Args.IS_MARKET})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<CalcBuySell> {

        private static final String CLASS_CODE = "class_code";
        private static final String SEC_CODE = "sec_code";
        private static final String CLIENT_CODE = "client_code";
        private static final String ACCOUNT = "account";
        private static final String PRICE = "price";
        private static final String IS_BUY = "is_buy";
        private static final String IS_MARKET = "is_market";

        @JsonProperty(CLASS_CODE)
        private final String classCode;

        @JsonProperty(SEC_CODE)
        private final String secCode;

        @JsonProperty(CLIENT_CODE)
        private final String clientCode;

        @JsonProperty(ACCOUNT)
        private final String account;

        @JsonProperty(PRICE)
        private final String price;

        @JsonProperty(IS_BUY)
        private final boolean isBuy;

        @JsonProperty(IS_MARKET)
        private final boolean isMarket;

        @Builder
        private Args(
                @NonNull final String classCode,
                @NonNull final String secCode,
                @NonNull final String clientCode,
                @NonNull final String account,
                @NonNull final String price,
                final boolean isBuy,
                final boolean isMarket) {

            this.classCode = classCode;
            this.secCode = secCode;
            this.clientCode = clientCode;
            this.account = account;
            this.price = price;
            this.isBuy = isBuy;
            this.isMarket = isMarket;
        }

        @JsonIgnore
        public String getClassCode() {
            return classCode;
        }

        @JsonIgnore
        public String getSecCode() {
            return secCode;
        }

        @JsonIgnore
        public String getClientCode() {
            return clientCode;
        }

        @JsonIgnore
        public String getAccount() {
            return account;
        }

        @JsonIgnore
        public String getPrice() {
            return price;
        }

        @JsonIgnore
        public boolean isBuy() {
            return isBuy;
        }

        @JsonIgnore
        public boolean isMarket() {
            return isMarket;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(CLASS_CODE, classCode)
                    .add(SEC_CODE, secCode)
                    .add(CLIENT_CODE, clientCode)
                    .add(ACCOUNT, account)
                    .add(PRICE, price)
                    .add(IS_BUY, isBuy)
                    .add(IS_MARKET, isMarket)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<CalcBuySell> {

        private static final String QTY = "qty";
        private static final String COMISSION = "comission";

        int qty;
        String comission;

        @JsonCreator
        public Result(
                @JsonProperty(value = QTY, required = true) final int qty,
                @JsonProperty(value = COMISSION, required = true) @NonNull final String comission) {

            this.qty = qty;
            this.comission = comission;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(QTY, qty)
                    .add(COMISSION, comission)
                    .toString();
        }
    }
}
