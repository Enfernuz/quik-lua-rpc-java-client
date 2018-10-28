package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.enfernuz.quik.lua.rpc.api.structures.MoneyLimit;
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

public final class GetMoneyEx implements RemoteProcedure {

    private GetMoneyEx() {}

    @JsonPropertyOrder({Args.FIRM_ID, Args.CLIENT_CODE, Args.TAG, Args.CURR_CODE, Args.LIMIT_KIND})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetMoneyEx> {

        private static final String FIRM_ID = "firmid";
        private static final String CLIENT_CODE = "client_code";
        private static final String TAG = "tag";
        private static final String CURR_CODE = "currcode";
        private static final String LIMIT_KIND = "limit_kind";

        @JsonProperty(FIRM_ID)
        private final String firmId;

        @JsonProperty(CLIENT_CODE)
        private final String clientCode;

        @JsonProperty(TAG)
        private final String tag;

        @JsonProperty(CURR_CODE)
        private final String currCode;

        @JsonProperty(LIMIT_KIND)
        private final int limitKind;

        @Builder
        private Args(@NonNull final String firmId,
                     @NonNull final String clientCode,
                     @NonNull final String tag,
                     @NonNull final String currCode,
                        int limitKind) {

            this.firmId = firmId;
            this.clientCode = clientCode;
            this.tag = tag;
            this.currCode = currCode;
            this.limitKind = limitKind;
        }

        @JsonIgnore
        public String getFirmId() {
            return firmId;
        }

        @JsonIgnore
        public String getClientCode() {
            return clientCode;
        }

        @JsonIgnore
        public String getTag() {
            return tag;
        }

        @JsonIgnore
        public String getCurrCode() {
            return currCode;
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
                    .add(TAG, tag)
                    .add(CURR_CODE, currCode)
                    .add(LIMIT_KIND, limitKind)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetMoneyEx> {

        private static final String MONEY_EX = "money_ex";

        MoneyLimit moneyEx;

        @JsonCreator
        public static Result getInstance(@JsonProperty(value = MONEY_EX, required = true) final MoneyLimit moneyEx) {
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
                    .add(MONEY_EX, moneyEx)
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
