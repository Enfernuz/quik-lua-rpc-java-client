package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Value;

public final class IsConnected {

    private IsConnected() {}

    public static enum Request { INSTANCE; }

    @Value
    public static class Result {

        int isConnected;

        @JsonCreator
        public Result(final @JsonProperty(value = "is_connected", required = true) int isConnected) {
            this.isConnected = isConnected;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("is_connected", isConnected)
                    .toString();
        }
    }
}
