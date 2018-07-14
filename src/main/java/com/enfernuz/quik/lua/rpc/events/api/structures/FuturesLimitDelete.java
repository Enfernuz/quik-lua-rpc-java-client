package com.enfernuz.quik.lua.rpc.events.api.structures;

import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class FuturesLimitDelete {

    String firmId;
    int limitType;

    private transient @NonFinal int hashCode;
    private transient @NonFinal String asString;

    @Builder
    private FuturesLimitDelete(final String firmId, final int limitType) {
        this.firmId = firmId;
        this.limitType = limitType;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof FuturesLimitDelete) ) {
            return false;
        } else {
            final FuturesLimitDelete that = (FuturesLimitDelete) o;
            return limitType == that.limitType &&
                    Objects.equals(firmId, that.firmId);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(firmId, limitType);
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("firmid", firmId)
                    .add("limit_type", limitType)
                    .toString();
        }

        return asString;
    }
}
