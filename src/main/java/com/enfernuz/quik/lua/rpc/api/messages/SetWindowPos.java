package com.enfernuz.quik.lua.rpc.api.messages;

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

public final class SetWindowPos implements RemoteProcedure {

    private SetWindowPos() {}

    @JsonPropertyOrder({Args.T_ID, Args.X, Args.Y, Args.DX, Args.DY})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<SetWindowPos> {

        private static final String T_ID = "t_id";
        private static final String X = "x";
        private static final String Y = "y";
        private static final String DX = "dx";
        private static final String DY = "dy";

        @JsonProperty(T_ID)
        private final int tId;

        @JsonProperty(X)
        private final int x;

        @JsonProperty(Y)
        private final int y;

        @JsonProperty(DX)
        private final int dx;

        @JsonProperty(DY)
        private final int dy;

        @Builder
        private Args(
                final int tId,
                final int x,
                final int y,
                final int dx,
                final int dy) {

            this.tId = tId;
            this.x = x;
            this.y = y;
            this.dx = dx;
            this.dy = dy;
        }

        @JsonIgnore
        public int getTId() {
            return tId;
        }

        @JsonIgnore
        public int getX() {
            return x;
        }

        @JsonIgnore
        public int getY() {
            return y;
        }

        @JsonIgnore
        public int getDX() {
            return dx;
        }

        @JsonIgnore
        public int getDY() {
            return dy;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(T_ID, tId)
                    .add(X, x)
                    .add(Y, y)
                    .add(DX, dx)
                    .add(DY, dy)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<SetWindowPos> {

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
