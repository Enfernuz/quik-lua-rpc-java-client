package com.enfernuz.quik.lua.rpc.api.messages.datasource;

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

public final class Size implements RemoteProcedure {

    private Size() {}

    @EqualsAndHashCode
    public static final class Args implements RpcArgs<Size> {

        private static final String DATASOURCE_UUID = "datasource_uuid";

        @JsonProperty(DATASOURCE_UUID)
        private final String datasourceUUID;

        public Args(@NonNull final String datasourceUUID) {
            this.datasourceUUID = datasourceUUID;
        }

        @JsonIgnore
        public String getDatasourceUUID() {
            return datasourceUUID;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(DATASOURCE_UUID, datasourceUUID)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<Size> {

        private static final String VALUE = "value";

        int value;

        @JsonCreator
        public Result(final @JsonProperty(value = VALUE, required = true) int value) {
            this.value = value;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(VALUE, value)
                    .toString();
        }
    }
}
