package com.enfernuz.quik.lua.rpc.events.api.structures;

import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class NegDeal {

    long negDealNum;
    String negDealTime;
    int flags;
    String brokerRef;
    String userId;
    String firmId;
    String cpUserId;
    String cpFirmId;
    String account;
    String price;
    int qty;
    String matchRef;
    String settleCode;
    String yield;
    String accruedInt;
    String value;
    String price2;
    String repoRate;
    String refundRate;
    String transId;
    String clientCode;
    int repoEntry;
    String repoValue;
    String repo2Value;
    String repoTerm;
    String startDiscount;
    String lowerDiscount;
    String upperDiscount;
    String blockSecurities;
    String uid;
    String withdrawTime;
    String negDealDate;
    String balance;
    String originRepoValue;
    String originQty;
    String originDiscount;
    String negDealActivationDate;
    String negDealActivationTime;
    String quoteNo;
    String settleCurrency;
    String secCode;
    String classCode;
    String bankAccId;
    String withdrawDate;
    String linkedOrder;
    DateTimeEntry activationDateTime;
    DateTimeEntry withdrawDateTime;
    DateTimeEntry dateTime;

    private transient @NonFinal int hashCode;
    private transient @NonFinal String asString;

    @Builder
    private NegDeal(
            final long negDealNum,
            final String negDealTime,
            final int flags,
            final String brokerRef,
            final String userId,
            final String firmId,
            final String cpUserId,
            final String cpFirmId,
            final String account,
            final String price,
            final int qty,
            final String matchRef,
            final String settleCode,
            final String yield,
            final String accruedInt,
            final String value,
            final String price2,
            final String repoRate,
            final String refundRate,
            final String transId,
            final String clientCode,
            final int repoEntry,
            final String repoValue,
            final String repo2Value,
            final String repoTerm,
            final String startDiscount,
            final String lowerDiscount,
            final String upperDiscount,
            final String blockSecurities,
            final String uid,
            final String withdrawTime,
            final String negDealDate,
            final String balance,
            final String originRepoValue,
            final String originQty,
            final String originDiscount,
            final String negDealActivationDate,
            final String negDealActivationTime,
            final String quoteNo,
            final String settleCurrency,
            final String secCode,
            final String classCode,
            final String bankAccId,
            final String withdrawDate,
            final String linkedOrder,
            final DateTimeEntry activationDateTime,
            final DateTimeEntry withdrawDateTime,
            final DateTimeEntry dateTime) {

        this.negDealNum = negDealNum;
        this.negDealTime = negDealTime;
        this.flags = flags;
        this.brokerRef = brokerRef;
        this.userId = userId;
        this.firmId = firmId;
        this.cpUserId = cpUserId;
        this.cpFirmId = cpFirmId;
        this.account = account;
        this.price = price;
        this.qty = qty;
        this.matchRef = matchRef;
        this.settleCode = settleCode;
        this.yield = yield;
        this.accruedInt = accruedInt;
        this.value = value;
        this.price2 = price2;
        this.repoRate = repoRate;
        this.refundRate = refundRate;
        this.transId = transId;
        this.clientCode = clientCode;
        this.repoEntry = repoEntry;
        this.repoValue = repoValue;
        this.repo2Value = repo2Value;
        this.repoTerm = repoTerm;
        this.startDiscount = startDiscount;
        this.lowerDiscount = lowerDiscount;
        this.upperDiscount = upperDiscount;
        this.blockSecurities = blockSecurities;
        this.uid = uid;
        this.withdrawTime = withdrawTime;
        this.negDealDate = negDealDate;
        this.balance = balance;
        this.originRepoValue = originRepoValue;
        this.originQty = originQty;
        this.originDiscount = originDiscount;
        this.negDealActivationDate = negDealActivationDate;
        this.negDealActivationTime = negDealActivationTime;
        this.quoteNo = quoteNo;
        this.settleCurrency = settleCurrency;
        this.secCode = secCode;
        this.classCode = classCode;
        this.bankAccId = bankAccId;
        this.withdrawDate = withdrawDate;
        this.linkedOrder = linkedOrder;
        this.activationDateTime = activationDateTime;
        this.withdrawDateTime = withdrawDateTime;
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof NegDeal) ) {
            return false;
        } else {
            final NegDeal negDeal = (NegDeal) o;
            return negDealNum == negDeal.negDealNum &&
                    flags == negDeal.flags &&
                    qty == negDeal.qty &&
                    repoEntry == negDeal.repoEntry &&
                    Objects.equals(negDealTime, negDeal.negDealTime) &&
                    Objects.equals(brokerRef, negDeal.brokerRef) &&
                    Objects.equals(userId, negDeal.userId) &&
                    Objects.equals(firmId, negDeal.firmId) &&
                    Objects.equals(cpUserId, negDeal.cpUserId) &&
                    Objects.equals(cpFirmId, negDeal.cpFirmId) &&
                    Objects.equals(account, negDeal.account) &&
                    Objects.equals(price, negDeal.price) &&
                    Objects.equals(matchRef, negDeal.matchRef) &&
                    Objects.equals(settleCode, negDeal.settleCode) &&
                    Objects.equals(yield, negDeal.yield) &&
                    Objects.equals(accruedInt, negDeal.accruedInt) &&
                    Objects.equals(value, negDeal.value) &&
                    Objects.equals(price2, negDeal.price2) &&
                    Objects.equals(repoRate, negDeal.repoRate) &&
                    Objects.equals(refundRate, negDeal.refundRate) &&
                    Objects.equals(transId, negDeal.transId) &&
                    Objects.equals(clientCode, negDeal.clientCode) &&
                    Objects.equals(repoValue, negDeal.repoValue) &&
                    Objects.equals(repo2Value, negDeal.repo2Value) &&
                    Objects.equals(repoTerm, negDeal.repoTerm) &&
                    Objects.equals(startDiscount, negDeal.startDiscount) &&
                    Objects.equals(lowerDiscount, negDeal.lowerDiscount) &&
                    Objects.equals(upperDiscount, negDeal.upperDiscount) &&
                    Objects.equals(blockSecurities, negDeal.blockSecurities) &&
                    Objects.equals(uid, negDeal.uid) &&
                    Objects.equals(withdrawTime, negDeal.withdrawTime) &&
                    Objects.equals(negDealDate, negDeal.negDealDate) &&
                    Objects.equals(balance, negDeal.balance) &&
                    Objects.equals(originRepoValue, negDeal.originRepoValue) &&
                    Objects.equals(originQty, negDeal.originQty) &&
                    Objects.equals(originDiscount, negDeal.originDiscount) &&
                    Objects.equals(negDealActivationDate, negDeal.negDealActivationDate) &&
                    Objects.equals(negDealActivationTime, negDeal.negDealActivationTime) &&
                    Objects.equals(quoteNo, negDeal.quoteNo) &&
                    Objects.equals(settleCurrency, negDeal.settleCurrency) &&
                    Objects.equals(secCode, negDeal.secCode) &&
                    Objects.equals(classCode, negDeal.classCode) &&
                    Objects.equals(bankAccId, negDeal.bankAccId) &&
                    Objects.equals(withdrawDate, negDeal.withdrawDate) &&
                    Objects.equals(linkedOrder, negDeal.linkedOrder) &&
                    Objects.equals(activationDateTime, negDeal.activationDateTime) &&
                    Objects.equals(withdrawDateTime, negDeal.withdrawDateTime) &&
                    Objects.equals(dateTime, negDeal.dateTime);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(
                    negDealNum,
                    negDealTime,
                    flags,
                    brokerRef,
                    userId,
                    firmId,
                    cpUserId,
                    cpFirmId,
                    account,
                    price,
                    qty,
                    matchRef,
                    settleCode,
                    yield,
                    accruedInt,
                    value,
                    price2,
                    repoRate,
                    refundRate,
                    transId,
                    clientCode,
                    repoEntry,
                    repoValue,
                    repo2Value,
                    repoTerm,
                    startDiscount,
                    lowerDiscount,
                    upperDiscount,
                    blockSecurities,
                    uid,
                    withdrawTime,
                    negDealDate,
                    balance,
                    originRepoValue,
                    originQty,
                    originDiscount,
                    negDealActivationDate,
                    negDealActivationTime,
                    quoteNo,
                    settleCurrency,
                    secCode,
                    classCode,
                    bankAccId,
                    withdrawDate,
                    linkedOrder,
                    activationDateTime,
                    withdrawDateTime,
                    dateTime
            );
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("neg_deal_num", negDealNum)
                    .add("neg_deal_time", negDealTime)
                    .add("flags", flags)
                    .add("brokerref", brokerRef)
                    .add("userid", userId)
                    .add("firmid", firmId)
                    .add("cpuserid", cpUserId)
                    .add("cpfirmid", cpFirmId)
                    .add("account", account)
                    .add("price", price)
                    .add("qty", qty)
                    .add("matchref", matchRef)
                    .add("settlecode", settleCode)
                    .add("yield", yield)
                    .add("accruedint", accruedInt)
                    .add("value", value)
                    .add("price2", price2)
                    .add("reporate", repoRate)
                    .add("refundrate", refundRate)
                    .add("trans_id", transId)
                    .add("client_code", clientCode)
                    .add("repoentry", repoEntry)
                    .add("repovalue", repoValue)
                    .add("repo2value", repo2Value)
                    .add("repoterm", repoTerm)
                    .add("start_discount", startDiscount)
                    .add("lower_discount", lowerDiscount)
                    .add("upper_discount", upperDiscount)
                    .add("block_securities", blockSecurities)
                    .add("uid", uid)
                    .add("withdraw_time", withdrawTime)
                    .add("neg_deal_date", negDealDate)
                    .add("balance", balance)
                    .add("origin_repovalue", originRepoValue)
                    .add("origin_qty", originQty)
                    .add("origin_discount", originDiscount)
                    .add("neg_deal_activation_date", negDealActivationDate)
                    .add("neg_deal_activation_time", negDealActivationTime)
                    .add("quoteno", quoteNo)
                    .add("settle_currency", settleCurrency)
                    .add("sec_code", secCode)
                    .add("class_code", classCode)
                    .add("bank_acc_id", bankAccId)
                    .add("withdraw_date", withdrawDate)
                    .add("linkedorder", linkedOrder)
                    .add("activation_date_time", activationDateTime)
                    .add("withdraw_date_time", withdrawDateTime)
                    .add("date_time", dateTime)
                    .toString();
        }

        return asString;
    }
}
