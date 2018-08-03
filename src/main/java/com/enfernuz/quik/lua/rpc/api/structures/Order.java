package com.enfernuz.quik.lua.rpc.api.structures;

import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class Order {

    long orderNum;
    int flags;
    String brokerRef;
    String userId;
    String firmId;
    String account;
    String price;
    int qty;
    String balance;
    String value;
    String accruedInt;
    String yield;
    String transId;
    String clientCode;
    String price2;
    String settleCode;
    String uid;
    String canceledUid;
    String exchangeCode;
    String activationTime;
    String linkedOrder;
    String expiry;
    String secCode;
    String classCode;
    DateTimeEntry datetime;
    DateTimeEntry withdrawDatetime;
    String bankAccId;
    int valueEntryType;
    String repoTerm;
    String repoValue;
    String repo2Value;
    String repoValueBalance;
    String startDiscount;
    String rejectReason;
    String extOrderFlags;
    int minQty;
    int execType;
    int sideQualifier;
    int acntType;
    int capacity;
    int passiveOnlyOrder;
    int visible;

    private transient @NonFinal @Getter(AccessLevel.NONE) int hashCode;
    private transient @NonFinal @Getter(AccessLevel.NONE) String asString;

    @Builder
    private Order(
            final long orderNum,
            final int flags,
            final String brokerRef,
            final String userId,
            final String firmId,
            final String account,
            final String price,
            final int qty,
            final String balance,
            final String value,
            final String accruedInt,
            final String yield,
            final String transId,
            final String clientCode,
            final String price2,
            final String settleCode,
            final String uid,
            final String canceledUid,
            final String exchangeCode,
            final String activationTime,
            final String linkedOrder,
            final String expiry,
            final String secCode,
            final String classCode,
            final DateTimeEntry datetime,
            final DateTimeEntry withdrawDatetime,
            final String bankAccId,
            final int valueEntryType,
            final String repoTerm,
            final String repoValue,
            final String repo2Value,
            final String repoValueBalance,
            final String startDiscount,
            final String rejectReason,
            final String extOrderFlags,
            final int minQty,
            final int execType,
            final int sideQualifier,
            final int acntType,
            final int capacity,
            final int passiveOnlyOrder,
            final int visible) {

        this.orderNum = orderNum;
        this.flags = flags;
        this.brokerRef = brokerRef;
        this.userId = userId;
        this.firmId = firmId;
        this.account = account;
        this.price = price;
        this.qty = qty;
        this.balance = balance;
        this.value = value;
        this.accruedInt = accruedInt;
        this.yield = yield;
        this.transId = transId;
        this.clientCode = clientCode;
        this.price2 = price2;
        this.settleCode = settleCode;
        this.uid = uid;
        this.canceledUid = canceledUid;
        this.exchangeCode = exchangeCode;
        this.activationTime = activationTime;
        this.linkedOrder = linkedOrder;
        this.expiry = expiry;
        this.secCode = secCode;
        this.classCode = classCode;
        this.datetime = datetime;
        this.withdrawDatetime = withdrawDatetime;
        this.bankAccId = bankAccId;
        this.valueEntryType = valueEntryType;
        this.repoTerm = repoTerm;
        this.repoValue = repoValue;
        this.repo2Value = repo2Value;
        this.repoValueBalance = repoValueBalance;
        this.startDiscount = startDiscount;
        this.rejectReason = rejectReason;
        this.extOrderFlags = extOrderFlags;
        this.minQty = minQty;
        this.execType = execType;
        this.sideQualifier = sideQualifier;
        this.acntType = acntType;
        this.capacity = capacity;
        this.passiveOnlyOrder = passiveOnlyOrder;
        this.visible = visible;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof Order) ) {
            return false;
        } else {
            final Order order = (Order) o;
            return orderNum == order.orderNum &&
                    flags == order.flags &&
                    qty == order.qty &&
                    valueEntryType == order.valueEntryType &&
                    minQty == order.minQty &&
                    execType == order.execType &&
                    sideQualifier == order.sideQualifier &&
                    acntType == order.acntType &&
                    capacity == order.capacity &&
                    passiveOnlyOrder == order.passiveOnlyOrder &&
                    visible == order.visible &&
                    Objects.equals(brokerRef, order.brokerRef) &&
                    Objects.equals(userId, order.userId) &&
                    Objects.equals(firmId, order.firmId) &&
                    Objects.equals(account, order.account) &&
                    Objects.equals(price, order.price) &&
                    Objects.equals(balance, order.balance) &&
                    Objects.equals(value, order.value) &&
                    Objects.equals(accruedInt, order.accruedInt) &&
                    Objects.equals(yield, order.yield) &&
                    Objects.equals(transId, order.transId) &&
                    Objects.equals(clientCode, order.clientCode) &&
                    Objects.equals(price2, order.price2) &&
                    Objects.equals(settleCode, order.settleCode) &&
                    Objects.equals(uid, order.uid) &&
                    Objects.equals(canceledUid, order.canceledUid) &&
                    Objects.equals(exchangeCode, order.exchangeCode) &&
                    Objects.equals(activationTime, order.activationTime) &&
                    Objects.equals(linkedOrder, order.linkedOrder) &&
                    Objects.equals(expiry, order.expiry) &&
                    Objects.equals(secCode, order.secCode) &&
                    Objects.equals(classCode, order.classCode) &&
                    Objects.equals(datetime, order.datetime) &&
                    Objects.equals(withdrawDatetime, order.withdrawDatetime) &&
                    Objects.equals(bankAccId, order.bankAccId) &&
                    Objects.equals(repoTerm, order.repoTerm) &&
                    Objects.equals(repoValue, order.repoValue) &&
                    Objects.equals(repo2Value, order.repo2Value) &&
                    Objects.equals(repoValueBalance, order.repoValueBalance) &&
                    Objects.equals(startDiscount, order.startDiscount) &&
                    Objects.equals(rejectReason, order.rejectReason) &&
                    Objects.equals(extOrderFlags, order.extOrderFlags);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(
                    orderNum,
                    flags,
                    brokerRef,
                    userId,
                    firmId,
                    account,
                    price,
                    qty,
                    balance,
                    value,
                    accruedInt,
                    yield,
                    transId,
                    clientCode,
                    price2,
                    settleCode,
                    uid,
                    canceledUid,
                    exchangeCode,
                    activationTime,
                    linkedOrder,
                    expiry,
                    secCode,
                    classCode,
                    datetime,
                    withdrawDatetime,
                    bankAccId,
                    valueEntryType,
                    repoTerm,
                    repoValue,
                    repo2Value,
                    repoValueBalance,
                    startDiscount,
                    rejectReason,
                    extOrderFlags,
                    minQty,
                    execType,
                    sideQualifier,
                    acntType,
                    capacity,
                    passiveOnlyOrder,
                    visible
            );
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("order_num", orderNum)
                    .add("flags", flags)
                    .add("brokerref", brokerRef)
                    .add("userid", userId)
                    .add("firmid", firmId)
                    .add("account", account)
                    .add("price", price)
                    .add("qty", qty)
                    .add("balance", balance)
                    .add("value", value)
                    .add("accruedint", accruedInt)
                    .add("yield", yield)
                    .add("trans_id", transId)
                    .add("client_code", clientCode)
                    .add("price2", price2)
                    .add("settlecode", settleCode)
                    .add("uid", uid)
                    .add("canceled_uid", canceledUid)
                    .add("exchange_code", exchangeCode)
                    .add("activation_time", activationTime)
                    .add("linkedorder", linkedOrder)
                    .add("expiry", expiry)
                    .add("sec_code", secCode)
                    .add("class_code", classCode)
                    .add("datetime", datetime)
                    .add("withdraw_datetime", withdrawDatetime)
                    .add("bank_acc_id", bankAccId)
                    .add("value_entry_type", valueEntryType)
                    .add("repoterm", repoTerm)
                    .add("repovalue", repoValue)
                    .add("repo2value", repo2Value)
                    .add("repo_value_balance", repoValueBalance)
                    .add("start_discount", startDiscount)
                    .add("reject_reason", rejectReason)
                    .add("ext_order_flags", extOrderFlags)
                    .add("min_qty", minQty)
                    .add("exec_type", execType)
                    .add("side_qualifier", sideQualifier)
                    .add("acnt_type", acntType)
                    .add("capacity", capacity)
                    .add("passive_only_order", passiveOnlyOrder)
                    .add("visible", visible)
                    .toString();
        }

        return asString;
    }
}
