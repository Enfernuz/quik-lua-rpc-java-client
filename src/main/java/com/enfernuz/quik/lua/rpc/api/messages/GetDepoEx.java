package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.enfernuz.quik.lua.rpc.api.structures.DepoLimit;
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

public final class GetDepoEx implements RemoteProcedure {

    private GetDepoEx() {}

    @JsonPropertyOrder({ Args.FIRM_ID, Args.CLIENT_CODE, Args.SEC_CODE, Args.TRD_ACC_ID, Args.LIMIT_KIND})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetDepoEx> {

        private static final String FIRM_ID = "firmid";
        private static final String CLIENT_CODE = "client_code";
        private static final String SEC_CODE = "sec_code";
        private static final String TRD_ACC_ID = "trdaccid";
        private static final String LIMIT_KIND = "limit_kind";

        @JsonProperty(FIRM_ID)
        private final String firmId;

        @JsonProperty(CLIENT_CODE)
        private final String clientCode;

        @JsonProperty(SEC_CODE)
        private final String secCode;

        @JsonProperty(TRD_ACC_ID)
        private final String trdAccId;

        @JsonProperty(LIMIT_KIND)
        private final int limitKind;

        @Builder
        private Args(
                @NonNull final String firmId,
                @NonNull final String clientCode,
                @NonNull final String secCode,
                @NonNull final String trdAccId,
                final int limitKind) {

            this.firmId = firmId;
            this.clientCode = clientCode;
            this.secCode = secCode;
            this.trdAccId = trdAccId;
            this.limitKind = limitKind;
        }

        @JsonIgnore
        public String getClientCode() {
            return clientCode;
        }

        @JsonIgnore
        public String getFirmId() {
            return firmId;
        }

        @JsonIgnore
        public String getSecCode() {
            return secCode;
        }

        @JsonIgnore
        public String getTrdAccId() {
            return trdAccId;
        }

        @JsonIgnore
        public int getLimitKind() {
            return limitKind;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(FIRM_ID, firmId)
                    .add(CLIENT_CODE, clientCode)
                    .add(SEC_CODE, secCode)
                    .add(TRD_ACC_ID, trdAccId)
                    .add(LIMIT_KIND, limitKind)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetDepoEx> {

        private static final String DEPO_EX = "depo_ex";

        DepoLimit depoEx;

        @JsonCreator
        public static Result getInstance(@JsonProperty(value = DEPO_EX) final DepoLimit depoEx) {
            return depoEx == null ? InstanceHolder.ERROR : new Result(depoEx);
        }

        private Result(final DepoLimit depoEx) {
            this.depoEx = depoEx;
        }

        public boolean isError() {
            return depoEx == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(DEPO_EX, depoEx)
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
