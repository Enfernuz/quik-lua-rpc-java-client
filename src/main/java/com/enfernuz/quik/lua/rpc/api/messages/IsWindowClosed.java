package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Value;

public final class IsWindowClosed {

    private IsWindowClosed() {}

    @Value
    public static class Request {

        int tId;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("t_id", tId)
                    .toString();
        }
    }

    @Value
    public static class Result {

        boolean result;

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
