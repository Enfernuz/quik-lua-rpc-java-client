package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

public final class SetCell {

    private SetCell() {}

    @Value
    public static class Request {

        int tId;
        int key;
        int code;
        @NonNull String text;
        double value;

        @Builder
        private Request(
                final int tId,
                final int key,
                final int code,
                final String text,
                final double value) {

            this.tId = tId;
            this.key = key;
            this.code = code;
            this.text = text;
            this.value = value;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("t_id", tId)
                    .add("key", key)
                    .add("code", code)
                    .add("text", text)
                    .add("value", value)
                    .toString();
        }
    }

    @Value
    public static class Result {

        boolean result;

        @JsonCreator
        public Result(final @JsonProperty(value = "result", required = true) boolean result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("result", result)
                    .toString();
        }
    }
}
