package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.enfernuz.quik.lua.rpc.api.structures.FuturesClientHolding;
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

public final class GetFuturesHolding implements RemoteProcedure {

    private GetFuturesHolding() {}

    @JsonPropertyOrder({Args.FIRM_ID, Args.TRD_ACC_ID, Args.SEC_CODE, Args.TYPE})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetFuturesHolding> {

        private static final String FIRM_ID = "firmid";
        private static final String TRD_ACC_ID = "trdaccid";
        private static final String SEC_CODE = "sec_code";
        private static final String TYPE = "type";

        @JsonProperty(FIRM_ID)
        private final String firmId;

        @JsonProperty(TRD_ACC_ID)
        private final String trdAccId;

        @JsonProperty(SEC_CODE)
        private final String secCode;

        @JsonProperty(TYPE)
        private final int type;

        @Builder
        private Args(
                @NonNull final String firmId,
                @NonNull final String trdAccId,
                @NonNull final String secCode,
                final int type) {

            this.firmId = firmId;
            this.trdAccId = trdAccId;
            this.secCode = secCode;
            this.type = type;
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
        public String getSecCode() {
            return secCode;
        }

        @JsonIgnore
        public int getType() {
            return type;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(FIRM_ID, firmId)
                    .add(TRD_ACC_ID, trdAccId)
                    .add(SEC_CODE, secCode)
                    .add(TYPE, type)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetFuturesHolding> {

        private static final String FUTURES_HOLDING = "futures_holding";

        FuturesClientHolding futuresHolding;

        @JsonCreator
        public static Result getInstance(@JsonProperty(FUTURES_HOLDING) final FuturesClientHolding futuresHolding) {
            return futuresHolding == null ? InstanceHolder.ERROR : new Result(futuresHolding);
        }

        private Result(final FuturesClientHolding futuresHolding) {
            this.futuresHolding = futuresHolding;
        }

        @Contract(pure = true)
        public boolean isError() {
            return futuresHolding == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(FUTURES_HOLDING, futuresHolding)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result ERROR = new Result(null);

            // just in case
            static {
                assert ERROR.isError();
            }
        }
    }
}
