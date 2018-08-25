package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Value;

public final class GetWindowCaption {

    private GetWindowCaption() {}

    @Value
    public static class Request {

        int tId;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("t_id", tId)
                    .toString();
        }
    }

    @Value
    public static class Result {

        String caption;

        @JsonCreator
        public Result(final @JsonProperty("caption") String caption) {
            this.caption = caption;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("caption", caption)
                    .toString();
        }
    }
}
