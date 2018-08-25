package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;

import java.util.Objects;

public final class GetTradeDate {

    private GetTradeDate() {}

    @Value
    public static class TradeDate {

        @NonNull String date;
        int year;
        int month;
        int day;

        private @NonFinal @Getter(AccessLevel.NONE) transient int hashCode;
        private @NonFinal @Getter(AccessLevel.NONE) transient String asString;

        @Builder
        @JsonCreator
        private TradeDate(
                final @JsonProperty(value = "date", required = true) String date,
                final @JsonProperty(value = "year", required = true) int year,
                final @JsonProperty(value = "month", required = true) int month,
                final @JsonProperty(value = "day", required = true) int day) {

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
                        .add("date", date)
                        .add("year", year)
                        .add("month", month)
                        .add("day", day)
                        .toString();
            }

            return asString;
        }
    }

    public static enum Request { INSTANCE; }

    @Value
    public static class Result {

        @NonNull TradeDate tradeDate;

        @JsonCreator
        public Result(final @JsonProperty(value = "trade_date", required = true) TradeDate tradeDate) {
            this.tradeDate = tradeDate;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("trade_date", tradeDate)
                    .toString();
        }
    }
}
