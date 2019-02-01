package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.CandleEntry;
import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

public class CandleEntryPbSerdeTest extends AbstractPbDeserializationTest<QluaStructures.CandleEntry, CandleEntry> {

    private static final String OPEN = "1";
    private static final String CLOSE = "2";
    private static final String HIGH = "3";
    private static final String LOW = "4";
    private static final String VOLUME = "5";
    private static final int DOES_EXIST = 7;

    private static final int MCS = 1;
    private static final int MS = 2;
    private static final int SEC = 3;
    private static final int MIN = 4;
    private static final int HOUR = 5;
    private static final int DAY = 6;
    private static final int WEEK_DAY = 7;
    private static final int MONTH = 8;
    private static final int YEAR = 9;

    @Override
    public @NotNull Deserializer<CandleEntry> getDeserializerUnderTest() {
        return CandleEntryPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public CandleEntry getTargetObject() {

        final DateTimeEntry dateTimeEntry = DateTimeEntry.builder()
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

        return CandleEntry.builder()
                .open(OPEN)
                .close(CLOSE)
                .high(HIGH)
                .low(LOW)
                .volume(VOLUME)
                .dateTimeEntry(dateTimeEntry)
                .doesExist(DOES_EXIST)
                .build();
    }

    @NotNull
    @Override
    public QluaStructures.CandleEntry getTargetObjectAsPbMessage() {

        final QluaStructures.DateTimeEntry pbDateTimeEntry = QluaStructures.DateTimeEntry.newBuilder()
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

        return QluaStructures.CandleEntry.newBuilder()
                .setOpen(OPEN)
                .setClose(CLOSE)
                .setHigh(HIGH)
                .setLow(LOW)
                .setVolume(VOLUME)
                .setDatetime(pbDateTimeEntry)
                .setDoesExist(DOES_EXIST)
                .build();
    }
}
