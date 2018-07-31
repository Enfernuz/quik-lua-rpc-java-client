package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class FuturesClientHolding {

    @JsonProperty("firmid") String firmId;
    @JsonProperty("trdaccid") String trdAccId;
    @JsonProperty("sec_code") String secCode;
    @JsonProperty("type") int type;
    @JsonProperty("startbuy") String startBuy;
    @JsonProperty("startsell") String startSell;
    @JsonProperty("todaybuy") String todayBuy;
    @JsonProperty("todaysell") String todaySell;
    @JsonProperty("totalnet") String totalNet;
    @JsonProperty("openbuys") int openBuys;
    @JsonProperty("opensells") int openSells;
    @JsonProperty("cbplused") String cbplUsed;
    @JsonProperty("cbplplanned") String cbplPlanned;
    @JsonProperty("varmargin") String varMargin;
    @JsonProperty("avrposnprice") String avrPosnPrice;
    @JsonProperty("positionvalue") String positionValue;
    @JsonProperty("real_varmargin") String realVarMargin;
    @JsonProperty("total_varmargin") String totalVarMargin;
    @JsonProperty("session_status") int sessionStatus;

    @Getter(AccessLevel.NONE)
    private @JsonIgnore @NonFinal transient int hashCode;

    @Getter(AccessLevel.NONE)
    private @JsonIgnore @NonFinal transient String asString;

    @Builder
    @JsonCreator
    private FuturesClientHolding(
            @JsonProperty("firmid") String firmId,
            @JsonProperty("trdaccid") String trdAccId,
            @JsonProperty("sec_code") String secCode,
            @JsonProperty(value = "type", required = true) int type,
            @JsonProperty("startbuy") String startBuy,
            @JsonProperty("startsell") String startSell,
            @JsonProperty("todaybuy") String todayBuy,
            @JsonProperty("todaysell") String todaySell,
            @JsonProperty("totalnet") String totalNet,
            @JsonProperty(value = "openbuys", required = true) int openBuys,
            @JsonProperty(value = "opensells", required = true) int openSells,
            @JsonProperty("cbplused") String cbplUsed,
            @JsonProperty("cbplplanned") String cbplPlanned,
            @JsonProperty("varmargin") String varMargin,
            @JsonProperty("avrposnprice") String avrPosnPrice,
            @JsonProperty("positionvalue") String positionValue,
            @JsonProperty("real_varmargin") String realVarMargin,
            @JsonProperty("total_varmargin") String totalVarMargin,
            @JsonProperty(value = "session_status", required = true) int sessionStatus) {

        this.firmId = firmId;
        this.trdAccId = trdAccId;
        this.secCode = secCode;
        this.type = type;
        this.startBuy = startBuy;
        this.startSell = startSell;
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

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof FuturesClientHolding) ) {
            return false;
        } else {
            final FuturesClientHolding that = (FuturesClientHolding) o;
            return type == that.type &&
                    openBuys == that.openBuys &&
                    openSells == that.openSells &&
                    sessionStatus == that.sessionStatus &&
                    Objects.equals(firmId, that.firmId) &&
                    Objects.equals(trdAccId, that.trdAccId) &&
                    Objects.equals(secCode, that.secCode) &&
                    Objects.equals(startBuy, that.startBuy) &&
                    Objects.equals(startSell, that.startSell) &&
                    Objects.equals(todayBuy, that.todayBuy) &&
                    Objects.equals(todaySell, that.todaySell) &&
                    Objects.equals(totalNet, that.totalNet) &&
                    Objects.equals(cbplUsed, that.cbplUsed) &&
                    Objects.equals(cbplPlanned, that.cbplPlanned) &&
                    Objects.equals(varMargin, that.varMargin) &&
                    Objects.equals(avrPosnPrice, that.avrPosnPrice) &&
                    Objects.equals(positionValue, that.positionValue) &&
                    Objects.equals(realVarMargin, that.realVarMargin) &&
                    Objects.equals(totalVarMargin, that.totalVarMargin);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            return Objects.hash(
                    firmId,
                    trdAccId,
                    secCode,
                    type,
                    startBuy,
                    startSell,
                    todayBuy,
                    todaySell,
                    totalNet,
                    openBuys,
                    openSells,
                    cbplUsed,
                    cbplPlanned,
                    varMargin,
                    avrPosnPrice,
                    positionValue,
                    realVarMargin,
                    totalVarMargin,
                    sessionStatus
            );
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("firmid", firmId)
                    .add("trdaccid", trdAccId)
                    .add("sec_code", secCode)
                    .add("type", type)
                    .add("startbuy", startBuy)
                    .add("startsell", startSell)
                    .add("todaybuy", todayBuy)
                    .add("todaysell", todaySell)
                    .add("totalnet", totalNet)
                    .add("openbuys", openBuys)
                    .add("opensells", openSells)
                    .add("cbplused", cbplUsed)
                    .add("cbplplanned", cbplPlanned)
                    .add("varmargin", varMargin)
                    .add("avrposnprice", avrPosnPrice)
                    .add("positionvalue", positionValue)
                    .add("real_varmargin", realVarMargin)
                    .add("total_varmargin", totalVarMargin)
                    .add("session_status", sessionStatus)
                    .toString();
        }

        return asString;
    }
}
