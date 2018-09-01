package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class DateTimeEntry implements Comparable<DateTimeEntry> {

    @JsonProperty("mcs") int mcs;
    @JsonProperty("ms") int ms;
    @JsonProperty("sec") int sec;
    @JsonProperty("min") int min;
    @JsonProperty("hour") int hour;
    @JsonProperty("day") int day;
    @JsonProperty("week_day") int weekDay;
    @JsonProperty("month") int month;
    @JsonProperty("year") int year;

    private @NonFinal @Getter(AccessLevel.NONE) transient int hashCode;
    private @NonFinal @Getter(AccessLevel.NONE) transient String asString;

    @Builder
    @JsonCreator
    private DateTimeEntry(
            @JsonProperty(value = "mcs", required = true) final int mcs,
            @JsonProperty(value = "ms", required = true) final int ms,
            @JsonProperty(value = "sec", required = true) final int sec,
            @JsonProperty(value = "min", required = true) final int min,
            @JsonProperty(value = "hour", required = true) final int hour,
            @JsonProperty(value = "day", required = true) final int day,
            @JsonProperty(value = "week_day", required = true) final int weekDay,
            @JsonProperty(value = "month", required = true) final int month,
            @JsonProperty(value = "year", required = true) final int year) {

        this.mcs = mcs;
        this.ms = ms;
        this.sec = sec;
        this.min = min;
        this.hour = hour;
        this.day = day;
        this.weekDay = weekDay;
        this.month = month;
        this.year = year;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof DateTimeEntry) ) {
            return false;
        } else {
            final DateTimeEntry that = (DateTimeEntry) o;
            return mcs == that.mcs &&
                    ms == that.ms &&
                    sec == that.sec &&
                    min == that.min &&
                    hour == that.hour &&
                    day == that.day &&
                    weekDay == that.weekDay &&
                    month == that.month &&
                    year == that.year;
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(mcs, ms, sec, min, hour, day, weekDay, month, year);
        }

        return hashCode;
    }

    @Override
    public int compareTo(final DateTimeEntry other) {
        return ComparisonChain
                .start()
                .compare(year, other.year)
                .compare(month, other.month)
                .compare(weekDay, other.weekDay)
                .compare(day, other.day)
                .compare(hour, other.hour)
                .compare(min, other.min)
                .compare(sec, other.sec)
                .compare(ms, other.ms)
                .compare(mcs, other.mcs)
                .result();
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("mcs", mcs)
                    .add("ms", ms)
                    .add("sec", sec)
                    .add("min", min)
                    .add("hour", hour)
                    .add("day", day)
                    .add("week_day", weekDay)
                    .add("month", month)
                    .add("year", year)
                    .toString();
        }

        return asString;
    }
}
