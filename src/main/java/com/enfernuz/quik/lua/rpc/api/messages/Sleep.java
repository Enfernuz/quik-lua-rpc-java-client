package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class Sleep implements RemoteProcedure {

    private Sleep() {}

    @EqualsAndHashCode
    public static final class Args implements RpcArgs<Sleep> {

        private static final String TIME = "time";

        @JsonProperty(TIME)
        private final long time;

        public Args(final long time) {
            this.time = time;
        }

        public long getTime() {
            return time;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(TIME, time)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<Sleep> {

        private static final String RESULT = "result";

        Long result;

        @JsonCreator
        public static Result getInstance(@JsonProperty(RESULT) final Long result) {

            if ( isError(result) ) {
                return InstanceHolder.ERROR;
            }

            return new Result(result);
        }

        public static Result getErrorInstance() {
            return InstanceHolder.ERROR;
        }

        private Result(final Long result) {
            this.result = result;
        }

        public boolean isError() {
            return isError(result);
        }

        @Contract(value = "null -> true; !null -> false", pure = true)
        private static boolean isError(final Long result) {
            return result == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(RESULT, result)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result ERROR = new Result(null);

            // sanity check
            static {
                assert ERROR.isError();
            }
        }
    }
}
