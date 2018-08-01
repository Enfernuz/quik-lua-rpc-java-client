package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.sun.istack.internal.NotNull;
import lombok.Builder;
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
                final @NotNull String firmId,
                final @NotNull String trdAccId,
                final @NotNull int limitType,
                final @NotNull String currCode) {

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
        public Result(final @JsonProperty(value = "futures_limit", required = true) @NotNull FuturesLimit futuresLimit) {
            this.futuresLimit = futuresLimit;
        }
    }
}
