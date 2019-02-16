package com.enfernuz.quik.lua.rpc.api.messages.bit;

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

public final class Test implements RemoteProcedure {

    private Test() {}

    @JsonPropertyOrder({Args.X, Args.N})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<Test> {

        private static final String X = "x";
        private static final String N = "n";

        @JsonProperty(X)
        private final long x;

        @JsonProperty(N)
        private final int n;

        @Builder
        private Args(final long x, final int n) {
            this.x = x;
            this.n = n;
        }

        @JsonIgnore
        public long getX() {
            return x;
        }

        @JsonIgnore
        public int getN() {
            return n;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(X, x)
                    .add(N, n)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<Test> {

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
