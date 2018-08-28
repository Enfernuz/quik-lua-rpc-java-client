package com.enfernuz.quik.lua.rpc.api.messages.datasource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

public final class T {

    private T() {}

    @Value
    public static class Request {

        @NonNull String datasourceUUID;
        int candleIndex;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("datasource_uuid", datasourceUUID)
                    .add("candle_index", candleIndex)
                    .toString();
        }
    }

    @Value
    public static class Result {

        int year;
        int month;
        int day;
        int weekDay;
        int hour;
        int min;
        int sec;
        int ms;
        int count;

        @Builder
        @JsonCreator
        private Result(final @JsonProperty(value = "year", required = true) int year,
                       final @JsonProperty(value = "month", required = true) int month,
                       final @JsonProperty(value = "day", required = true) int day,
                       final @JsonProperty(value = "week_day", required = true) int weekDay,
                       final @JsonProperty(value = "hour", required = true) int hour,
                       final @JsonProperty(value = "min", required = true) int min,
                       final @JsonProperty(value = "sec", required = true) int sec,
                       final @JsonProperty(value = "ms", required = true) int ms,
                       final @JsonProperty(value = "count", required = true) int count) {

            this.year = year;
            this.month = month;
            this.day = day;
            this.weekDay = weekDay;
            this.hour = hour;
            this.min = min;
            this.sec = sec;
            this.ms = ms;
            this.count = count;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("year", year)
                    .add("month", month)
                    .add("day", day)
                    .add("week_day", weekDay)
                    .add("hour", hour)
                    .add("min", min)
                    .add("sec", sec)
                    .add("ms", ms)
                    .add("count", count)
                    .toString();
        }
    }
}
