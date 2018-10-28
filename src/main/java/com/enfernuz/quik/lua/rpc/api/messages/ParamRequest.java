package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class ParamRequest implements RemoteProcedure {

    @JsonPropertyOrder({Args.CLASS_CODE, Args.SEC_CODE, Args.DB_NAME})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<ParamRequest> {

        private static final String CLASS_CODE = "class_code";
        private static final String SEC_CODE = "sec_code";
        private static final String DB_NAME = "db_name";

        @JsonProperty(CLASS_CODE)
        private final String classCode;

        @JsonProperty(SEC_CODE)
        private final String secCode;

        @JsonProperty(DB_NAME)
        private final String dbName;

        @Builder
        private Args(@NonNull final String classCode, @NonNull final String secCode, @NonNull final String dbName) {

            this.classCode = classCode;
            this.secCode = secCode;
            this.dbName = dbName;
        }

        @JsonIgnore
        public String getClassCode() {
            return classCode;
        }

        @JsonIgnore
        public String getSecCode() {
            return secCode;
        }

        @JsonIgnore
        public String getDbName() {
            return dbName;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(CLASS_CODE, classCode)
                    .add(SEC_CODE, secCode)
                    .add(DB_NAME, dbName)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<ParamRequest> {

        private static final String RESULT = "result";

        boolean result;

        @JsonCreator
        public static Result getInstance(@JsonProperty(value = RESULT, required = true) final boolean result) {
            return result ? InstanceHolder.TRUE : InstanceHolder.FALSE;
        }

        private Result(final boolean result) {
            this.result = result;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(RESULT, result)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result TRUE = new Result(true);
            private static final Result FALSE = new Result(false);

            // sanity check
            static {
                assert TRUE.result;
                assert !FALSE.result;
            }
        }
    }
}
