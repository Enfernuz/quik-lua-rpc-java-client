package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesLimit;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

public final class GetFuturesLimit {

    private GetFuturesLimit() {}

    @Value
    public static class Request {

        String firmId;
        String trdAccId;
        int limitType;
        String currCode;

        @Builder
        private Request(
                @NonNull final String firmId,
                @NonNull final String trdAccId,
                final int limitType,
                @NonNull final String currCode) {

            this.firmId = firmId;
            this.trdAccId = trdAccId;
            this.limitType = limitType;
            this.currCode = currCode;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("firmid", firmId)
                    .add("trdaccid", trdAccId)
                    .add("limit_type", limitType)
                    .add("currcode", currCode)
                    .toString();
        }
    }

    @Value
    public static class Result {

        FuturesLimit futuresLimit;

        @JsonCreator
        public Result(final @JsonProperty(value = "futures_limit") FuturesLimit futuresLimit) {
            this.futuresLimit = futuresLimit;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("futures_limit", futuresLimit)
                    .toString();
        }
    }
}
