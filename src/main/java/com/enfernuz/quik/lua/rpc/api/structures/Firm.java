package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class Firm {

    @JsonProperty("firm_id") String firmId;
    @JsonProperty("firm_name") String firmName;
    @JsonProperty("status") int status;
    @JsonProperty("exchange") String exchange;

    @Getter(AccessLevel.NONE)
    private @JsonIgnore @NonFinal transient int hashCode;

    @Getter(AccessLevel.NONE)
    private @JsonIgnore @NonFinal transient String asString;

    @Builder
    @JsonCreator
    private Firm(
            @JsonProperty("firm_id") @NonNull final String firmId,
            @JsonProperty("firm_name") final String firmName,
            @JsonProperty(value = "status", required = true) int status,
            @JsonProperty("exchange") final String exchange) {

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