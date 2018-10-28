package com.enfernuz.quik.lua.rpc.api.messages.datasource;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class T implements RemoteProcedure {

    private T() {}

    @JsonPropertyOrder({Args.DATASOURCE_UUID, Args.CANDLE_INDEX})
    public static final class Args implements RpcArgs<T> {

        private static final String DATASOURCE_UUID = "datasource_uuid";
        private static final String CANDLE_INDEX = "candle_index";

        @JsonProperty(DATASOURCE_UUID)
        private final String datasourceUUID;

        @JsonProperty(CANDLE_INDEX)
        private final int candleIndex;

        @JsonIgnore
        @Getter(AccessLevel.NONE)
        @NonFinal
        private transient int hashCode;

        @JsonIgnore
        @Getter(AccessLevel.NONE)
        @NonFinal
        private transient String asString;

        public Args(@NonNull final String datasourceUUID, final int candleIndex) {
            this.datasourceUUID = datasourceUUID;
            this.candleIndex = candleIndex;
        }

        @JsonIgnore
        public String getDatasourceUUID() {
            return datasourceUUID;
        }

        @JsonIgnore
        public int getCandleIndex() {
            return candleIndex;
        }

        @Override
        public boolean equals(final Object o) {

            if (o == this) {
                return true;
            } else if (!(o instanceof Args)) {
                return false;
            } else {
                final Args request = (Args) o;
                return candleIndex == request.candleIndex &&
                        Objects.equals(datasourceUUID, request.datasourceUUID);
            }
        }

        @Override
        public int hashCode() {

            if (hashCode == 0) {
                hashCode = Objects.hash(datasourceUUID, candleIndex);
            }

            return hashCode;
        }

        @NotNull
        @Override
        public String toString() {

            if (asString == null) {
                asString = MoreObjects.toStringHelper(this)
                        .add(DATASOURCE_UUID, datasourceUUID)
                        .add(CANDLE_INDEX, candleIndex)
                        .toString();
            }

            return asString;
        }
    }

    @Value
    public static class Result implements RpcResult<T> {

        private static final String YEAR = "year";
        private static final String MONTH = "month";
        private static final String DAY = "day";
        private static final String WEEK_DAY = "week_day";
        private static final String HOUR = "hour";
        private static final String MIN = "min";
        private static final String SEC = "sec";
        private static final String MS = "ms";
        private static final String COUNT = "count";

        int year;
        int month;
        int day;
        int weekDay;
        int hour;
        int min;
        int sec;
        int ms;
        int count;

        @JsonCreator
        @Builder
        private Result(@JsonProperty(value = YEAR, required = true) final int year,
                       @JsonProperty(value = MONTH, required = true) final int month,
                       @JsonProperty(value = DAY, required = true) final int day,
                       @JsonProperty(value = WEEK_DAY, required = true) final int weekDay,
                       @JsonProperty(value = HOUR, required = true) final int hour,
                       @JsonProperty(value = MIN, required = true) final int min,
                       @JsonProperty(value = SEC, required = true) final int sec,
                       @JsonProperty(value = MS, required = true) final int ms,
                       @JsonProperty(value = COUNT, required = true) final int count) {

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

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(YEAR, year)
                    .add(MONTH, month)
                    .add(DAY, day)
                    .add(WEEK_DAY, weekDay)
                    .add(HOUR, hour)
                    .add(MIN, min)
                    .add(SEC, sec)
                    .add(MS, ms)
                    .add(COUNT, count)
                    .toString();
        }
    }
}
