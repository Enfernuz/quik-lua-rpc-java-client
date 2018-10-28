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

public final class GetNumCandles implements RemoteProcedure {

    private GetNumCandles() {}

    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetNumCandles> {

        private static final String TAG = "tag";

        @JsonProperty(TAG)
        private final String tag;

        @JsonIgnore
        public String getTag() {
            return tag;
        }

        public Args(@NonNull final String tag) {
            this.tag = tag;
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
    public static class Result implements RpcResult<GetNumCandles> {

        private static final String NUM_CANDLES = "num_candles";

        int numCandles;

        @JsonCreator
        public Result(@JsonProperty(value = NUM_CANDLES, required = true) final int numCandles) {
            this.numCandles = numCandles;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(NUM_CANDLES, numCandles)
                    .toString();
        }
    }
}
