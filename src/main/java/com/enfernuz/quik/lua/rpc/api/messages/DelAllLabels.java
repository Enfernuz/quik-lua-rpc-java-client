package com.enfernuz.quik.lua.rpc.api.messages;

import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.Contract;

public final class DelAllLabels {

    private DelAllLabels() {}

    @Value
    public static class Request {

        @NonNull String chartTag;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("chart_tag", chartTag)
                    .toString();
        }
    }

    @Value
    public static class Result {

        boolean result;

        @Contract(pure = true)
        public static Result getInstance(final boolean result) {
            return result ? InstanceHolder.TRUE : InstanceHolder.FALSE;
        }

        private Result(final boolean result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("result", result)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result TRUE = new Result(true);
            private static final Result FALSE = new Result(false);

            static {
                assert TRUE.result == true;
                assert FALSE.result == false;
            }
        }
    }
}
