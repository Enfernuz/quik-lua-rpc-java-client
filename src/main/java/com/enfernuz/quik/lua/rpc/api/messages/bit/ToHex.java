package com.enfernuz.quik.lua.rpc.api.messages.bit;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

public final class ToHex {

    private ToHex() {}

    @Value
    public static class Request {

        int x;
        int n;

        @Builder
        private Request(final int x, final int n) {
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

        @NonNull String result;

        @JsonCreator
        public Result(final @JsonProperty(value = "result", required = true) String result) {
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
