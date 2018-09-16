package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class IsConnected {

    private IsConnected() {}

    public enum Request { INSTANCE; }

    @Value
    public static class Result {

        private static final String IS_CONNECTED_FIELD = "is_connected";

        int isConnected;

        @JsonCreator
        public static Result getInstance(@JsonProperty(value = IS_CONNECTED_FIELD, required = true) final int isConnected) {

            switch (isConnected) {
                case 0:
                    return InstanceHolder.FALSE;
                case 1:
                    return InstanceHolder.TRUE;
                default:
                    return new Result(isConnected);
            }
        }

        private Result(final int isConnected) {
            this.isConnected = isConnected;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(IS_CONNECTED_FIELD, isConnected)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result TRUE = new Result(1);
            private static final Result FALSE = new Result(0);

            // sanity check
            static {
                assert TRUE.isConnected == 1;
                assert FALSE.isConnected == 0;
            }
        }
    }
}
