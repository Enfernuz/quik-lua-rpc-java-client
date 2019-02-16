package com.enfernuz.quik.lua.rpc.api.messages.bit;

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

public final class ToHex implements RemoteProcedure {

    private ToHex() {}

    @JsonPropertyOrder({Args.X, Args.N})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<ToHex> {

        private static final String X = "x";
        private static final String N = "n";

        @JsonProperty(X)
        private final long x;

        @JsonProperty(N)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private final Integer n;

        @Builder
        private Args(final long x, final Integer n) {
            this.x = x;
            this.n = n;
        }

        @JsonIgnore
        public long getX() {
            return x;
        }

        @JsonIgnore
        public Integer getN() {
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
    public static class Result implements RpcResult<ToHex> {

        private static final String RESULT = "result";

        String result;

        @JsonCreator
        public Result(@JsonProperty(value = RESULT, required = true) @NonNull final String result) {
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
