package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class ParamRequest {

    @Value
    public static class Request {

        private static final String CLASS_CODE_FIELD = "class_code";
        private static final String SEC_CODE_FIELD = "sec_code";
        private static final String DB_NAME_FIELD = "db_name";

        String classCode;
        String secCode;
        String dbName;

        @Builder
        private Request(@NonNull final String classCode, @NonNull final String secCode, @NonNull final String dbName) {
            this.classCode = classCode;
            this.secCode = secCode;
            this.dbName = dbName;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(CLASS_CODE_FIELD, classCode)
                    .add(SEC_CODE_FIELD, secCode)
                    .add(DB_NAME_FIELD, dbName)
                    .toString();
        }
    }

    @Value
    public static class Result {

        private static final String RESULT_FIELD = "result";

        boolean result;

        @JsonCreator
        public static Result getInstance(@JsonProperty(value = RESULT_FIELD, required = true) final boolean result) {
            return result ? InstanceHolder.TRUE : InstanceHolder.FALSE;
        }

        private Result(final  boolean result) {
            this.result = result;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(RESULT_FIELD, result)
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
