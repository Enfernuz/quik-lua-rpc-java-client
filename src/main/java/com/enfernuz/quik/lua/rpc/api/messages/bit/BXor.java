package com.enfernuz.quik.lua.rpc.api.messages.bit;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.util.Arrays;

public final class BXor {

    private BXor() {}

    @Value
    public static class Request {

        int x1;
        int x2;
        @Getter(AccessLevel.NONE) int[] xi;

        @Builder
        private Request(final int x1, final int x2, final int[] xi) {
            this.x1 = x1;
            this.x2 = x2;
            this.xi = (xi == null) ? null : xi.clone();
        }

        public int[] getXi() {
            return (xi == null) ? null : xi.clone();
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("x1", x1)
                    .add("x2", x2)
                    .add("xi", Arrays.toString(xi))
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
}
