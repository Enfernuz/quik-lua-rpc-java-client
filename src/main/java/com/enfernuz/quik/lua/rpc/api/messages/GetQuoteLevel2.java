package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import lombok.*;
import lombok.experimental.NonFinal;

import java.util.List;
import java.util.Objects;

public final class GetQuoteLevel2 {

    @Value
    public static class QuoteEntry {

        @NonNull String price;
        @NonNull String quantity;

        private @NonFinal @Getter(AccessLevel.NONE) transient int hashCode;
        private @NonFinal @Getter(AccessLevel.NONE) transient String asString;

        @Builder
        @JsonCreator
        private QuoteEntry(
                final @JsonProperty(value = "price", required = true) String price,
                final @JsonProperty(value = "quantity", required = true) String quantity) {

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
                        .add("price", price)
                        .add("quantity", quantity)
                        .toString();
            }

            return asString;
        }
    }

    @Value
    public static class Request {

        @NonNull String classCode;
        @NonNull String secCode;

        @Builder
        private Request(final String classCode, final String secCode) {
            this.classCode = classCode;
            this.secCode = secCode;
        }

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

        @NonNull String bidCount;
        @NonNull String offerCount;
        @NonNull List<QuoteEntry> bids;
        @NonNull List<QuoteEntry> offers;

        private @NonFinal @Getter(AccessLevel.NONE) transient int hashCode;
        private @NonFinal @Getter(AccessLevel.NONE) transient String asString;

        @Builder
        @JsonCreator
        private Result(
                final @JsonProperty(value = "bid_count", required = true) String bidCount,
                final @JsonProperty(value = "offer_count", required = true) String offerCount,
                final @JsonProperty(value = "bids", required = true) Iterable<? extends QuoteEntry> bids,
                final @JsonProperty(value = "offers", required = true) Iterable<? extends QuoteEntry> offers) {

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
                        .add("bid_count", bidCount)
                        .add("offer_count", offerCount)
                        .add("bids", bids)
                        .add("offers", offers)
                        .toString();
            }

            return asString;
        }
    }
}
