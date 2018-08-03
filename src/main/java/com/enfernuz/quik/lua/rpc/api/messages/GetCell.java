package com.enfernuz.quik.lua.rpc.api.messages;

import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

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

        @Builder
        private Result(final @NonNull String image, final @NonNull String value) {
            this.image = image;
            this.value = value;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("image", image)
                    .add("value", value)
                    .toString();
        }
    }
}
