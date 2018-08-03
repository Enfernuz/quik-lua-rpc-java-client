package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.Depo;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

public final class GetDepo {

    private GetDepo() {}

    @Value
    public static class Request {

        String clientCode;
        String firmId;
        String secCode;
        String trdAccId;

        @Builder
        private Request(
                final @NonNull String clientCode,
                final @NonNull String firmId,
                final @NonNull String secCode,
                final @NonNull String trdAccId) {

            this.clientCode = clientCode;
            this.firmId = firmId;
            this.secCode = secCode;
            this.trdAccId = trdAccId;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("client_code", clientCode)
                    .add("firmid", firmId)
                    .add("sec_code", secCode)
                    .add("trdaccid", trdAccId)
                    .toString();
        }
    }

    @Value
    public static class Result {

        @NonNull
        Depo depo;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("depo", depo)
                    .toString();
        }
    }
}