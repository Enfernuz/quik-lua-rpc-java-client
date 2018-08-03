package com.enfernuz.quik.lua.rpc.api.structures;

import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class DepoLimitDelete {

    String secCode;
    String trdAccId;
    String firmId;
    String clientCode;
    int limitKind;

    private transient @NonFinal @Getter(AccessLevel.NONE) int hashCode;
    private transient @NonFinal @Getter(AccessLevel.NONE) String asString;

    @Builder
    private DepoLimitDelete(
            final String secCode,
            final String trdAccId,
            final String firmId,
            final String clientCode,
            final int limitKind) {

        this.secCode = secCode;
        this.trdAccId = trdAccId;
        this.firmId = firmId;
        this.clientCode = clientCode;
        this.limitKind = limitKind;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof DepoLimitDelete) ) {
            return false;
        } else {
            final DepoLimitDelete that = (DepoLimitDelete) o;
            return limitKind == that.limitKind &&
                    Objects.equals(secCode, that.secCode) &&
                    Objects.equals(trdAccId, that.trdAccId) &&
                    Objects.equals(firmId, that.firmId) &&
                    Objects.equals(clientCode, that.clientCode);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(secCode, trdAccId, firmId, clientCode, limitKind);
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("sec_code", secCode)
                    .add("trdaccid", trdAccId)
                    .add("firmid", firmId)
                    .add("client_code", clientCode)
                    .add("limit_kind", limitKind)
                    .toString();
        }

        return asString;
    }
}
