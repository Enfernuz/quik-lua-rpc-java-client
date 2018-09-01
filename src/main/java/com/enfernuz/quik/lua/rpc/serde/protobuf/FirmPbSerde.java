package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.structures.Firm;
import com.enfernuz.quik.lua.rpc.serde.PbConverter;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertFromPbString;
import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.convertToPbString;

enum FirmPbSerde implements Serde<Firm>, PbConverter<QluaStructures.Firm, Firm> {

    INSTANCE;

    @Override
    public byte[] serialize(final Firm firm) {
        return convertToPb(firm).toByteArray();
    }

    @SneakyThrows(InvalidProtocolBufferException.class)
    @Override
    public Firm deserialize(final byte[] data) {
        return convertFromPb(QluaStructures.Firm.parseFrom(data));
    }

    @Override
    public Firm convertFromPb(@NotNull QluaStructures.Firm firm) {

        return Firm
                .builder()
                .firmId(firm.getFirmid())
                .firmName( convertFromPbString(firm.getFirmName()) )
                .status(firm.getStatus())
                .exchange( convertFromPbString(firm.getExchange()) )
                .build();
    }

    @Override
    public QluaStructures.Firm convertToPb(@NotNull final Firm firm) {

        return QluaStructures.Firm.newBuilder()
                .setFirmid( firm.getFirmId() )
                .setFirmName( convertToPbString(firm.getFirmName()) )
                .setStatus( firm.getStatus() )
                .setExchange( convertToPbString(firm.getExchange()) )
                .build();
    }
}
