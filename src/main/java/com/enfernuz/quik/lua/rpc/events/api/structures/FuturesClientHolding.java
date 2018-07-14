package com.enfernuz.quik.lua.rpc.events.api.structures;

import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class FuturesClientHolding {

    String firmId;
    String trdAccId;
    String secCode;
    int type;
    String startBuy;
    String startSell;
    String todayBuy;
    String todaySell;
    String totalNet;
    int openBuys;
    int openSells;
    String cbpLUsed;
    String cbpLPlanned;
    String varMargin;
    String avrPosnPrice;
    String positionValue;
    String realVarMargin;
    String totalVarMargin;
    int sessionStatus;

    private transient @NonFinal int hashCode;
    private transient @NonFinal String asString;

    @Builder
    private FuturesClientHolding(
            final String firmId,
            final String trdAccId,
            final String secCode,
            final int type,
            final String startBuy,
            final String startSell,
            final String todayBuy,
            final String todaySell,
            final String totalNet,
            final int openBuys,
            final int openSells,
            final String cbpLUsed,
            final String cbpLPlanned,
            final String varMargin,
            final String avrPosnPrice,
            final String positionValue,
            final String realVarMargin,
            final String totalVarMargin,
            final int sessionStatus) {

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
        this.cbpLUsed = cbpLUsed;
        this.cbpLPlanned = cbpLPlanned;
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
                    Objects.equals(cbpLUsed, that.cbpLUsed) &&
                    Objects.equals(cbpLPlanned, that.cbpLPlanned) &&
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
                    cbpLUsed,
                    cbpLPlanned,
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
                    .add("cbplused", cbpLUsed)
                    .add("cbplplanned", cbpLPlanned)
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
