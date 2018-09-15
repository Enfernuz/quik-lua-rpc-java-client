package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.PortfolioInfo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class GetPortfolioInfo {

    @Value
    public static class Request {

        String firmId;
        String clientCode;

        @Builder
        private Request(@NonNull final String firmId, @NonNull final String clientCode) {
            this.firmId = firmId;
            this.clientCode = clientCode;
        }

        @NotNull
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
        public Result(@JsonProperty(value = "portfolio_info", required = true) @NonNull final PortfolioInfo portfolioInfo) {
            this.portfolioInfo = portfolioInfo;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("portfolio_info", portfolioInfo)
                    .toString();
        }
    }
}
