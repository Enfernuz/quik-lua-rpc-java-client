package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;

public final class GetNumCandles {

    private GetNumCandles() {}

    @Value
    public static class Request {

        @NonNull String tag;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("tag", tag)
                    .toString();
        }
    }

    @Value
    public static class Result {

        int numCandles;

        @JsonCreator
        public Result(final @JsonProperty(value = "num_candles", required = true) int numCandles) {
            this.numCandles = numCandles;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("num_candles", numCandles)
                    .toString();
        }
    }
}
