package com.enfernuz.quik.lua.rpc.api.structures;

import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

public final class Message {

    private Message() {}

    @Value
    public static class Request {

        String message;
        IconType iconType;

        @Builder
        private Request(final @NonNull String message, final @NonNull IconType iconType) {
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
