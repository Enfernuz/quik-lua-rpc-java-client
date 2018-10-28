package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

enum DateTimeEntryPbDeserializer implements Deserializer<DateTimeEntry>, FromPbConverter<QluaStructures.DateTimeEntry, DateTimeEntry> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public DateTimeEntry deserialize(final byte[] data) {
        return convert( QluaStructures.DateTimeEntry.parseFrom(data) );
    }

    @Override
    public DateTimeEntry convert(@NotNull final QluaStructures.DateTimeEntry dateTimeEntry) {

        return DateTimeEntry
                .builder()
                .mcs( dateTimeEntry.getMcs() )
                .ms( dateTimeEntry.getMs() )
                .sec( dateTimeEntry.getSec() )
                .min( dateTimeEntry.getMin() )
                .hour( dateTimeEntry.getHour() )
                .day( dateTimeEntry.getDay() )
                .weekDay( dateTimeEntry.getWeekDay() )
                .month( dateTimeEntry.getMonth() )
                .year( dateTimeEntry.getYear() )
                .build();
    }
}
