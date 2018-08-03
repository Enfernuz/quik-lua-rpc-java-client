package com.enfernuz.quik.lua.rpc.api.structures;

import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class TransReply {

    long transId;
    int status;
    String resultMsg;
    DateTimeEntry dateTime;
    String uid;
    int flags;
    String serverTransId;
    String orderNum;
    String price;
    String quantity;
    String balance;
    String firmId;
    String account;
    String clientCode;
    String brokerRef;
    String classCode;
    String secCode;
    String exchangeCode;

    private transient @NonFinal @Getter(AccessLevel.NONE) int hashCode;
    private transient @NonFinal @Getter(AccessLevel.NONE) String asString;

    @Builder
    private TransReply(
            final long transId,
            final int status,
            final String resultMsg,
            final DateTimeEntry dateTime,
            final String uid,
            final int flags,
            final String serverTransId,
            final String orderNum,
            final String price,
            final String quantity,
            final String balance,
            final String firmId,
            final String account,
            final String clientCode,
            final String brokerRef,
            final String classCode,
            final String secCode,
            final String exchangeCode) {

        this.transId = transId;
        this.status = status;
        this.resultMsg = resultMsg;
        this.dateTime = dateTime;
        this.uid = uid;
        this.flags = flags;
        this.serverTransId = serverTransId;
        this.orderNum = orderNum;
        this.price = price;
        this.quantity = quantity;
        this.balance = balance;
        this.firmId = firmId;
        this.account = account;
        this.clientCode = clientCode;
        this.brokerRef = brokerRef;
        this.classCode = classCode;
        this.secCode = secCode;
        this.exchangeCode = exchangeCode;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof TransReply) )  {
            return false;
        } else {
            final TransReply that = (TransReply) o;
            return transId == that.transId &&
                    status == that.status &&
                    flags == that.flags &&
                    Objects.equals(resultMsg, that.resultMsg) &&
                    Objects.equals(dateTime, that.dateTime) &&
                    Objects.equals(uid, that.uid) &&
                    Objects.equals(serverTransId, that.serverTransId) &&
                    Objects.equals(orderNum, that.orderNum) &&
                    Objects.equals(price, that.price) &&
                    Objects.equals(quantity, that.quantity) &&
                    Objects.equals(balance, that.balance) &&
                    Objects.equals(firmId, that.firmId) &&
                    Objects.equals(account, that.account) &&
                    Objects.equals(clientCode, that.clientCode) &&
                    Objects.equals(brokerRef, that.brokerRef) &&
                    Objects.equals(classCode, that.classCode) &&
                    Objects.equals(secCode, that.secCode) &&
                    Objects.equals(exchangeCode, that.exchangeCode);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(
                    transId,
                    status,
                    resultMsg,
                    dateTime,
                    uid,
                    flags,
                    serverTransId,
                    orderNum,
                    price,
                    quantity,
                    balance,
                    firmId,
                    account,
                    clientCode,
                    brokerRef,
                    classCode,
                    secCode,
                    exchangeCode
            );
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("trans_id", transId)
                    .add("status", status)
                    .add("result_msg", resultMsg)
                    .add("date_time", dateTime)
                    .add("uid", uid)
                    .add("flags", flags)
                    .add("server_trans_id", serverTransId)
                    .add("order_num", orderNum)
                    .add("price", price)
                    .add("quantity", quantity)
                    .add("balance", balance)
                    .add("firm_id", firmId)
                    .add("account", account)
                    .add("client_code", clientCode)
                    .add("brokerref", brokerRef)
                    .add("class_code", classCode)
                    .add("sec_code", secCode)
                    .add("exchange_code", exchangeCode)
                    .toString();
        }

        return asString;
    }
}
