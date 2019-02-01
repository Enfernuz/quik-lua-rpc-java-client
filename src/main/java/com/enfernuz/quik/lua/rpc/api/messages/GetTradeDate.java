package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class GetTradeDate implements RemoteProcedure {

    private GetTradeDate() {}

    @Value
    public static class Result implements RpcResult<GetTradeDate> {

        private static final String TRADE_DATE = "trade_date";

        TradeDate tradeDate;

        @JsonCreator
        public Result(@JsonProperty(value = TRADE_DATE, required = true) @NonNull final TradeDate tradeDate) {
            this.tradeDate = tradeDate;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(TRADE_DATE, tradeDate)
                    .toString();
        }
    }

    @Value
    public static class TradeDate {

        private static final String DATE = "date";
        private static final String YEAR = "year";
        private static final String MONTH = "month";
        private static final String DAY = "day";

        String date;
        int year;
        int month;
        int day;

        @Getter(AccessLevel.NONE)
        @NonFinal
        private transient int hashCode;

        @Getter(AccessLevel.NONE)
        @NonFinal
        private transient String asString;

        @JsonCreator
        @Builder
        private TradeDate(
                @JsonProperty(value = DATE, required = true) @NonNull final String date,
                @JsonProperty(value = YEAR, required = true) final int year,
                @JsonProperty(value = MONTH, required = true) final int month,
                @JsonProperty(value = DAY, required = true) final int day) {

            this.date = date;
            this.year = year;
            this.month = month;
            this.day = day;
        }

        @Override
        public boolean equals(final Object o) {

            if (o == this) {
                return true;
            } else if ( !(o instanceof TradeDate) ) {
                return false;
            } else {
                final TradeDate tradeDate = (TradeDate) o;
                return year == tradeDate.year &&
                        month == tradeDate.month &&
                        day == tradeDate.day &&
                        Objects.equals(date, tradeDate.date);
            }
        }

        @Override
        public int hashCode() {

            if (hashCode == 0) {
                hashCode = Objects.hash(date, year, month, day);
            }

            return hashCode;
        }

        @Override
        public String toString() {

            if (asString == null) {
                asString = MoreObjects.toStringHelper(this)
                        .add(DATE, date)
                        .add(YEAR, year)
                        .add(MONTH, month)
                        .add(DAY, day)
                        .toString();
            }

            return asString;
        }
    }
}
