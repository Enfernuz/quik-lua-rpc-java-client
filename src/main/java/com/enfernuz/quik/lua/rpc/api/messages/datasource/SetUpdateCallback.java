package com.enfernuz.quik.lua.rpc.api.messages.datasource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

public final class SetUpdateCallback {

    private SetUpdateCallback() {}

    @Value
    public static class Request {

        @NonNull String datasourceUUID;
        @NonNull String fCbDef;

        @Builder
        private Request(final String datasourceUUID, final String fCbDef) {
            this.datasourceUUID = datasourceUUID;
            this.fCbDef = fCbDef;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("datasource_uuid", datasourceUUID)
                    .add("f_cb_def", fCbDef)
                    .toString();
        }
    }

    @Value
    public static class Result {

        boolean result;

        @JsonCreator
        public Result(final @JsonProperty(value = "result", required = true) boolean result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("result", result)
                    .toString();
        }
    }
}
