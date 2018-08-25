package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.Value;

public final class GetWindowRect {

    private GetWindowRect() {}

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

        int top;
        int left;
        int bottom;
        int right;

        @Builder
        @JsonCreator
        private Result(
                final @JsonProperty(value = "top", required = true) int top,
                final @JsonProperty(value = "left", required = true) int left,
                final @JsonProperty(value = "bottom", required = true) int bottom,
                final @JsonProperty(value = "right", required = true) int right) {

            this.top = top;
            this.left = left;
            this.bottom = bottom;
            this.right = right;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("top", top)
                    .add("left", left)
                    .add("bottom", bottom)
                    .add("right", right)
                    .toString();
        }
    }
}
