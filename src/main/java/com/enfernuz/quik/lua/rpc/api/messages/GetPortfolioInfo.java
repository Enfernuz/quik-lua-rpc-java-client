package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.enfernuz.quik.lua.rpc.api.structures.PortfolioInfo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class GetPortfolioInfo implements RemoteProcedure {

    @JsonPropertyOrder({Args.FIRM_ID, Args.CLIENT_CODE})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetPortfolioInfo> {

        private static final String FIRM_ID = "firm_id";
        private static final String CLIENT_CODE = "client_code";

        @JsonProperty(FIRM_ID)
        private final String firmId;

        @JsonProperty(CLIENT_CODE)
        private final String clientCode;

        @Builder
        private Args(@NonNull final String firmId, @NonNull final String clientCode) {
            this.firmId = firmId;
            this.clientCode = clientCode;
        }

        @JsonIgnore
        public String getFirmId() {
            return firmId;
        }

        @JsonIgnore
        public String getClientCode() {
            return clientCode;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(FIRM_ID, firmId)
                    .add(CLIENT_CODE, clientCode)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetPortfolioInfo> {

        private static final String PORTFOLIO_INFO = "portfolio_info";

        PortfolioInfo portfolioInfo;

        @JsonCreator
        public Result(@JsonProperty(value = PORTFOLIO_INFO, required = true) @NonNull final PortfolioInfo portfolioInfo) {
            this.portfolioInfo = portfolioInfo;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(PORTFOLIO_INFO, portfolioInfo)
                    .toString();
        }
    }
}
