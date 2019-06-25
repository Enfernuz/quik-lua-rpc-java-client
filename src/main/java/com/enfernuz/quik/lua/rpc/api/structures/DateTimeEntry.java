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
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Value
public class DateTimeEntry implements Comparable<DateTimeEntry> {

    private static final String MCS = "mcs";
    private static final String MS = "ms";
    private static final String SEC = "sec";
    private static final String MIN = "min";
    private static final String HOUR = "hour";
    private static final String DAY = "day";
    private static final String WEEK_DAY = "week_day";
    private static final String MONTH = "month";
    private static final String YEAR = "year";

    int mcs;
    int ms;
    int sec;
    int min;
    int hour;
    int day;
    int weekDay;
    int month;
    int year;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient int hashCode;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient String asString;

    @JsonCreator
    @Builder
    private DateTimeEntry(
            @JsonProperty(value = MCS) final int mcs,
            @JsonProperty(value = MS, required = true) final int ms,
            @JsonProperty(value = SEC, required = true) final int sec,
            @JsonProperty(value = MIN, required = true) final int min,
            @JsonProperty(value = HOUR, required = true) final int hour,
            @JsonProperty(value = DAY, required = true) final int day,
            @JsonProperty(value = WEEK_DAY, required = true) final int weekDay,
            @JsonProperty(value = MONTH, required = true) final int month,
            @JsonProperty(value = YEAR, required = true) final int year) {

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
                .compare(day, other.day)
                .compare(hour, other.hour)
                .compare(min, other.min)
                .compare(sec, other.sec)
                .compare(ms, other.ms)
                .compare(mcs, other.mcs)
                .result();
    }

    @NotNull
    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add(MCS, mcs)
                    .add(MS, ms)
                    .add(SEC, sec)
                    .add(MIN, min)
                    .add(HOUR, hour)
                    .add(DAY, day)
                    .add(WEEK_DAY, weekDay)
                    .add(MONTH, month)
                    .add(YEAR, year)
                    .toString();
        }

        return asString;
    }
}
