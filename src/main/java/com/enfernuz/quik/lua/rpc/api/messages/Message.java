package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;

public final class Message {

    private Message() {}

    @Value
    public static class Request {

        @NonNull String message;
        IconType iconType;

        public Request(final String message) {
            this(message, null);
        }

        public Request(final String message, final IconType iconType) {
            this.message = message;
            this.iconType = iconType;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("message", message)
                    .add("icon_type", iconType)
                    .toString();
        }
    }

    @Value
    public static class Result {

        int result;

        @JsonCreator
        public Result(final @JsonProperty(value = "result", required = true) int result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("result", result)
                    .toString();
        }
    }

    public static enum IconType {

        INFO(1),
        WARNING(2),
        ERROR(3);

        public final int value;

        IconType(final int value) {
            this.value = value;
        }
    }
}
