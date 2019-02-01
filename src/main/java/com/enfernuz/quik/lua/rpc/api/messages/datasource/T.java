package com.enfernuz.quik.lua.rpc.api.messages.datasource;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.enfernuz.quik.lua.rpc.api.structures.DataSourceTime;
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

        private static final String TIME = "time";

        DataSourceTime time;

        @JsonCreator
        public Result(@JsonProperty(value = TIME, required = true) @NonNull @NotNull final DataSourceTime time) {
            this.time = time;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(TIME, time)
                    .toString();
        }
    }
}
