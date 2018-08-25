package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Value;

public final class PrintDbgStr {

    private PrintDbgStr() {}

    public static enum Request { INSTANCE; }

    @Value
    public static class Result {

        String s;

        public Result(final @JsonProperty("s") String s) {
            this.s = s;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("s", s)
                    .toString();
        }
    }
}
