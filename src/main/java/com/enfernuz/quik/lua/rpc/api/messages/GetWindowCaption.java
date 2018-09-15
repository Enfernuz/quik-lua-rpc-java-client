package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class GetWindowCaption {

    private GetWindowCaption() {}

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
    public static class Result {

        private static final String CAPTION_FIELD = "caption";

        String caption;

        @JsonCreator
        public static Result getInstance(@JsonProperty(CAPTION_FIELD) final String caption) {
            return isError(caption) ? InstanceHolder.ERROR : new Result(caption);
        }

        public static Result getErrorInstance() {
            return InstanceHolder.ERROR;
        }

        private Result(final String caption) {
            this.caption = caption;
        }

        @Contract(pure = true)
        public boolean isError() {
            return isError(caption);
        }

        @Contract(value = "null -> true; !null -> false", pure = true)
        private static boolean isError(final String caption) {
            return caption == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(CAPTION_FIELD, caption)
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
