package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class RGB implements RemoteProcedure {

    private RGB() {}

    @JsonPropertyOrder({Args.RED, Args.GREEN, Args.BLUE})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<RGB> {

        private static final String RED = "red";
        private static final String GREEN = "green";
        private static final String BLUE = "blue";

        @JsonProperty(RED)
        private final int red;

        @JsonProperty(GREEN)
        private final int green;

        @JsonProperty(BLUE)
        private final int blue;

        @Builder
        private Args(final int red, final int green, final int blue) {

            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        @JsonIgnore
        public int getRed() {
            return red;
        }

        @JsonIgnore
        public int getGreen() {
            return green;
        }

        @JsonIgnore
        public int getBlue() {
            return blue;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(RED, red)
                    .add(GREEN, green)
                    .add(BLUE, blue)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<RGB> {

        private static final String RESULT = "result";

        int result;

        @JsonCreator
        public Result(@JsonProperty(value = RESULT, required = true) final int result) {
            this.result = result;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(RESULT, result)
                    .toString();
        }
    }
}
