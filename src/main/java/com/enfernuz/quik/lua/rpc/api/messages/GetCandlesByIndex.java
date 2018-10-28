package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.enfernuz.quik.lua.rpc.api.structures.CandleEntry;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class GetCandlesByIndex implements RemoteProcedure {

    private GetCandlesByIndex() {}

    @JsonPropertyOrder({Args.TAG, Args.LINE, Args.FIRST_CANDLE, Args.COUNT})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetCandlesByIndex> {

        private static final String TAG = "tag";
        private static final String LINE = "line";
        private static final String FIRST_CANDLE = "first_candle";
        private static final String COUNT = "count";

        @JsonProperty(TAG)
        private final String tag;

        @JsonProperty(LINE)
        private final int line;

        @JsonProperty(FIRST_CANDLE)
        private final int firstCandle;

        @JsonProperty(COUNT)
        private final int count;

        @Builder
        private Args(
                @NonNull final String tag,
                final int line,
                final int firstCandle,
                final int count) {

            this.tag = tag;
            this.line = line;
            this.firstCandle = firstCandle;
            this.count = count;
        }

        @JsonIgnore
        public String getTag() {
            return tag;
        }

        @JsonIgnore
        public int getLine() {
            return line;
        }

        @JsonIgnore
        public int getFirstCandle() {
            return firstCandle;
        }

        @JsonIgnore
        public int getCount() {
            return count;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(TAG, tag)
                    .add(LINE, line)
                    .add(FIRST_CANDLE, firstCandle)
                    .add(COUNT, count)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetCandlesByIndex> {

        private static final String T = "t";
        private static final String N = "n";
        private static final String L = "l";

        List<CandleEntry> t;
        int n;
        String l;

        @JsonCreator
        public Result(@JsonProperty(value = T, required = true) @NonNull final List<? extends CandleEntry> t,
                      @JsonProperty(value = N, required = true) final int n,
                      @JsonProperty(value = L, required = true) final String l) {

            this.t = ImmutableList.copyOf(t);
            this.n = n;
            this.l = l;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(T, t)
                    .add(N, n)
                    .add(L, l)
                    .toString();
        }
    }
}
