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

import java.util.Objects;

@Value
public class Order {

    private static final String ORDER_NUM = "order_num";
    private static final String FLAGS = "flags";
    private static final String BROKER_REF = "brokerref";
    private static final String USER_ID = "userid";
    private static final String FIRM_ID = "firmid";
    private static final String ACCOUNT = "account";
    private static final String PRICE = "price";
    private static final String QTY = "qty";
    private static final String BALANCE = "balance";
    private static final String VALUE = "value";
    private static final String ACCRUED_INT = "accruedint";
    private static final String YIELD = "yield";
    private static final String TRANS_ID = "trans_id";
    private static final String CLIENT_CODE = "client_code";
    private static final String PRICE_2 = "price2";
    private static final String SETTLE_CODE = "settlecode";
    private static final String UID = "uid";
    private static final String CANCELED_UID = "canceled_uid";
    private static final String EXCHANGE_CODE = "exchange_code";
    private static final String ACTIVATION_TIME = "activation_time";
    private static final String LINKED_ORDER = "linkedorder";
    private static final String EXPIRY = "expiry";
    private static final String SEC_CODE = "sec_code";
    private static final String CLASS_CODE = "class_code";
    private static final String DATE_TIME = "datetime";
    private static final String WITHDRAW_DATE_TIME = "withdraw_datetime";
    private static final String BANK_ACC_ID = "bank_acc_id";
    private static final String VALUE_ENTRY_TYPE = "value_entry_type";
    private static final String REPO_TERM = "repoterm";
    private static final String REPO_VALUE = "repovalue";
    private static final String REPO_2_VALUE = "repo2value";
    private static final String REPO_VALUE_BALANCE = "repo_value_balance";
    private static final String START_DISCOUNT = "start_discount";
    private static final String REJECT_REASON = "reject_reason";
    private static final String EXT_ORDER_FLAGS = "ext_order_flags";
    private static final String MIN_QTY = "min_qty";
    private static final String EXEC_TYPE = "exec_type";
    private static final String SIDE_QUALIFIER = "side_qualifier";
    private static final String ACCOUNT_TYPE = "acnt_type";
    private static final String CAPACITY = "capacity";
    private static final String PASSIVE_ONLY_ORDER = "passive_only_order";
    private static final String VISIBLE = "visible";
    private static final String AWG_PRICE = "awg_price";
    private static final String EXPIRY_TIME = "expiry_time";
    private static final String REVISION_NUMBER = "revision_number";
    private static final String PRICE_CURRENCY = "price_currency";
    private static final String EXT_ORDER_STATUS = "ext_order_status";
    private static final String ACCEPTED_UID = "accepted_uid";
    private static final String FILLED_VALUE = "filled_value";
    private static final String EXT_REF = "extref";
    private static final String SETTLE_CURRENCY = "settle_currency";
    private static final String ON_BEHALF_OF_UID = "on_behalf_of_uid";
    private static final String CLIENT_QUALIFIER = "client_qualifier";
    private static final String CLIENT_SHORT_CODE = "client_short_code";
    private static final String INVESTMENT_DECISION_MAKER_QUALIFIER = "investment_decision_maker_qualifier";
    private static final String INVESTMENT_DECISION_MAKER_SHORT_CODE = "investment_decision_maker_short_code";
    private static final String EXECUTING_TRADER_QUALIFIER = "executing_trader_qualifier";
    private static final String EXECUTING_TRADER_SHORT_CODE = "executing_trader_short_code";

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
    String awgPrice;
    String expiryTime;
    String revisionNumber;
    String priceCurrency;
    int extOrderStatus;
    String acceptedUid;
    String filledValue;
    String extRef;
    String settleCurrency;
    String onBehalfOfUid;
    int clientQualifier;
    String clientShortCode;
    int investmentDecisionMakerQualifier;
    String investmentDecisionMakerShortCode;
    int executingTraderQualifier;
    String executingTraderShortCode;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient int hashCode;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient String asString;

    @JsonCreator
    @Builder
    private Order(
            @JsonProperty(value = ORDER_NUM, required = true) final long orderNum,
            @JsonProperty(value = FLAGS, required = true) final int flags,
            @JsonProperty(BROKER_REF) final String brokerRef,
            @JsonProperty(USER_ID) final String userId,
            @JsonProperty(FIRM_ID) final String firmId,
            @JsonProperty(ACCOUNT) final String account,
            @JsonProperty(value = PRICE, required = true) final String price,
            @JsonProperty(value = QTY, required = true) final int qty,
            @JsonProperty(BALANCE) final String balance,
            @JsonProperty(value = VALUE, required = true) final String value,
            @JsonProperty(ACCRUED_INT) final String accruedInt,
            @JsonProperty(YIELD) final String yield,
            @JsonProperty(TRANS_ID) final String transId,
            @JsonProperty(CLIENT_CODE) final String clientCode,
            @JsonProperty(PRICE_2) final String price2,
            @JsonProperty(SETTLE_CODE) final String settleCode,
            @JsonProperty(UID) final String uid,
            @JsonProperty(CANCELED_UID) final String canceledUid,
            @JsonProperty(EXCHANGE_CODE) final String exchangeCode,
            @JsonProperty(ACTIVATION_TIME) final String activationTime,
            @JsonProperty(LINKED_ORDER) final String linkedOrder,
            @JsonProperty(EXPIRY) final String expiry,
            @JsonProperty(value = SEC_CODE, required = true) final String secCode,
            @JsonProperty(value = CLASS_CODE, required = true) final String classCode,
            @JsonProperty(value = DATE_TIME, required = true) final DateTimeEntry datetime,
            @JsonProperty(WITHDRAW_DATE_TIME) final DateTimeEntry withdrawDatetime,
            @JsonProperty(BANK_ACC_ID) final String bankAccId,
            @JsonProperty(value = VALUE_ENTRY_TYPE, required = true) final int valueEntryType,
            @JsonProperty(REPO_TERM) final String repoTerm,
            @JsonProperty(REPO_VALUE) final String repoValue,
            @JsonProperty(REPO_2_VALUE) final String repo2Value,
            @JsonProperty(REPO_VALUE_BALANCE) final String repoValueBalance,
            @JsonProperty(START_DISCOUNT) final String startDiscount,
            @JsonProperty(REJECT_REASON) final String rejectReason,
            @JsonProperty(EXT_ORDER_FLAGS) final String extOrderFlags,
            @JsonProperty(value = MIN_QTY, required = true) final int minQty,
            @JsonProperty(value = EXEC_TYPE, required = true) final int execType,
            @JsonProperty(value = SIDE_QUALIFIER, required = true) final int sideQualifier,
            @JsonProperty(value = ACCOUNT_TYPE, required = true) final int acntType,
            @JsonProperty(value = CAPACITY, required = true) final int capacity,
            @JsonProperty(value = PASSIVE_ONLY_ORDER, required = true) final int passiveOnlyOrder,
            @JsonProperty(value = VISIBLE, required = true) final int visible,
            @JsonProperty(AWG_PRICE) final String awgPrice,
            @JsonProperty(EXPIRY_TIME) final String expiryTime,
            @JsonProperty(REVISION_NUMBER) final String revisionNumber,
            @JsonProperty(PRICE_CURRENCY) final String priceCurrency,
            @JsonProperty(value = EXT_ORDER_STATUS, required = true) final int extOrderStatus,
            @JsonProperty(ACCEPTED_UID) final String acceptedUid,
            @JsonProperty(FILLED_VALUE) final String filledValue,
            @JsonProperty(EXT_REF) final String extRef,
            @JsonProperty(SETTLE_CURRENCY) final String settleCurrency,
            @JsonProperty(ON_BEHALF_OF_UID) final String onBehalfOfUid,
            @JsonProperty(CLIENT_QUALIFIER) final int clientQualifier,
            @JsonProperty(CLIENT_SHORT_CODE) final String clientShortCode,
            @JsonProperty(INVESTMENT_DECISION_MAKER_QUALIFIER) final int investmentDecisionMakerQualifier,
            @JsonProperty(INVESTMENT_DECISION_MAKER_SHORT_CODE) final String investmentDecisionMakerShortCode,
            @JsonProperty(EXECUTING_TRADER_QUALIFIER) final int executingTraderQualifier,
            @JsonProperty(EXECUTING_TRADER_SHORT_CODE) final String executingTraderShortCode) {

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
        this.awgPrice = awgPrice;
        this.expiryTime = expiryTime;
        this.revisionNumber = revisionNumber;
        this.priceCurrency = priceCurrency;
        this.extOrderStatus = extOrderStatus;
        this.acceptedUid = acceptedUid;
        this.filledValue = filledValue;
        this.extRef = extRef;
        this.settleCurrency = settleCurrency;
        this.onBehalfOfUid = onBehalfOfUid;
        this.clientQualifier = clientQualifier;
        this.clientShortCode = clientShortCode;
        this.investmentDecisionMakerQualifier = investmentDecisionMakerQualifier;
        this.investmentDecisionMakerShortCode = investmentDecisionMakerShortCode;
        this.executingTraderQualifier = executingTraderQualifier;
        this.executingTraderShortCode = executingTraderShortCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
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
                extOrderStatus == order.extOrderStatus &&
                clientQualifier == order.clientQualifier &&
                investmentDecisionMakerQualifier == order.investmentDecisionMakerQualifier &&
                executingTraderQualifier == order.executingTraderQualifier &&
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
                Objects.equals(extOrderFlags, order.extOrderFlags) &&
                Objects.equals(awgPrice, order.awgPrice) &&
                Objects.equals(expiryTime, order.expiryTime) &&
                Objects.equals(revisionNumber, order.revisionNumber) &&
                Objects.equals(priceCurrency, order.priceCurrency) &&
                Objects.equals(acceptedUid, order.acceptedUid) &&
                Objects.equals(filledValue, order.filledValue) &&
                Objects.equals(extRef, order.extRef) &&
                Objects.equals(settleCurrency, order.settleCurrency) &&
                Objects.equals(onBehalfOfUid, order.onBehalfOfUid) &&
                Objects.equals(clientShortCode, order.clientShortCode) &&
                Objects.equals(investmentDecisionMakerShortCode, order.investmentDecisionMakerShortCode) &&
                Objects.equals(executingTraderShortCode, order.executingTraderShortCode);
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
                    visible,
                    awgPrice,
                    expiryTime,
                    revisionNumber,
                    priceCurrency,
                    extOrderStatus,
                    acceptedUid,
                    filledValue,
                    extRef,
                    settleCurrency,
                    onBehalfOfUid,
                    clientQualifier,
                    clientShortCode,
                    investmentDecisionMakerQualifier,
                    investmentDecisionMakerShortCode,
                    executingTraderQualifier,
                    executingTraderShortCode
            );
        }

        return hashCode;
    }

    @NotNull
    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add(ORDER_NUM, orderNum)
                    .add(FLAGS, flags)
                    .add(BROKER_REF, brokerRef)
                    .add(USER_ID, userId)
                    .add(FIRM_ID, firmId)
                    .add(ACCOUNT, account)
                    .add(PRICE, price)
                    .add(QTY, qty)
                    .add(BALANCE, balance)
                    .add(VALUE, value)
                    .add(ACCRUED_INT, accruedInt)
                    .add(YIELD, yield)
                    .add(TRANS_ID, transId)
                    .add(CLIENT_CODE, clientCode)
                    .add(PRICE_2, price2)
                    .add(SETTLE_CODE, settleCode)
                    .add(UID, uid)
                    .add(CANCELED_UID, canceledUid)
                    .add(EXCHANGE_CODE, exchangeCode)
                    .add(ACTIVATION_TIME, activationTime)
                    .add(LINKED_ORDER, linkedOrder)
                    .add(EXPIRY, expiry)
                    .add(SEC_CODE, secCode)
                    .add(CLASS_CODE, classCode)
                    .add(DATE_TIME, datetime)
                    .add(WITHDRAW_DATE_TIME, withdrawDatetime)
                    .add(BANK_ACC_ID, bankAccId)
                    .add(VALUE_ENTRY_TYPE, valueEntryType)
                    .add(REPO_TERM, repoTerm)
                    .add(REPO_VALUE, repoValue)
                    .add(REPO_2_VALUE, repo2Value)
                    .add(REPO_VALUE_BALANCE, repoValueBalance)
                    .add(START_DISCOUNT, startDiscount)
                    .add(REJECT_REASON, rejectReason)
                    .add(EXT_ORDER_FLAGS, extOrderFlags)
                    .add(MIN_QTY, minQty)
                    .add(EXEC_TYPE, execType)
                    .add(SIDE_QUALIFIER, sideQualifier)
                    .add(ACCOUNT_TYPE, acntType)
                    .add(CAPACITY, capacity)
                    .add(PASSIVE_ONLY_ORDER, passiveOnlyOrder)
                    .add(VISIBLE, visible)
                    .add(AWG_PRICE, awgPrice)
                    .add(EXPIRY_TIME, expiryTime)
                    .add(REVISION_NUMBER, revisionNumber)
                    .add(PRICE_CURRENCY, priceCurrency)
                    .add(EXT_ORDER_STATUS, extOrderStatus)
                    .add(ACCEPTED_UID, acceptedUid)
                    .add(FILLED_VALUE, filledValue)
                    .add(EXT_REF, extRef)
                    .add(SETTLE_CURRENCY, settleCurrency)
                    .add(ON_BEHALF_OF_UID, onBehalfOfUid)
                    .add(CLIENT_QUALIFIER, clientQualifier)
                    .add(CLIENT_SHORT_CODE, clientShortCode)
                    .add(INVESTMENT_DECISION_MAKER_QUALIFIER, investmentDecisionMakerQualifier)
                    .add(INVESTMENT_DECISION_MAKER_SHORT_CODE, investmentDecisionMakerShortCode)
                    .add(EXECUTING_TRADER_QUALIFIER, executingTraderQualifier)
                    .add(EXECUTING_TRADER_SHORT_CODE, executingTraderShortCode)
                    .toString();
        }

        return asString;
    }
}
