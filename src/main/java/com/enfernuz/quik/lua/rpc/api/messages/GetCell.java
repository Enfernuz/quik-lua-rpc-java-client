package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class GetCell {

    private GetCell() {}

    @Value
    public static class Request {

        int tId;
        int key;
        int code;

        @Builder
        private Request(final int tId, final int key, final int code) {
            this.tId = tId;
            this.key = key;
            this.code = code;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("t_id", tId)
                    .add("key", key)
                    .add("code", code)
                    .toString();
        }
    }

    @Value
    public static class Result {

        String image;
        String value;

        @JsonCreator
        @Builder
        private static Result getInstance(
                @JsonProperty("image") final String image,
                @JsonProperty("value") final String value) {

            return image == null && value == null ? InstanceHolder.ERROR : new Result(image, value);
        }

        private Result(final String image, final String value) {
            this.image = image;
            this.value = value;
        }

        @Contract(pure = true)
        public boolean isError() {
            return image == null && value == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("image", image)
                    .add("value", value)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result ERROR = new Result(null, null);

            // just in case
            static {
                assert ERROR.isError();
            }
        }
    }
}
