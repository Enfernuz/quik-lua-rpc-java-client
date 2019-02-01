package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.enfernuz.quik.lua.rpc.api.structures.FuturesLimit;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class GetFuturesLimit implements RemoteProcedure {

    private GetFuturesLimit() {}

    @JsonPropertyOrder({Args.FIRM_ID, Args.TRD_ACC_ID, Args.LIMIT_TYPE, Args.CURR_CODE})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetFuturesLimit> {

        private static final String FIRM_ID = "firmid";
        private static final String TRD_ACC_ID = "trdaccid";
        private static final String LIMIT_TYPE = "limit_type";
        private static final String CURR_CODE = "currcode";

        @JsonProperty(FIRM_ID)
        private final String firmId;

        @JsonProperty(TRD_ACC_ID)
        private final String trdAccId;

        @JsonProperty(LIMIT_TYPE)
        private final int limitType;

        @JsonProperty(CURR_CODE)
        private final String currCode;

        @Builder
        private Args(
                @NonNull final String firmId,
                @NonNull final String trdAccId,
                final int limitType,
                @NonNull final String currCode) {

            this.firmId = firmId;
            this.trdAccId = trdAccId;
            this.limitType = limitType;
            this.currCode = currCode;
        }

        @JsonIgnore
        public String getFirmId() {
            return firmId;
        }

        @JsonIgnore
        public String getTrdAccId() {
            return trdAccId;
        }

        @JsonIgnore
        public int getLimitType() {
            return limitType;
        }

        @JsonIgnore
        public String getCurrCode() {
            return currCode;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(FIRM_ID, firmId)
                    .add(TRD_ACC_ID, trdAccId)
                    .add(LIMIT_TYPE, limitType)
                    .add(CURR_CODE, currCode)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetFuturesLimit> {

        private static final String FUTURES_LIMIT = "futures_limit";

        FuturesLimit futuresLimit;

        @JsonCreator
        public static Result getInstance(@JsonProperty(FUTURES_LIMIT) final FuturesLimit futuresLimit) {
            return futuresLimit == null ? InstanceHolder.ERROR : new Result(futuresLimit);
        }

        private Result(final FuturesLimit futuresLimit) {
            this.futuresLimit = futuresLimit;
        }

        public boolean isError() {
            return futuresLimit == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(FUTURES_LIMIT, futuresLimit)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result ERROR = new Result(null);

            // sanity check
            static {
                assert ERROR.isError();
            }
        }
    }
}
