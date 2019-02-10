package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.*;
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

        @JsonProperty(T_ID)
        private final int tId;

        @JsonProperty(ROW)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private final Integer row;

        @JsonProperty(COL)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private final Integer col;

        @JsonProperty(B_COLOR)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private final Integer bColor;

        @JsonProperty(F_COLOR)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private final Integer fColor;

        @JsonProperty(SEL_B_COLOR)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private final Integer selBColor;

        @JsonProperty(SEL_F_COLOR)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private final Integer selFColor;

        private Args(
                final int tId,
                final Integer row,
                final Integer col,
                final Integer bColor,
                final Integer fColor,
                final Integer selBColor,
                final Integer selFColor) {

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
        public Integer getRow() {
            return row;
        }

        @JsonIgnore
        public Integer getCol() {
            return col;
        }

        @JsonIgnore
        public Integer getBColor() {
            return bColor;
        }

        @JsonIgnore
        public Integer getFColor() {
            return fColor;
        }

        @JsonIgnore
        public Integer getSelBColor() {
            return selBColor;
        }

        @JsonIgnore
        public Integer getSelFColor() {
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
            private Integer row;
            private Integer col;
            private Integer bColor;
            private Integer fColor;
            private Integer selBColor;
            private Integer selFColor;

            ArgsBuilder() {}

            public ArgsBuilder tId(final int tId) {
                this.tId = tId;
                return this;
            }

            public ArgsBuilder row(final Integer row) {
                this.row = row;
                return this;
            }

            public ArgsBuilder col(final Integer col) {
                this.col = col;
                return this;
            }

            public ArgsBuilder bColor(final Integer bColor) {
                this.bColor = bColor;
                return this;
            }

            public ArgsBuilder fColor(final Integer fColor) {
                this.fColor = fColor;
                return this;
            }

            public ArgsBuilder selBColor(final Integer selBColor) {
                this.selBColor = selBColor;
                return this;
            }

            public ArgsBuilder selFColor(final Integer selFColor) {
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
