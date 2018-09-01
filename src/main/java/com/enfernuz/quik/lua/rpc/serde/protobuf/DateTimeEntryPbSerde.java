package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

enum DateTimeEntryPbSerde implements Deserializer<DateTimeEntry>, PbConverter<QluaStructures.DateTimeEntry, DateTimeEntry> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public DateTimeEntry deserialize(final byte[] data) {
        return convertFromPb( QluaStructures.DateTimeEntry.parseFrom(data) );
    }

    @Override
    public DateTimeEntry convertFromPb(@NotNull final QluaStructures.DateTimeEntry dateTimeEntry) {

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

    @Override
    public QluaStructures.DateTimeEntry convertToPb(@NotNull final DateTimeEntry dateTimeEntry) {

        return QluaStructures.DateTimeEntry.newBuilder()
                .setMcs( dateTimeEntry.getMcs() )
                .setMs( dateTimeEntry.getMs() )
                .setSec( dateTimeEntry.getSec() )
                .setMin( dateTimeEntry.getMin() )
                .setHour( dateTimeEntry.getHour() )
                .setDay( dateTimeEntry.getDay() )
                .setWeekDay( dateTimeEntry.getWeekDay() )
                .setMonth( dateTimeEntry.getMonth() )
                .setYear( dateTimeEntry.getYear() )
                .build();
    }
}
