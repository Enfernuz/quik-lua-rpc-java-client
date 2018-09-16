package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class InsertRow {

    private InsertRow() {}

    @Value
    public static class Request {

        private static final String T_ID_FIELD = "t_id";
        private static final String KEY_FIELD = "key";

        int tId;
        int key;

        @Builder
        private Request(final int tId, final int key) {

            this.tId = tId;
            this.key = key;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(T_ID_FIELD, tId)
                    .add(KEY_FIELD, key)
                    .toString();
        }
    }

    @Value
    public static class Result {

        private static final String RESULT_FIELD = "result";

        int result;

        @JsonCreator
        public Result(final @JsonProperty(value = RESULT_FIELD, required = true) int result) {
            this.result = result;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(RESULT_FIELD, result)
                    .toString();
        }
    }
}
