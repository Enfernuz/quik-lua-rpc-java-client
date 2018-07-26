package com.enfernuz.quik.lua.rpc.api.structures;

import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

public final class CancelParamRequest {

    @Value
    public static class Request {

        String classCode;
        String secCode;
        String dbName;

        @Builder
        private Request(final @NonNull String classCode, final @NonNull String secCode, final @NonNull String dbName) {
            this.classCode = classCode;
            this.secCode = secCode;
            this.dbName = dbName;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("class_code", classCode)
                    .add("sec_code", secCode)
                    .add("db_name", dbName)
                    .toString();
        }
    }

    @Value
    public static class Result {

        boolean result;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("result", result)
                    .toString();
        }
    }
}
