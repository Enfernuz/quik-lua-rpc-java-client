package com.enfernuz.quik.lua.rpc.api.messages;

import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

public final class CalcBuySell {

    private CalcBuySell() {}

    @Value
    public static class Request {

        String classCode;
        String secCode;
        String clientCode;
        String account;
        String price;
        boolean isBuy;
        boolean isMarket;

        @Builder
        private Request(
                final @NonNull String classCode,
                final @NonNull String secCode,
                final @NonNull String clientCode,
                final @NonNull String account,
                final @NonNull String price,
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

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("class_code", classCode)
                    .add("sec_code", secCode)
                    .add("client_code", clientCode)
                    .add("account", account)
                    .add("price", price)
                    .add("is_buy", isBuy)
                    .add("is_market", isMarket)
                    .toString();
        }
    }

    @Value
    @RequiredArgsConstructor
    public static class Result {

        int qty;
        String comission;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("qty", qty)
                    .add("comission", comission)
                    .toString();
        }
    }
}
