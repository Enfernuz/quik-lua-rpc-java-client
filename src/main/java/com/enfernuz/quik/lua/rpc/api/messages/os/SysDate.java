package com.enfernuz.quik.lua.rpc.api.messages.os;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;

public final class SysDate {

    private SysDate() {}

    public static enum Request { INSTANCE; }

    @Value
    public static class Result {

        @NonNull DateTimeEntry result;

        @JsonCreator
        public Result(final @JsonProperty(value = "result", required = true) DateTimeEntry result) {
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
