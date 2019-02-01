package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class IsWindowClosed implements RemoteProcedure {

    private IsWindowClosed() {}

    @EqualsAndHashCode
    public static final class Args implements RpcArgs<IsWindowClosed> {

        private static final String T_ID = "t_id";

        @JsonProperty(T_ID)
        private final int tId;

        public Args(final int tId) {
            this.tId = tId;
        }

        @JsonIgnore
        public int getTId() {
            return tId;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(T_ID, tId)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<IsWindowClosed> {

        private static final String WINDOW_CLOSED = "window_closed";

        Boolean windowClosed;

        @JsonCreator
        public static Result getInstance(@JsonProperty(WINDOW_CLOSED) final Boolean windowClosed) {

            if (isError(windowClosed)) {
                return InstanceHolder.ERROR;
            }

            return windowClosed ? InstanceHolder.TRUE : InstanceHolder.FALSE;
        }

        public static Result getErrorInstance() {
            return InstanceHolder.ERROR;
        }

        private Result(final Boolean windowClosed) {
            this.windowClosed = windowClosed;
        }

        public boolean isError() {
            return isError(windowClosed);
        }

        @Contract(value = "null -> true; !null -> false", pure = true)
        private static boolean isError(final Boolean windowClosed) {
            return windowClosed == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(WINDOW_CLOSED, windowClosed)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result TRUE = new Result(Boolean.TRUE);
            private static final Result FALSE = new Result(Boolean.FALSE);
            private static final Result ERROR = new Result(null);

            // sanity check
            static {
                assert !TRUE.isError() && TRUE.windowClosed;
                assert !FALSE.isError() && !FALSE.windowClosed;
                assert ERROR.isError();
            }
        }
    }
}
