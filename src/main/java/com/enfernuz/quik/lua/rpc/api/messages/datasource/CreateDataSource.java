package com.enfernuz.quik.lua.rpc.api.messages.datasource;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.*;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CreateDataSource implements RemoteProcedure {

    private CreateDataSource() {}

    public enum Interval {

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
        INTERVAL_MN1
    }

    @JsonPropertyOrder({Args.CLASS_CODE, Args.SEC_CODE, Args.INTERVAL, Args.PARAM})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<CreateDataSource> {

        private static final String CLASS_CODE = "class_code";
        private static final String SEC_CODE = "sec_code";
        private static final String INTERVAL = "interval";
        private static final String PARAM = "param";

        @JsonProperty(CLASS_CODE)
        private final String classCode;

        @JsonProperty(SEC_CODE)
        private final String secCode;

        @JsonProperty(INTERVAL)
        private final Interval interval;

        @JsonProperty(PARAM)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private final String param;

        @Builder
        private Args(
                @NonNull final String classCode,
                @NonNull final String secCode,
                @NonNull final Interval interval,
                final String param) {

            this.classCode = classCode;
            this.secCode = secCode;
            this.interval = interval;
            this.param = param;
        }

        @JsonIgnore
        @NotNull
        public String getClassCode() {
            return classCode;
        }

        @JsonIgnore
        @NotNull
        public String getSecCode() {
            return secCode;
        }

        @JsonIgnore
        @NotNull
        public Interval getInterval() {
            return interval;
        }

        @JsonIgnore
        @Nullable
        public String getParam() {
            return param;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(CLASS_CODE, classCode)
                    .add(SEC_CODE, secCode)
                    .add(INTERVAL, interval)
                    .add(PARAM, param)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<CreateDataSource> {

        private static final String DATASOURCE_UUID = "datasource_uuid";
        private static final String IS_ERROR = "is_error";
        private static final String ERROR_DESCRIPTION = "error_desc";

        String datasourceUUID;
        boolean error;
        String errorDesc;

        @JsonCreator
        @Builder
        private Result(
                @JsonProperty(value = DATASOURCE_UUID) final String datasourceUUID,
                @JsonProperty(value = IS_ERROR, required = true) final boolean error,
                @JsonProperty(value = ERROR_DESCRIPTION) final String errorDesc) {

            this.datasourceUUID = datasourceUUID;
            this.error = error;
            this.errorDesc = errorDesc;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(DATASOURCE_UUID, datasourceUUID)
                    .add(IS_ERROR, error)
                    .add(ERROR_DESCRIPTION, errorDesc)
                    .toString();
        }
    }
}
