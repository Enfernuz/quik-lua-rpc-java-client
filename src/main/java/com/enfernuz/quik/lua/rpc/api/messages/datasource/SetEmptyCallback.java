package com.enfernuz.quik.lua.rpc.api.messages.datasource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;

public final class SetEmptyCallback {

    private SetEmptyCallback() {}

    @Value
    public static class Request {

        @NonNull String datasourceUUID;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("datasource_uuid", datasourceUUID)
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
