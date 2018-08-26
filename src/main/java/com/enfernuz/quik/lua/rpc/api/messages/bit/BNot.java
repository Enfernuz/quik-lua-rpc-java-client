package com.enfernuz.quik.lua.rpc.api.messages.bit;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Value;

public final class BNot {

    private BNot() {}

    @Value
    public static class Request {

        int x;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("x", x)
                    .toString();
        }
    }

    @Value
    public static class Result {

        int result;

        @JsonCreator
        public Result(final @JsonProperty(value = "result", required = true) int result) {
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
