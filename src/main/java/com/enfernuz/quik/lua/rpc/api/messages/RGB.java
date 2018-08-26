package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.Value;

public final class RGB {

    private RGB() {}

    @Value
    public static class Request {

        int red;
        int green;
        int blue;

        @Builder
        private Request(final int red, final int green, final int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("red", red)
                    .add("green", green)
                    .add("blue", blue)
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
