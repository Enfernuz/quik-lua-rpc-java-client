package com.enfernuz.quik.lua.rpc.api.messages.datasource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

public final class CreateDataSource {

    private CreateDataSource() {}

    public static enum Interval {

        INTERVAL_TICK,
        INTERVAL_M1,
        INTERVAL_M2,
        INTERVAL_M3,
        INTERVAL_M4,
        INTERVAL_M5,
        INTERVAL_M6,
        INTERVAL_M10,
        INTERVAL_M15,
        INTERVAL_M20,
        INTERVAL_M30,
        INTERVAL_H1,
        INTERVAL_H2,
        INTERVAL_H4,
        INTERVAL_D1,
        INTERVAL_W1,
        INTERVAL_MN1;
    }

    @Value
    public static class Request {

        @NonNull String classCode;
        @NonNull String secCode;
        @NonNull Interval interval;
        String param;

        @Builder
        private Request(
                final String classCode,
                final String secCode,
                final Interval interval,
                final String param) {

            this.classCode = classCode;
            this.secCode = secCode;
            this.interval = interval;
            this.param = param;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("class_code", classCode)
                    .add("sec_code", secCode)
                    .add("interval", interval)
                    .add("param", param)
                    .toString();
        }
    }

    @Value
    public static class Result {

        String datasourceUUID;
        boolean error;
        String errorDesc;

        @JsonCreator
        @Builder
        private Result(
                final @JsonProperty(value = "datasource_uuid") String datasourceUUID,
                final @JsonProperty(value = "is_error") boolean error,
                final @JsonProperty(value = "error_desc") String errorDesc) {
            this.datasourceUUID = datasourceUUID;
            this.error = error;
            this.errorDesc = errorDesc;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("datasource_uuid", datasourceUUID)
                    .add("is_error", error)
                    .add("error_desc", errorDesc)
                    .toString();
        }
    }
}
