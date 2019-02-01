package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import lombok.*;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;

public final class SendTransaction implements RemoteProcedure {

    private SendTransaction() {}

    public static final class Args implements RpcArgs<SendTransaction> {

        private static final String TRANSACTION = "transaction";

        @JsonProperty(TRANSACTION)
        private final Map<String, String> transaction;

        @Getter(AccessLevel.NONE)
        @NonFinal
        private transient int hashCode;

        @Getter(AccessLevel.NONE)
        @NonFinal
        private transient String asString;

        public Args(@NonNull @NotNull final Map<String, String> transaction) {
            this.transaction = ImmutableMap.copyOf(transaction);
        }

        @NotNull
        @JsonIgnore
        public Map<String, String> getTransaction() {
            return transaction;
        }

        @Override
        public boolean equals(final Object o) {

            if (o == this) {
                return true;
            } else if ( !(o instanceof Args) ) {
                return false;
            } else {
                final Args request = (Args) o;
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
                        .add(TRANSACTION, transaction)
                        .toString();
            }

            return asString;
        }
    }

    @Value
    public static class Result implements RpcResult<SendTransaction> {

        private static final String RESULT = "result";

        String result;

        @JsonCreator
        public Result(@JsonProperty(value = RESULT, required = true) @NonNull final String result) {
            this.result = result;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(RESULT, result)
                    .toString();
        }
    }
}
