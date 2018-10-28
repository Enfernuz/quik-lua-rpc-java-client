package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class GetWindowRect implements RemoteProcedure {

    private GetWindowRect() {}

    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetWindowRect> {

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
    public static class Result implements RpcResult<GetWindowRect> {

        private static final String WINDOW_RECT = "window_rect";

        WindowRect windowRect;

        @JsonCreator
        public static Result getInstance(@JsonProperty(WINDOW_RECT) final WindowRect windowRect) {
            return isError(windowRect) ? InstanceHolder.ERROR : new Result(windowRect);
        }

        public static Result getErrorInstance() {
            return InstanceHolder.ERROR;
        }

        private Result(final WindowRect windowRect) {
            this.windowRect = windowRect;
        }

        public boolean isError() {
            return isError(windowRect);
        }

        @Contract(value = "null -> true; !null -> false", pure = true)
        private static boolean isError(final WindowRect windowRect) {
            return windowRect == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(WINDOW_RECT, windowRect)
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

    @Value
    public static class WindowRect {

        private static final String TOP = "top";
        private static final String LEFT = "left";
        private static final String BOTTOM = "bottom";
        private static final String RIGHT = "right";

        int top;
        int left;
        int bottom;
        int right;

        @JsonCreator
        @Builder
        private WindowRect(
                @JsonProperty(value = TOP, required = true) final int top,
                @JsonProperty(value = LEFT, required = true) final int left,
                @JsonProperty(value = BOTTOM, required = true) final int bottom,
                @JsonProperty(value = RIGHT, required = true) final int right) {

            this.top = top;
            this.left = left;
            this.bottom = bottom;
            this.right = right;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(TOP, top)
                    .add(LEFT, left)
                    .add(BOTTOM, bottom)
                    .add(RIGHT, right)
                    .toString();
        }
    }
}
