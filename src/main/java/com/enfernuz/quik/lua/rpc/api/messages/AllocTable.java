package com.enfernuz.quik.lua.rpc.api.messages;

import com.google.common.base.MoreObjects;
import lombok.Value;

public final class AllocTable {

    private AllocTable() {}

    public static enum Request { INSTANCE; }

    @Value
    public static class Result {

        int tId;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("t_id", tId)
                    .toString();
        }
    }
}