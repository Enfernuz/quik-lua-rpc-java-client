package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public final class GetItem {

    private GetItem() {}

    @Value
    public static class Request {

        String tableName;
        int index;

        public Request(@NonNull final String tableName, final int index) {
            this.tableName = tableName;
            this.index = index;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("table_name", tableName)
                    .add("index", index)
                    .toString();
        }
    }

    @Value
    public static class Result {

        Map<String, String> tableRow;

        @JsonCreator
        public static Result getInstance(@JsonProperty("table_row") final Map<String, String> tableRow) {

            if (tableRow == null || tableRow.isEmpty()) {
                return InstanceHolder.ERROR;
            }

            return new Result(tableRow);
        }

        private Result(final Map<String, String> tableRow) {
            this.tableRow = (tableRow == null || tableRow.isEmpty()) ? null : ImmutableMap.copyOf(tableRow);
        }

        @Contract(pure = true)
        public boolean isError() {
            return tableRow == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("table_row", tableRow)
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
