package com.enfernuz.quik.lua.rpc.api.messages.datasource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;

public final class Size {

    private Size() {}

    @Value
    public static class Request {

        @NonNull
        String datasourceUUID;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("datasource_uuid", datasourceUUID)
                    .toString();
        }
    }

    @Value
    public static class Result {

        int value;

        @JsonCreator
        public Result(final @JsonProperty(value = "value", required = true) int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("value", value)
                    .toString();
        }
    }
}
