package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetOrderByNumber;
import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.api.structures.Order;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import qlua.structs.QluaStructures;

@RunWith(Enclosed.class)
public class GetOrderByNumberResultPbSerdeTest {

    private static final int DATETIME_MCS = 1;
    private static final int DATETIME_MS = 2;
    private static final int DATETIME_SEC = 3;
    private static final int DATETIME_MIN = 4;
    private static final int DATETIME_HOUR = 5;
    private static final int DATETIME_DAY = 6;
    private static final int DATETIME_WEEK_DAY = 7;
    private static final int DATETIME_MONTH = 8;
    private static final int DATETIME_YEAR = 9;

    private static final long ORDER_NUM = 12345678910L;
    private static final int FLAGS = 2;
    private static final String BROKER_REF = "3";
    private static final String USER_ID = "4";
    private static final String FIRM_ID = "5";
    private static final String ACCOUNT = "6";
    private static final String PRICE = "7";
    private static final int QTY = 8;
    private static final String BALANCE = "9";
    private static final String VALUE = "10";
    private static final String ACCRUED_INT = "11";
    private static final String YIELD = "12";
    private static final String TRANS_ID = "13";
    private static final String CLIENT_CODE = "14";
    private static final String PRICE2 = "15";
    private static final String SETTLE_CODE = "16";
    private static final String UID = "17";
    private static final String CANCELED_UID = "18";
    private static final String EXCHANGE_CODE = "19";
    private static final String ACTIVATION_TIME = "20";
    private static final String LINKED_ORDER = "21";
    private static final String EXPIRY = "22";
    private static final String SEC_CODE = "23";
    private static final String CLASS_CODE = "24";
    private static final String BANK_ACC_ID = "27";
    private static final int VALUE_ENTRY_TYPE = 28;
    private static final String REPO_TERM = "29";
    private static final String REPO_VALUE = "30";
    private static final String REPO2_VALUE = "31";
    private static final String REPO_VALUE_BALANCE = "32";
    private static final String START_DISCOUNT = "33";
    private static final String REJECT_REASON = "34";
    private static final String EXT_ORDER_FLAGS = "35";
    private static final int MIN_QTY = 36;
    private static final int EXEC_TYPE = 37;
    private static final int SIDE_QUALIFIER = 38;
    private static final int ACNT_TYPE = 39;
    private static final int CAPACITY = 40;
    private static final int PASSIVE_ONLY_ORDER = 41;
    private static final int VISIBLE = 42;

    private static final int INDX = 2;

    public static class NormalGetOrderByNumberResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetOrderByNumber.Result, GetOrderByNumber.Result> {

        @Override
        public @NotNull Deserializer<GetOrderByNumber.Result> getDeserializerUnderTest() {
            return GetOrderByNumberResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public GetOrderByNumber.Result getTargetObject() {

            final DateTimeEntry dateTimeEntry = DateTimeEntry.builder()
                    .mcs(DATETIME_MCS)
                    .ms(DATETIME_MS)
                    .sec(DATETIME_SEC)
                    .min(DATETIME_MIN)
                    .hour(DATETIME_HOUR)
                    .day(DATETIME_DAY)
                    .weekDay(DATETIME_WEEK_DAY)
                    .month(DATETIME_MONTH)
                    .year(DATETIME_YEAR)
                    .build();

            final Order order = Order.builder()
                    .orderNum(ORDER_NUM)
                    .flags(FLAGS)
                    .brokerRef(BROKER_REF)
                    .userId(USER_ID)
                    .firmId(FIRM_ID)
                    .account(ACCOUNT)
                    .price(PRICE)
                    .qty(QTY)
                    .balance(BALANCE)
                    .value(VALUE)
                    .accruedInt(ACCRUED_INT)
                    .yield(YIELD)
                    .transId(TRANS_ID)
                    .clientCode(CLIENT_CODE)
                    .price2(PRICE2)
                    .settleCode(SETTLE_CODE)
                    .uid(UID)
                    .canceledUid(CANCELED_UID)
                    .exchangeCode(EXCHANGE_CODE)
                    .activationTime(ACTIVATION_TIME)
                    .linkedOrder(LINKED_ORDER)
                    .expiry(EXPIRY)
                    .secCode(SEC_CODE)
                    .classCode(CLASS_CODE)
                    .datetime(dateTimeEntry)
                    .withdrawDatetime(dateTimeEntry)
                    .bankAccId(BANK_ACC_ID)
                    .valueEntryType(VALUE_ENTRY_TYPE)
                    .repoTerm(REPO_TERM)
                    .repoValue(REPO_VALUE)
                    .repo2Value(REPO2_VALUE)
                    .repoValueBalance(REPO_VALUE_BALANCE)
                    .startDiscount(START_DISCOUNT)
                    .rejectReason(REJECT_REASON)
                    .extOrderFlags(EXT_ORDER_FLAGS)
                    .minQty(MIN_QTY)
                    .execType(EXEC_TYPE)
                    .sideQualifier(SIDE_QUALIFIER)
                    .acntType(ACNT_TYPE)
                    .capacity(CAPACITY)
                    .passiveOnlyOrder(PASSIVE_ONLY_ORDER)
                    .visible(VISIBLE)
                    .build();

            return GetOrderByNumber.Result.getInstance(order, INDX);
        }

        @NotNull
        @Override
        public qlua.rpc.GetOrderByNumber.Result getTargetObjectAsPbMessage() {

            final QluaStructures.DateTimeEntry pbDateTimeEntry = QluaStructures.DateTimeEntry.newBuilder()
                    .setMcs(DATETIME_MCS)
                    .setMs(DATETIME_MS)
                    .setSec(DATETIME_SEC)
                    .setMin(DATETIME_MIN)
                    .setHour(DATETIME_HOUR)
                    .setDay(DATETIME_DAY)
                    .setWeekDay(DATETIME_WEEK_DAY)
                    .setMonth(DATETIME_MONTH)
                    .setYear(DATETIME_YEAR)
                    .build();

            final QluaStructures.Order order = QluaStructures.Order.newBuilder()
                    .setOrderNum(ORDER_NUM)
                    .setFlags(FLAGS)
                    .setBrokerref(BROKER_REF)
                    .setUserid(USER_ID)
                    .setFirmid(FIRM_ID)
                    .setAccount(ACCOUNT)
                    .setPrice(PRICE)
                    .setQty(QTY)
                    .setBalance(BALANCE)
                    .setValue(VALUE)
                    .setAccruedint(ACCRUED_INT)
                    .setYield(YIELD)
                    .setTransId(TRANS_ID)
                    .setClientCode(CLIENT_CODE)
                    .setPrice2(PRICE2)
                    .setSettlecode(SETTLE_CODE)
                    .setUid(UID)
                    .setCanceledUid(CANCELED_UID)
                    .setExchangeCode(EXCHANGE_CODE)
                    .setActivationTime(ACTIVATION_TIME)
                    .setLinkedorder(LINKED_ORDER)
                    .setExpiry(EXPIRY)
                    .setSecCode(SEC_CODE)
                    .setClassCode(CLASS_CODE)
                    .setDatetime(pbDateTimeEntry)
                    .setWithdrawDatetime(pbDateTimeEntry)
                    .setBankAccId(BANK_ACC_ID)
                    .setValueEntryType(VALUE_ENTRY_TYPE)
                    .setRepoterm(REPO_TERM)
                    .setRepovalue(REPO_VALUE)
                    .setRepo2Value(REPO2_VALUE)
                    .setRepoValueBalance(REPO_VALUE_BALANCE)
                    .setStartDiscount(START_DISCOUNT)
                    .setRejectReason(REJECT_REASON)
                    .setExtOrderFlags(EXT_ORDER_FLAGS)
                    .setMinQty(MIN_QTY)
                    .setExecType(EXEC_TYPE)
                    .setSideQualifier(SIDE_QUALIFIER)
                    .setAcntType(ACNT_TYPE)
                    .setCapacity(CAPACITY)
                    .setPassiveOnlyOrder(PASSIVE_ONLY_ORDER)
                    .setVisible(VISIBLE)
                    .build();

            return qlua.rpc.GetOrderByNumber.Result.newBuilder()
                    .setOrder(order)
                    .setValueIndx(INDX)
                    .build();
        }
    }

    public static class ErrorGetOrderByNumberResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.GetOrderByNumber.Result, GetOrderByNumber.Result> {

        @Override
        public @NotNull Deserializer<GetOrderByNumber.Result> getDeserializerUnderTest() {
            return GetOrderByNumberResultPbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public GetOrderByNumber.Result getTargetObject() {
            return GetOrderByNumber.Result.getInstance(null, null);
        }

        @NotNull
        @Override
        public qlua.rpc.GetOrderByNumber.Result getTargetObjectAsPbMessage() {
            return qlua.rpc.GetOrderByNumber.Result.newBuilder()
                    .setNullIndx(true)
                    .build();
        }
    }
}
