package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class Highlight {

    private Highlight() {}

    private static final String T_ID_FIELD = "t_id";
    private static final String ROW_FIELD = "row";
    private static final String COL_FIELD = "col";
    private static final String B_COLOR_FIELD = "b_color";
    private static final String F_COLOR_FIELD = "f_color";
    private static final String TIMEOUT_FIELD = "timeout";

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

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(T_ID_FIELD, tId)
                    .add(ROW_FIELD, row)
                    .add(COL_FIELD, col)
                    .add(B_COLOR_FIELD, bColor)
                    .add(F_COLOR_FIELD, fColor)
                    .add(TIMEOUT_FIELD, timeout)
                    .toString();
        }
    }

    @Value
    public static class Result {

        private static final String RESULT_FIELD = "result";

        boolean result;

        @JsonCreator
        public static Result getInstance(@JsonProperty(value = RESULT_FIELD, required = true) final boolean result) {
            return result ? InstanceHolder.TRUE : InstanceHolder.FALSE;
        }

        private Result(final boolean result) {
            this.result = result;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(RESULT_FIELD, result)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result TRUE = new Result(true);
            private static final Result FALSE = new Result(false);

            // sanity check
            static {
                assert TRUE.result;
                assert !FALSE.result;
            }
        }
    }
}
