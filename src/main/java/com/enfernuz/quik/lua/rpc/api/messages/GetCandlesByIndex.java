package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.CandleEntry;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.List;

public final class GetCandlesByIndex {

    private GetCandlesByIndex() {}

    @Value
    public static class Request {

        String tag;
        int line;
        int firstCandle;
        int count;

        @Builder
        private Request(
                final @NonNull String tag,
                final int line,
                final int firstCandle,
                final int count) {

            this.tag = tag;
            this.line = line;
            this.firstCandle = firstCandle;
            this.count = count;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("tag", tag)
                    .add("line", line)
                    .add("first_candle", firstCandle)
                    .add("count", count)
                    .toString();
        }
    }

    @Value
    public static class Result {

        List<CandleEntry> t;
        int n;
        String l;

        public Result(final @NonNull List<? extends CandleEntry> t, final int n, final String l) {
            this.t = ImmutableList.copyOf(t);
            this.n = n;
            this.l = l;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("t", t)
                    .add("n", n)
                    .add("l", l)
                    .toString();
        }
    }
}
