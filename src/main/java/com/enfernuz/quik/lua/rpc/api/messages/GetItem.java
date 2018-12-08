package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public final class GetItem implements RemoteProcedure {

    private GetItem() {}

    @JsonPropertyOrder({Args.TABLE_NAME, Args.INDEX})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetItem> {

        private static final String TABLE_NAME = "table_name";
        private static final String INDEX = "index";

        @JsonProperty(TABLE_NAME)
        private final String tableName;

        @JsonProperty(INDEX)
        private final int index;

        public Args(@NonNull final String tableName, final int index) {
            this.tableName = tableName;
            this.index = index;
        }

        @JsonIgnore
        public String getTableName() {
            return tableName;
        }

        @JsonIgnore
        public int getIndex() {
            return index;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(TABLE_NAME, tableName)
                    .add(INDEX, index)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetItem> {

        private static final String TABLE_ROW = "table_row";

        Map<String, String> tableRow;

        @JsonCreator
        public static Result getInstance(@JsonProperty(TABLE_ROW) final Map<String, String> tableRow) {

            if (tableRow == null) {
                return InstanceHolder.ERROR;
            }

            return new Result(tableRow);
        }

        private Result(final Map<String, String> tableRow) {
            this.tableRow = (tableRow == null) ? null : ImmutableMap.copyOf(tableRow);
        }

        public boolean isError() {
            return tableRow == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(TABLE_ROW, tableRow)
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
