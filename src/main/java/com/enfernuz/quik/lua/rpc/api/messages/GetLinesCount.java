package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class GetLinesCount {

    private GetLinesCount() {}

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

        int linesCount;

        @JsonCreator
        public Result(@JsonProperty(value = "lines_count", required = true) final int linesCount) {
            this.linesCount = linesCount;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("lines_count", linesCount)
                    .toString();
        }
    }
}
