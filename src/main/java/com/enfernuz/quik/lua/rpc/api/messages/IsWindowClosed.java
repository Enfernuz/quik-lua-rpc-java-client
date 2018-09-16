package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class IsWindowClosed {

    private IsWindowClosed() {}

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
    public static class WindowClosed {

        private static final String RESULT_FIELD = "result";

        boolean result;

        @JsonCreator
        public static WindowClosed getInstance(@JsonProperty(value = RESULT_FIELD, required = true) final boolean result) {
            return result ? InstanceHolder.TRUE : InstanceHolder.FALSE;
        }

        private WindowClosed(final boolean result) {
            this.result = result;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(RESULT_FIELD, result)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final WindowClosed TRUE = new WindowClosed(true);
            private static final WindowClosed FALSE = new WindowClosed(false);

            // sanity check
            static {
                assert TRUE.result;
                assert !FALSE.result;
            }
        }
    }

    @Value
    public static class Result {

        private static final String WINDOW_CLOSED_FIELD = "window_closed";

        WindowClosed windowClosed;

        @JsonCreator
        public static Result getInstance(@JsonProperty(value = WINDOW_CLOSED_FIELD, required = true) final WindowClosed windowClosed) {

            if (isError(windowClosed)) {
                return InstanceHolder.ERROR;
            }

            return windowClosed.result ? InstanceHolder.TRUE : InstanceHolder.FALSE;
        }

        public static Result getErrorInstance() {
            return InstanceHolder.ERROR;
        }

        private Result(final WindowClosed windowClosed) {
            this.windowClosed = windowClosed;
        }

        @Contract(pure = true)
        public boolean isError() {
            return isError(windowClosed);
        }

        @Contract(value = "null -> true; !null -> false", pure = true)
        private static boolean isError(final WindowClosed windowClosed) {
            return windowClosed == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(WINDOW_CLOSED_FIELD, windowClosed)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result TRUE = new Result(WindowClosed.getInstance(true));
            private static final Result FALSE = new Result(WindowClosed.getInstance(false));
            private static final Result ERROR = new Result(null);

            // sanity check
            static {
                assert !TRUE.isError() && TRUE.windowClosed.result;
                assert !FALSE.isError() && !FALSE.windowClosed.result;
                assert ERROR.isError();
            }
        }
    }
}
