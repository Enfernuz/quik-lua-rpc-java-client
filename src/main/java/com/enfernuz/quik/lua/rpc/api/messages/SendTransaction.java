package com.enfernuz.quik.lua.rpc.api.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Map;
import java.util.Objects;

public final class SendTransaction {

    private SendTransaction() {}

    @Value
    public static class Request {

        Map<String, String> transaction;

        private transient @NonFinal @Getter(AccessLevel.NONE) int hashCode;
        private transient @NonFinal @Getter(AccessLevel.NONE) String asString;

        public Request(final Map<String, String> transaction) {
            this.transaction = ImmutableMap.copyOf(transaction);
        }

        @Override
        public boolean equals(final Object o) {

            if (o == this) {
                return true;
            } else if ( !(o instanceof Request) ) {
                return false;
            } else {
                final Request request = (Request) o;
                return Objects.equals(transaction, request.transaction);
            }
        }

        @Override
        public int hashCode() {

            if (hashCode == 0) {
                hashCode = Objects.hash(transaction);
            }

            return hashCode;
        }

        @Override
        public String toString() {

            if (asString == null) {
                asString = MoreObjects.toStringHelper(this)
                        .add("transaction", transaction)
                        .toString();
            }

            return asString;
        }
    }

    @Value
    public static class Result {

        @NonNull String result;

        @JsonCreator
        public Result(final @JsonProperty(value = "result", required = true) String result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("result", result)
                    .toString();
        }
    }
}
