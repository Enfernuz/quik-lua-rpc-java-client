package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class GetTradeDate {

    private GetTradeDate() {}

    @Value
    public static class TradeDate {

        private static final String DATE_FIELD = "date";
        private static final String YEAR_FIELD = "year";
        private static final String MONTH_FIELD = "month";
        private static final String DAY_FIELD = "day";

        String date;
        int year;
        int month;
        int day;

        private @NonFinal @Getter(AccessLevel.NONE) transient int hashCode;
        private @NonFinal @Getter(AccessLevel.NONE) transient String asString;

        @Builder
        @JsonCreator
        private TradeDate(
                @JsonProperty(value = DATE_FIELD, required = true) @NonNull final String date,
                @JsonProperty(value = YEAR_FIELD, required = true) final int year,
                @JsonProperty(value = MONTH_FIELD, required = true) final int month,
                @JsonProperty(value = DAY_FIELD, required = true) final int day) {

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
                        .add(DATE_FIELD, date)
                        .add(YEAR_FIELD, year)
                        .add(MONTH_FIELD, month)
                        .add(DAY_FIELD, day)
                        .toString();
            }

            return asString;
        }
    }

    public static enum Request { INSTANCE; }

    @Value
    public static class Result {

        private static final String TRADE_DATE_FIELD = "trade_date";

        TradeDate tradeDate;

        @JsonCreator
        public Result(@JsonProperty(value = TRADE_DATE_FIELD, required = true) @NonNull final TradeDate tradeDate) {
            this.tradeDate = tradeDate;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(TRADE_DATE_FIELD, tradeDate)
                    .toString();
        }
    }
}
