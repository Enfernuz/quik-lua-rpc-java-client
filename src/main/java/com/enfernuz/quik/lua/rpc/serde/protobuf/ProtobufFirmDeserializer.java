package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.events.api.structures.Firm;
import com.enfernuz.quik.lua.rpc.serde.Deserializer;
import com.enfernuz.quik.lua.rpc.serde.SerdeException;
import qlua.structs.QluaStructures;

enum ProtobufFirmDeserializer implements Deserializer<Firm> {

    INSTANCE;

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
