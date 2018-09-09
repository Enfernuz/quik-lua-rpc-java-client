package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesClientHolding;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

public final class GetFuturesHolding {

    private GetFuturesHolding() {}

    @Value
    public static class Request {

        String firmId;
        String trdAccId;
        String secCode;
        int type;

        @Builder
        private Request(
                final @NonNull String firmId,
                final @NonNull String trdAccId,
                final @NonNull String secCode,
                final int type) {

            this.firmId = firmId;
            this.trdAccId = trdAccId;
            this.secCode = secCode;
            this.type = type;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("firmid", firmId)
                    .add("trdaccid", trdAccId)
                    .add("sec_code", secCode)
                    .add("type", type)
                    .toString();
        }
    }

    @Value
    public static class Result {

        FuturesClientHolding futuresHolding;

        @JsonCreator
        public Result(@JsonProperty(value = "futures_holding") final FuturesClientHolding futuresHolding) {
            this.futuresHolding = futuresHolding;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("futures_holding", futuresHolding)
                    .toString();
        }
    }
}
