package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.AllTrade;
import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import qlua.structs.QluaStructures;

@RunWith(Enclosed.class)
public class AllTradePbSerdeTest {

    private static final long TRADE_NUM = 1L;
    private static final int FLAGS = 2;
    private static final String PRICE = "3";
    private static final int QTY = 4;
    private static final String VALUE = "5";
    private static final String ACCRUED_INT = "6";
    private static final String YIELD = "7";
    private static final String SETTLE_CODE = "8";
    private static final String REPO_RATE = "9";
    private static final String REPO_VALUE = "10";
    private static final String REPO2_VALUE = "11";
    private static final String REPO_TERM = "12";
    private static final String SEC_CODE = "13";
    private static final String CLASS_CODE = "14";
    private static final int PERIOD = 15;
    private static final String OPEN_INTEREST = "16";
    private static final String EXCHANGE_CODE = "17";

    private static final int MCS = 1;
    private static final int MS = 2;
    private static final int SEC = 3;
    private static final int MIN = 4;
    private static final int HOUR = 5;
    private static final int DAY = 6;
    private static final int WEEK_DAY = 7;
    private static final int MONTH = 8;
    private static final int YEAR = 9;

    private static final DateTimeEntry DATETIME = DateTimeEntry.builder()
            .mcs(MCS)
            .ms(MS)
            .sec(SEC)
            .min(MIN)
            .hour(HOUR)
            .day(DAY)
            .weekDay(WEEK_DAY)
            .month(MONTH)
            .year(YEAR)
            .build();

    private static final QluaStructures.DateTimeEntry PB_DATETIME = QluaStructures.DateTimeEntry.newBuilder()
            .setMcs(MCS)
            .setMs(MS)
            .setSec(SEC)
            .setMin(MIN)
            .setHour(HOUR)
            .setDay(DAY)
            .setWeekDay(WEEK_DAY)
            .setMonth(MONTH)
            .setYear(YEAR)
            .build();

    public static class FullArgsAllTradePbSerdeTest extends AbstractPbDeserializationTest<QluaStructures.AllTrade, AllTrade> {

        @Override
        public @NotNull Deserializer<AllTrade> getDeserializerUnderTest() {
            return AllTradePbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public AllTrade getTargetObject() {

            return AllTrade.builder()
                    .tradeNum(TRADE_NUM)
                    .flags(FLAGS)
                    .price(PRICE)
                    .qty(QTY)
                    .value(VALUE)
                    .accruedInt(ACCRUED_INT)
                    .yield(YIELD)
                    .settleCode(SETTLE_CODE)
                    .repoRate(REPO_RATE)
                    .repoValue(REPO_VALUE)
                    .repo2Value(REPO2_VALUE)
                    .repoTerm(REPO_TERM)
                    .secCode(SEC_CODE)
                    .classCode(CLASS_CODE)
                    .datetime(DATETIME)
                    .period(PERIOD)
                    .openInterest(OPEN_INTEREST)
                    .exchangeCode(EXCHANGE_CODE)
                    .build();
        }

        @NotNull
        @Override
        public QluaStructures.AllTrade getTargetObjectAsPbMessage() {

            return QluaStructures.AllTrade.newBuilder()
                    .setTradeNum(TRADE_NUM)
                    .setValueFlags(FLAGS)
                    .setPrice(PRICE)
                    .setQty(QTY)
                    .setValue(VALUE)
                    .setAccruedint(ACCRUED_INT)
                    .setYield(YIELD)
                    .setSettlecode(SETTLE_CODE)
                    .setReporate(REPO_RATE)
                    .setRepovalue(REPO_VALUE)
                    .setRepo2Value(REPO2_VALUE)
                    .setRepoterm(REPO_TERM)
                    .setSecCode(SEC_CODE)
                    .setClassCode(CLASS_CODE)
                    .setDatetime(PB_DATETIME)
                    .setPeriod(PERIOD)
                    .setOpenInterest(OPEN_INTEREST)
                    .setExchangeCode(EXCHANGE_CODE)
                    .build();
        }
    }

    public static class OnlyRequiredArgsAllTradePbSerdeTest extends AbstractPbDeserializationTest<QluaStructures.AllTrade, AllTrade> {

        @Override
        public @NotNull Deserializer<AllTrade> getDeserializerUnderTest() {
            return AllTradePbDeserializer.INSTANCE;
        }

        @NotNull
        @Override
        public AllTrade getTargetObject() {

            return AllTrade.builder()
                    .tradeNum(TRADE_NUM)
                    .price(PRICE)
                    .qty(QTY)
                    .secCode(SEC_CODE)
                    .classCode(CLASS_CODE)
                    .datetime(DATETIME)
                    .period(PERIOD)
                    .build();
        }

        @NotNull
        @Override
        public QluaStructures.AllTrade getTargetObjectAsPbMessage() {

            return QluaStructures.AllTrade.newBuilder()
                    .setTradeNum(TRADE_NUM)
                    .setNullFlags(true)
                    .setPrice(PRICE)
                    .setQty(QTY)
                    .setSecCode(SEC_CODE)
                    .setClassCode(CLASS_CODE)
                    .setDatetime(PB_DATETIME)
                    .setPeriod(PERIOD)
                    .build();
        }
    }
}
