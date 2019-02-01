package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

@Value
public class MoneyLimitDelete {

    private static final String CURRENCY_CODE = "currcode";
    private static final String TAG = "tag";
    private static final String CLIENT_CODE = "client_code";
    private static final String FIRM_ID = "firmid";
    private static final String LIMIT_KIND = "limit_kind";

    String currCode;
    String tag;
    String clientCode;
    String firmId;
    int limitKind;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient String asString;

    @JsonCreator
    @Builder
    private MoneyLimitDelete(
            @JsonProperty(CURRENCY_CODE) final String currCode,
            @JsonProperty(TAG) final String tag,
            @JsonProperty(CLIENT_CODE) final String clientCode,
            @JsonProperty(FIRM_ID) final String firmId,
            @JsonProperty(value = LIMIT_KIND, required = true) final int limitKind) {

        this.currCode = currCode;
        this.tag = tag;
        this.clientCode = clientCode;
        this.firmId = firmId;
        this.limitKind = limitKind;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add(CURRENCY_CODE, currCode)
                    .add(TAG, tag)
                    .add(CLIENT_CODE, clientCode)
                    .add(FIRM_ID, firmId)
                    .add(LIMIT_KIND, limitKind)
                    .toString();
        }

        return asString;
    }
}
