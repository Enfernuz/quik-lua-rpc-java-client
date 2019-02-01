package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;
import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

@Value
public class DataSourceTime implements Comparable<DataSourceTime> {

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
    private DataSourceTime(@JsonProperty(value = YEAR, required = true) final int year,
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

    @Override
    public int compareTo(@NotNull final DataSourceTime other) {
        return ComparisonChain
                .start()
                .compare(year, other.year)
                .compare(month, other.month)
                .compare(day, other.day)
                .compare(weekDay, other.weekDay)
                .compare(hour, other.hour)
                .compare(min, other.min)
                .compare(sec, other.sec)
                .compare(ms, other.ms)
                .result();
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
