package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

@Value
public class DepoLimitDelete {

    private static final String SECURITY_CODE = "sec_code";
    private static final String TRADING_ACCOUNT_ID = "trdaccid";
    private static final String FIRM_ID = "firmid";
    private static final String CLIENT_CODE = "client_code";
    private static final String LIMIT_KIND = "limit_kind";

    String secCode;
    String trdAccId;
    String firmId;
    String clientCode;
    int limitKind;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient String asString;

    @JsonCreator
    @Builder
    private DepoLimitDelete(
            @JsonProperty(SECURITY_CODE) final String secCode,
            @JsonProperty(TRADING_ACCOUNT_ID) final String trdAccId,
            @JsonProperty(FIRM_ID) final String firmId,
            @JsonProperty(CLIENT_CODE) final String clientCode,
            @JsonProperty(value = LIMIT_KIND, required = true) final int limitKind) {

        this.secCode = secCode;
        this.trdAccId = trdAccId;
        this.firmId = firmId;
        this.clientCode = clientCode;
        this.limitKind = limitKind;
    }

    @NotNull
    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add(SECURITY_CODE, secCode)
                    .add(TRADING_ACCOUNT_ID, trdAccId)
                    .add(FIRM_ID, firmId)
                    .add(CLIENT_CODE, clientCode)
                    .add(LIMIT_KIND, limitKind)
                    .toString();
        }

        return asString;
    }
}
