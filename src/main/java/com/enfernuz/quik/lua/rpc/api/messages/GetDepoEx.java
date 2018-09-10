package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.DepoLimit;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class GetDepoEx {

    private GetDepoEx() {}

    @Value
    public static class Request {

        String firmId;
        String clientCode;
        String secCode;
        String trdAccId;
        int limitKind;

        @Builder
        private Request(
                final @NonNull String firmId,
                final @NonNull String clientCode,
                final @NonNull String secCode,
                final @NonNull String trdAccId,
                final int limitKind) {

            this.firmId = firmId;
            this.clientCode = clientCode;
            this.secCode = secCode;
            this.trdAccId = trdAccId;
            this.limitKind = limitKind;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("firmid", firmId)
                    .add("client_code", clientCode)
                    .add("sec_code", secCode)
                    .add("trdaccid", trdAccId)
                    .add("limit_kind", limitKind)
                    .toString();
        }
    }

    @Value
    public static class Result {

        DepoLimit depoEx;

        @JsonCreator
        public static Result getInstance(@JsonProperty("depo_ex") final DepoLimit depoEx) {
            return depoEx == null ? InstanceHolder.ERROR : new Result(depoEx);
        }

        private Result(final DepoLimit depoEx) {
            this.depoEx = depoEx;
        }

        @Contract(pure = true)
        public boolean isError() {
            return depoEx == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("depo_ex", depoEx)
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
