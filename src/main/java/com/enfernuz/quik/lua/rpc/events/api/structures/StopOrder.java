package com.enfernuz.quik.lua.rpc.events.api.structures;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class StopOrder {

    long orderNum;
    String orderTime;
    int flags;
    String brokerRef;
    String firmId;
    String account;
    int condition;
    String conditionPrice;
    String price;
    int qty;
    String linkedOrder;
    String expiry;
    String transId;
    String clientCode;
    String coOrderNum;
    String coOrderPrice;
    int stopOrderType;
    String orderDate;
    String allTradeNum;
    int stopFlags;
    String offset;
    String spread;
    String balance;
    String uid;
    int filledQty;
    String withdrawTime;
    String conditionPrice2;
    String activeFromTime;
    String activeToTime;
    String secCode;
    String classCode;
    String conditionSecCode;
    String conditionClassCode;
    String canceledUid;
    DateTimeEntry orderDateTime;
    DateTimeEntry withdrawDateTime;

    private transient @NonFinal @Getter(AccessLevel.NONE) int hashCode;
    private transient @NonFinal @Getter(AccessLevel.NONE) String asString;

    @Builder
    private StopOrder(
            final long orderNum,
            final String orderTime,
            final int flags,
            final String brokerRef,
            final String firmId,
            final String account,
            final int condition,
            final String conditionPrice,
            final String price,
            final int qty,
            final String linkedOrder,
            final String expiry,
            final String transId,
            final String clientCode,
            final String coOrderNum,
            final String coOrderPrice,
            final int stopOrderType,
            final String orderDate,
            final String allTradeNum,
            final int stopFlags,
            final String offset,
            final String spread,
            final String balance,
            final String uid,
            final int filledQty,
            final String withdrawTime,
            final String conditionPrice2,
            final String activeFromTime,
            final String activeToTime,
            final String secCode,
            final String classCode,
            final String conditionSecCode,
            final String conditionClassCode,
            final String canceledUid,
            final DateTimeEntry orderDateTime,
            final DateTimeEntry withdrawDateTime) {

        this.orderNum = orderNum;
        this.orderTime = orderTime;
        this.flags = flags;
        this.brokerRef = brokerRef;
        this.firmId = firmId;
        this.account = account;
        this.condition = condition;
        this.conditionPrice = conditionPrice;
        this.price = price;
        this.qty = qty;
        this.linkedOrder = linkedOrder;
        this.expiry = expiry;
        this.transId = transId;
        this.clientCode = clientCode;
        this.coOrderNum = coOrderNum;
        this.coOrderPrice = coOrderPrice;
        this.stopOrderType = stopOrderType;
        this.orderDate = orderDate;
        this.allTradeNum = allTradeNum;
        this.stopFlags = stopFlags;
        this.offset = offset;
        this.spread = spread;
        this.balance = balance;
        this.uid = uid;
        this.filledQty = filledQty;
        this.withdrawTime = withdrawTime;
        this.conditionPrice2 = conditionPrice2;
        this.activeFromTime = activeFromTime;
        this.activeToTime = activeToTime;
        this.secCode = secCode;
        this.classCode = classCode;
        this.conditionSecCode = conditionSecCode;
        this.conditionClassCode = conditionClassCode;
        this.canceledUid = canceledUid;
        this.orderDateTime = orderDateTime;
        this.withdrawDateTime = withdrawDateTime;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof StopOrder) ) {
            return false;
        } else {
            final StopOrder stopOrder = (StopOrder) o;
            return orderNum == stopOrder.orderNum &&
                    flags == stopOrder.flags &&
                    condition == stopOrder.condition &&
                    qty == stopOrder.qty &&
                    stopOrderType == stopOrder.stopOrderType &&
                    stopFlags == stopOrder.stopFlags &&
                    filledQty == stopOrder.filledQty &&
                    Objects.equals(orderTime, stopOrder.orderTime) &&
                    Objects.equals(brokerRef, stopOrder.brokerRef) &&
                    Objects.equals(firmId, stopOrder.firmId) &&
                    Objects.equals(account, stopOrder.account) &&
                    Objects.equals(conditionPrice, stopOrder.conditionPrice) &&
                    Objects.equals(price, stopOrder.price) &&
                    Objects.equals(linkedOrder, stopOrder.linkedOrder) &&
                    Objects.equals(expiry, stopOrder.expiry) &&
                    Objects.equals(transId, stopOrder.transId) &&
                    Objects.equals(clientCode, stopOrder.clientCode) &&
                    Objects.equals(coOrderNum, stopOrder.coOrderNum) &&
                    Objects.equals(coOrderPrice, stopOrder.coOrderPrice) &&
                    Objects.equals(orderDate, stopOrder.orderDate) &&
                    Objects.equals(allTradeNum, stopOrder.allTradeNum) &&
                    Objects.equals(offset, stopOrder.offset) &&
                    Objects.equals(spread, stopOrder.spread) &&
                    Objects.equals(balance, stopOrder.balance) &&
                    Objects.equals(uid, stopOrder.uid) &&
                    Objects.equals(withdrawTime, stopOrder.withdrawTime) &&
                    Objects.equals(conditionPrice2, stopOrder.conditionPrice2) &&
                    Objects.equals(activeFromTime, stopOrder.activeFromTime) &&
                    Objects.equals(activeToTime, stopOrder.activeToTime) &&
                    Objects.equals(secCode, stopOrder.secCode) &&
                    Objects.equals(classCode, stopOrder.classCode) &&
                    Objects.equals(conditionSecCode, stopOrder.conditionSecCode) &&
                    Objects.equals(conditionClassCode, stopOrder.conditionClassCode) &&
                    Objects.equals(canceledUid, stopOrder.canceledUid) &&
                    Objects.equals(orderDateTime, stopOrder.orderDateTime) &&
                    Objects.equals(withdrawDateTime, stopOrder.withdrawDateTime);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(
                    orderNum,
                    orderTime,
                    flags,
                    brokerRef,
                    firmId,
                    account,
                    condition,
                    conditionPrice,
                    price,
                    qty,
                    linkedOrder,
                    expiry,
                    transId,
                    clientCode,
                    coOrderNum,
                    coOrderPrice,
                    stopOrderType,
                    orderDate,
                    allTradeNum,
                    stopFlags,
                    offset,
                    spread,
                    balance,
                    uid,
                    filledQty,
                    withdrawTime,
                    conditionPrice2,
                    activeFromTime,
                    activeToTime,
                    secCode,
                    classCode,
                    conditionSecCode,
                    conditionClassCode,
                    canceledUid,
                    orderDateTime,
                    withdrawDateTime
            );
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("order_num", orderNum)
                    .add("ordertime", orderTime)
                    .add("flags", flags)
                    .add("brokerref", brokerRef)
                    .add("firmid", firmId)
                    .add("account", account)
                    .add("condition", condition)
                    .add("condition_price", conditionPrice)
                    .add("price", price)
                    .add("qty", qty)
                    .add("linkedorder", linkedOrder)
                    .add("expiry", expiry)
                    .add("trans_id", transId)
                    .add("client_code", clientCode)
                    .add("co_order_num", coOrderNum)
                    .add("co_order_price", coOrderPrice)
                    .add("stop_order_type", stopOrderType)
                    .add("orderdate", orderDate)
                    .add("alltrade_num", allTradeNum)
                    .add("stopflags", stopFlags)
                    .add("offset", offset)
                    .add("spread", spread)
                    .add("balance", balance)
                    .add("uid", uid)
                    .add("filled_qty", filledQty)
                    .add("withdraw_time", withdrawTime)
                    .add("condition_price2", conditionPrice2)
                    .add("active_from_time", activeFromTime)
                    .add("active_to_time", activeToTime)
                    .add("sec_code", secCode)
                    .add("class_code", classCode)
                    .add("condition_sec_code", conditionSecCode)
                    .add("condition_class_code", conditionClassCode)
                    .add("canceled_uid", canceledUid)
                    .add("order_date_time", orderDateTime)
                    .add("withdraw_datetime", withdrawDateTime)
                    .toString();
        }

        return asString;
    }
}
