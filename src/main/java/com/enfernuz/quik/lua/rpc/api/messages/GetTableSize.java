package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.Value;

public final class GetTableSize {

    @Value
    public static class Request {

       int tId;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("t_id", tId)
                    .toString();
        }
    }

    @Value
    public static class Result {

        int rows;
        int col;

        @Builder
        @JsonCreator
        private Result(final @JsonProperty("rows") int rows, final @JsonProperty("col") int col) {
            this.rows = rows;
            this.col = col;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("rows", rows)
                    .add("col", col)
                    .toString();
        }
    }
}
