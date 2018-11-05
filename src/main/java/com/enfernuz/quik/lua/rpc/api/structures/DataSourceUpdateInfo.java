package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

@Value
public class DataSourceUpdateInfo {

    private static final String DATA_SOURCE_UUID = "data_source_uuid";
    private static final String INDEX = "index";
    private static final String OPEN = "open";
    private static final String HIGH = "high";
    private static final String LOW = "low";
    private static final String CLOSE = "close";
    private static final String VOLUME = "volume";
    private static final String TIME = "time";
    private static final String SIZE = "size";

    String datasourceUUID;
    int index;
    String open;
    String high;
    String low;
    String close;
    String volume;
    DataSourceTime time;
    Integer size;

    @JsonCreator
    @Builder
    private DataSourceUpdateInfo(
            @JsonProperty(value = DATA_SOURCE_UUID,required = true) @NonNull @NotNull final String datasourceUUID,
            @JsonProperty(value = INDEX, required = true) final int index,
            @JsonProperty(OPEN) final String open,
            @JsonProperty(HIGH) final String high,
            @JsonProperty(LOW) final String low,
            @JsonProperty(CLOSE) final String close,
            @JsonProperty(VOLUME) final String volume,
            @JsonProperty(TIME) final DataSourceTime time,
            @JsonProperty(SIZE) final Integer size) {

        this.datasourceUUID = datasourceUUID;
        this.index = index;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.time = time;
        this.size = size;
    }

    @NotNull
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(DATA_SOURCE_UUID, datasourceUUID)
                .add(INDEX, index)
                .add(OPEN, open)
                .add(HIGH, high)
                .add(LOW, low)
                .add(CLOSE, close)
                .add(VOLUME, volume)
                .add(TIME, time)
                .add(SIZE, size)
                .toString();
    }
}
