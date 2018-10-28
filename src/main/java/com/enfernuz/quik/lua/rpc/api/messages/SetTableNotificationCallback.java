package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class SetTableNotificationCallback implements RemoteProcedure {

    private SetTableNotificationCallback() {}

    @JsonPropertyOrder({Args.T_ID, Args.FUNCTION_CALLBACK_DEFINITION})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<SetTableNotificationCallback> {

        private static final String T_ID = "t_id";
        private static final String FUNCTION_CALLBACK_DEFINITION = "f_cb_def";

        @JsonProperty(T_ID)
        private final int tId;

        @JsonProperty(FUNCTION_CALLBACK_DEFINITION)
        private final String fCbDef;

        public Args(final int tId, @NonNull final String fCbDef) {

            this.tId = tId;
            this.fCbDef = fCbDef;
        }

        @JsonIgnore
        public int getTId() {
            return tId;
        }

        @JsonIgnore
        public String getFunctionCallbackDefinition() {
            return fCbDef;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(T_ID, tId)
                    .add(FUNCTION_CALLBACK_DEFINITION, fCbDef)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<SetTableNotificationCallback> {

        private static final String RESULT = "result";

        int result;

        @JsonCreator
        public static Result getInstance(@JsonProperty(value = RESULT, required = true) final int result) {

            if ( isOk(result) ) {
                return InstanceHolder.OK;
            } else if ( isError(result) ) {
                return InstanceHolder.ERROR;
            }

            return new Result(result);
        }

        public static Result getErrorInstance() {
            return InstanceHolder.ERROR;
        }

        public static Result getOkInstance() {
            return InstanceHolder.OK;
        }

        private Result(final int result) {
            this.result = result;
        }

        public boolean isError() {
            return isError(result);
        }

        public boolean isOk() {
            return isOk(result);
        }

        private static boolean isOk(final int result) {
            return result == 1;
        }

        private static boolean isError(final int result) {
            return result == 0;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(RESULT, result)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result OK = new Result(1);
            private static final Result ERROR = new Result(0);

            // sanity check
            static {
                assert !OK.isError() && OK.isOk();
                assert ERROR.isError() && !ERROR.isOk();
            }
        }
    }
}
