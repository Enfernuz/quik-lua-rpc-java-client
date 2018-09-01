package com.enfernuz.quik.lua.rpc.api.structures;

import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class Trade {

    long tradeNum;
    long orderNum;
    String brokerRef;
    String userId;
    String firmId;
    String canceledUid;
    String account;
    String price;
    int qty;
    String value;
    String accruedInt;
    String yield;
    String settleCode;
    String cpFirmId;
    int flags;
    String price2;
    String repoRate;
    String clientCode;
    String accrued2;
    String repoTerm;
    String repoValue;
    String repo2Value;
    String startDiscount;
    String lowerDiscount;
    String upperDiscount;
    String blockSecurities;
    String clearingComission;
    String exchangeComission;
    String techCenterComission;
    String settleDate;
    String settleCurrency;
    String tradeCurrency;
    String exchangeCode;
    String stationId;
    String secCode;
    String classCode;
    DateTimeEntry datetime;
    String bankAccId;
    String brokerComission;
    String linkedTrade;
    int period;
    String transId;
    int kind;
    String clearingBankAccId;
    DateTimeEntry canceledDatetime;
    String clearingFirmId;
    String systemRef;
    String uid;

    private transient @NonFinal @Getter(AccessLevel.NONE) int hashCode;
    private transient @NonFinal @Getter(AccessLevel.NONE) String asString;

    @Builder
    private Trade(
            final long tradeNum,
            final long orderNum,
            final String brokerRef,
            final String userId,
            final String firmId,
            final String canceledUid,
            final String account,
            final String price,
            final int qty,
            final String value,
            final String accruedInt,
            final String yield,
            final String settleCode,
            final String cpFirmId,
            final int flags,
            final String price2,
            final String repoRate,
            final String clientCode,
            final String accrued2,
            final String repoTerm,
            final String repoValue,
            final String repo2Value,
            final String startDiscount,
            final String lowerDiscount,
            final String upperDiscount,
            final String blockSecurities,
            final String clearingComission,
            final String exchangeComission,
            final String techCenterComission,
            final String settleDate,
            final String settleCurrency,
            final String tradeCurrency,
            final String exchangeCode,
            final String stationId,
            final String secCode,
            final String classCode,
            final DateTimeEntry datetime,
            final String bankAccId,
            final String brokerComission,
            final String linkedTrade,
            final int period,
            final String transId,
            final int kind,
            final String clearingBankAccId,
            final DateTimeEntry canceledDatetime,
            final String clearingFirmId,
            final String systemRef,
            final String uid) {

        this.tradeNum = tradeNum;
        this.orderNum = orderNum;
        this.brokerRef = brokerRef;
        this.userId = userId;
        this.firmId = firmId;
        this.canceledUid = canceledUid;
        this.account = account;
        this.price = price;
        this.qty = qty;
        this.value = value;
        this.accruedInt = accruedInt;
        this.yield = yield;
        this.settleCode = settleCode;
        this.cpFirmId = cpFirmId;
        this.flags = flags;
        this.price2 = price2;
        this.repoRate = repoRate;
        this.clientCode = clientCode;
        this.accrued2 = accrued2;
        this.repoTerm = repoTerm;
        this.repoValue = repoValue;
        this.repo2Value = repo2Value;
        this.startDiscount = startDiscount;
        this.lowerDiscount = lowerDiscount;
        this.upperDiscount = upperDiscount;
        this.blockSecurities = blockSecurities;
        this.clearingComission = clearingComission;
        this.exchangeComission = exchangeComission;
        this.techCenterComission = techCenterComission;
        this.settleDate = settleDate;
        this.settleCurrency = settleCurrency;
        this.tradeCurrency = tradeCurrency;
        this.exchangeCode = exchangeCode;
        this.stationId = stationId;
        this.secCode = secCode;
        this.classCode = classCode;
        this.datetime = datetime;
        this.bankAccId = bankAccId;
        this.brokerComission = brokerComission;
        this.linkedTrade = linkedTrade;
        this.period = period;
        this.transId = transId;
        this.kind = kind;
        this.clearingBankAccId = clearingBankAccId;
        this.canceledDatetime = canceledDatetime;
        this.clearingFirmId = clearingFirmId;
        this.systemRef = systemRef;
        this.uid = uid;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof Trade) ) {
            return false;
        } else {
            final Trade trade = (Trade) o;
            return tradeNum == trade.tradeNum &&
                    orderNum == trade.orderNum &&
                    qty == trade.qty &&
                    flags == trade.flags &&
                    period == trade.period &&
                    kind == trade.kind &&
                    Objects.equals(brokerRef, trade.brokerRef) &&
                    Objects.equals(userId, trade.userId) &&
                    Objects.equals(firmId, trade.firmId) &&
                    Objects.equals(canceledUid, trade.canceledUid) &&
                    Objects.equals(account, trade.account) &&
                    Objects.equals(price, trade.price) &&
                    Objects.equals(value, trade.value) &&
                    Objects.equals(accruedInt, trade.accruedInt) &&
                    Objects.equals(yield, trade.yield) &&
                    Objects.equals(settleCode, trade.settleCode) &&
                    Objects.equals(cpFirmId, trade.cpFirmId) &&
                    Objects.equals(price2, trade.price2) &&
                    Objects.equals(repoRate, trade.repoRate) &&
                    Objects.equals(clientCode, trade.clientCode) &&
                    Objects.equals(accrued2, trade.accrued2) &&
                    Objects.equals(repoTerm, trade.repoTerm) &&
                    Objects.equals(repoValue, trade.repoValue) &&
                    Objects.equals(repo2Value, trade.repo2Value) &&
                    Objects.equals(startDiscount, trade.startDiscount) &&
                    Objects.equals(lowerDiscount, trade.lowerDiscount) &&
                    Objects.equals(upperDiscount, trade.upperDiscount) &&
                    Objects.equals(blockSecurities, trade.blockSecurities) &&
                    Objects.equals(clearingComission, trade.clearingComission) &&
                    Objects.equals(exchangeComission, trade.exchangeComission) &&
                    Objects.equals(techCenterComission, trade.techCenterComission) &&
                    Objects.equals(settleDate, trade.settleDate) &&
                    Objects.equals(settleCurrency, trade.settleCurrency) &&
                    Objects.equals(tradeCurrency, trade.tradeCurrency) &&
                    Objects.equals(exchangeCode, trade.exchangeCode) &&
                    Objects.equals(stationId, trade.stationId) &&
                    Objects.equals(secCode, trade.secCode) &&
                    Objects.equals(classCode, trade.classCode) &&
                    Objects.equals(datetime, trade.datetime) &&
                    Objects.equals(bankAccId, trade.bankAccId) &&
                    Objects.equals(brokerComission, trade.brokerComission) &&
                    Objects.equals(linkedTrade, trade.linkedTrade) &&
                    Objects.equals(transId, trade.transId) &&
                    Objects.equals(clearingBankAccId, trade.clearingBankAccId) &&
                    Objects.equals(canceledDatetime, trade.canceledDatetime) &&
                    Objects.equals(clearingFirmId, trade.clearingFirmId) &&
                    Objects.equals(systemRef, trade.systemRef) &&
                    Objects.equals(uid, trade.uid);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(
                    tradeNum,
                    orderNum,
                    brokerRef,
                    userId,
                    firmId,
                    canceledUid,
                    account,
                    price,
                    qty,
                    value,
                    accruedInt,
                    yield,
                    settleCode,
                    cpFirmId,
                    flags,
                    price2,
                    repoRate,
                    clientCode,
                    accrued2,
                    repoTerm,
                    repoValue,
                    repo2Value,
                    startDiscount,
                    lowerDiscount,
                    upperDiscount,
                    blockSecurities,
                    clearingComission,
                    exchangeComission,
                    techCenterComission,
                    settleDate,
                    settleCurrency,
                    tradeCurrency,
                    exchangeCode,
                    stationId,
                    secCode,
                    classCode,
                    datetime,
                    bankAccId,
                    brokerComission,
                    linkedTrade,
                    period,
                    transId,
                    kind,
                    clearingBankAccId,
                    canceledDatetime,
                    clearingFirmId,
                    systemRef,
                    uid
            );
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("trade_num", tradeNum)
                    .add("order_num", orderNum)
                    .add("brokerref", brokerRef)
                    .add("userid", userId)
                    .add("firmid", firmId)
                    .add("canceled_uid", canceledUid)
                    .add("account", account)
                    .add("price", price)
                    .add("qty", qty)
                    .add("value", value)
                    .add("accruedint", accruedInt)
                    .add("yield", yield)
                    .add("settlecode", settleCode)
                    .add("cpfirmid", cpFirmId)
                    .add("flags", flags)
                    .add("price2", price2)
                    .add("reporate", repoRate)
                    .add("client_code", clientCode)
                    .add("accrued2", accrued2)
                    .add("repoterm", repoTerm)
                    .add("repovalue", repoValue)
                    .add("repo2value", repo2Value)
                    .add("start_discount", startDiscount)
                    .add("lower_discount", lowerDiscount)
                    .add("upper_discount", upperDiscount)
                    .add("block_securities", blockSecurities)
                    .add("clearing_comission", clearingComission)
                    .add("exchange_comission", exchangeComission)
                    .add("tech_center_comission", techCenterComission)
                    .add("settle_date", settleDate)
                    .add("settle_currency", settleCurrency)
                    .add("trade_currency", tradeCurrency)
                    .add("exchange_code", exchangeCode)
                    .add("station_id", stationId)
                    .add("sec_code", secCode)
                    .add("class_code", classCode)
                    .add("datetime", datetime)
                    .add("bank_acc_id", bankAccId)
                    .add("broker_comission", brokerComission)
                    .add("linked_trade", linkedTrade)
                    .add("period", period)
                    .add("trans_id", transId)
                    .add("kind", kind)
                    .add("clearing_bank_accid", clearingBankAccId)
                    .add("canceled_datetime", canceledDatetime)
                    .add("clearing_firmid", clearingFirmId)
                    .add("system_ref", systemRef)
                    .add("uid", uid)
                    .toString();
        }

        return asString;
    }
}
