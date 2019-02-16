package com.enfernuz.quik.lua.rpc.api.messages.bit;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class BNot implements RemoteProcedure {

    private BNot() {}

    @EqualsAndHashCode
    public static final class Args implements RpcArgs<BNot> {

        private static final String X = "x";

        @JsonProperty(X)
        private final long x;

        public Args(final long x) {
            this.x = x;
        }

        @JsonIgnore
        public long getX() {
            return x;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(X, x)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<BNot> {

        private static final String RESULT = "result";

        long result;

        @JsonCreator
        public Result(final @JsonProperty(value = RESULT, required = true) long result) {
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
