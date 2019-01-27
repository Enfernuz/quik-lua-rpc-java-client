package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.T;
import com.enfernuz.quik.lua.rpc.api.structures.DataSourceTime;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import org.jetbrains.annotations.NotNull;

public class DatasourceTResultPbSerdeTest extends AbstractPbDeserializationTest<qlua.rpc.datasource.T.Result, T.Result> {

    private static final int YEAR = 1;
    private static final int MONTH = 2;
    private static final int DAY = 3;
    private static final int WEEK_DAY = 4;
    private static final int HOUR = 5;
    private static final int MIN = 6;
    private static final int SEC = 7;
    private static final int MS = 8;
    private static final int COUNT = 9;

    @Override
    public @NotNull Deserializer<T.Result> getDeserializerUnderTest() {
        return DsTResultPbDeserializer.INSTANCE;
    }

    @NotNull
    @Override
    public T.Result getTargetObject() {

        final DataSourceTime time = DataSourceTime.builder()
                .year(YEAR)
                .month(MONTH)
                .day(DAY)
                .weekDay(WEEK_DAY)
                .hour(HOUR)
                .min(MIN)
                .sec(SEC)
                .ms(MS)
                .count(COUNT)
                .build();

        return new T.Result(time);
    }

    @NotNull
    @Override
    public qlua.rpc.datasource.T.Result getTargetObjectAsPbMessage() {

        qlua.structs.QluaStructures.DataSourceTime pbTime =
                qlua.structs.QluaStructures.DataSourceTime.newBuilder()
                        .setYear(YEAR)
                        .setMonth(MONTH)
                        .setDay(DAY)
                        .setWeekDay(WEEK_DAY)
                        .setHour(HOUR)
                        .setMin(MIN)
                        .setSec(SEC)
                        .setMs(MS)
                        .setCount(COUNT)
                        .build();

        return qlua.rpc.datasource.T.Result.newBuilder()
                .setTime(pbTime)
                .build();
    }
}
