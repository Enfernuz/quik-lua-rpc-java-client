package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.Value;

public final class SetSelectedRow {

    private SetSelectedRow() {}

    @Value
    public static class Request {

        int tableId;
        int row;

        @Builder
        private Request(final int tableId, final int row) {
            this.tableId = tableId;
            this.row = row;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("table_id", tableId)
                    .add("row", row)
                    .toString();
        }
    }

    @Value
    public static class Result {

        int result;

        @JsonCreator
        public Result(final @JsonProperty(value = "result", required = true) int result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("result", result)
                    .toString();
        }
    }
}
