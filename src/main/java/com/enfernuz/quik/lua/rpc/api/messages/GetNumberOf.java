package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class GetNumberOf implements RemoteProcedure {

    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetNumberOf> {

        private static final String TABLE_NAME = "table_name";

        @JsonProperty(TABLE_NAME)
        private final String tableName;

        public Args(@NonNull final String tableName) {
            this.tableName = tableName;
        }

        @JsonIgnore
        public String getTableName() {
            return tableName;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(TABLE_NAME, tableName)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetNumberOf> {

        private static final String RESULT = "result";

        int result;

        @JsonCreator
        public Result(@JsonProperty(value = RESULT, required = true) final int result) {
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
