package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

@Value
public class Trade {

    private static final String TRADE_NUM = "trade_num";
    private static final String ORDER_NUM = "order_num";
    private static final String BROKER_REF = "brokerref";
    private static final String USER_ID = "userid";
    private static final String FIRM_ID = "firmid";
    private static final String CANCELED_UID = "canceled_uid";
    private static final String ACCOUNT = "account";
    private static final String PRICE = "price";
    private static final String QUANTITY = "qty";
    private static final String VALUE = "value";
    private static final String ACCRUED_INTEREST = "accruedint";
    private static final String YIELD = "yield";
    private static final String SETTLE_CODE = "settlecode";
    private static final String COUNTERPARTY_FIRM_ID = "cpfirmid";
    private static final String FLAGS = "flags";
    private static final String PRICE_2 = "price2";
    private static final String REPO_RATE = "reporate";
    private static final String CLIENT_CODE = "client_code";
    private static final String ACCRUED_2 = "accrued2";
    private static final String REPO_TERM = "repoterm";
    private static final String REPO_VALUE = "repovalue";
    private static final String REPO_2_VALUE = "repo2value";
    private static final String START_DISCOUNT = "start_discount";
    private static final String LOWER_DISCOUNT = "lower_discount";
    private static final String UPPER_DISCOUNT = "upper_discount";
    private static final String BLOCK_SECURITIES = "block_securities";
    private static final String CLEARING_COMISSION = "clearing_comission";
    private static final String EXCHANGE_COMISSION = "exchange_comission";
    private static final String TECH_CENTER_COMISSION = "tech_center_comission";
    private static final String SETTLE_DATE = "settle_date";
    private static final String SETTLE_CURRENCY = "settle_currency";
    private static final String TRADE_CURRENCY = "trade_currency";
    private static final String EXCHANGE_CODE = "exchange_code";
    private static final String STATION_ID = "station_id";
    private static final String SECURITY_CODE = "sec_code";
    private static final String CLASS_CODE = "class_code";
    private static final String DATETIME = "datetime";
    private static final String BANK_ACC_ID = "bank_acc_id";
    private static final String BROKER_COMISSION = "broker_comission";
    private static final String LINKED_TRADE = "linked_trade";
    private static final String PERIOD = "period";
    private static final String TRANS_ID = "trans_id";
    private static final String KIND = "kind";
    private static final String CLEARING_BANK_ACC_ID = "clearing_bank_accid";
    private static final String CANCELED_DATETIME = "canceled_datetime";
    private static final String CLEARING_FIRM_ID = "clearing_firmid";
    private static final String SYSTEM_REF = "system_ref";
    private static final String UID = "uid";
    private static final String L_SECURITY_CODE = "lseccode";
    private static final String ORDER_REVISION_NUMBER = "order_revision_number";
    private static final String ORDER_QUANTITY = "order_qty";
    private static final String ORDER_PRICE = "order_price";
    private static final String ORDER_EXCHANGE_CODE = "order_exchange_code";
    private static final String EXEC_MARKET = "exec_market";
    private static final String LIQUIDITY_INDICATOR = "liquidity_indicator";
    private static final String EXT_REF = "extref";
    private static final String EXT_TRADE_FLAGS = "ext_trade_flags";
    private static final String ON_BEHALF_OF_UID = "on_behalf_of_uid";
    private static final String CLIENT_QUALIFIER = "client_qualifier";
    private static final String CLIENT_SHORT_CODE = "client_short_code";
    private static final String INVESTMENT_DECISION_MAKER_QUALIFIER = "investment_decision_maker_qualifier";
    private static final String INVESTMENT_DECISION_MAKER_SHORT_CODE = "investment_decision_maker_short_code";
    private static final String EXECUTING_TRADER_QUALIFIER = "executing_trader_qualifier";
    private static final String EXECUTING_TRADER_SHORT_CODE = "executing_trader_short_code";
    private static final String WAIVER_FLAG = "waiver_flag";
    private static final String MLEG_BASE_SID = "mleg_base_sid";
    private static final String SIDE_QUALIFIER = "side_qualifier";
    private static final String OTC_POST_TRADE_INDICATOR = "otc_post_trade_indicator";
    private static final String CAPACITY = "capacity";
    private static final String CROSS_RATE = "cross_rate";

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
    String lSecCode;
    String orderRevisionNumber;
    String orderQty;
    String orderPrice;
    String orderExchangeCode;
    String execMarket;
    int liquidityIndicator;
    String extRef;
    String extTradeFlags;
    String onBehalfOfUid;
    int clientQualifier;
    String clientShortCode;
    int investmentDecisionMakerQualifier;
    String investmentDecisionMakerShortCode;
    int executingTraderQualifier;
    String executingTraderShortCode;
    int waiverFlag;
    String mlegBaseSid;
    int sideQualifier;
    int otcPostTradeIndicator;
    int capacity;
    String crossRate;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient int hashCode;

    @Getter(AccessLevel.NONE)
    @NonFinal
    private transient String asString;

    @JsonCreator
    @Builder
    private Trade(
            @JsonProperty(value = TRADE_NUM, required = true) final long tradeNum,
            @JsonProperty(value = ORDER_NUM, required = true) final long orderNum,
            @JsonProperty(BROKER_REF) final String brokerRef,
            @JsonProperty(USER_ID) final String userId,
            @JsonProperty(FIRM_ID) final String firmId,
            @JsonProperty(CANCELED_UID) final String canceledUid,
            @JsonProperty(ACCOUNT) final String account,
            @JsonProperty(value = PRICE, required = true) final String price,
            @JsonProperty(value = QUANTITY, required = true) final int qty,
            @JsonProperty(value = VALUE, required = true) final String value,
            @JsonProperty(ACCRUED_INTEREST) final String accruedInt,
            @JsonProperty(YIELD) final String yield,
            @JsonProperty(SETTLE_CODE) final String settleCode,
            @JsonProperty(COUNTERPARTY_FIRM_ID) final String cpFirmId,
            @JsonProperty(value = FLAGS, required = true) final int flags,
            @JsonProperty(PRICE_2) final String price2,
            @JsonProperty(REPO_RATE) final String repoRate,
            @JsonProperty(CLIENT_CODE) final String clientCode,
            @JsonProperty(ACCRUED_2) final String accrued2,
            @JsonProperty(REPO_TERM) final String repoTerm,
            @JsonProperty(REPO_VALUE) final String repoValue,
            @JsonProperty(REPO_2_VALUE) final String repo2Value,
            @JsonProperty(START_DISCOUNT) final String startDiscount,
            @JsonProperty(LOWER_DISCOUNT) final String lowerDiscount,
            @JsonProperty(UPPER_DISCOUNT) final String upperDiscount,
            @JsonProperty(BLOCK_SECURITIES) final String blockSecurities,
            @JsonProperty(CLEARING_COMISSION) final String clearingComission,
            @JsonProperty(EXCHANGE_COMISSION) final String exchangeComission,
            @JsonProperty(TECH_CENTER_COMISSION) final String techCenterComission,
            @JsonProperty(SETTLE_DATE) final String settleDate,
            @JsonProperty(SETTLE_CURRENCY) final String settleCurrency,
            @JsonProperty(TRADE_CURRENCY) final String tradeCurrency,
            @JsonProperty(EXCHANGE_CODE) final String exchangeCode,
            @JsonProperty(STATION_ID) final String stationId,
            @JsonProperty(SECURITY_CODE) final String secCode,
            @JsonProperty(CLASS_CODE) final String classCode,
            @JsonProperty(value = DATETIME, required = true) final DateTimeEntry datetime,
            @JsonProperty(BANK_ACC_ID) final String bankAccId,
            @JsonProperty(BROKER_COMISSION) final String brokerComission,
            @JsonProperty(LINKED_TRADE) final String linkedTrade,
            @JsonProperty(value = PERIOD, required = true) final int period,
            @JsonProperty(TRANS_ID) final String transId,
            @JsonProperty(value = KIND, required = true) final int kind,
            @JsonProperty(CLEARING_BANK_ACC_ID) final String clearingBankAccId,
            @JsonProperty(CANCELED_DATETIME) final DateTimeEntry canceledDatetime,
            @JsonProperty(CLEARING_FIRM_ID) final String clearingFirmId,
            @JsonProperty(SYSTEM_REF) final String systemRef,
            @JsonProperty(UID) final String uid,
            @JsonProperty(L_SECURITY_CODE) final String lSecCode,
            @JsonProperty(ORDER_REVISION_NUMBER) final String orderRevisionNumber,
            @JsonProperty(ORDER_QUANTITY) final String orderQty,
            @JsonProperty(ORDER_PRICE) final String orderPrice,
            @JsonProperty(ORDER_EXCHANGE_CODE) final String orderExchangeCode,
            @JsonProperty(EXEC_MARKET) final String execMarket,
            @JsonProperty(value = LIQUIDITY_INDICATOR, required = true) final int liquidityIndicator,
            @JsonProperty(EXT_REF) final String extRef,
            @JsonProperty(EXT_TRADE_FLAGS) final String extTradeFlags,
            @JsonProperty(ON_BEHALF_OF_UID) final String onBehalfOfUid,
            @JsonProperty(value = CLIENT_QUALIFIER, required = true) final int clientQualifier,
            @JsonProperty(CLIENT_SHORT_CODE) final String clientShortCode,
            @JsonProperty(value = INVESTMENT_DECISION_MAKER_QUALIFIER, required = true) final int investmentDecisionMakerQualifier,
            @JsonProperty(INVESTMENT_DECISION_MAKER_SHORT_CODE) final String investmentDecisionMakerShortCode,
            @JsonProperty(value = EXECUTING_TRADER_QUALIFIER, required = true) final int executingTraderQualifier,
            @JsonProperty(EXECUTING_TRADER_SHORT_CODE) final String executingTraderShortCode,
            @JsonProperty(value = WAIVER_FLAG, required = true) final int waiverFlag,
            @JsonProperty(MLEG_BASE_SID) final String mlegBaseSid,
            @JsonProperty(value = SIDE_QUALIFIER, required = true) final int sideQualifier,
            @JsonProperty(value = OTC_POST_TRADE_INDICATOR, required = true) final int otcPostTradeIndicator,
            @JsonProperty(value = CAPACITY, required = true) final int capacity,
            @JsonProperty(CROSS_RATE) final String crossRate) {

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
        this.lSecCode = lSecCode;
        this.orderRevisionNumber = orderRevisionNumber;
        this.orderQty = orderQty;
        this.orderPrice = orderPrice;
        this.orderExchangeCode = orderExchangeCode;
        this.execMarket = execMarket;
        this.liquidityIndicator = liquidityIndicator;
        this.extRef = extRef;
        this.extTradeFlags = extTradeFlags;
        this.onBehalfOfUid = onBehalfOfUid;
        this.clientQualifier = clientQualifier;
        this.clientShortCode = clientShortCode;
        this.investmentDecisionMakerQualifier = investmentDecisionMakerQualifier;
        this.investmentDecisionMakerShortCode = investmentDecisionMakerShortCode;
        this.executingTraderQualifier = executingTraderQualifier;
        this.executingTraderShortCode = executingTraderShortCode;
        this.waiverFlag = waiverFlag;
        this.mlegBaseSid = mlegBaseSid;
        this.sideQualifier = sideQualifier;
        this.otcPostTradeIndicator = otcPostTradeIndicator;
        this.capacity = capacity;
        this.crossRate = crossRate;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add(TRADE_NUM, tradeNum)
                    .add(ORDER_NUM, orderNum)
                    .add(BROKER_REF, brokerRef)
                    .add(USER_ID, userId)
                    .add(FIRM_ID, firmId)
                    .add(CANCELED_UID, canceledUid)
                    .add(ACCOUNT, account)
                    .add(PRICE, price)
                    .add(QUANTITY, qty)
                    .add(VALUE, value)
                    .add(ACCRUED_INTEREST, accruedInt)
                    .add(YIELD, yield)
                    .add(SETTLE_CODE, settleCode)
                    .add(COUNTERPARTY_FIRM_ID, cpFirmId)
                    .add(FLAGS, flags)
                    .add(PRICE_2, price2)
                    .add(REPO_RATE, repoRate)
                    .add(CLIENT_CODE, clientCode)
                    .add(ACCRUED_2, accrued2)
                    .add(REPO_TERM, repoTerm)
                    .add(REPO_VALUE, repoValue)
                    .add(REPO_2_VALUE, repo2Value)
                    .add(START_DISCOUNT, startDiscount)
                    .add(LOWER_DISCOUNT, lowerDiscount)
                    .add(UPPER_DISCOUNT, upperDiscount)
                    .add(BLOCK_SECURITIES, blockSecurities)
                    .add(CLEARING_COMISSION, clearingComission)
                    .add(EXCHANGE_COMISSION, exchangeComission)
                    .add(TECH_CENTER_COMISSION, techCenterComission)
                    .add(SETTLE_DATE, settleDate)
                    .add(SETTLE_CURRENCY, settleCurrency)
                    .add(TRADE_CURRENCY, tradeCurrency)
                    .add(EXCHANGE_CODE, exchangeCode)
                    .add(STATION_ID, stationId)
                    .add(SECURITY_CODE, secCode)
                    .add(CLASS_CODE, classCode)
                    .add(DATETIME, datetime)
                    .add(BANK_ACC_ID, bankAccId)
                    .add(BROKER_COMISSION, brokerComission)
                    .add(LINKED_TRADE, linkedTrade)
                    .add(PERIOD, period)
                    .add(TRANS_ID, transId)
                    .add(KIND, kind)
                    .add(CLEARING_BANK_ACC_ID, clearingBankAccId)
                    .add(CANCELED_DATETIME, canceledDatetime)
                    .add(CLEARING_FIRM_ID, clearingFirmId)
                    .add(SYSTEM_REF, systemRef)
                    .add(UID, uid)
                    .add(L_SECURITY_CODE, lSecCode)
                    .add(ORDER_REVISION_NUMBER, orderRevisionNumber)
                    .add(ORDER_QUANTITY, orderQty)
                    .add(ORDER_PRICE, orderPrice)
                    .add(ORDER_EXCHANGE_CODE, orderExchangeCode)
                    .add(EXEC_MARKET, execMarket)
                    .add(LIQUIDITY_INDICATOR, liquidityIndicator)
                    .add(EXT_REF, extRef)
                    .add(EXT_TRADE_FLAGS, extTradeFlags)
                    .add(ON_BEHALF_OF_UID, onBehalfOfUid)
                    .add(CLIENT_QUALIFIER, clientQualifier)
                    .add(CLIENT_SHORT_CODE, clientShortCode)
                    .add(INVESTMENT_DECISION_MAKER_QUALIFIER, investmentDecisionMakerQualifier)
                    .add(INVESTMENT_DECISION_MAKER_SHORT_CODE, investmentDecisionMakerShortCode)
                    .add(EXECUTING_TRADER_QUALIFIER, executingTraderQualifier)
                    .add(EXECUTING_TRADER_SHORT_CODE, executingTraderShortCode)
                    .add(WAIVER_FLAG, waiverFlag)
                    .add(MLEG_BASE_SID, mlegBaseSid)
                    .add(SIDE_QUALIFIER, sideQualifier)
                    .add(OTC_POST_TRADE_INDICATOR, otcPostTradeIndicator)
                    .add(CAPACITY, capacity)
                    .add(CROSS_RATE, crossRate)
                    .toString();
        }

        return asString;
    }
}
