package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class GetLinesCount implements RemoteProcedure {

    private GetLinesCount() {}

    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetLinesCount> {

        private static final String TAG = "tag";

        @JsonProperty(TAG)
        private final String tag;

        public Args(@NonNull final String tag) {
            this.tag = tag;
        }

        @JsonIgnore
        public String getTag() {
            return tag;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(TAG, tag)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetLinesCount> {

        private static final String LINES_COUNT = "lines_count";

        int linesCount;

        @JsonCreator
        public Result(@JsonProperty(value = LINES_COUNT, required = true) final int linesCount) {
            this.linesCount = linesCount;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(LINES_COUNT, linesCount)
                    .toString();
        }
    }
}
