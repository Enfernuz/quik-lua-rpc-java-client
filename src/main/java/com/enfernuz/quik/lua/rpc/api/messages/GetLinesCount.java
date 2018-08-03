package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;

public final class GetLinesCount {

    private GetLinesCount() {}

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

        int linesCount;

        @JsonCreator
        public Result(final @JsonProperty(value = "lines_count", required = true) int linesCount) {
            this.linesCount = linesCount;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("lines_count", linesCount)
                    .toString();
        }
    }
}
