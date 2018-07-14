package com.enfernuz.quik.lua.rpc.events.api.structures;

import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class MoneyLimitDelete {

    String currCode;
    String tag;
    String clientCode;
    String firmId;
    int limitKind;

    private transient @NonFinal int hashCode;
    private transient @NonFinal String asString;

    @Builder
    private MoneyLimitDelete(
            final String currCode,
            final String tag,
            final String clientCode,
            final String firmId,
            final int limitKind) {

        this.currCode = currCode;
        this.tag = tag;
        this.clientCode = clientCode;
        this.firmId = firmId;
        this.limitKind = limitKind;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof MoneyLimitDelete) ) {
            return false;
        } else {
            final MoneyLimitDelete that = (MoneyLimitDelete) o;
            return limitKind == that.limitKind &&
                    Objects.equals(currCode, that.currCode) &&
                    Objects.equals(tag, that.tag) &&
                    Objects.equals(clientCode, that.clientCode) &&
                    Objects.equals(firmId, that.firmId);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(currCode, tag, clientCode, firmId, limitKind);
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("currcode", currCode)
                    .add("tag", tag)
                    .add("client_code", clientCode)
                    .add("firmid", firmId)
                    .add("limit_kind", limitKind)
                    .toString();
        }

        return asString;
    }
}
