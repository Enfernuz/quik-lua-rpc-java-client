package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.FuturesLimit;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class GetFuturesLimit {

    private GetFuturesLimit() {}

    @Value
    public static class Request {

        String firmId;
        String trdAccId;
        int limitType;
        String currCode;

        @Builder
        private Request(
                @NonNull final String firmId,
                @NonNull final String trdAccId,
                final int limitType,
                @NonNull final String currCode) {

            this.firmId = firmId;
            this.trdAccId = trdAccId;
            this.limitType = limitType;
            this.currCode = currCode;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("firmid", firmId)
                    .add("trdaccid", trdAccId)
                    .add("limit_type", limitType)
                    .add("currcode", currCode)
                    .toString();
        }
    }

    @Value
    public static class Result {

        FuturesLimit futuresLimit;

        @JsonCreator
        public static Result getInstance(@JsonProperty("futures_limit") final FuturesLimit futuresLimit) {
            return futuresLimit == null ? InstanceHolder.ERROR : new Result(futuresLimit);
        }

        private Result(final FuturesLimit futuresLimit) {
            this.futuresLimit = futuresLimit;
        }

        @Contract(pure = true)
        public boolean isError() {
            return futuresLimit == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("futures_limit", futuresLimit)
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
