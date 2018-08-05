package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.PortfolioInfo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

public final class GetPortfolioInfo {

    @Value
    public static class Request {

        @NonNull String firmId;
        @NonNull String clientCode;

        @Builder
        private Request(final String firmId, final String clientCode) {
            this.firmId = firmId;
            this.clientCode = clientCode;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("firm_id", firmId)
                    .add("client_code", clientCode)
                    .toString();
        }
    }

    @Value
    public static class Result {

        PortfolioInfo portfolioInfo;

        @JsonCreator
        public Result(final @JsonProperty(value = "portfolio_info", required = true) @NonNull PortfolioInfo portfolioInfo) {
            this.portfolioInfo = portfolioInfo;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("portfolio_info", portfolioInfo)
                    .toString();
        }
    }
}
