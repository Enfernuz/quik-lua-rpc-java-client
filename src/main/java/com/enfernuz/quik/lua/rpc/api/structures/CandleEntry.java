package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Value
public class CandleEntry implements Comparable<CandleEntry> {

    private static final String OPEN = "open";
    private static final String CLOSE = "close";
    private static final String HIGH = "high";
    private static final String LOW = "low";
    private static final String VOLUME = "volume";
    private static final String DATETIME = "datetime";
    private static final String DOES_EXIST = "doesExist";

    String open;
    String close;
    String high;
    String low;
    String volume;
    DateTimeEntry dateTimeEntry;
    int doesExist;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient int hashCode;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient String asString;

    @JsonCreator
    @Builder
    private CandleEntry(
            @JsonProperty(value = OPEN, required = true) final String open,
            @JsonProperty(value = CLOSE, required = true) final String close,
            @JsonProperty(value = HIGH, required = true) final String high,
            @JsonProperty(value = LOW, required = true) final String low,
            @JsonProperty(value = VOLUME, required = true) final String volume,
            @JsonProperty(value = DATETIME, required = true) final DateTimeEntry dateTimeEntry,
            @JsonProperty(value = DOES_EXIST, required = true) final int doesExist) {

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

    @NotNull
    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add(OPEN, open)
                    .add(CLOSE, close)
                    .add(HIGH, high)
                    .add(LOW, low)
                    .add(VOLUME, volume)
                    .add(DATETIME, dateTimeEntry)
                    .add(DOES_EXIST, doesExist)
                    .toString();
        }

        return asString;
    }
}
