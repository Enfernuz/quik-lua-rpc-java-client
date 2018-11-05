package com.enfernuz.quik.lua.rpc.api.messages.datasource;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.*;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SetUpdateCallback implements RemoteProcedure {

    private SetUpdateCallback() {}

    @JsonPropertyOrder({
            Args.DATASOURCE_UUID,
            Args.CALLBACK_FUNCTION_DEFINITION,
            Args.WATCHING_O,
            Args.WATCHING_H,
            Args.WATCHING_L,
            Args.WATCHING_C,
            Args.WATCHING_V,
            Args.WATCHING_T,
            Args.WATCHING_SIZE
    })
    @EqualsAndHashCode
    public static class Args implements RpcArgs<SetUpdateCallback> {

        private static final String DATASOURCE_UUID = "datasource_uuid";
        private static final String CALLBACK_FUNCTION_DEFINITION = "f_cb_def";
        private static final String WATCHING_O = "watching_O";
        private static final String WATCHING_H = "watching_H";
        private static final String WATCHING_L = "watching_L";
        private static final String WATCHING_C = "watching_C";
        private static final String WATCHING_V = "watching_V";
        private static final String WATCHING_T = "watching_T";
        private static final String WATCHING_SIZE = "watching_Size";

        @JsonProperty(DATASOURCE_UUID)
        private final String datasourceUUID;

        @JsonProperty(CALLBACK_FUNCTION_DEFINITION)
        private final String fCbDef;

        @JsonProperty(WATCHING_O)
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private final boolean watchingO;

        @JsonProperty(WATCHING_H)
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private final boolean watchingH;

        @JsonProperty(WATCHING_L)
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private final boolean watchingL;

        @JsonProperty(WATCHING_C)
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private final boolean watchingC;

        @JsonProperty(WATCHING_V)
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private final boolean watchingV;

        @JsonProperty(WATCHING_T)
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private final boolean watchingT;

        @JsonProperty(WATCHING_SIZE)
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private final boolean watchingSize;

        @JsonCreator
        @Builder
        private Args(
                @NonNull final String datasourceUUID,
                final String fCbDef,
                final boolean watchingO,
                final boolean watchingH,
                final boolean watchingL,
                final boolean watchingC,
                final boolean watchingV,
                final boolean watchingT,
                final boolean watchingSize) {

            this.datasourceUUID = datasourceUUID;
            this.fCbDef = fCbDef;
            this.watchingO = watchingO;
            this.watchingH = watchingH;
            this.watchingL = watchingL;
            this.watchingC = watchingC;
            this.watchingV = watchingV;
            this.watchingT = watchingT;
            this.watchingSize = watchingSize;
        }

        @JsonIgnore
        @NotNull
        public String getDatasourceUUID() {
            return datasourceUUID;
        }

        @JsonIgnore
        @Nullable
        public String getCallbackFunctionDefinition() {
            return fCbDef;
        }

        @JsonIgnore
        public boolean isWatchingO() {
            return watchingO;
        }

        @JsonIgnore
        public boolean isWatchingH() {
            return watchingH;
        }

        @JsonIgnore
        public boolean isWatchingL() {
            return watchingL;
        }

        @JsonIgnore
        public boolean isWatchingC() {
            return watchingC;
        }

        @JsonIgnore
        public boolean isWatchingV() {
            return watchingV;
        }

        @JsonIgnore
        public boolean isWatchingT() {
            return watchingT;
        }

        @JsonIgnore
        public boolean isWatchingSize() {
            return watchingSize;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(DATASOURCE_UUID, datasourceUUID)
                    .add(CALLBACK_FUNCTION_DEFINITION, fCbDef)
                    .add(WATCHING_O, watchingO)
                    .add(WATCHING_H, watchingH)
                    .add(WATCHING_L, watchingL)
                    .add(WATCHING_C, watchingC)
                    .add(WATCHING_V,watchingV)
                    .add(WATCHING_T, watchingT)
                    .add(WATCHING_SIZE, watchingSize)
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
