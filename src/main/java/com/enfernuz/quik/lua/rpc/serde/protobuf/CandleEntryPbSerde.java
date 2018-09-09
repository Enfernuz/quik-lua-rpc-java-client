package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.CandleEntry;
import com.enfernuz.quik.lua.rpc.api.structures.DateTimeEntry;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.*;

enum CandleEntryPbSerde implements Serde<CandleEntry>, PbConverter<QluaStructures.CandleEntry, CandleEntry> {

    INSTANCE;

    @Override
    public byte[] serialize(final CandleEntry candleEntry) {
        return convertToPb(candleEntry).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public CandleEntry deserialize(final byte[] data) {
        return convertFromPb( QluaStructures.CandleEntry.parseFrom(data) );
    }

    @Override
    public CandleEntry convertFromPb(@NotNull final QluaStructures.CandleEntry candleEntry) {

        final CandleEntry.CandleEntryBuilder result = CandleEntry.builder()
                .open( convertFromPbString(candleEntry.getOpen()) )
                .close( convertFromPbString(candleEntry.getClose()) )
                .high( convertFromPbString(candleEntry.getHigh()) )
                .low( convertFromPbString(candleEntry.getLow()) )
                .volume( convertFromPbString(candleEntry.getVolume()) )
                .doesExist( candleEntry.getDoesExist() );

        if (candleEntry.hasDatetime()) {
            result.dateTimeEntry( convertFromPbDateTimeEntry(candleEntry.getDatetime()) );
        }

        return result.build();
    }

    @Override
    public QluaStructures.CandleEntry convertToPb(@NotNull final CandleEntry candleEntry) {

        final QluaStructures.CandleEntry.Builder result = QluaStructures.CandleEntry.newBuilder()
                .setOpen( convertToPbString(candleEntry.getOpen()) )
                .setClose( convertToPbString(candleEntry.getClose()) )
                .setHigh( convertToPbString(candleEntry.getHigh()) )
                .setLow( convertToPbString(candleEntry.getLow()) )
                .setVolume( convertToPbString(candleEntry.getVolume()) )
                .setDoesExist( candleEntry.getDoesExist() );

        final DateTimeEntry dateTimeEntry = candleEntry.getDateTimeEntry();
        if (dateTimeEntry != null) {
            result.setDatetime( convertToPbDateTimeEntry(candleEntry.getDateTimeEntry()) );
        }

        return result.build();
    }
}
