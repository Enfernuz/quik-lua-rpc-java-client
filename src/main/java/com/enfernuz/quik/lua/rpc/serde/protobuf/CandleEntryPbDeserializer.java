package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.CandleEntry;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbDateTimeEntry;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;

enum CandleEntryPbDeserializer implements Deserializer<CandleEntry>, FromPbConverter<QluaStructures.CandleEntry, CandleEntry> {

    INSTANCE;

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public CandleEntry deserialize(final byte[] data) {
        return convert( QluaStructures.CandleEntry.parseFrom(data) );
    }

    @Override
    public CandleEntry convert(@NotNull final QluaStructures.CandleEntry candleEntry) {

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
}
