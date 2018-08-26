package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.*;

import java.util.Arrays;

public final class SearchItems {

    private SearchItems() {}

    @Value
    public static class Request {

        @NonNull String tableName;
        int startIndex;
        int endIndex;
        @NonNull String fnDef;
        String params;

        @Builder
        private Request(
                final String tableName,
                final int startIndex,
                final int endIndex,
                final String fnDef,
                final String params) {

            this.tableName = tableName;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.fnDef = fnDef;
            this.params = params;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("table_name", tableName)
                    .add("start_index", startIndex)
                    .add("end_index", endIndex)
                    .add("fn_def", fnDef)
                    .add("params", params)
                    .toString();
        }
    }

    @Value
    public static class Result {

        @Getter(AccessLevel.NONE) int[] items_indices;

        @JsonCreator
        public Result(final @JsonProperty(value = "items_indices", required = true) int[] items_indices) {
            this.items_indices = items_indices;
        }

        public int[] getItemsIndices() {
            return items_indices.clone();
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("items_indices", Arrays.toString(items_indices))
                    .toString();
        }
    }
}
