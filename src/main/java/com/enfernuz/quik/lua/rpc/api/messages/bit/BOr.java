package com.enfernuz.quik.lua.rpc.api.messages.bit;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.*;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public final class BOr implements RemoteProcedure {

    private BOr() {}

    @JsonPropertyOrder({Args.X_1, Args.X_2, Args.X_I})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<BOr> {

        private static final String X_1 = "x1";
        private static final String X_2 = "x2";
        private static final String X_I = "xi";

        @JsonProperty(X_1)
        private final long x1;

        @JsonProperty(X_2)
        private final long x2;

        @JsonProperty(X_I)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private final long[] xi;

        @Builder
        private Args(final long x1, final long x2, final long[] xi) {
            this.x1 = x1;
            this.x2 = x2;
            this.xi = (xi == null) ? null : xi.clone();
        }

        @JsonIgnore
        public long getX1() {
            return x1;
        }

        @JsonIgnore
        public long getX2() {
            return x2;
        }

        @JsonIgnore
        public long[] getXi() {
            return (xi == null) ? null : xi.clone();
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(X_1, x1)
                    .add(X_2, x2)
                    .add(X_I, Arrays.toString(xi))
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<BOr> {

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
