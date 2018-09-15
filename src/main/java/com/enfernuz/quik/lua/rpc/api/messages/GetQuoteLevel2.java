package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import lombok.*;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public final class GetQuoteLevel2 {

    private GetQuoteLevel2() {}

    @Value
    public static class QuoteEntry {

        private static final String PRICE_FIELD = "price";
        private static final String QUANTITY_FIELD = "quantity";

        String price;
        String quantity;

        private @NonFinal @Getter(AccessLevel.NONE) transient int hashCode;
        private @NonFinal @Getter(AccessLevel.NONE) transient String asString;

        @Builder
        @JsonCreator
        private QuoteEntry(
                @JsonProperty(value = PRICE_FIELD, required = true) @NonNull final String price,
                @JsonProperty(value = QUANTITY_FIELD, required = true) @NonNull final String quantity) {

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

        @Override
        public String toString() {

            if (asString == null) {
                asString = MoreObjects.toStringHelper(this)
                        .add(PRICE_FIELD, price)
                        .add(QUANTITY_FIELD, quantity)
                        .toString();
            }

            return asString;
        }
    }

    @Value
    public static class Request {

        String classCode;
        String secCode;

        @Builder
        private Request(@NonNull final String classCode, @NonNull final String secCode) {
            this.classCode = classCode;
            this.secCode = secCode;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("class_code", classCode)
                    .add("sec_code", secCode)
                    .toString();
        }
    }

    @Value
    public static class Result {

        private static final String BID_COUNT_FIELD = "bid_count";
        private static final String OFFER_COUNT_FIELD = "offer_count";
        private static final String BIDS_FIELD = "bids";
        private static final String OFFERS_FIELD = "offers";

        String bidCount;
        String offerCount;
        List<QuoteEntry> bids;
        List<QuoteEntry> offers;

        private @NonFinal @Getter(AccessLevel.NONE) transient int hashCode;
        private @NonFinal @Getter(AccessLevel.NONE) transient String asString;

        @Builder
        @JsonCreator
        private Result(
                @JsonProperty(value = BID_COUNT_FIELD, required = true) @NonNull final String bidCount,
                @JsonProperty(value = OFFER_COUNT_FIELD, required = true) @NonNull final String offerCount,
                @JsonProperty(value = BIDS_FIELD, required = true) @NonNull final Iterable<? extends QuoteEntry> bids,
                @JsonProperty(value = OFFERS_FIELD, required = true) @NonNull final Iterable<? extends QuoteEntry> offers) {

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

        @Override
        public String toString() {

            if (asString == null) {
                asString = MoreObjects.toStringHelper(this)
                        .add(BID_COUNT_FIELD, bidCount)
                        .add(OFFER_COUNT_FIELD, offerCount)
                        .add(BIDS_FIELD, bids)
                        .add(OFFERS_FIELD, offers)
                        .toString();
            }

            return asString;
        }
    }
}
