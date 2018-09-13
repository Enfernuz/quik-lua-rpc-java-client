package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class GetNumCandles {

    private GetNumCandles() {}

    @Value
    public static class Request {

        String tag;

        public Request(@NonNull final String tag) {
            this.tag = tag;
        }

        @NotNull
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
        public Result(@JsonProperty(value = "num_candles", required = true) final int numCandles) {
            this.numCandles = numCandles;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("num_candles", numCandles)
                    .toString();
        }
    }
}
