package com.enfernuz.quik.lua.rpc.events.api.structures;

import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class DateTimeEntry {

    int mcs;
    int ms;
    int sec;
    int min;
    int hour;
    int day;
    int weekDay;
    int month;
    int year;

    private @NonFinal transient int hashCode;
    private @NonFinal transient String asString;

    @Builder
    private DateTimeEntry(
            final int mcs,
            final int ms,
            final int sec,
            final int min,
            final int hour,
            final int day,
            final int weekDay,
            final int month,
            final int year) {

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
            hashCode = Objects.hash(super.hashCode(), mcs, ms, sec, min, hour, day, weekDay, month, year);
        }

        return hashCode;
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
                    .add("weekDay", weekDay)
                    .add("month", month)
                    .add("year", year)
                    .toString();
        }

        return asString;
    }
}
