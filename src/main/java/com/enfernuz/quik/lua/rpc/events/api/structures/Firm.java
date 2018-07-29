package com.enfernuz.quik.lua.rpc.events.api.structures;

import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class Firm {

    String firmId;
    String firmName;
    int status;
    String exchange;

    private @NonFinal @Getter(AccessLevel.NONE) transient int hashCode;
    private @NonFinal @Getter(AccessLevel.NONE) transient String asString;

    @Builder
    private Firm(@NonNull final String firmId, final String firmName, int status, final String exchange) {
        this.firmId = firmId;
        this.firmName = firmName;
        this.status = status;
        this.exchange = exchange;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof Firm) ) {
            return false;
        } else {
            final Firm other = (Firm) o;
            return Integer.compare(status, other.status) == 0
                    && Objects.equals(firmId, other.firmId)
                    && Objects.equals(exchange, other.exchange)
                    && Objects.equals(firmName, other.firmName);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(firmId, firmName, status, exchange);
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("firmid", firmId)
                    .add("firm_name", firmName)
                    .add("status", status)
                    .add("exchange", exchange)
                    .toString();
        }

        return asString;
    }
}