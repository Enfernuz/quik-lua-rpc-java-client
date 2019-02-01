package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;

@Value
public class FuturesLimitDelete {

    private static final String FIRM_ID = "firmid";
    private static final String LIMIT_TYPE = "limit_type";

    String firmId;
    int limitType;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient String asString;

    @JsonCreator
    @Builder
    private FuturesLimitDelete(
            @JsonProperty(value = FIRM_ID, required = true) @NonNull final String firmId,
            @JsonProperty(value = LIMIT_TYPE, required = true) final int limitType) {
        this.firmId = firmId;
        this.limitType = limitType;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add(FIRM_ID, firmId)
                    .add(LIMIT_TYPE, limitType)
                    .toString();
        }

        return asString;
    }
}
