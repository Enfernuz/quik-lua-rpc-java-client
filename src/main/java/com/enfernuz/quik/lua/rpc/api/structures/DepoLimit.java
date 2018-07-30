package com.enfernuz.quik.lua.rpc.api.structures;

import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class DepoLimit {

    String secCode;
    String trdAccId;
    String firmId;
    String clientCode;
    int openBal;
    int openLimit;
    int currentBal;
    int currentLimit;
    int lockedSell;
    int lockedBuy;
    String lockedBuyValue;
    String lockedSellValue;
    String awgPositionPrice;
    int limitKind;

    private transient @NonFinal @Getter(AccessLevel.NONE) int hashCode;
    private transient @NonFinal @Getter(AccessLevel.NONE) String asString;

    @Builder
    private DepoLimit(
            final String secCode,
            final String trdAccId,
            final String firmId,
            final String clientCode,
            final int openBal,
            final int openLimit,
            final int currentBal,
            final int currentLimit,
            final int lockedSell,
            final int lockedBuy,
            final String lockedBuyValue,
            final String lockedSellValue,
            final String awgPositionPrice,
            final int limitKind) {

        this.secCode = secCode;
        this.trdAccId = trdAccId;
        this.firmId = firmId;
        this.clientCode = clientCode;
        this.openBal = openBal;
        this.openLimit = openLimit;
        this.currentBal = currentBal;
        this.currentLimit = currentLimit;
        this.lockedSell = lockedSell;
        this.lockedBuy = lockedBuy;
        this.lockedBuyValue = lockedBuyValue;
        this.lockedSellValue = lockedSellValue;
        this.awgPositionPrice = awgPositionPrice;
        this.limitKind = limitKind;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof DepoLimit) ) {
            return false;
        } else {
            final DepoLimit depoLimit = (DepoLimit) o;
            return openBal == depoLimit.openBal &&
                    openLimit == depoLimit.openLimit &&
                    currentBal == depoLimit.currentBal &&
                    currentLimit == depoLimit.currentLimit &&
                    lockedSell == depoLimit.lockedSell &&
                    lockedBuy == depoLimit.lockedBuy &&
                    limitKind == depoLimit.limitKind &&
                    Objects.equals(secCode, depoLimit.secCode) &&
                    Objects.equals(trdAccId, depoLimit.trdAccId) &&
                    Objects.equals(firmId, depoLimit.firmId) &&
                    Objects.equals(clientCode, depoLimit.clientCode) &&
                    Objects.equals(lockedBuyValue, depoLimit.lockedBuyValue) &&
                    Objects.equals(lockedSellValue, depoLimit.lockedSellValue) &&
                    Objects.equals(awgPositionPrice, depoLimit.awgPositionPrice);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(
                    secCode,
                    trdAccId,
                    firmId,
                    clientCode,
                    openBal,
                    openLimit,
                    currentBal,
                    currentLimit,
                    lockedSell,
                    lockedBuy,
                    lockedBuyValue,
                    lockedSellValue,
                    awgPositionPrice,
                    limitKind
            );
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
                    .add("openbal", openBal)
                    .add("openlimit", openLimit)
                    .add("currentbal", currentBal)
                    .add("currentlimit", currentLimit)
                    .add("locked_sell", lockedSell)
                    .add("locked_buy", lockedBuy)
                    .add("locked_buy_value", lockedBuyValue)
                    .add("locked_sell_value", lockedSellValue)
                    .add("awg_position_price", awgPositionPrice)
                    .add("limit_kind", limitKind)
                    .toString();
        }

        return asString;
    }
}
