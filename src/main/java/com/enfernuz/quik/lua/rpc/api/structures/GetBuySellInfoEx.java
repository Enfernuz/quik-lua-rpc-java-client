package com.enfernuz.quik.lua.rpc.api.structures;

import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;

import java.util.Objects;

public final class GetBuySellInfoEx {

    private GetBuySellInfoEx() {}

    @Value
    public static class Request {

        String firmId;
        String clientCode;
        String classCode;
        String secCode;
        String price;

        @Builder
        private Request(
                final @NonNull String firmId,
                final @NonNull String clientCode,
                final @NonNull String classCode,
                final @NonNull String secCode,
                final @NonNull String price) {

            this.firmId = firmId;
            this.clientCode = clientCode;
            this.classCode = classCode;
            this.secCode = secCode;
            this.price = price;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("firm_id", firmId)
                    .add("client_code", clientCode)
                    .add("class_code", classCode)
                    .add("sec_code", secCode)
                    .add("price", price)
                    .toString();
        }
    }

    @Value
    public static class Result {

        @NonNull BuySellInfoEx buySellInfoEx;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("buy_sell_info_ex", buySellInfoEx)
                    .toString();
        }
    }

    @Value
    public static class BuySellInfoEx {

        GetBuySellInfo.BuySellInfo buySellInfo;
        String limitKind;
        String dLong;
        String dMinLong;
        String dShort;
        String dMinShort;
        String clientType;
        String isLongAllowed;
        String isShortAllowed;

        private @NonFinal @Getter(AccessLevel.NONE) transient int hashCode;
        private @NonFinal @Getter(AccessLevel.NONE) transient String asString;

        @Builder
        private BuySellInfoEx(
                final @NonNull GetBuySellInfo.BuySellInfo buySellInfo,
                final String limitKind,
                final String dLong,
                final String dMinLong,
                final String dShort,
                final String dMinShort,
                final String clientType,
                final String isLongAllowed,
                final String isShortAllowed) {

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
                hashCode = Objects.hash(buySellInfo, limitKind, dLong, dMinLong, dShort, dMinShort, clientType, isLongAllowed, isShortAllowed);
            }

            return hashCode;
        }

        @Override
        public String toString() {

            if (asString == null) {
                asString = MoreObjects.toStringHelper(this)
                        .add("buy_sell_info", buySellInfo)
                        .add("limit_kind", limitKind)
                        .add("d_long", dLong)
                        .add("d_min_long", dMinLong)
                        .add("d_short", dShort)
                        .add("d_min_short", dMinShort)
                        .add("client_type", clientType)
                        .add("is_long_allowed", isLongAllowed)
                        .add("is_short_allowed", isShortAllowed)
                        .toString();
            }

            return asString;
        }
    }
}
