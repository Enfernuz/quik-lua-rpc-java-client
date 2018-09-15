package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class GetTableSize {

    private GetTableSize() {}

    private static final String T_ID_FIELD = "t_id";

    @Value
    public static class Request {

       int tId;

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(T_ID_FIELD, tId)
                    .toString();
        }
    }

    @Value
    public static class TableSize {

        private static final String ROWS_FIELD = "rows";
        private static final String COL_FIELD = "col";

        int rows;
        int col;

        @Builder
        @JsonCreator
        private TableSize(
                @JsonProperty(value = ROWS_FIELD, required = true) final int rows,
                @JsonProperty(value = COL_FIELD, required = true) final int col) {

            this.rows = rows;
            this.col = col;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(ROWS_FIELD, rows)
                    .add(COL_FIELD, col)
                    .toString();
        }
    }

    @Value
    public static class Result {

        private static final String TABLE_SIZE_FIELD = "table_size";

        TableSize tableSize;

        @JsonCreator
        public static Result getInstance(@JsonProperty(TABLE_SIZE_FIELD) final TableSize tableSize) {
            return isError(tableSize) ? InstanceHolder.ERROR : new Result(tableSize);
        }

        @Contract(pure = true)
        public static Result getErrorInstance() {
            return InstanceHolder.ERROR;
        }

        private Result(final TableSize tableSize) {
            this.tableSize = tableSize;
        }

        @Contract(pure = true)
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
                    .add(TABLE_SIZE_FIELD, tableSize)
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
}
