package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class SetSelectedRow implements RemoteProcedure {

    private SetSelectedRow() {}

    @JsonPropertyOrder({Args.TABLE_ID, Args.ROW})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<SetSelectedRow> {

        private static final String TABLE_ID = "table_id";
        private static final String ROW = "row";

        @JsonProperty(TABLE_ID)
        private final int tableId;

        @JsonProperty(ROW)
        @JsonInclude(Include.NON_NULL)
        private final Integer row;

        private Args(final int tableId, final Integer row) {

            this.tableId = tableId;
            this.row = row;
        }

        public static ArgsBuilder builder() {
            return new ArgsBuilder();
        }

        @JsonIgnore
        public int getTableId() {
            return tableId;
        }

        @JsonIgnore
        public Integer getRow() {
            return row;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(TABLE_ID, tableId)
                    .add(ROW, row)
                    .toString();
        }

        public static final class ArgsBuilder {

            private int tableId;
            private Integer row;

            ArgsBuilder() {}

            public ArgsBuilder tableId(final int tableId) {
                this.tableId = tableId;
                return this;
            }

            public ArgsBuilder row(final Integer row) {
                this.row = row;
                return this;
            }

            public Args build() {
                return new Args(tableId, row);
            }

            @NotNull
            @Override
            public String toString() {
                return MoreObjects.toStringHelper(this)
                        .add(TABLE_ID, tableId)
                        .add(ROW, row)
                        .toString();
            }
        }
    }

    @Value
    public static class Result implements RpcResult<SetSelectedRow> {

        private static final String RESULT = "result";

        int result;

        @JsonCreator
        public static Result getInstance(@JsonProperty(value = RESULT, required = true) final int result) {

            if ( isError(result) ) {
                return InstanceHolder.ERROR;
            }

            return new Result(result);
        }

        public static Result getErrorInstance() {
            return InstanceHolder.ERROR;
        }

        private Result(final int result) {
            this.result = result;
        }

        public boolean isError() {
            return isError(result);
        }

        private static boolean isError(final int result) {
            return result == -1;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(RESULT, result)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result ERROR = new Result(-1);

            // sanity check
            static {
                assert ERROR.isError();
            }
        }
    }
}
