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
            return Firm
                    .builder()
                    .firmId(firm.getFirmid())
                    .firmName(firm.getFirmName())
                    .status(firm.getStatus())
                    .exchange(firm.getExchange())
                    .build();
        } catch (final Exception ex) {
            throw new SerdeException(
                    String.format("Ошибка при десериализации экземпляра %s из protobuf-представления.", Firm.class.getName()),
                    ex
            );
        }
    }
}
