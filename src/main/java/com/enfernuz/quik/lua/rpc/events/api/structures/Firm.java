package com.enfernuz.quik.lua.rpc.events.api.structures;

import com.google.common.base.MoreObjects;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public final class Firm {

    private final String firmId;
    private final String firmName;
    private final int status;
    private final String exchange;

    private transient int hashCode;
    private transient String asString;

    public Firm(final String firmId, final String firmName, int status, final String exchange) {
        this.firmId = requireNonNull(firmId, "Аргумент 'firmId' не должен быть null.");
        this.firmName = firmName;
        this.status = status;
        this.exchange = exchange;
    }

    public String getFirmId() {
        return firmId;
    }

    public String getFirmName() {
        return firmName;
    }

    public int getStatus() {
        return status;
    }

    public String getExchange() {
        return exchange;
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
                    .add("firmId", firmId)
                    .add("firm_name", firmName)
                    .add("status", status)
                    .add("exchange", exchange)
                    .toString();
        }

        return asString;
    }
}