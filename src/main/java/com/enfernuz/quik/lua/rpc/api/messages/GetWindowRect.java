package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class GetWindowRect {

    private GetWindowRect() {}

    @Value
    public static class Request {

        private static final String T_ID_FIELD = "t_id";

        int tId;

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(T_ID_FIELD, tId)
                    .toString();
        }
    }

    @Value
    public static class WindowRect {

        private static final String TOP_FIELD = "top";
        private static final String LEFT_FIELD = "left";
        private static final String BOTTOM_FIELD = "bottom";
        private static final String RIGHT_FIELD = "right";

        int top;
        int left;
        int bottom;
        int right;

        @Builder
        @JsonCreator
        private WindowRect(
                @JsonProperty(value = TOP_FIELD, required = true) final int top,
                @JsonProperty(value = LEFT_FIELD, required = true) final int left,
                @JsonProperty(value = BOTTOM_FIELD, required = true) final int bottom,
                @JsonProperty(value = RIGHT_FIELD, required = true) final int right) {

            this.top = top;
            this.left = left;
            this.bottom = bottom;
            this.right = right;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(TOP_FIELD, top)
                    .add(LEFT_FIELD, left)
                    .add(BOTTOM_FIELD, bottom)
                    .add(RIGHT_FIELD, right)
                    .toString();
        }
    }

    @Value
    public static class Result {

        private static final String WINDOW_RECT_FIELD = "window_rect";

        WindowRect windowRect;

        @JsonCreator
        public static Result getInstance(@JsonProperty(WINDOW_RECT_FIELD) final WindowRect windowRect) {
            return isError(windowRect) ? InstanceHolder.ERROR : new Result(windowRect);
        }

        public static Result getErrorInstance() {
            return InstanceHolder.ERROR;
        }

        private Result(final WindowRect windowRect) {
            this.windowRect = windowRect;
        }

        @Contract(pure = true)
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
                    .add(WINDOW_RECT_FIELD, windowRect)
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
