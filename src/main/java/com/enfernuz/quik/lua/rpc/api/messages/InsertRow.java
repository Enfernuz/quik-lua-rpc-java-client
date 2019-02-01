package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class InsertRow implements RemoteProcedure {

    private InsertRow() {}

    @JsonPropertyOrder({Args.T_ID, Args.KEY})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<InsertRow> {

        private static final String T_ID = "t_id";
        private static final String KEY = "key";

        @JsonProperty(T_ID)
        private final int tId;

        @JsonProperty(KEY)
        private final int key;

        @Builder
        private Args(final int tId, final int key) {

            this.tId = tId;
            this.key = key;
        }

        @JsonIgnore
        public int getTId() {
            return tId;
        }

        @JsonIgnore
        public int getKey() {
            return key;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(T_ID, tId)
                    .add(KEY, key)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<InsertRow> {

        private static final String RESULT = "result";

        int result;

        @JsonCreator
        public Result(final @JsonProperty(value = RESULT, required = true) int result) {
            this.result = result;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(RESULT, result)
                    .toString();
        }
    }
}
