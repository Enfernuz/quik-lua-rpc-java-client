package com.enfernuz.quik.lua.rpc.api.messages.bit;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.Value;

public final class Test {

    private Test() {}

    @Value
    public static class Request {

        int x;
        int n;

        @Builder
        private Request(int x, int n) {
            this.x = x;
            this.n = n;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("x", x)
                    .add("n", n)
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
