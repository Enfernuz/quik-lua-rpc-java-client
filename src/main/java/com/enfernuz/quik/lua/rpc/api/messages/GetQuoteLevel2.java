package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import lombok.*;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public final class GetQuoteLevel2 implements RemoteProcedure {

    private GetQuoteLevel2() {}

    @JsonPropertyOrder({Args.CLASS_CODE, Args.SEC_CODE})
    @EqualsAndHashCode
    public static final class Args implements RpcArgs<GetQuoteLevel2> {

        private static final String CLASS_CODE = "class_code";
        private static final String SEC_CODE = "sec_code";

        @JsonProperty(CLASS_CODE)
        private final String classCode;

        @JsonProperty(SEC_CODE)
        private final String secCode;

        @Builder
        private Args(@NonNull final String classCode, @NonNull final String secCode) {

            this.classCode = classCode;
            this.secCode = secCode;
        }

        @JsonIgnore
        public String getClassCode() {
            return classCode;
        }

        @JsonIgnore
        public String getSecCode() {
            return secCode;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(CLASS_CODE, classCode)
                    .add(SEC_CODE, secCode)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<GetQuoteLevel2> {

        private static final String BID_COUNT = "bid_count";
        private static final String OFFER_COUNT = "offer_count";
        private static final String BIDS = "bids";
        private static final String OFFERS = "offers";

        String bidCount;
        String offerCount;
        List<QuoteEntry> bids;
        List<QuoteEntry> offers;

        @Getter(AccessLevel.NONE)
        @NonFinal
        private transient int hashCode;

        @Getter(AccessLevel.NONE)
        @NonFinal
        private transient String asString;

        @JsonCreator
        @Builder
        private Result(
                @JsonProperty(value = BID_COUNT, required = true) @NonNull final String bidCount,
                @JsonProperty(value = OFFER_COUNT, required = true) @NonNull final String offerCount,
                @JsonProperty(value = BIDS, required = true) @NonNull final Iterable<? extends QuoteEntry> bids,
                @JsonProperty(value = OFFERS, required = true) @NonNull final Iterable<? extends QuoteEntry> offers) {

            this.bidCount = bidCount;
            this.offerCount = offerCount;
            this.bids = ImmutableList.copyOf(bids);
            this.offers = ImmutableList.copyOf(offers);
        }

        @Override
        public boolean equals(final Object o) {

            if (o == this) {
                return true;
            } else if ( !(o instanceof Result) ) {
                return false;
            } else {
                final Result result = (Result) o;
                return Objects.equals(bidCount, result.bidCount) &&
                        Objects.equals(offerCount, result.offerCount) &&
                        Objects.equals(bids, result.bids) &&
                        Objects.equals(offers, result.offers);
            }
        }

        @Override
        public int hashCode() {

            if (hashCode == 0) {
                hashCode = Objects.hash(bidCount, offerCount, bids, offers);
            }

            return hashCode;
        }

        @NotNull
        @Override
        public String toString() {

            if (asString == null) {
                asString = MoreObjects.toStringHelper(this)
                        .add(BID_COUNT, bidCount)
                        .add(OFFER_COUNT, offerCount)
                        .add(BIDS, bids)
                        .add(OFFERS, offers)
                        .toString();
            }

            return asString;
        }
    }

    @Value
    public static class QuoteEntry {

        private static final String PRICE = "price";
        private static final String QUANTITY = "quantity";

        String price;
        String quantity;

        @Getter(AccessLevel.NONE)
        @NonFinal
        private transient int hashCode;

        @Getter(AccessLevel.NONE)
        @NonFinal
        private transient String asString;

        @JsonCreator
        @Builder
        private QuoteEntry(
                @JsonProperty(value = PRICE, required = true) @NonNull final String price,
                @JsonProperty(value = QUANTITY, required = true) @NonNull final String quantity) {

            this.price = price;
            this.quantity = quantity;
        }

        @Override
        public boolean equals(final Object o) {

            if (o == this) {
                return true;
            } else if ( !(o instanceof QuoteEntry) ) {
                return false;
            } else {
                final QuoteEntry that = (QuoteEntry) o;
                return Objects.equals(price, that.price) &&
                        Objects.equals(quantity, that.quantity);
            }
        }

        @Override
        public int hashCode() {

            if (hashCode == 0) {
                hashCode = Objects.hash(price, quantity);
            }

            return hashCode;
        }

        @NotNull
        @Override
        public String toString() {

            if (asString == null) {
                asString = MoreObjects.toStringHelper(this)
                        .add(PRICE, price)
                        .add(QUANTITY, quantity)
                        .toString();
            }

            return asString;
        }
    }
}
