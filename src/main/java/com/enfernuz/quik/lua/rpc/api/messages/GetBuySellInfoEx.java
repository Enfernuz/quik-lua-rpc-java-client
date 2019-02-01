package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class GetBuySellInfoEx implements RemoteProcedure {

    private GetBuySellInfoEx() {}

    @JsonPropertyOrder({Args.FIRM_ID, Args.CLIENT_CODE, Args.CLASS_CODE, Args.SEC_CODE, Args.PRICE})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetBuySellInfoEx> {

        private static final String FIRM_ID = "firm_id";
        private static final String CLIENT_CODE = "client_code";
        private static final String CLASS_CODE = "class_code";
        private static final String SEC_CODE = "sec_code";
        private static final String PRICE = "price";

        @JsonProperty(FIRM_ID)
        private final String firmId;

        @JsonProperty(CLIENT_CODE)
        private final String clientCode;

        @JsonProperty(CLASS_CODE)
        private final String classCode;

        @JsonProperty(SEC_CODE)
        private final String secCode;

        @JsonProperty(PRICE)
        private final String price;

        @Builder
        private Args(
                @NonNull final String firmId,
                @NonNull final String clientCode,
                @NonNull final String classCode,
                @NonNull final String secCode,
                @NonNull final String price) {

            this.firmId = firmId;
            this.clientCode = clientCode;
            this.classCode = classCode;
            this.secCode = secCode;
            this.price = price;
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
        public String getClassCode() {
            return classCode;
        }

        @JsonIgnore
        public String getSecCode() {
            return secCode;
        }

        @JsonIgnore
        public String getPrice() {
            return price;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(FIRM_ID, firmId)
                    .add(CLIENT_CODE, clientCode)
                    .add(CLASS_CODE, classCode)
                    .add(SEC_CODE, secCode)
                    .add(PRICE, price)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetBuySellInfoEx> {

        private static final String BUY_SELL_INFO_EX = "buy_sell_info_ex";

        BuySellInfoEx buySellInfoEx;

        @JsonCreator
        public Result(@JsonProperty(value = BUY_SELL_INFO_EX, required = true) @NonNull final BuySellInfoEx buySellInfoEx) {
            this.buySellInfoEx = buySellInfoEx;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(BUY_SELL_INFO_EX, buySellInfoEx)
                    .toString();
        }
    }

    @Value
    public static class BuySellInfoEx {

        private static final String BUY_SELL_INFO = "buy_sell_info";
        private static final String LIMIT_KIND = "limit_kind";
        private static final String D_LONG = "d_long";
        private static final String D_MIN_LONG = "d_min_long";
        private static final String D_SHORT = "d_short";
        private static final String D_MIN_SHORT = "d_min_short";
        private static final String CLIENT_TYPE = "client_type";
        private static final String IS_LONG_ALLOWED = "is_long_allowed";
        private static final String IS_SHORT_ALLOWED = "is_short_allowed";

        GetBuySellInfo.BuySellInfo buySellInfo;
        String limitKind;
        String dLong;
        String dMinLong;
        String dShort;
        String dMinShort;
        String clientType;
        String isLongAllowed;
        String isShortAllowed;

        @Getter(AccessLevel.NONE)
        @NonFinal
        private transient int hashCode;

        @Getter(AccessLevel.NONE)
        @NonFinal
        private transient String asString;

        @JsonCreator
        @Builder
        private BuySellInfoEx(
                @JsonProperty(value = BUY_SELL_INFO, required = true) @NonNull final GetBuySellInfo.BuySellInfo buySellInfo,
                @JsonProperty(LIMIT_KIND) final String limitKind,
                @JsonProperty(D_LONG) final String dLong,
                @JsonProperty(D_MIN_LONG) final String dMinLong,
                @JsonProperty(D_SHORT) final String dShort,
                @JsonProperty(D_MIN_SHORT) final String dMinShort,
                @JsonProperty(CLIENT_TYPE) final String clientType,
                @JsonProperty(IS_LONG_ALLOWED) final String isLongAllowed,
                @JsonProperty(IS_SHORT_ALLOWED) final String isShortAllowed) {

            this.buySellInfo = buySellInfo;
            this.limitKind = limitKind;
            this.dLong = dLong;
            this.dMinLong = dMinLong;
            this.dShort = dShort;
            this.dMinShort = dMinShort;
            this.clientType = clientType;
            this.isLongAllowed = isLongAllowed;
            this.isShortAllowed = isShortAllowed;
        }

        @Override
        public boolean equals(final Object o) {

            if (o == this) {
                return true;
            } else if ( !(o instanceof BuySellInfoEx) ) {
                return false;
            } else {
                final BuySellInfoEx that = (BuySellInfoEx) o;
                return Objects.equals(buySellInfo, that.buySellInfo) &&
                        Objects.equals(limitKind, that.limitKind) &&
                        Objects.equals(dLong, that.dLong) &&
                        Objects.equals(dMinLong, that.dMinLong) &&
                        Objects.equals(dShort, that.dShort) &&
                        Objects.equals(dMinShort, that.dMinShort) &&
                        Objects.equals(clientType, that.clientType) &&
                        Objects.equals(isLongAllowed, that.isLongAllowed) &&
                        Objects.equals(isShortAllowed, that.isShortAllowed);
            }
        }

        @Override
        public int hashCode() {

            if (hashCode == 0) {
                hashCode = Objects.hash(
                        buySellInfo,
                        limitKind,
                        dLong,
                        dMinLong,
                        dShort,
                        dMinShort,
                        clientType,
                        isLongAllowed,
                        isShortAllowed
                );
            }

            return hashCode;
        }

        @NotNull
        @Override
        public String toString() {

            if (asString == null) {
                asString = MoreObjects.toStringHelper(this)
                        .add(BUY_SELL_INFO, buySellInfo)
                        .add(LIMIT_KIND, limitKind)
                        .add(D_LONG, dLong)
                        .add(D_MIN_LONG, dMinLong)
                        .add(D_SHORT, dShort)
                        .add(D_MIN_SHORT, dMinShort)
                        .add(CLIENT_TYPE, clientType)
                        .add(IS_LONG_ALLOWED, isLongAllowed)
                        .add(IS_SHORT_ALLOWED, isShortAllowed)
                        .toString();
            }

            return asString;
        }
    }
}
