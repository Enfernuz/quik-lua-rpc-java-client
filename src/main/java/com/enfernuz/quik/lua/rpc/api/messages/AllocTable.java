package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Value;

public final class AllocTable {

    private AllocTable() {}

    public enum Request { INSTANCE; }

    @Value
    public static class Result {

        int tId;

        @JsonCreator
        public Result(@JsonProperty(value = "t_id", required = true) int tId) {
            this.tId = tId;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("t_id", tId)
                    .toString();
        }
    }
}
