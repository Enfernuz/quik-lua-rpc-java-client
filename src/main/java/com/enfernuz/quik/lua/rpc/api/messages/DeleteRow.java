package com.enfernuz.quik.lua.rpc.api.messages;

import com.google.common.base.MoreObjects;
import lombok.Value;

public final class DeleteRow {

    private DeleteRow() {}

    @Value
    public static class Request {

        int tId;
        int key;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("t_id", tId)
                    .add("key", key)
                    .toString();
        }
    }

    @Value
    public static class Result {

        boolean result;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("result", result)
                    .toString();
        }
    }
}
