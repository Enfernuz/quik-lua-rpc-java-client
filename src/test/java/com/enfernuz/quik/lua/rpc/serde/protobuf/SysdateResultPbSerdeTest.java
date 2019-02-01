package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.os.SysDate;
import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class SysdateResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.os.Sysdate.Result, SysDate.Result> {

    private static final int YEAR = 1;
    private static final int MONTH = 2;
    private static final int DAY = 3;
    private static final int WEEK_DAY = 4;
    private static final int HOUR = 5;
    private static final int MINUTE = 6;
    private static final int SEC = 7;
    private static final int MS = 8;
    private static final int MCS = 9;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Override
    public @NotNull Deserializer<SysDate.Result> getDeserializerUnderTest() {
        return SysDateResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public SysDate.Result getTargetObject() {

        final DateTimeEntry dateTimeEntry = DateTimeEntry.builder()
                .year(YEAR)
                .month(MONTH)
                .day(DAY)
                .weekDay(WEEK_DAY)
                .hour(HOUR)
                .min(MINUTE)
                .sec(SEC)
                .ms(MS)
                .mcs(MCS)
                .build();

        return new SysDate.Result(dateTimeEntry);
    }

    @NotNull
    @Override
    public qlua.rpc.os.Sysdate.Result getTargetObjectAsPbMessage() {

        final qlua.structs.QluaStructures.DateTimeEntry pbDateTimeEntry =
                qlua.structs.QluaStructures.DateTimeEntry.newBuilder()
                        .setYear(YEAR)
                        .setMonth(MONTH)
                        .setDay(DAY)
                        .setWeekDay(WEEK_DAY)
                        .setHour(HOUR)
                        .setMin(MINUTE)
                        .setSec(SEC)
                        .setMs(MS)
                        .setMcs(MCS)
                        .build();

        return qlua.rpc.os.Sysdate.Result.newBuilder()
                .setResult(pbDateTimeEntry)
                .build();
    }
}
