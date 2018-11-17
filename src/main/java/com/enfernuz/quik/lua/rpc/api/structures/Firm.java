package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;

@Value
public class Firm {

    private static final String FIRM_ID = "firmid";
    private static final String FIRM_NAME = "firm_name";
    private static final String STATUS = "status";
    private static final String EXCHANGE = "exchange";

    String firmId;
    String firmName;
    Integer status;
    String exchange;

    @Getter(AccessLevel.NONE)
    private @NonFinal transient String asString;

    @JsonCreator
    @Builder
    private Firm(
            @JsonProperty(value = FIRM_ID, required = true) @NonNull final String firmId,
            @JsonProperty(FIRM_NAME) final String firmName,
            @JsonProperty(STATUS) final Integer status,
            @JsonProperty(EXCHANGE) final String exchange) {

        this.firmId = firmId;
        this.firmName = firmName;
        this.status = status;
        this.exchange = exchange;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add(FIRM_ID, firmId)
                    .add(FIRM_NAME, firmName)
                    .add(STATUS, status)
                    .add(EXCHANGE, exchange)
                    .toString();
        }

        return asString;
    }
}