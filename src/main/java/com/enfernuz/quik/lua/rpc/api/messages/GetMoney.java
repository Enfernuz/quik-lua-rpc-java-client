package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.enfernuz.quik.lua.rpc.api.structures.Money;
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

public final class GetMoney implements RemoteProcedure {

    private GetMoney() {}

    @JsonPropertyOrder({Args.CLIENT_CODE, Args.FIRM_ID, Args.TAG, Args.CURR_CODE})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetMoney> {

        private static final String CLIENT_CODE = "client_code";
        private static final String FIRM_ID = "firmid";
        private static final String TAG = "tag";
        private static final String CURR_CODE = "currcode";

        @JsonProperty(CLIENT_CODE)
        private final String clientCode;

        @JsonProperty(FIRM_ID)
        private final String firmId;

        @JsonProperty(TAG)
        private final String tag;

        @JsonProperty(CURR_CODE)
        private final String currCode;

        @Builder
        private Args(
                @NonNull final String clientCode,
                @NonNull final String firmId,
                @NonNull final String tag,
                @NonNull final String currCode) {

            this.clientCode = clientCode;
            this.firmId = firmId;
            this.tag = tag;
            this.currCode = currCode;
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
        public String getTag() {
            return tag;
        }

        @JsonIgnore
        public String getCurrCode() {
            return currCode;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(CLIENT_CODE, clientCode)
                    .add(FIRM_ID, firmId)
                    .add(TAG, tag)
                    .add(CURR_CODE, currCode)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetMoney> {

        private static final String MONEY = "money";

        Money money;

        @JsonCreator
        public Result(@JsonProperty(value = MONEY, required = true) @NonNull final Money money) {
            this.money = money;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(MONEY, money)
                    .toString();
        }
    }
}
