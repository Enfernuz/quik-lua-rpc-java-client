package com.enfernuz.quik.lua.rpc.api.messages.datasource;

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
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class SetUpdateCallback implements RemoteProcedure {

    private SetUpdateCallback() {}

    @JsonPropertyOrder({Args.DATASOURCE_UUID, Args.CALLBACK_FUNCTION_DEFINITION})
    @EqualsAndHashCode
    public static class Args implements RpcArgs<SetUpdateCallback> {

        private static final String DATASOURCE_UUID = "datasource_uuid";
        private static final String CALLBACK_FUNCTION_DEFINITION = "f_cb_def";

        @JsonProperty(DATASOURCE_UUID)
        private final String datasourceUUID;

        @JsonProperty(CALLBACK_FUNCTION_DEFINITION)
        private final String fCbDef;

        @Builder
        private Args(@NonNull final String datasourceUUID, @NonNull final String fCbDef) {
            this.datasourceUUID = datasourceUUID;
            this.fCbDef = fCbDef;
        }

        @JsonIgnore
        public String getDatasourceUUID() {
            return datasourceUUID;
        }

        @JsonIgnore
        public String getCallbackFunctionDefinition() {
            return fCbDef;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(DATASOURCE_UUID, datasourceUUID)
                    .add(CALLBACK_FUNCTION_DEFINITION, fCbDef)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<SetUpdateCallback> {

        private static final String RESULT = "result";

        boolean result;

        @JsonCreator
        public static Result getInstance(@JsonProperty(value = RESULT, required = true) final boolean result) {
            return result ? InstanceHolder.TRUE : InstanceHolder.FALSE;
        }

        private Result(final boolean result) {
            this.result = result;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(RESULT, result)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result TRUE = new Result(true);
            private static final Result FALSE = new Result(false);

            // sanity check
            static {
                assert TRUE.result;
                assert !FALSE.result;
            }
        }
    }
}
