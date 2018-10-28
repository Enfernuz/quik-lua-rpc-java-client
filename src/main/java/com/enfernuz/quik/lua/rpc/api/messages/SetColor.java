package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class SetColor implements RemoteProcedure {

    private SetColor() {}

    @JsonPropertyOrder({Args.T_ID, Args.ROW, Args.COL, Args.B_COLOR, Args.F_COLOR, Args.SEL_B_COLOR, Args.SEL_F_COLOR})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<SetColor> {

        private static final String T_ID = "t_id";
        private static final String ROW = "row";
        private static final String COL = "col";
        private static final String B_COLOR = "b_color";
        private static final String F_COLOR = "f_color";
        private static final String SEL_B_COLOR = "sel_b_color";
        private static final String SEL_F_COLOR = "sel_f_color";

        public static final int QTABLE_NO_INDEX = -1;
        public static final int QTABLE_DEFAULT_COLOR = -1;

        @JsonProperty(T_ID)
        private final int tId;

        @JsonProperty(ROW)
        private final int row;

        @JsonProperty(COL)
        private final int col;

        @JsonProperty(B_COLOR)
        private final int bColor;

        @JsonProperty(F_COLOR)
        private final int fColor;

        @JsonProperty(SEL_B_COLOR)
        private final int selBColor;

        @JsonProperty(SEL_F_COLOR)
        private final int selFColor;

        private Args(
                final int tId,
                final int row,
                final int col,
                final int bColor,
                final int fColor,
                final int selBColor,
                final int selFColor) {

            this.tId = tId;
            this.row = row;
            this.col = col;
            this.bColor = bColor;
            this.fColor = fColor;
            this.selBColor = selBColor;
            this.selFColor = selFColor;
        }

        public static ArgsBuilder builder() {
            return new ArgsBuilder();
        }

        @JsonIgnore
        public int getTId() {
            return tId;
        }

        @JsonIgnore
        public int getRow() {
            return row;
        }

        @JsonIgnore
        public int getCol() {
            return col;
        }

        @JsonIgnore
        public int getbColor() {
            return bColor;
        }

        @JsonIgnore
        public int getfColor() {
            return fColor;
        }

        @JsonIgnore
        public int getSelBColor() {
            return selBColor;
        }

        @JsonIgnore
        public int getSelFColor() {
            return selFColor;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(T_ID, tId)
                    .add(ROW, row)
                    .add(COL, col)
                    .add(B_COLOR, bColor)
                    .add(F_COLOR, fColor)
                    .add(SEL_B_COLOR, selBColor)
                    .add(SEL_F_COLOR, selFColor)
                    .toString();
        }

        public static final class ArgsBuilder {

            private int tId;
            private int row = QTABLE_NO_INDEX;
            private int col = QTABLE_NO_INDEX;
            private int bColor = QTABLE_DEFAULT_COLOR;
            private int fColor = QTABLE_DEFAULT_COLOR;
            private int selBColor = QTABLE_DEFAULT_COLOR;
            private int selFColor = QTABLE_DEFAULT_COLOR;

            ArgsBuilder() {}

            public ArgsBuilder tId(final int tId) {
                this.tId = tId;
                return this;
            }

            public ArgsBuilder row(final int row) {
                this.row = row;
                return this;
            }

            public ArgsBuilder col(final int col) {
                this.col = col;
                return this;
            }

            public ArgsBuilder bColor(final int bColor) {
                this.bColor = bColor;
                return this;
            }

            public ArgsBuilder fColor(final int fColor) {
                this.fColor = fColor;
                return this;
            }

            public ArgsBuilder selBColor(final int selBColor) {
                this.selBColor = selBColor;
                return this;
            }

            public ArgsBuilder selFColor(final int selFColor) {
                this.selFColor = selFColor;
                return this;
            }

            public Args build() {
                return new Args(tId, row, col, bColor, fColor, selBColor, selFColor);
            }

            @Override
            public String toString() {
                return MoreObjects.toStringHelper(this)
                        .add(T_ID, tId)
                        .add(ROW, row)
                        .add(COL, col)
                        .add(B_COLOR, bColor)
                        .add(F_COLOR, fColor)
                        .add(SEL_B_COLOR, selBColor)
                        .add(SEL_F_COLOR, selFColor)
                        .toString();
            }
        }
    }

    @Value
    public static class Result implements RpcResult<SetColor> {

        private static final String RESULT = "result";

        boolean result;

        @JsonCreator
        public static Result getInstance(@JsonProperty(value = RESULT, required = true) final boolean result) {
            return result ? InstanceHolder.TRUE : InstanceHolder.FALSE;
        }

        private Result(final boolean result) {
            this.result = result;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(RESULT, result)
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
