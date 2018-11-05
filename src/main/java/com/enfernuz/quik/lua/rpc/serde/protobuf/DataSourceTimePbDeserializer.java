package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DataSourceTime;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

enum DataSourceTimePbDeserializer implements Deserializer<DataSourceTime>, FromPbConverter<QluaStructures.DataSourceTime, DataSourceTime> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public DataSourceTime deserialize(final byte[] data) {
        return convert( QluaStructures.DataSourceTime.parseFrom(data) );
    }

    @Override
    public DataSourceTime convert(@NotNull final QluaStructures.DataSourceTime time) {

        return DataSourceTime.builder()
                .year( time.getYear() )
                .month( time.getMonth() )
                .day( time.getDay() )
                .weekDay( time.getWeekDay() )
                .hour( time.getHour() )
                .min( time.getMin() )
                .sec( time.getSec() )
                .ms( time.getMs() )
                .count( time.getCount() )
                .build();
    }
}
