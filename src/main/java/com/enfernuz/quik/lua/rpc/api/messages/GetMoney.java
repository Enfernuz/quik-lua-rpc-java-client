package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.structures.Money;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

public final class GetMoney {

    private GetMoney() {}

    @Value
    public static class Request {

        String clientCode;
        String firmId;
        String tag;
        String currCode;

        @Builder
        private Request(
                final @NonNull String clientCode,
                final @NonNull String firmId,
                final @NonNull String tag,
                final @NonNull String currCode) {

            this.clientCode = clientCode;
            this.firmId = firmId;
            this.tag = tag;
            this.currCode = currCode;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("client_code", clientCode)
                    .add("firmid", firmId)
                    .add("tag", tag)
                    .add("currcode", currCode)
                    .toString();
        }
    }

    @Value
    public static class Result {

        Money money;

        @JsonCreator
        public Result(@JsonProperty(value = "money", required = true) @NonNull final Money money) {
            this.money = money;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("money", money)
                    .toString();
        }
    }
}
