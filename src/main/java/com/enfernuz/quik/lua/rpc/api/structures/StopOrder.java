package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.*;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Value
public class StopOrder implements Comparable<StopOrder> {

    private static final String ORDER_NUMBER = "order_num";
    private static final String ORDER_TIME = "ordertime";
    private static final String FLAGS = "flags";
    private static final String BROKER_REF = "brokerref";
    private static final String FIRM_ID = "firmid";
    private static final String ACCOUNT = "account";
    private static final String CONDITION = "condition";
    private static final String CONDITION_PRICE = "condition_price";
    private static final String PRICE = "price";
    private static final String QUANTITY = "qty";
    private static final String LINKED_ORDER = "linkedorder";
    private static final String EXPIRY = "expiry";
    private static final String TRANSACTION_ID = "trans_id";
    private static final String CLIENT_CODE = "client_code";
    private static final String CO_ORDER_NUMBER = "co_order_num";
    private static final String CO_ORDER_PRICE = "co_order_price";
    private static final String STOP_ORDER_TYPE = "stop_order_type";
    private static final String ORDER_DATE = "orderdate";
    private static final String ALL_TRADE_NUMBER = "alltrade_num";
    private static final String STOP_FLAGS = "stopflags";
    private static final String OFFSET = "offset";
    private static final String SPREAD = "spread";
    private static final String BALANCE = "balance";
    private static final String UID = "uid";
    private static final String FILLED_QUANTITY = "filled_qty";
    private static final String WITHDRAW_TIME = "withdraw_time";
    private static final String CONDITION_PRICE_2 = "condition_price2";
    private static final String ACTIVE_FROM_TIME = "active_from_time";
    private static final String ACTIVE_TO_TIME = "active_to_time";
    private static final String SECURITY_CODE = "sec_code";
    private static final String CLASS_CODE = "class_code";
    private static final String CONDITION_SECURITY_CODE = "condition_sec_code";
    private static final String CONDITION_CLASS_CODE = "condition_class_code";
    private static final String CANCELED_UID = "canceled_uid";
    private static final String ORDER_DATE_TIME = "order_date_time";
    private static final String WITHDRAW_DATE_TIME = "withdraw_datetime";
    private static final String ACTIVATION_DATE_TIME = "activation_date_time";

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
    DateTimeEntry activationDateTime;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient int hashCode;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient String asString;

    @JsonCreator
    @Builder
    private StopOrder(
            @JsonProperty(value = ORDER_NUMBER, required = true) final long orderNum,
            @JsonProperty(ORDER_TIME) final String orderTime,
            @JsonProperty(value = FLAGS, required = true) final int flags,
            @JsonProperty(BROKER_REF) final String brokerRef,
            @JsonProperty(FIRM_ID) final String firmId,
            @JsonProperty(ACCOUNT) final String account,
            @JsonProperty(value = CONDITION, required = true) final int condition,
            @JsonProperty(value = CONDITION_PRICE, required = true) @NonNull final String conditionPrice,
            @JsonProperty(value = PRICE, required = true) @NonNull final String price,
            @JsonProperty(value = QUANTITY, required = true) final int qty,
            @JsonProperty(LINKED_ORDER) final String linkedOrder,
            @JsonProperty(EXPIRY) final String expiry,
            @JsonProperty(TRANSACTION_ID) final String transId,
            @JsonProperty(CLIENT_CODE) final String clientCode,
            @JsonProperty(CO_ORDER_NUMBER) final String coOrderNum,
            @JsonProperty(CO_ORDER_PRICE) final String coOrderPrice,
            @JsonProperty(value = STOP_ORDER_TYPE, required = true) final int stopOrderType,
            @JsonProperty(ORDER_DATE) final String orderDate,
            @JsonProperty(ALL_TRADE_NUMBER) final String allTradeNum,
            @JsonProperty(value = STOP_FLAGS, required = true) final int stopFlags,
            @JsonProperty(OFFSET) final String offset,
            @JsonProperty(SPREAD) final String spread,
            @JsonProperty(BALANCE) final String balance,
            @JsonProperty(UID) final String uid,
            @JsonProperty(value = FILLED_QUANTITY, required = true) final int filledQty,
            @JsonProperty(WITHDRAW_TIME) final String withdrawTime,
            @JsonProperty(CONDITION_PRICE_2) final String conditionPrice2,
            @JsonProperty(ACTIVE_FROM_TIME) final String activeFromTime,
            @JsonProperty(ACTIVE_TO_TIME) final String activeToTime,
            @JsonProperty(SECURITY_CODE) final String secCode,
            @JsonProperty(CLASS_CODE) final String classCode,
            @JsonProperty(CONDITION_SECURITY_CODE) final String conditionSecCode,
            @JsonProperty(CONDITION_CLASS_CODE) final String conditionClassCode,
            @JsonProperty(CANCELED_UID) final String canceledUid,
            @JsonProperty(value = ORDER_DATE_TIME, required = true) @NonNull final DateTimeEntry orderDateTime,
            @JsonProperty(WITHDRAW_DATE_TIME) final DateTimeEntry withdrawDateTime,
            @JsonProperty(ACTIVATION_DATE_TIME) final DateTimeEntry activationDateTime) {

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
        this.activationDateTime = activationDateTime;
    }

    @Override
    public int compareTo(@NotNull final StopOrder other) {
        return orderDateTime.compareTo(other.orderDateTime);
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
                    Objects.equals(withdrawDateTime, stopOrder.withdrawDateTime) &&
                    Objects.equals(activationDateTime, stopOrder.activationDateTime);
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
                    withdrawDateTime,
                    activationDateTime
            );
        }

        return hashCode;
    }

    @NotNull
    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add(ORDER_NUMBER, orderNum)
                    .add(ORDER_TIME, orderTime)
                    .add(FLAGS, flags)
                    .add(BROKER_REF, brokerRef)
                    .add(FIRM_ID, firmId)
                    .add(ACCOUNT, account)
                    .add(CONDITION, condition)
                    .add(CONDITION_PRICE, conditionPrice)
                    .add(PRICE, price)
                    .add(QUANTITY, qty)
                    .add(LINKED_ORDER, linkedOrder)
                    .add(EXPIRY, expiry)
                    .add(TRANSACTION_ID, transId)
                    .add(CLIENT_CODE, clientCode)
                    .add(CO_ORDER_NUMBER, coOrderNum)
                    .add(CO_ORDER_PRICE, coOrderPrice)
                    .add(STOP_ORDER_TYPE, stopOrderType)
                    .add(ORDER_DATE, orderDate)
                    .add(ALL_TRADE_NUMBER, allTradeNum)
                    .add(STOP_FLAGS, stopFlags)
                    .add(OFFSET, offset)
                    .add(SPREAD, spread)
                    .add(BALANCE, balance)
                    .add(UID, uid)
                    .add(FILLED_QUANTITY, filledQty)
                    .add(WITHDRAW_TIME, withdrawTime)
                    .add(CONDITION_PRICE_2, conditionPrice2)
                    .add(ACTIVE_FROM_TIME, activeFromTime)
                    .add(ACTIVE_TO_TIME, activeToTime)
                    .add(SECURITY_CODE, secCode)
                    .add(CLASS_CODE, classCode)
                    .add(CONDITION_SECURITY_CODE, conditionSecCode)
                    .add(CONDITION_CLASS_CODE, conditionClassCode)
                    .add(CANCELED_UID, canceledUid)
                    .add(ORDER_DATE_TIME, orderDateTime)
                    .add(WITHDRAW_DATE_TIME, withdrawDateTime)
                    .add(ACTIVATION_DATE_TIME, activationDateTime)
                    .toString();
        }

        return asString;
    }
}
