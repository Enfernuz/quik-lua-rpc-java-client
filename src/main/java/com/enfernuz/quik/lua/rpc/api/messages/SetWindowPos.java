package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.Value;

public final class SetWindowPos {

    private SetWindowPos() {}

    @Value
    public static class Request {

        int tId;
        int x;
        int y;
        int dx;
        int dy;

        @Builder
        private Request(
                final int tId,
                final int x,
                final int y,
                final int dx,
                final int dy) {

            this.tId = tId;
            this.x = x;
            this.y = y;
            this.dx = dx;
            this.dy = dy;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("t_id", tId)
                    .add("x", x)
                    .add("y", y)
                    .add("dx", dx)
                    .add("dy", dy)
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
