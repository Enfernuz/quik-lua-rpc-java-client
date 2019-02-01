package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.enfernuz.quik.lua.rpc.api.structures.Depo;
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

public final class GetDepo implements RemoteProcedure {

    private GetDepo() {}

    @JsonPropertyOrder({Args.CLIENT_CODE, Args.FIRM_ID, Args.SEC_CODE, Args.TRD_ACC_ID})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetDepo> {

        private static final String CLIENT_CODE = "client_code";
        private static final String FIRM_ID = "firmid";
        private static final String SEC_CODE = "sec_code";
        private static final String TRD_ACC_ID = "trdaccid";

        @JsonProperty(CLIENT_CODE)
        private final String clientCode;

        @JsonProperty(FIRM_ID)
        private final String firmId;

        @JsonProperty(SEC_CODE)
        private final String secCode;

        @JsonProperty(TRD_ACC_ID)
        private final String trdAccId;

        @Builder
        private Args(
                @NonNull final String clientCode,
                @NonNull final String firmId,
                @NonNull final String secCode,
                @NonNull final String trdAccId) {

            this.clientCode = clientCode;
            this.firmId = firmId;
            this.secCode = secCode;
            this.trdAccId = trdAccId;
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

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(CLIENT_CODE, clientCode)
                    .add(FIRM_ID, firmId)
                    .add(SEC_CODE, secCode)
                    .add(TRD_ACC_ID, trdAccId)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetDepo> {

        private static final String DEPO = "depo";

        Depo depo;

        @JsonCreator
        public Result(@JsonProperty(value = DEPO, required = true) @NonNull final Depo depo) {
            this.depo = depo;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(DEPO, depo)
                    .toString();
        }
    }
}