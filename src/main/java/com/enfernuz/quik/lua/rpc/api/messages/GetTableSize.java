package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class GetTableSize implements RemoteProcedure {

    private GetTableSize() {}

    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetTableSize> {

        private static final String T_ID = "t_id";

        @JsonProperty(T_ID)
        private final int tId;

        public Args(final int tId) {
            this.tId = tId;
        }

        @JsonIgnore
        public int getTId() {
            return tId;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(T_ID, tId)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetTableSize> {

        private static final String TABLE_SIZE = "table_size";

        TableSize tableSize;

        @JsonCreator
        public static Result getInstance(@JsonProperty(TABLE_SIZE) @Nullable final TableSize tableSize) {
            return isError(tableSize) ? InstanceHolder.ERROR : new Result(tableSize);
        }

        public static Result getErrorInstance() {
            return InstanceHolder.ERROR;
        }

        private Result(final TableSize tableSize) {
            this.tableSize = tableSize;
        }

        public boolean isError() {
            return isError(tableSize);
        }

        @Contract(value = "null -> true; !null -> false", pure = true)
        private static boolean isError(final TableSize tableSize) {
            return tableSize == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(TABLE_SIZE, tableSize)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result ERROR = new Result(null);

            // sanity check
            static {
                assert ERROR.isError();
            }
        }
    }

    @Value
    public static class TableSize {

        private static final String ROWS = "rows";
        private static final String COL = "col";

        int rows;
        int col;

        @JsonCreator
        @Builder
        private TableSize(
                @JsonProperty(value = ROWS, required = true) final int rows,
                @JsonProperty(value = COL, required = true) final int col) {

            this.rows = rows;
            this.col = col;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(ROWS, rows)
                    .add(COL, col)
                    .toString();
        }
    }
}
