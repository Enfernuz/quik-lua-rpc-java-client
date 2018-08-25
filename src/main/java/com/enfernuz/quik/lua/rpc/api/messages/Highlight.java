package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.Value;

public final class Highlight {

    private Highlight() {}

    @Value
    public static class Request {

        int tId;
        int row;
        int col;
        int bColor;
        int fColor;
        int timeout;

        @Builder
        private Request(
                final int tId,
                final int row,
                final int col,
                final int bColor,
                final int fColor,
                final int timeout) {

            this.tId = tId;
            this.row = row;
            this.col = col;
            this.bColor = bColor;
            this.fColor = fColor;
            this.timeout = timeout;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("t_id", tId)
                    .add("row", row)
                    .add("col", col)
                    .add("b_color", bColor)
                    .add("f_color", fColor)
                    .add("timeout", timeout)
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
