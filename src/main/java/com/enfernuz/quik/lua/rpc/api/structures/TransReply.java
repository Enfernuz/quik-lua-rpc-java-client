package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.jetbrains.annotations.NotNull;

@Value
public class TransReply {

    private static final String TRANSACTION_ID = "trans_id";
    private static final String STATUS = "status";
    private static final String RESULT_MESSAGE = "result_msg";
    private static final String DATE_TIME = "date_time";
    private static final String UID = "uid";
    private static final String FLAGS = "flags";
    private static final String SERVER_TRANSACTION_ID = "server_trans_id";
    private static final String ORDER_NUMBER = "order_num";
    private static final String PRICE = "price";
    private static final String QUANTITY = "quantity";
    private static final String BALANCE = "balance";
    private static final String FIRM_ID = "firm_id";
    private static final String ACCOUNT = "account";
    private static final String CLIENT_CODE = "client_code";
    private static final String BROKER_REF = "brokerref";
    private static final String CLASS_CODE = "class_code";
    private static final String SECURITY_CODE = "sec_code";
    private static final String EXCHANGE_CODE = "exchange_code";
    private static final String ERROR_CODE = "error_code";
    private static final String ERROR_SOURCE = "error_source";
    private static final String FIRST_ORDER_NUMBER = "first_ordernum";
    private static final String GATE_REPLY_TIME = "gate_reply_time";

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
    int errorCode;
    int errorSource;
    String firstOrderNum;
    DateTimeEntry gateReplyTime;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient String asString;

    @JsonCreator
    @Builder
    private TransReply(
            @JsonProperty(value = TRANSACTION_ID, required = true) final long transId,
            @JsonProperty(value = STATUS, required = true) final int status,
            @JsonProperty(value = RESULT_MESSAGE, required = true) final String resultMsg,
            @JsonProperty(value = DATE_TIME, required = true) final DateTimeEntry dateTime,
            @JsonProperty(value = UID, required = true) final String uid,
            @JsonProperty(value = FLAGS, required = true) final int flags,
            @JsonProperty(value = SERVER_TRANSACTION_ID, required = true) final String serverTransId,
            @JsonProperty(ORDER_NUMBER) final String orderNum,
            @JsonProperty(PRICE) final String price,
            @JsonProperty(QUANTITY) final String quantity,
            @JsonProperty(BALANCE) final String balance,
            @JsonProperty(FIRM_ID) final String firmId,
            @JsonProperty(ACCOUNT) final String account,
            @JsonProperty(CLIENT_CODE) final String clientCode,
            @JsonProperty(BROKER_REF) final String brokerRef,
            @JsonProperty(CLASS_CODE) final String classCode,
            @JsonProperty(SECURITY_CODE) final String secCode,
            @JsonProperty(EXCHANGE_CODE) final String exchangeCode,
            @JsonProperty(value = ERROR_CODE, required = true) final int errorCode,
            @JsonProperty(value = ERROR_SOURCE, required = true) final int errorSource,
            @JsonProperty(FIRST_ORDER_NUMBER) final String firstOrderNum,
            @JsonProperty(value = GATE_REPLY_TIME, required = true) final DateTimeEntry gateReplyTime) {

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
        this.errorCode = errorCode;
        this.errorSource = errorSource;
        this.firstOrderNum = firstOrderNum;
        this.gateReplyTime = gateReplyTime;
    }

    @NotNull
    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add(TRANSACTION_ID, transId)
                    .add(STATUS, status)
                    .add(RESULT_MESSAGE, resultMsg)
                    .add(DATE_TIME, dateTime)
                    .add(UID, uid)
                    .add(FLAGS, flags)
                    .add(SERVER_TRANSACTION_ID, serverTransId)
                    .add(ORDER_NUMBER, orderNum)
                    .add(PRICE, price)
                    .add(QUANTITY, quantity)
                    .add(BALANCE, balance)
                    .add(FIRM_ID, firmId)
                    .add(ACCOUNT, account)
                    .add(CLIENT_CODE, clientCode)
                    .add(BROKER_REF, brokerRef)
                    .add(CLASS_CODE, classCode)
                    .add(SECURITY_CODE, secCode)
                    .add(EXCHANGE_CODE, exchangeCode)
                    .add(ERROR_CODE, errorCode)
                    .add(ERROR_SOURCE, errorSource)
                    .add(FIRST_ORDER_NUMBER, firstOrderNum)
                    .add(GATE_REPLY_TIME, gateReplyTime)
                    .toString();
        }

        return asString;
    }
}
