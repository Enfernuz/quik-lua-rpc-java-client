package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.events.api.structures.Firm;
import com.enfernuz.quik.lua.rpc.serde.Serde;
import qlua.structs.QluaStructures;

import static com.enfernuz.quik.lua.rpc.serde.protobuf.ProtobufSerdeUtils.asNonNullString;

enum ProtobufFirmSerde implements Serde<Firm> {

    INSTANCE;

    @Override
    public byte[] serialize(final Firm firm) {

        try {
            return QluaStructures.Firm
                    .newBuilder()
                    .setFirmid( firm.getFirmId() )
                    .setFirmName( asNonNullString(firm.getFirmName()) )
                    .setStatus( firm.getStatus() )
                    .setExchange( asNonNullString(firm.getExchange()) )
                    .build()
                    .toByteArray();
        } catch (final RuntimeException ex) {
            throw new SerdeException(); // TODO
        }
    }

    @Override
    public Firm deserialize(final byte[] data) {

        try {
            final QluaStructures.Firm firm = QluaStructures.Firm.parseFrom(data);
            return new Firm(firm.getFirmid(), firm.getFirmName(), firm.getStatus(), firm.getExchange());
        } catch (final Exception ex) {
            throw new SerdeException(); // TODO
        }
    }
}
