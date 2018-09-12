package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.MoneyLimit;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class GetMoneyEx {

    private GetMoneyEx() {}

    @Value
    public static class Request {

        String firmId;
        String clientCode;
        String tag;
        String currCode;
        int limitKind;

        @Builder
        private Request(final @NonNull String firmId,
                        final @NonNull String clientCode,
                        final @NonNull String tag,
                        final @NonNull String currCode,
                        int limitKind) {

            this.firmId = firmId;
            this.clientCode = clientCode;
            this.tag = tag;
            this.currCode = currCode;
            this.limitKind = limitKind;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("firmid", firmId)
                    .add("client_code", clientCode)
                    .add("tag", tag)
                    .add("currcode", currCode)
                    .add("limit_kind", limitKind)
                    .toString();
        }
    }

    @Value
    public static class Result {

        @Nullable MoneyLimit moneyEx;

        @JsonCreator
        public static Result getInstance(@JsonProperty(value = "money_ex") final MoneyLimit moneyEx) {
            return (moneyEx == null) ? InstanceHolder.ERROR : new Result(moneyEx);
        }

        private Result(final MoneyLimit moneyEx) {
            this.moneyEx = moneyEx;
        }

        public boolean isError() {
            return moneyEx == null;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("money_ex", moneyEx)
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
