package com.enfernuz.quik.lua.rpc.api.messages.datasource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

public final class O {

    private O() {}

    @Value
    public static class Request {

        @NonNull
        String datasourceUUID;
        int candleIndex;

        private @NonFinal @Getter(AccessLevel.NONE) transient int hashCode;
        private @NonFinal @Getter(AccessLevel.NONE) transient String asString;

        public Request(final String datasourceUUID, final int candleIndex) {
            this.datasourceUUID = datasourceUUID;
            this.candleIndex = candleIndex;
        }

        @Override
        public boolean equals(final Object o) {

            if (o == this) {
                return true;
            } else if (!(o instanceof Request)) {
                return false;
            } else {
                final Request request = (Request) o;
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

        @Override
        public String toString() {

            if (asString == null) {
                asString = MoreObjects.toStringHelper(this)
                        .add("datasource_uuid", datasourceUUID)
                        .add("candle_index", candleIndex)
                        .toString();
            }

            return asString;
        }
    }

    @Value
    public static class Result {

        String value;

        private @NonFinal @Getter(AccessLevel.NONE) transient int hashCode;
        private @NonFinal @Getter(AccessLevel.NONE) transient String asString;

        @JsonCreator
        public Result(final @JsonProperty("value") String value) {
            this.value = value;
        }

        @Override
        public boolean equals(final Object o) {

            if (o == this) {
                return true;
            } else if ( !(o instanceof Result) ) {
                return false;
            } else {
                final Result result = (Result) o;
                return Objects.equals(value, result.value);
            }
        }

        @Override
        public int hashCode() {

            if (hashCode == 0) {
                hashCode = Objects.hash(value);
            }

            return hashCode;
        }

        @Override
        public String toString() {

            if (asString == null) {
                asString = MoreObjects.toStringHelper(this)
                        .add("value", value)
                        .toString();
            }

            return asString;
        }
    }
}
