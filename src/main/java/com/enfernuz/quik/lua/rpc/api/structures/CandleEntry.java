package com.enfernuz.quik.lua.rpc.api.structures;

import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class CandleEntry implements Comparable<CandleEntry> {

    String open;
    String close;
    String high;
    String low;
    String volume;
    DateTimeEntry dateTimeEntry;
    int doesExist;

    private @NonFinal @Getter(AccessLevel.NONE) transient int hashCode;
    private @NonFinal @Getter(AccessLevel.NONE) transient String asString;

    @Builder
    private CandleEntry(
            final String open,
            final String close,
            final String high,
            final String low,
            final String volume,
            final DateTimeEntry dateTimeEntry,
            final int doesExist) {

        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
        this.volume = volume;
        this.dateTimeEntry = dateTimeEntry;
        this.doesExist = doesExist;
    }

    @Override
    public int compareTo(final CandleEntry other) {
        return dateTimeEntry.compareTo(other.dateTimeEntry);
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof CandleEntry) )  {
            return false;
        } else {
            final CandleEntry that = (CandleEntry) o;
            return doesExist == that.doesExist &&
                    Objects.equals(open, that.open) &&
                    Objects.equals(close, that.close) &&
                    Objects.equals(high, that.high) &&
                    Objects.equals(low, that.low) &&
                    Objects.equals(volume, that.volume) &&
                    Objects.equals(dateTimeEntry, that.dateTimeEntry);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(open, close, high, low, volume, dateTimeEntry, doesExist);
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("open", open)
                    .add("close", close)
                    .add("high", high)
                    .add("low", low)
                    .add("volume", volume)
                    .add("datetime", dateTimeEntry)
                    .add("does_exist", doesExist)
                    .toString();
        }

        return asString;
    }
}
