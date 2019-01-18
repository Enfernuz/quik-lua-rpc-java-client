package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.*;
import com.google.common.base.MoreObjects;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public final class SearchItems implements RemoteProcedure {

    private SearchItems() {}

    @JsonPropertyOrder({Args.TABLE_NAME, Args.START_INDEX, Args.END_INDEX, Args.FUNCTION_DEFINITION, Args.PARAMS})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<SearchItems> {

        private static final String TABLE_NAME = "table_name";
        private static final String START_INDEX = "start_index";
        private static final String END_INDEX = "end_index";
        private static final String FUNCTION_DEFINITION = "fn_def";
        private static final String PARAMS = "params";

        @JsonProperty(TABLE_NAME)
        private final String tableName;

        @JsonProperty(START_INDEX)
        private final int startIndex;

        @JsonProperty(END_INDEX)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private final Integer endIndex;

        @JsonProperty(FUNCTION_DEFINITION)
        private final String fnDef;

        @JsonProperty(PARAMS)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private final String params;

        @Builder
        private Args(
                @NonNull final String tableName,
                final int startIndex,
                final Integer endIndex,
                @NonNull final String fnDef,
                final String params) {

            this.tableName = tableName;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.fnDef = fnDef;
            this.params = params;
        }

        @JsonIgnore
        public String getTableName() {
            return tableName;
        }

        @JsonIgnore
        public int getStartIndex() {
            return startIndex;
        }

        @JsonIgnore
        public Integer getEndIndex() {
            return endIndex;
        }

        @JsonIgnore
        public String getFnDef() {
            return fnDef;
        }

        @JsonIgnore
        public String getParams() {
            return params;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(TABLE_NAME, tableName)
                    .add(START_INDEX, startIndex)
                    .add(END_INDEX, endIndex)
                    .add(FUNCTION_DEFINITION, fnDef)
                    .add(PARAMS, params)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<SearchItems> {

        private static final String ITEMS_INDICES = "items_indices";

        @Getter(AccessLevel.NONE)
        int[] items_indices;

        @JsonCreator
        public static Result getInstance(@JsonProperty(ITEMS_INDICES) final int[] items_indices) {

            if (items_indices == null) {
                return getNullInstance();
            } else if (items_indices.length == 0) {
                return getEmptyInstance();
            }

            return new Result(items_indices);
        }

        public static Result getNullInstance() {
            return InstanceHolder.NULL_INSTANCE;
        }

        public static Result getEmptyInstance() {
            return InstanceHolder.EMPTY_INSTANCE;
        }

        private Result(final int[] items_indices) {
            this.items_indices = items_indices;
        }

        @Nullable
        public int[] getItemsIndices() {

            if (items_indices == null) {
                return null;
            } else if (items_indices.length == 0) {
                return items_indices;
            }

            return items_indices.clone();
        }

        public boolean isNull() {
            return items_indices == null;
        }

        public boolean isEmpty() {
            return items_indices != null && items_indices.length == 0;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(ITEMS_INDICES, Arrays.toString(items_indices))
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result NULL_INSTANCE = new Result(null);
            private static final Result EMPTY_INSTANCE = new Result(new int[] {});

            // sanity check
            static {
                assert NULL_INSTANCE.isNull();
                assert EMPTY_INSTANCE.isEmpty();
            }
        }
    }
}
