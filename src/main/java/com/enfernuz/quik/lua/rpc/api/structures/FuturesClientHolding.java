package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

@Value
public class FuturesClientHolding {

    private static final String FIRM_ID = "firmid";
    private static final String TRADING_ACCOUNT_ID = "trdaccid";
    private static final String SECURITY_CODE = "sec_code";
    private static final String TYPE = "type";
    private static final String START_BUY = "startbuy";
    private static final String START_SELL = "startsell";
    private static final String START_NET = "startnet";
    private static final String TODAY_BUY = "todaybuy";
    private static final String TODAY_SELL = "todaysell";
    private static final String TOTAL_NET = "totalnet";
    private static final String OPEN_BUYS = "openbuys";
    private static final String OPEN_SELLS = "opensells";
    private static final String CBP_L_USED = "cbplused";
    private static final String CBP_L_PLANNED = "cbplplanned";
    private static final String VAR_MARGIN = "varmargin";
    private static final String AVR_POSITION_PRICE = "avrposnprice";
    private static final String POSITION_VALUE = "positionvalue";
    private static final String REAL_VAR_MARGIN = "real_varmargin";
    private static final String TOTAL_VAR_MARGIN = "total_varmargin";
    private static final String SESSION_STATUS = "session_status";

    String firmId;
    String trdAccId;
    String secCode;
    int type;
    String startBuy;
    String startSell;
    String startNet;
    String todayBuy;
    String todaySell;
    String totalNet;
    int openBuys;
    int openSells;
    String cbplUsed;
    String cbplPlanned;
    String varMargin;
    String avrPosnPrice;
    String positionValue;
    String realVarMargin;
    String totalVarMargin;
    int sessionStatus;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient String asString;

    @JsonCreator
    @Builder
    private FuturesClientHolding(
            @JsonProperty(value = FIRM_ID, required = true) @NonNull String firmId,
            @JsonProperty(value = TRADING_ACCOUNT_ID, required = true) @NonNull String trdAccId,
            @JsonProperty(value = SECURITY_CODE, required = true) @NonNull String secCode,
            @JsonProperty(value = TYPE, required = true) int type,
            @JsonProperty(START_BUY) String startBuy,
            @JsonProperty(START_SELL) String startSell,
            @JsonProperty(START_NET) String startNet,
            @JsonProperty(TODAY_BUY) String todayBuy,
            @JsonProperty(TODAY_SELL) String todaySell,
            @JsonProperty(TOTAL_NET) String totalNet,
            @JsonProperty(value = OPEN_BUYS, required = true) int openBuys,
            @JsonProperty(value = OPEN_SELLS, required = true) int openSells,
            @JsonProperty(CBP_L_USED) String cbplUsed,
            @JsonProperty(CBP_L_PLANNED) String cbplPlanned,
            @JsonProperty(VAR_MARGIN) String varMargin,
            @JsonProperty(AVR_POSITION_PRICE) String avrPosnPrice,
            @JsonProperty(POSITION_VALUE) String positionValue,
            @JsonProperty(REAL_VAR_MARGIN) String realVarMargin,
            @JsonProperty(TOTAL_VAR_MARGIN) String totalVarMargin,
            @JsonProperty(value = SESSION_STATUS, required = true) int sessionStatus) {

        this.firmId = firmId;
        this.trdAccId = trdAccId;
        this.secCode = secCode;
        this.type = type;
        this.startBuy = startBuy;
        this.startSell = startSell;
        this.startNet = startNet;
        this.todayBuy = todayBuy;
        this.todaySell = todaySell;
        this.totalNet = totalNet;
        this.openBuys = openBuys;
        this.openSells = openSells;
        this.cbplUsed = cbplUsed;
        this.cbplPlanned = cbplPlanned;
        this.varMargin = varMargin;
        this.avrPosnPrice = avrPosnPrice;
        this.positionValue = positionValue;
        this.realVarMargin = realVarMargin;
        this.totalVarMargin = totalVarMargin;
        this.sessionStatus = sessionStatus;
    }

    @NotNull
    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add(FIRM_ID, firmId)
                    .add(TRADING_ACCOUNT_ID, trdAccId)
                    .add(SECURITY_CODE, secCode)
                    .add(TYPE, type)
                    .add(START_BUY, startBuy)
                    .add(START_SELL, startSell)
                    .add(START_NET, startNet)
                    .add(TODAY_BUY, todayBuy)
                    .add(TODAY_SELL, todaySell)
                    .add(TOTAL_NET, totalNet)
                    .add(OPEN_BUYS, openBuys)
                    .add(OPEN_SELLS, openSells)
                    .add(CBP_L_USED, cbplUsed)
                    .add(CBP_L_PLANNED, cbplPlanned)
                    .add(VAR_MARGIN, varMargin)
                    .add(AVR_POSITION_PRICE, avrPosnPrice)
                    .add(POSITION_VALUE, positionValue)
                    .add(REAL_VAR_MARGIN, realVarMargin)
                    .add(TOTAL_VAR_MARGIN, totalVarMargin)
                    .add(SESSION_STATUS, sessionStatus)
                    .toString();
        }

        return asString;
    }
}
