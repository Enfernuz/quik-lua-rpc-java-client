package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.MoneyLimit;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

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


        MoneyLimit moneyEx;

        @JsonCreator
        public Result(final @JsonProperty(value = "money_ex", required = true) @NonNull MoneyLimit moneyEx) {
            this.moneyEx = moneyEx;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("money_ex", moneyEx)
                    .toString();
        }
    }
}
